package com.giordano.data;

import com.giordano.data.model.Day;
import com.giordano.data.model.PayLine;
import com.giordano.data.model.PayTable;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class MockData {

    static PayTable getMockPayTable() {
        return new PayTable("USD", getMockPayLineMap());
    }

    private static Map<Day, List<PayLine>> getMockPayLineMap() {
        Map<Day, List<PayLine>> mockPayLineMap = new HashMap<>();
        mockPayLineMap.put(Day.MO, Arrays.asList(
                new PayLine(LocalTime.of(0,1), LocalTime.of(9,0), 25.00),
                new PayLine(LocalTime.of(9,1), LocalTime.of(18,0), 15.00),
                new PayLine(LocalTime.of(18,1), LocalTime.of(0,0), 20.00)
        ));

        mockPayLineMap.put(Day.TU, Arrays.asList(
                new PayLine(LocalTime.of(0,1), LocalTime.of(9,0), 25.00),
                new PayLine(LocalTime.of(9,1), LocalTime.of(18,0), 15.00),
                new PayLine(LocalTime.of(18,1), LocalTime.of(0,0), 20.00)
        ));

        mockPayLineMap.put(Day.WE, Arrays.asList(
                new PayLine(LocalTime.of(0,1), LocalTime.of(9,0), 25.00),
                new PayLine(LocalTime.of(9,1), LocalTime.of(18,0), 15.00),
                new PayLine(LocalTime.of(18,1), LocalTime.of(0,0), 20.00)
        ));

        mockPayLineMap.put(Day.TH, Arrays.asList(
                new PayLine(LocalTime.of(0,1), LocalTime.of(9,0), 25.00),
                new PayLine(LocalTime.of(9,1), LocalTime.of(18,0), 15.00),
                new PayLine(LocalTime.of(18,1), LocalTime.of(0,0), 20.00)
        ));

        mockPayLineMap.put(Day.FR, Arrays.asList(
                new PayLine(LocalTime.of(0,1), LocalTime.of(9,0), 25.00),
                new PayLine(LocalTime.of(9,1), LocalTime.of(18,0), 15.00),
                new PayLine(LocalTime.of(18,1), LocalTime.of(0,0), 20.00)
        ));

        mockPayLineMap.put(Day.SA, Arrays.asList(
                new PayLine(LocalTime.of(0,1), LocalTime.of(9,0), 30.00),
                new PayLine(LocalTime.of(9,1), LocalTime.of(18,0), 20.00),
                new PayLine(LocalTime.of(18,1), LocalTime.of(0,0), 25.00)
        ));

        mockPayLineMap.put(Day.SU, Arrays.asList(
                new PayLine(LocalTime.of(0,1), LocalTime.of(9,0), 30.00),
                new PayLine(LocalTime.of(9,1), LocalTime.of(18,0), 20.00),
                new PayLine(LocalTime.of(18,1), LocalTime.of(0,0), 25.00)
        ));

        return mockPayLineMap;
    }

    private MockData() {
    }
}
