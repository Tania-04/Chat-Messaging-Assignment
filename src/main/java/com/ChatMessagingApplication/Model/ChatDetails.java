package com.ChatMessagingApplication.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Builder
@Table(name ="chat_detail")
public class ChatDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chat_id")
    private Integer chatId;

    @Column(name = "sender_name")
    private String senderName;

    @Column(name = "receiver_name")
    private String receiverName;

    @Column(name = "message_sent_time")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date messageSentTime;

    @Column(name = "message_content")
    private String messageContent;

    @Column(name = "receiver_phone_number")
    private Integer receiverPhoneNumber;

    @Column(name = "user_phone_number")
    private Integer senderPhoneNumber;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private UserDetails userDetails;


}
