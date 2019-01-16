package com.giordano.domain.service;

import com.giordano.data.model.*;
import com.giordano.data.repository.PayTableRepository;
import com.giordano.data.repository.WorkReportRepository;
import com.giordano.domain.exception.InvalidWorkReportsSizeException;
import com.giordano.domain.model.PayReport;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.time.temporal.ChronoUnit.HOURS;

public class PayReportServiceImpl implements PayReportService {
    private WorkReportRepository workReportRepository;
    private PayTableRepository payTableRepository;

    public PayReportServiceImpl(WorkReportRepository workReportRepository, PayTableRepository payTableRepository) {
        this.workReportRepository = workReportRepository;
        this.payTableRepository = payTableRepository;
    }

    private PayLine getApplicablePayLine(LocalTime timeStart, LocalTime timeEnd, List<PayLine> payLines) {
        return payLines.stream()
            .filter(payLine -> {
                LocalTime fromTime = payLine.getFromTime();
                LocalTime untilTime = payLine.getUntilTime();

                fromTime = fromTime.minusMinutes(1);

                if(untilTime.equals(LocalTime.MIDNIGHT))
                    untilTime = untilTime.minusMinutes(1);
                else
                    untilTime = untilTime.plusMinutes(1);

                return timeStart.isAfter(fromTime) && timeEnd.isBefore(untilTime);
            })
            .findFirst()
            .orElse(null);
    }

    private double getAmountToPay(LocalTime timeStart, LocalTime timeEnd, List<PayLine> payLines) {
        PayLine payLine = getApplicablePayLine(timeStart, timeEnd, payLines);
        double amount = 0.0;
        if(Objects.nonNull(payLine))
            amount = payLine.getAmount();
        return amount;
    }

    private List<PayReport> generatePayReports(List<WorkReport> workReports, PayTable payTable) {
        List<PayReport> payReports = new ArrayList<>();
        for (WorkReport workReport : workReports) {
            double totalOfPay = 0.0;
            for (WorkedSchedule workedSchedule : workReport.getWorkedSchedules()) {
                Day day = workedSchedule.getDay();
                LocalTime timeStart = workedSchedule.getTimeStart();
                LocalTime timeEnd = workedSchedule.getTimeEnd();
                long workedHours = HOURS.between(timeStart, timeEnd);

                List<PayLine> payLines = payTable.getPayLineMap().get(day);
                double amountToPay = getAmountToPay(timeStart, timeEnd, payLines);

                totalOfPay += workedHours * amountToPay;
            }
            payReports.add(new PayReport(workReport.getEmployeeName(), totalOfPay, payTable.getCurrencyCode()));
        }
        return payReports;
    }

    private void validateWorkReportsSize(List<WorkReport> workReports) {
        if(workReports.size() < 5)
            throw new InvalidWorkReportsSizeException("Required at least five sets of data");
    }

    @Override
    public List<PayReport> getAllPayReports() {
        List<WorkReport> workReports = workReportRepository.getAllWorkReport();
        validateWorkReportsSize(workReports);
        PayTable payTable = payTableRepository.getPayTable();
        return generatePayReports(workReports, payTable);
    }
}
