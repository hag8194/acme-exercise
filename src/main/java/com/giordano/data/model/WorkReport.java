package com.giordano.data.model;

import java.util.List;

public class WorkReport {
    private String employeeName;
    private String rawWorkedSchedule;
    private List<WorkedSchedule> workedScheduleList;

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getRawWorkedSchedule() {
        return rawWorkedSchedule;
    }

    public void setRawWorkedSchedule(String rawWorkedSchedule) {
        this.rawWorkedSchedule = rawWorkedSchedule;
    }

    public List<WorkedSchedule> getWorkedScheduleList() {
        return workedScheduleList;
    }

    public void setWorkedScheduleList(List<WorkedSchedule> workedScheduleList) {
        this.workedScheduleList = workedScheduleList;
    }
}
