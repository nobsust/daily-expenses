package com.github.nobsust.dex.core;

import java.time.LocalDate;

/**
 * Created by Sam on 2/1/2017.
 */
public class Expense {

    private Integer id;
    private LocalDate date;
    private Integer amount;

    public Expense() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(String strDate) {

        this.date = date;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
