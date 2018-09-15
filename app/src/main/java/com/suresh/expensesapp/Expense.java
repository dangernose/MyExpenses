package com.suresh.expensesapp;

import java.math.BigDecimal;
import java.util.Date;

public class Expense {
    Long ExpenseId;
    String ExpenseName;
    Integer CategoryId;
    BigDecimal ExpenseAmount;
    String date;
    public Expense(Long expenseId, String expenseName, Integer categoryId, BigDecimal expenseAmount) {
        ExpenseId = expenseId;
        ExpenseName = expenseName;
        CategoryId = categoryId;
        ExpenseAmount = expenseAmount;
    }


    public Long getExpenseId() {
        return ExpenseId;
    }

    public void setExpenseId(Long expenseId) {
        ExpenseId = expenseId;
    }

    public String getExpenseName() {
        return ExpenseName;
    }

    public void setExpenseName(String expenseName) {
        ExpenseName = expenseName;
    }

    public Integer getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(Integer categoryId) {
        CategoryId = categoryId;
    }

    public BigDecimal getExpenseAmount() {
        return ExpenseAmount;
    }

    public void setExpenseAmount(BigDecimal expenseAmount) {
        ExpenseAmount = expenseAmount;
    }
}
