package com.tracker.ExpenseTrackerAPI.controller;

import com.tracker.ExpenseTrackerAPI.model.Expense;
import com.tracker.ExpenseTrackerAPI.model.User;
import com.tracker.ExpenseTrackerAPI.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class ExpenseController {
    @Autowired
    ExpenseService expenseService;

    @PostMapping("expense")
    public String createExpense(@RequestBody Expense expense) {
        return expenseService.createExpense(expense);
    }
    @GetMapping("expense/id/{expenseId}")
    public Expense getExpenseById(@PathVariable Long expenseId) {
        return expenseService.getExpenseById(expenseId);
    }
    @PutMapping("expense/id/{expenseId}")
    public String updateExpense(@PathVariable Long expenseId, @RequestParam Expense expense) {
        return expenseService.updateExpense(expenseId, expense);
    }

    @DeleteMapping("expense/id/{expenseId}")
    public String deleteExpenseById(@PathVariable Long expenseId) {
        return expenseService.deleteExpenseById(expenseId);
    }


    @GetMapping("expense/date")
    public List<Expense> getExpensesByDate(@RequestParam LocalDate date) {
        return expenseService.getExpensesByDate(date);
    }

    @GetMapping("expense/report/dates")
    public Double getTotalExpenditureForMonth(@RequestParam Long userId,@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        return expenseService.getTotalExpenditureForMonth(userId,startDate,endDate);

    }
}
