package com.giordano.data.utils;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapperUtils {
    public static final String CURRENCY_CODE = "CURRENCY_CODE";
    public static final String MO = "MO";
    public static final String TU = "TU";
    public static final String WE = "WE";
    public static final String TH = "TH";
    public static final String FR = "FR";
    public static final String SA = "SA";
    public static final String SU = "SU";

    public static List<LocalTime> mapStartAndEndTime(String[] startAndEndTimeArray) {
        return Arrays.stream(startAndEndTimeArray)
            .flatMap(s -> {
                String[] minuteAndSecond = s.split(":");
                return Stream.of(LocalTime.of(Integer.parseInt(minuteAndSecond[0]), Integer.parseInt(minuteAndSecond[1])));
            }).collect(Collectors.toList());
    }

    private MapperUtils() {

    }
}
