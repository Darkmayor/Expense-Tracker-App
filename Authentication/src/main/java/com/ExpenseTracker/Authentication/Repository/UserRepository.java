package com.ExpenseTracker.Authentication.Repository;

import com.ExpenseTracker.Authentication.Entities.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserInfo , Long> {

    public UserInfo findByUsername(String username);
}
