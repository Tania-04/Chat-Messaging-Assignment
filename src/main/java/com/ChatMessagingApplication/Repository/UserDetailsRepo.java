package com.ChatMessagingApplication.Repository;

import com.ChatMessagingApplication.Model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepo extends JpaRepository<UserDetails,Integer> {

    UserDetails findByUserPhoneNumber(Integer phoneNumber);
}
