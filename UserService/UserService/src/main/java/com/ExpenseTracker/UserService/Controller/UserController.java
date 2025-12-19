package com.ExpenseTracker.UserService.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import com.ExpenseTracker.UserService.Entities.UserInfoDTO;
import com.ExpenseTracker.UserService.Services.UserService;
@RestController
public class UserController {

    private UserService userService;

    @PostMapping("/user/v1/createupdate")
    public ResponseEntity<UserInfoDTO> createUpdate(@RequestBody UserInfoDTO userInfoDTO){
        try{
            UserInfoDTO user = userService.SaveUser(userInfoDTO);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/user/v1/getUser")
    public ResponseEntity<UserInfoDTO> getUser(UserInfoDTO userInfoDTO){
        try{
            UserInfoDTO user = userService.getUser(userInfoDTO);
            return new ResponseEntity<>(user , HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
