package com.ExpenseTracker.UserService.Services;

import com.ExpenseTracker.UserService.Entities.UserInfo;
import com.ExpenseTracker.UserService.Entities.UserInfoDTO;
import com.ExpenseTracker.UserService.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public UserInfo SaveUser(UserInfoDTO userInfoDTO){
        Function<UserInfoDTO, UserInfo> TransformedUser = user->{
            return userRepository.save(user.transformToUserInfo());
        };


    }
}
