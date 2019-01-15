package com.giordano.data.model;

import java.time.LocalTime;

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

    public void setDay(Day day) {
        this.day = day;
    }

    public LocalTime getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(LocalTime timeStart) {
        this.timeStart = timeStart;
    }

    public LocalTime getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(LocalTime timeEnd) {
        this.timeEnd = timeEnd;
    }
}
