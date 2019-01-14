package com.giordano.data.model;

import java.time.LocalTime;
import java.util.Objects;

public class PayLine {
    private LocalTime fromTime;
    private LocalTime untilTime;
    private Double amount;

    public PayLine(LocalTime fromTime, LocalTime untilTime, Double amount) {
        this.fromTime = fromTime;
        this.untilTime = untilTime;
        this.amount = amount;
    }

    public LocalTime getFromTime() {
        return fromTime;
    }

    public LocalTime getUntilTime() {
        return untilTime;
    }

    public Double getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PayLine payLine = (PayLine) o;
        return fromTime.equals(payLine.fromTime) &&
                untilTime.equals(payLine.untilTime) &&
                amount.equals(payLine.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fromTime, untilTime, amount);
    }
}
