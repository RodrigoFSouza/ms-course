package br.com.cronos.hrpayroll.entities;


import java.io.Serializable;

public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private double dayleIncome;

    private int days;

    public Payment() {
    }

    public Payment(String name, double dayleIncome, int days) {
        this.name = name;
        this.dayleIncome = dayleIncome;
        this.days = days;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDayleIncome() {
        return dayleIncome;
    }

    public void setDayleIncome(double dayleIncome) {
        this.dayleIncome = dayleIncome;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public double getTotal() {
        return this.days * this.dayleIncome;
    }
}
