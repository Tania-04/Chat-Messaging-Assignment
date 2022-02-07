package com.ChatMessagingApplication.DTO.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatDetailRequestDto {

    @JsonProperty("receiver_username")
    @NotBlank(message = " Receiver's Name can't be null")
    private String receiverUserName;

    @JsonProperty("sender_username")
    @NotBlank(message = "Sender's Name can't be null")
    private String senderUserName;
}
