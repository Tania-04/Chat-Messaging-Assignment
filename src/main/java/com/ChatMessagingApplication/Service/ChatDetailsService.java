package com.ChatMessagingApplication.Service;

import com.ChatMessagingApplication.DTO.Request.ChatDetailRequestDto;
import com.ChatMessagingApplication.DTO.Request.ChatEntryRequest;
import com.ChatMessagingApplication.DTO.Request.DeleteOneMsg;
import com.ChatMessagingApplication.DTO.Request.DeleteWholeChat;
import com.ChatMessagingApplication.DTO.Response.ChatDetailResponse;
import com.ChatMessagingApplication.Model.ChatDetails;

import java.util.List;

public interface ChatDetailsService {

    ChatDetails addChatEntry(ChatEntryRequest chatEntryRequest);

    List<ChatDetailResponse> findChatDetails(ChatDetailRequestDto chatDetailRequestDto);

    Integer deleteUserDetails(DeleteWholeChat deleteWholeChat);

    Integer deleteSpecificUserDetails(DeleteOneMsg deleteOneMsg);

}
