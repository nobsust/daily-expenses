package com.github.nobsust.dex;

/**
 * Created by Sam on 2/1/2017.
 */
public class Expense {

    private Integer id;
    private Integer amount;

    public Expense() {
    }

    public Expense(Integer id, Integer amount) {
        this.id = id;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
