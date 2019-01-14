package com.giordano.presentation.controller;

import com.giordano.domain.service.WorkReportService;

public class MainController {
    private WorkReportService workReportService;

    public MainController(WorkReportService workReportService) {
        this.workReportService = workReportService;
    }

    public void generatePayReport() {
        workReportService.getPayReportList();
    }
}
