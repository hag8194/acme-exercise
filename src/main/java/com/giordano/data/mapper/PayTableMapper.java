package com.giordano.data.mapper;

import com.giordano.data.model.Day;
import com.giordano.data.model.PayLine;
import com.giordano.data.model.PayTable;
import static com.giordano.data.utils.MapperUtils.*;

import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PayTableMapper {

    private PayLine generatePayLine(String timesAndAmount) {
        String[] auxArray = timesAndAmount.split(",");
        String[] timeArray = auxArray[0].split("-");
        Double amount = Double.valueOf(auxArray[1]);

        List<LocalTime> localTimeList = Arrays.stream(timeArray)
            .flatMap(s -> {
                String[] stringArray = s.split(":");
                return Stream.of(LocalTime.of(Integer.parseInt(stringArray[0]), Integer.parseInt(stringArray[1])));
            }).collect(Collectors.toList());

        return new PayLine(localTimeList.get(0), localTimeList.get(1), amount);
    }

    private void updatePayLineMap(Day day, String[] fileLine, Map<Day, List<PayLine>> payLineMap) {
        List<PayLine> payLineList;
        if (payLineMap.containsKey(day)) {
            payLineList = payLineMap.get(day);
            payLineList.add(generatePayLine(fileLine[1]));
        } else {
            payLineList = new ArrayList<>();
            payLineList.add(generatePayLine(fileLine[1]));
            payLineMap.put(day, payLineList);
        }
    }

    private void processString(AtomicReference<String> currencyCode, Map<Day, List<PayLine>> payLineMap, String[] fileLine) {
        switch (fileLine[0]) {
            case CURRENCY_CODE:
                currencyCode.set(fileLine[1]);
                break;
            case MON:
                updatePayLineMap(Day.MON, fileLine, payLineMap);
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
