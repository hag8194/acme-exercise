package com.giordano.data.model;

import java.util.List;

public class WorkReport {
    private String employeeName;
    private List<WorkedSchedule> workedSchedules;

    public WorkReport(String employeeName, List<WorkedSchedule> workedSchedules) {
        this.employeeName = employeeName;
        this.workedSchedules = workedSchedules;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public List<WorkedSchedule> getWorkedSchedules() {
        return workedSchedules;
    }
}
