package com.github.nobsust.dex.api;

/**
 * Created by Sam on 2/1/2017.
 */
public class ExpenseDto {

    private Integer id;
    private String date;
    private Integer amount;

    public ExpenseDto() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
