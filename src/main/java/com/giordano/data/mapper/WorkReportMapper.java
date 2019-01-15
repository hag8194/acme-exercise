package com.giordano.data.mapper;

import com.giordano.data.model.Day;
import com.giordano.data.model.WorkReport;
import com.giordano.data.model.WorkedSchedule;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static com.giordano.data.utils.MapperUtils.*;

public class WorkReportMapper {

    private Day getDayOfWeek(String rawWorkedSchedule) {
        String dayString = rawWorkedSchedule.substring(0, 2);
        switch (dayString) {
            case MO:
                return Day.MO;
            case TU:
                return Day.TU;
            case WE:
                return Day.WE;
            case TH:
                return Day.TH;
            case FR:
                return Day.FR;
            case SA:
                return Day.SA;
        }
        return Day.SU;
    }

    private List<WorkedSchedule> mapWorkedSchedules(String fullRawWorkedSchedule) {
        String[] rawWorkedSchedules = fullRawWorkedSchedule.split(",");
        List<WorkedSchedule> workedSchedules = new ArrayList<>();

        for(String rawWorkedSchedule : rawWorkedSchedules) {
            Day day = getDayOfWeek(rawWorkedSchedule);
            String rawStartAndEndTime = rawWorkedSchedule.replace(day.toString(), "");
            List<LocalTime> startAndEndTime = mapStartAndEndTime(rawStartAndEndTime.split("-"));
            workedSchedules.add(new WorkedSchedule(day, startAndEndTime.get(0), startAndEndTime.get(1)));
        }

        return workedSchedules;
    }

    public List<WorkReport> convert(Stream<String> stream) {
        List<WorkReport> workReports = new ArrayList<>();
        stream.forEach(s -> {
            String[] rawWorkReport = s.split("=");
            String employeeName = rawWorkReport[0];
            List<WorkedSchedule> workedSchedules = mapWorkedSchedules(rawWorkReport[1]);
            workReports.add(new WorkReport(employeeName, workedSchedules));
        });

        return workReports;
    }
}
