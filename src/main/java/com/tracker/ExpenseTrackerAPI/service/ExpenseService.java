package com.tracker.ExpenseTrackerAPI.service;

import com.tracker.ExpenseTrackerAPI.model.Expense;
import com.tracker.ExpenseTrackerAPI.repository.IExpenseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class ExpenseService {
    @Autowired
    IExpenseRepo expenseRepo;

    public String createExpense(Expense expense) {
        expenseRepo.save(expense);
        return "Expense added";
    }

    public Expense getExpenseById(Long expenseId) {
        return expenseRepo.findById(expenseId).orElse(null);
    }

    public String updateExpense(Long expenseId, Expense expense) {
        Expense myExpense = getExpenseById(expenseId);
        if(myExpense == null){
            return "Id Not Found";
        }
        myExpense.setTitle(expense.getTitle());
        myExpense.setDescription(expense.getDescription());
        myExpense.setPrice(expense.getPrice());
        myExpense.setDate(expense.getDate());
        myExpense.setTime(expense.getTime());
        expenseRepo.save(myExpense);

        return "Expense updated";
    }

    public String deleteExpenseById(Long expenseId) {
        Expense useLessExpense = getExpenseById(expenseId);
        if(useLessExpense==null){
            return "Id not found";
        }
        expenseRepo.delete(useLessExpense);
        return "Expense Deleted";
    }

    public List<Expense> getExpensesByDate(LocalDate date) {
        return expenseRepo.findAllExpenseByDate(date);
    }

    public Double getTotalExpenditureForMonth(Long userId,LocalDate startDate, LocalDate endDate ) {
        List<Expense> expenses = expenseRepo.findByExpenseByUserIdAndStartDateAfterAndEndDateBefore(userId, startDate, endDate);

        double totalAmount = 0.0;
        for (Expense expense : expenses) {
            totalAmount += expense.getPrice();
        }

        return totalAmount;
    }
}
