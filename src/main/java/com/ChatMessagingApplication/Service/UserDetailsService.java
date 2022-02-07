package com.ChatMessagingApplication.Service;

import com.ChatMessagingApplication.DTO.Request.UserSignupRequest;
import com.ChatMessagingApplication.Model.UserDetails;

public interface UserDetailsService {

    UserDetails saveUserData(UserSignupRequest userSignupRequest);
}
