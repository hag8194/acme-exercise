package com.giordano.data.model;

import java.time.LocalTime;
import java.util.Objects;

public class WorkedSchedule {
    private Day day;
    private LocalTime timeStart;
    private LocalTime timeEnd;

    public WorkedSchedule(Day day, LocalTime timeStart, LocalTime timeEnd) {
        this.day = day;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
    }

    public Day getDay() {
        return day;
    }

    public LocalTime getTimeStart() {
        return timeStart;
    }

    public LocalTime getTimeEnd() {
        return timeEnd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkedSchedule that = (WorkedSchedule) o;
        return day == that.day &&
            timeStart.equals(that.timeStart) &&
            timeEnd.equals(that.timeEnd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, timeStart, timeEnd);
    }
}
