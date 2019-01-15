package com.giordano.domain.service;

import com.giordano.data.repository.PayTableRepository;
import com.giordano.data.repository.WorkReportRepository;
import com.giordano.domain.model.PayReport;

import java.util.List;

public class WorkReportServiceImpl implements WorkReportService {
    private WorkReportRepository workReportRepository;
    private PayTableRepository payTableRepository;

    public WorkReportServiceImpl(WorkReportRepository workReportRepository, PayTableRepository payTableRepository) {
        this.workReportRepository = workReportRepository;
        this.payTableRepository = payTableRepository;
    }

    @Override
    public List<PayReport> getPayReports() {
        workReportRepository.getAllWorkReport();
        payTableRepository.getPayTable();
        return null;
    }
}
