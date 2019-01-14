package com.giordano.data.model;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class PayTable {
    private String currencyCode;
    private Map<Day, List<PayLine>> payLineMap;

    public PayTable(String currencyCode, Map<Day, List<PayLine>> payLineMap) {
        this.currencyCode = currencyCode;
        this.payLineMap = payLineMap;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public Map<Day, List<PayLine>> getPayLineMap() {
        return payLineMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PayTable payTable = (PayTable) o;
        return currencyCode.equals(payTable.currencyCode) &&
                payLineMap.equals(payTable.payLineMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currencyCode, payLineMap);
    }
}
