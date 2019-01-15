package com.giordano.presentation.view;

import com.giordano.domain.model.PayReport;

import java.util.List;

public class PayReportsView {
    private List<PayReport> payReports;

    public PayReportsView(List<PayReport> payReports) {
        this.payReports = payReports;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        payReports.forEach(payReport -> result.append("The amount to pay ")
            .append(payReport.getEmployeeName())
            .append(" is: ")
            .append(payReport.getAmount())
            .append(" ")
            .append(payReport.getCurrencyCode())
            .append("\n"));

        return result.toString();
    }
}
