package com.giordano.data.model;

import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkReport that = (WorkReport) o;
        return employeeName.equals(that.employeeName) &&
            workedSchedules.equals(that.workedSchedules);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeName, workedSchedules);
    }
}
