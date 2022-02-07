package com.ChatMessagingApplication.DTO.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSignupRequest {

    @NotBlank(message = "UserName can't be blank")
    @JsonProperty("user_name")
    private String userName;

    @NotNull(message = "Phone Number can't be null")
    @JsonProperty("phone_number")
    private Integer phoneNumber;

    @NotBlank(message = "Email Id can't be blank")
    @Email
    @JsonProperty("email_id")
    private String emailId;
}
