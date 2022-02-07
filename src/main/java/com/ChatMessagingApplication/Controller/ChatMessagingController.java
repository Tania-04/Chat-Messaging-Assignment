package com.ChatMessagingApplication.Controller;


import com.ChatMessagingApplication.DTO.Request.*;
import com.ChatMessagingApplication.DTO.Response.ChatDetailResponse;
import com.ChatMessagingApplication.Model.ChatDetails;
import com.ChatMessagingApplication.Model.UserDetails;
import com.ChatMessagingApplication.Service.ChatDetailsService;
import com.ChatMessagingApplication.Service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/user")
public class ChatMessagingController {

    @Autowired
    ChatDetailsService chatDetailsService;

    @Autowired
    UserDetailsService userDetailsService;

    @PostMapping("/signup")
    ResponseEntity<String> signupUser(@Valid  @RequestBody   UserSignupRequest userSignupRequest)
    {
        UserDetails userDetails = userDetailsService.saveUserData(userSignupRequest);
        if(userDetails == null )
            return new ResponseEntity<>("Error in Signing Up the User", HttpStatus.OK);
        return new ResponseEntity<>("SignUp successfull ", HttpStatus.OK);
    }

    @PostMapping("/chat_entry")
    ResponseEntity<String> addChat(@RequestBody @Valid ChatEntryRequest chatEntryRequest){

        ChatDetails chatDetails = chatDetailsService.addChatEntry(chatEntryRequest);
        if(chatDetails == null)
            return new ResponseEntity<>("Error in adding chat entry in database ", HttpStatus.OK);
        return new ResponseEntity<>("Chat details added successfully",HttpStatus.OK);
    }

    @GetMapping("/find_chat")
    ResponseEntity<Object> findChat(@RequestBody @Valid  ChatDetailRequestDto chatDetailRequestDto){

        List<ChatDetailResponse> chatDetailResponseList = chatDetailsService.findChatDetails(chatDetailRequestDto);

        if(chatDetailResponseList.isEmpty())
            return new ResponseEntity<>("No Chat Found" , HttpStatus.OK);
        return new ResponseEntity<>(chatDetailResponseList ,HttpStatus.OK);

    }

    @DeleteMapping("/delete_chat")
    ResponseEntity<String> deleteWholeChat(@RequestBody @Valid DeleteWholeChat deleteWholeChat)
    {
        Integer rowsDeleted = chatDetailsService.deleteUserDetails(deleteWholeChat);

        if(rowsDeleted == null)
            return new ResponseEntity<>("No rows deleted or some exception occured",HttpStatus.OK);
        return new ResponseEntity<>("Deleted " + rowsDeleted + " rows", HttpStatus.OK);

    }

    @DeleteMapping("/delete_specific_chat")
    ResponseEntity<String> deleteSpecificUserChat(@RequestBody @Valid DeleteOneMsg deleteOneMsg)
    {
        Integer rowsDeleted = chatDetailsService.deleteSpecificUserDetails(deleteOneMsg);

        if(rowsDeleted == null)
            return new ResponseEntity<>("No rows deleted or some exception occured",HttpStatus.OK);
        return new ResponseEntity<>("Deleted " + rowsDeleted + " rows", HttpStatus.OK);

    }
}
