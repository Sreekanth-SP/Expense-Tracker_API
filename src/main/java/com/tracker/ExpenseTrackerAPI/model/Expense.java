package com.tracker.ExpenseTrackerAPI.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long expenseId;

    private String title;
    private String description;
    private Double price;
    private LocalDate date;
    private LocalTime time;

    @ManyToOne
    @JoinColumn(name = "fk_user_id")
    private User user;


}
