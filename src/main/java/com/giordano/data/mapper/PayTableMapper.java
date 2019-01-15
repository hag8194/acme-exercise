package com.giordano.data.mapper;

import com.giordano.data.model.Day;
import com.giordano.data.model.PayLine;
import com.giordano.data.model.PayTable;
import static com.giordano.data.utils.MapperUtils.*;

import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class PayTableMapper {

    private PayLine generatePayLine(String rawTimesAndAmount) {
        String[] timesAndAmount = rawTimesAndAmount.split(",");
        String[] startAndEndTimeArray = timesAndAmount[0].split("-");
        Double amount = Double.valueOf(timesAndAmount[1]);

        List<LocalTime> startAndEndTime = mapStartAndEndTime(startAndEndTimeArray);

        return new PayLine(startAndEndTime.get(0), startAndEndTime.get(1), amount);
    }

    private void updatePayLineMap(Day day, String[] fileLine, Map<Day, List<PayLine>> payLineMap) {
        List<PayLine> payLines;
        if (payLineMap.containsKey(day)) {
            payLines = payLineMap.get(day);
            payLines.add(generatePayLine(fileLine[1]));
        } else {
            payLines = new ArrayList<>();
            payLines.add(generatePayLine(fileLine[1]));
            payLineMap.put(day, payLines);
        }
    }

    private void processString(AtomicReference<String> currencyCode, Map<Day, List<PayLine>> payLineMap, String[] fileLine) {
        switch (fileLine[0]) {
            case CURRENCY_CODE:
                currencyCode.set(fileLine[1]);
                break;
            case MO:
                updatePayLineMap(Day.MO, fileLine, payLineMap);
                break;
            case TU:
                updatePayLineMap(Day.TU, fileLine, payLineMap);
                break;
            case WE:
                updatePayLineMap(Day.WE, fileLine, payLineMap);
                break;
            case TH:
                updatePayLineMap(Day.TH, fileLine, payLineMap);
                break;
            case FR:
                updatePayLineMap(Day.FR, fileLine, payLineMap);
                break;
            case SA:
                updatePayLineMap(Day.SA, fileLine, payLineMap);
                break;
            case SU:
                updatePayLineMap(Day.SU, fileLine, payLineMap);
                break;
        }
    }

    public PayTable convert(Stream<String> stream) {
        AtomicReference<String> currencyCode = new AtomicReference<>();
        Map<Day, List<PayLine>> payLineMap = new HashMap<>();

        stream.filter(s -> !s.isEmpty())
            .forEach(s -> processString(currencyCode, payLineMap, s.split("=")));

        return new PayTable(currencyCode.get(), payLineMap);
    }

}
