package com.giordano.data;

import com.giordano.data.model.*;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class MockData {

    private static Map<Day, List<PayLine>> getMockPayLineMap() {
        Map<Day, List<PayLine>> mockPayLineMap = new HashMap<>();
        mockPayLineMap.put(Day.MO, Arrays.asList(
            new PayLine(LocalTime.of(0, 1), LocalTime.of(9, 0), 25.00),
            new PayLine(LocalTime.of(9, 1), LocalTime.of(18, 0), 15.00),
            new PayLine(LocalTime.of(18, 1), LocalTime.of(0, 0), 20.00)
        ));

        mockPayLineMap.put(Day.TU, Arrays.asList(
            new PayLine(LocalTime.of(0, 1), LocalTime.of(9, 0), 25.00),
            new PayLine(LocalTime.of(9, 1), LocalTime.of(18, 0), 15.00),
            new PayLine(LocalTime.of(18, 1), LocalTime.of(0, 0), 20.00)
        ));

        mockPayLineMap.put(Day.WE, Arrays.asList(
            new PayLine(LocalTime.of(0, 1), LocalTime.of(9, 0), 25.00),
            new PayLine(LocalTime.of(9, 1), LocalTime.of(18, 0), 15.00),
            new PayLine(LocalTime.of(18, 1), LocalTime.of(0, 0), 20.00)
        ));

        mockPayLineMap.put(Day.TH, Arrays.asList(
            new PayLine(LocalTime.of(0, 1), LocalTime.of(9, 0), 25.00),
            new PayLine(LocalTime.of(9, 1), LocalTime.of(18, 0), 15.00),
            new PayLine(LocalTime.of(18, 1), LocalTime.of(0, 0), 20.00)
        ));

        mockPayLineMap.put(Day.FR, Arrays.asList(
            new PayLine(LocalTime.of(0, 1), LocalTime.of(9, 0), 25.00),
            new PayLine(LocalTime.of(9, 1), LocalTime.of(18, 0), 15.00),
            new PayLine(LocalTime.of(18, 1), LocalTime.of(0, 0), 20.00)
        ));

        mockPayLineMap.put(Day.SA, Arrays.asList(
            new PayLine(LocalTime.of(0, 1), LocalTime.of(9, 0), 30.00),
            new PayLine(LocalTime.of(9, 1), LocalTime.of(18, 0), 20.00),
            new PayLine(LocalTime.of(18, 1), LocalTime.of(0, 0), 25.00)
        ));

        mockPayLineMap.put(Day.SU, Arrays.asList(
            new PayLine(LocalTime.of(0, 1), LocalTime.of(9, 0), 30.00),
            new PayLine(LocalTime.of(9, 1), LocalTime.of(18, 0), 20.00),
            new PayLine(LocalTime.of(18, 1), LocalTime.of(0, 0), 25.00)
        ));

        return mockPayLineMap;
    }

    public static PayTable getMockPayTable() {
        return new PayTable("USD", getMockPayLineMap());
    }

    public static List<WorkReport> getMockWorkReports() {
        return Arrays.asList(
            new WorkReport("RENE", Arrays.asList(
                new WorkedSchedule(Day.MO, LocalTime.of(10, 0), LocalTime.of(12, 0)),
                new WorkedSchedule(Day.TU, LocalTime.of(10, 0), LocalTime.of(12, 0)),
                new WorkedSchedule(Day.TH, LocalTime.of(1, 0), LocalTime.of(3, 0)),
                new WorkedSchedule(Day.SA, LocalTime.of(14, 0), LocalTime.of(18, 0)),
                new WorkedSchedule(Day.SU, LocalTime.of(20, 0), LocalTime.of(21, 0))
            )),
            new WorkReport("ASTRID", Arrays.asList(
                new WorkedSchedule(Day.MO, LocalTime.of(10, 0), LocalTime.of(12, 0)),
                new WorkedSchedule(Day.TH, LocalTime.of(12, 0), LocalTime.of(14, 0)),
                new WorkedSchedule(Day.SU, LocalTime.of(20, 0), LocalTime.of(21, 0))
            )),
            new WorkReport("PEDRO", Arrays.asList(
                new WorkedSchedule(Day.MO, LocalTime.of(10, 0), LocalTime.of(12, 0)),
                new WorkedSchedule(Day.TU, LocalTime.of(10, 0), LocalTime.of(12, 0)),
                new WorkedSchedule(Day.TH, LocalTime.of(1, 0), LocalTime.of(3, 0)),
                new WorkedSchedule(Day.SA, LocalTime.of(14, 0), LocalTime.of(18, 0)),
                new WorkedSchedule(Day.SU, LocalTime.of(20, 0), LocalTime.of(21, 0))
            )),
            new WorkReport("JESUS", Arrays.asList(
                new WorkedSchedule(Day.MO, LocalTime.of(10, 0), LocalTime.of(12, 0)),
                new WorkedSchedule(Day.TH, LocalTime.of(12, 0), LocalTime.of(14, 0)),
                new WorkedSchedule(Day.SU, LocalTime.of(20, 0), LocalTime.of(21, 0))
            )),
            new WorkReport("CESAR", Arrays.asList(
                new WorkedSchedule(Day.MO, LocalTime.of(10, 0), LocalTime.of(12, 0)),
                new WorkedSchedule(Day.TH, LocalTime.of(12, 0), LocalTime.of(14, 0)),
                new WorkedSchedule(Day.SU, LocalTime.of(20, 0), LocalTime.of(21, 0))
            ))
        );
    }

    public static List<WorkReport> getMockWorkReportsWithTwoItems() {
        return Arrays.asList(
            new WorkReport("RENE", Arrays.asList(
                new WorkedSchedule(Day.MO, LocalTime.of(10, 0), LocalTime.of(12, 0)),
                new WorkedSchedule(Day.TU, LocalTime.of(10, 0), LocalTime.of(12, 0)),
                new WorkedSchedule(Day.TH, LocalTime.of(1, 0), LocalTime.of(3, 0)),
                new WorkedSchedule(Day.SA, LocalTime.of(14, 0), LocalTime.of(18, 0)),
                new WorkedSchedule(Day.SU, LocalTime.of(20, 0), LocalTime.of(21, 0))
            )),
            new WorkReport("ASTRID", Arrays.asList(
                new WorkedSchedule(Day.MO, LocalTime.of(10, 0), LocalTime.of(12, 0)),
                new WorkedSchedule(Day.TH, LocalTime.of(12, 0), LocalTime.of(14, 0)),
                new WorkedSchedule(Day.SU, LocalTime.of(20, 0), LocalTime.of(21, 0))
            ))
        );
    }

    private MockData() {
    }
}
