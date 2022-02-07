package com.ChatMessagingApplication.DTO.Request;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatEntryRequest {

    @NotBlank(message = "Sender Name can't be null")
    @JsonProperty("sender_name")
    private String senderName;

    @NotBlank(message = "Receiver Name can't be null")
    @JsonProperty("receiver_name")
    private String receiverName;

    @NotBlank(message = "Sent Message can't be null")
    @JsonProperty("message")
    private String message;

    @NotNull(message = "You must specify receiver's phone number")
    @JsonProperty("receiver_phone_number")
    private Integer receiverPhoneNumber;

    @NotNull(message = "You must specify sender's phone number")
    @JsonProperty("sender_phone_number")
    private Integer senderPhoneNumber;

}
