package com.tracker.ExpenseTrackerAPI.repository;

import com.tracker.ExpenseTrackerAPI.model.AuthenticationToken;
import com.tracker.ExpenseTrackerAPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthenticationToken extends JpaRepository<AuthenticationToken,Long> {
    AuthenticationToken findFirstByTokenValue(String authTokenValue);
    AuthenticationToken findFirstByUser(User user);
}
