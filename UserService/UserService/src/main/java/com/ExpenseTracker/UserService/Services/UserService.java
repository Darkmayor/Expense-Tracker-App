package com.ExpenseTracker.UserService.Services;

import com.ExpenseTracker.UserService.Entities.UserInfo;
import com.ExpenseTracker.UserService.Entities.UserInfoDTO;
import com.ExpenseTracker.UserService.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public UserInfoDTO SaveUser(UserInfoDTO userInfoDTO){
       UnaryOperator<UserInfo> updatedUser = user->{
           user.setUserId(userInfoDTO.getUserId());
           user.setEmail(userInfoDTO.getEmail());
           user.setFirstName(userInfoDTO.getFirstName());
           user.setLastName(userInfoDTO.getLastName());
           user.setProfilePic(userInfoDTO.getProfilePic());
            return userRepository.save(user);
        };

        Supplier<UserInfo> createUser =  () -> {
          return userRepository.save(userInfoDTO.transformToUserInfo());
        };

        UserInfo userInfo = userRepository.findByUserId(userInfoDTO.getUserId())
                .map(updatedUser)
                .orElseGet(createUser);

     return UserInfoDTO.builder().userId(userInfo.getUserId())
              .firstName(userInfo.getFirstName())
              .lastName(userInfo.getLastName())
              .email(userInfo.getEmail())
              .phoneNumber(userInfo.getPhoneNumber())
              .profilePic(userInfo.getProfilePic())
              .build();
    }

    public UserInfoDTO getUser(UserInfoDTO userInfoDTO) throws Exception {
        Optional<UserInfo> optionalUserInfo = userRepository.findByUserId(userInfoDTO.getUserId());
        if(optionalUserInfo.isEmpty()){
            throw new Exception("No Such user Exist");
        }
        UserInfo userInfo = optionalUserInfo.get();

        return UserInfoDTO.builder().userId(userInfo.getUserId())
                .firstName(userInfo.getFirstName())
                .lastName(userInfo.getLastName())
                .email(userInfo.getEmail())
                .phoneNumber(userInfo.getPhoneNumber())
                .profilePic(userInfo.getProfilePic())
                .build();

    }
}
