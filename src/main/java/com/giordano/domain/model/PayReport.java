package com.giordano.domain.model;

import java.util.Objects;

public class PayReport {
    private String employeeName;
    private Double amount;
    private String currencyCode;

    public PayReport(String employeeName, Double amount, String currencyCode) {
        this.employeeName = employeeName;
        this.amount = amount;
        this.currencyCode = currencyCode;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public Double getAmount() {
        return amount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PayReport payReport = (PayReport) o;
        return employeeName.equals(payReport.employeeName) &&
            amount.equals(payReport.amount) &&
            currencyCode.equals(payReport.currencyCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeName, amount, currencyCode);
    }
}
