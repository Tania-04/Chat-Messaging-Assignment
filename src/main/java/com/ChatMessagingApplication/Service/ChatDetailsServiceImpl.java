package com.ChatMessagingApplication.Service;

import com.ChatMessagingApplication.DTO.Request.ChatDetailRequestDto;
import com.ChatMessagingApplication.DTO.Request.ChatEntryRequest;
import com.ChatMessagingApplication.DTO.Request.DeleteOneMsg;
import com.ChatMessagingApplication.DTO.Request.DeleteWholeChat;
import com.ChatMessagingApplication.DTO.Response.ChatDetailResponse;
import com.ChatMessagingApplication.Model.ChatDetails;
import com.ChatMessagingApplication.Model.UserDetails;
import com.ChatMessagingApplication.Repository.ChatDetailsRepo;
import com.ChatMessagingApplication.Repository.UserDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChatDetailsServiceImpl implements ChatDetailsService {

    @Autowired
    ChatDetailsRepo chatDetailsRepo;

    @Autowired
    UserDetailsRepo userDetailsRepo;

    @Override
    public ChatDetails addChatEntry(ChatEntryRequest chatEntryRequest) {


        UserDetails userDetails = userDetailsRepo.findByUserPhoneNumber(chatEntryRequest.getSenderPhoneNumber());

        if (userDetails == null)
            return null;
        ChatDetails chatDetails = ChatDetails.builder().receiverName(chatEntryRequest.getReceiverName()).receiverPhoneNumber(chatEntryRequest.getReceiverPhoneNumber())
                .senderPhoneNumber(chatEntryRequest.getSenderPhoneNumber()).senderName(chatEntryRequest.getSenderName()).messageContent(chatEntryRequest.getMessage())
                .userDetails(userDetails).build();

        return chatDetailsRepo.save(chatDetails);
    }

    @Override
    public List<ChatDetailResponse> findChatDetails(ChatDetailRequestDto chatDetailRequestDto) {

        List<ChatDetails> chatDetailsList = chatDetailsRepo.findBySenderNameAndReceiverName(chatDetailRequestDto.getSenderUserName()
                , chatDetailRequestDto.getReceiverUserName());

        if (chatDetailsList.isEmpty())
            return List.of();

        List<ChatDetailResponse> chatDetailResponses = new ArrayList<>();
        chatDetailsList.forEach(chatDetails -> chatDetailResponses.add(ChatDetailResponse.builder().senderName(chatDetails.getSenderName())
                .receiveTime(chatDetails.getMessageSentTime()).message(chatDetails.getMessageContent()).build()));

        return chatDetailResponses;
    }

    @Override
    @Transactional
    public Integer deleteUserDetails(DeleteWholeChat deleteWholeChat) {


        Integer rowsDeleted = chatDetailsRepo.deleteWholeChat(deleteWholeChat.getSenderName(), deleteWholeChat.getReceiverName());
        System.out.println(" rowsDeleted " + rowsDeleted);

        return rowsDeleted;

    }

    @Override
    @Transactional
    public Integer deleteSpecificUserDetails(DeleteOneMsg deleteOneMsg) {

        System.out.println(deleteOneMsg.getSenderName() + "  "+  deleteOneMsg.getReceiverName()+"   "+deleteOneMsg.getMessage());
        Integer rowsDeleted = chatDetailsRepo.deleteSpecificChat(deleteOneMsg.getSenderName(), deleteOneMsg.getReceiverName(),deleteOneMsg.getMessage());
        System.out.println(" rowsDeleted " + rowsDeleted);

        return rowsDeleted;

    }
}
