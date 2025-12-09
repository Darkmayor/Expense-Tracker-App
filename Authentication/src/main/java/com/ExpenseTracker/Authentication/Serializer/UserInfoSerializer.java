package com.ExpenseTracker.Authentication.Serializer;

import com.ExpenseTracker.Authentication.model.UserInfoDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class UserInfoSerializer implements Serializer<UserInfoDto> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public byte[] serialize(String s, UserInfoDto userInfoDto) {
        byte[] serializedData = null;
        ObjectMapper mapper = new ObjectMapper();
        try{
            serializedData = mapper.writeValueAsString(s).getBytes();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return serializedData;
    }

    @Override
    public void close() {
    }
}
