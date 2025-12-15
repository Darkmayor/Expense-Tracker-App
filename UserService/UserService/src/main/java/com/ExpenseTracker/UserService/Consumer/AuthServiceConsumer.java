package com.ExpenseTracker.UserService.Consumer;


import com.ExpenseTracker.UserService.Entities.UserInfo;
import com.ExpenseTracker.UserService.Entities.UserInfoDTO;
import com.ExpenseTracker.UserService.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;


public class AuthServiceConsumer {


    private final UserRepository userRepository;

    @Autowired
    public AuthServiceConsumer(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @KafkaListener(topics = "${spring.kafka.topic-json.name}" , groupId = "${spring.kafka.consumer.group-id}")
    public void listener(UserInfoDTO eventData){
        try{
            UserInfo userInfo = eventData.transformToUserInfo();
            userRepository.save(userInfo);
        }catch (Exception e){

        }
    }
}
