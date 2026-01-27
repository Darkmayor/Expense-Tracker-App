package com.ExpenseTracker.Authentication.Controllers;

import com.ExpenseTracker.Authentication.Entities.RefreshToken;
import com.ExpenseTracker.Authentication.Response.JwtResponseDTO;
import com.ExpenseTracker.Authentication.Services.JwtService;
import com.ExpenseTracker.Authentication.Services.RefreshTokenService;
import com.ExpenseTracker.Authentication.Services.UserDetailServiceImpl;
import com.ExpenseTracker.Authentication.model.UserInfoDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@AllArgsConstructor
@RestController
public class AuthController
{

    @Autowired
    private JwtService jwtService;

    @Autowired
    private RefreshTokenService refreshTokenService;

    @Autowired
    private UserDetailServiceImpl userDetailsService;

   @PostMapping("auth/v1/signup")
   public ResponseEntity SignUp(@RequestBody UserInfoDto userInfoDto){
       try{
           Boolean isSignUped = userDetailsService.signupUser(userInfoDto);
           if(Boolean.FALSE.equals(isSignUped)){
               return new ResponseEntity<>("Already Exist", HttpStatus.BAD_REQUEST);
           }
           RefreshToken refreshToken = refreshTokenService.createRefreshToken(userInfoDto.getUsername());
           String jwtToken = jwtService.GenerateToken(userInfoDto.getUsername());
           return new ResponseEntity<>(
                   JwtResponseDTO.builder().accessToken(jwtToken).
                   token(refreshToken.getToken()).build(), HttpStatus.OK);
       }catch (Exception ex){
           return new ResponseEntity<>("Exception in User Service", HttpStatus.INTERNAL_SERVER_ERROR);
       }
   }

   @GetMapping("auth/v1/ping")
    public ResponseEntity<String> validRequest(){
       //if authenticate
       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       if(authentication.isAuthenticated() && authentication != null){
          //extract user id
           String userName = userDetailsService.getUserByUsername(authentication.getName());
           if(Objects.nonNull(userName)){
               return new ResponseEntity<>(userName , HttpStatus.OK);
           }
       }
           return new ResponseEntity<>("Some error in authentication system" , HttpStatus.UNAUTHORIZED);
   }

    @GetMapping("/health")
    public ResponseEntity<Boolean> checkHealth(){
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
