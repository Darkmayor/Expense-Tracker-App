package com.ExpenseTracker.Authentication.model;

import com.ExpenseTracker.Authentication.Entities.UserInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class UserInfoDto extends UserInfo {

    @NonNull
    private String firstName; // first_name
    @NonNull
    private String lastName; //last_name
    @NonNull
    private Long phoneNumber;
    @NonNull
    private String email; // email


}
