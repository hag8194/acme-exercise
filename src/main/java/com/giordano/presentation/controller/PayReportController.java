package com.giordano.presentation.controller;

import com.giordano.domain.model.PayReport;
import com.giordano.domain.service.PayReportService;
import com.giordano.presentation.view.PayReportsView;

import java.util.List;

public class PayReportController {
    private PayReportService payReportService;

    public PayReportController(PayReportService payReportService) {
        this.payReportService = payReportService;
    }

    public void generatePayReport() {
        List<PayReport> payReports = payReportService.getAllPayReports();
        PayReportsView payReportsView = new PayReportsView(payReports);
        System.out.println(payReportsView);
    }
}
