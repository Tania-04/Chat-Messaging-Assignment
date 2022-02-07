package com.ChatMessagingApplication.Model;

import com.ChatMessagingApplication.DTO.Request.UserSignupRequest;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Builder
@Table(name ="user_details", uniqueConstraints = @UniqueConstraint(columnNames = {"user_id","user_name","user_phone_number"}))
public class UserDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_name", nullable = false)
    private String userName;


    @Column(name = "user_phone_number")
    private Integer userPhoneNumber;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "creation_time")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date creationTime;

    @OneToMany(mappedBy = "userDetails", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<ChatDetails> chatDetailsList;


}
