package com.ChatMessagingApplication.DTO.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatDetailResponse {

    @JsonProperty("sender_name")
    private String senderName;

    @JsonProperty("receive time")
    private Date receiveTime;

    private String message;
}
