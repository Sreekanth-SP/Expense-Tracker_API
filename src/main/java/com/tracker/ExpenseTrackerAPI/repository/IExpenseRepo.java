package com.tracker.ExpenseTrackerAPI.repository;

import com.tracker.ExpenseTrackerAPI.model.Expense;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IExpenseRepo extends JpaRepository<Expense,Long> {
    List<Expense> findAllExpenseByDate(LocalDate date);

    @Transactional
    @Modifying
    @Query(value = "select * from Expense where user_id= :userId AND date >= :startDate AND date <= :endDate",nativeQuery = true)
    List<Expense> findByExpenseByUserIdAndStartDateAfterAndEndDateBefore(Long userId, LocalDate startDate, LocalDate endDate);
}
