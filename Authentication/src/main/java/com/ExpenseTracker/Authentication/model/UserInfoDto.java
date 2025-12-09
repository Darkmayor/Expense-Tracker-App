package com.ExpenseTracker.Authentication.model;

import com.ExpenseTracker.Authentication.Entities.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInfoDto extends UserInfo {

    private String firstName; // first_name

    private String lastName; //last_name

    private Long phoneNumber;

    private String email; // email


}
