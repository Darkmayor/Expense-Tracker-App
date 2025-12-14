package com.ExpenseTracker.UserService.Repository;

import com.ExpenseTracker.UserService.Entities.UserInfoDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserInfoDTO , String> {

    UserInfoDTO findByUserId(String userId);
}
