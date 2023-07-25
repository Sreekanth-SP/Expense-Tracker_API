package com.tracker.ExpenseTrackerAPI.repository;

import com.tracker.ExpenseTrackerAPI.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IExpenseRepo extends JpaRepository<Expense,Long> {
    List<Expense> findAllExpenseByDate(LocalDate date);
    List<Expense> findByUser_UserIdAndDateBetween(Long userId, LocalDate startDate,LocalDate endDate);
}
