package com.ChatMessagingApplication.Service;

import com.ChatMessagingApplication.DTO.Request.UserSignupRequest;
import com.ChatMessagingApplication.Model.UserDetails;
import com.ChatMessagingApplication.Repository.UserDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserDetailsRepo userDetailsRepo;

    @Override
    public UserDetails saveUserData(UserSignupRequest userSignupRequest) {

        UserDetails userDetails = UserDetails.builder().userName(userSignupRequest.getUserName())
                .userPhoneNumber(userSignupRequest.getPhoneNumber()).emailId(userSignupRequest.getEmailId()).build();

        UserDetails userDetailresponse =   userDetailsRepo.save(userDetails);

        if(userDetailresponse == null)
            return null;

        return userDetailresponse;
    }
}
