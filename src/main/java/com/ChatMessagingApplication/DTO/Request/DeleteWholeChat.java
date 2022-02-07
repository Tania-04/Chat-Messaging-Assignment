package com.ChatMessagingApplication.DTO.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeleteWholeChat {

    @JsonProperty("sender_name")
    @NotBlank(message = "Sender Name can't be null")
    private String senderName;

    @JsonProperty("receiver_name")
    @NotBlank(message = "User Name can't be null")
    private String receiverName;
}
