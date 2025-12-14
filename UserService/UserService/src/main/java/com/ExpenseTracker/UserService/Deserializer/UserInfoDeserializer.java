package com.ExpenseTracker.UserService.Deserializer;

import com.ExpenseTracker.UserService.Entities.UserInfoDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class UserInfoDeserializer implements Deserializer<UserInfoDTO> {

    Logger logger = LoggerFactory.getLogger(UserInfoDeserializer.class);
    @Override
    public UserInfoDTO deserialize(String s, byte[] bytes) {
        ObjectMapper objectMapper = new ObjectMapper();
        UserInfoDTO user = null;
        try{
            user = objectMapper.readValue(bytes , UserInfoDTO.class);
        }catch (Exception e){
            logger.error("Could Not Deserialize and map the object");
        }
        return user;
    }
}
