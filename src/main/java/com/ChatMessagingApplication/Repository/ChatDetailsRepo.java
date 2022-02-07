package com.ChatMessagingApplication.Repository;

import com.ChatMessagingApplication.Model.ChatDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChatDetailsRepo extends JpaRepository<ChatDetails,Integer> {

    List<ChatDetails> findBySenderNameAndReceiverName(String senderName, String receiverName);

    @Modifying
    @Query("Delete from ChatDetails Where senderName = :senderName AND receiverName = :receiverName")
    Integer deleteWholeChat(String senderName, String receiverName);


    @Modifying
    @Query("Delete from ChatDetails Where senderName = :senderName AND receiverName = :receiverName AND messageContent =:message")
    Integer deleteSpecificChat(String senderName, String receiverName, String message) ;
}
