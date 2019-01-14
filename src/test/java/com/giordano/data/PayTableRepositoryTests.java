package com.giordano.data;

import com.giordano.MockApplication;
import com.giordano.data.model.Day;
import com.giordano.data.model.PayLine;
import com.giordano.data.model.PayTable;
import com.giordano.data.repository.PayTableRepository;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class PayTableRepositoryTests {
    private PayTableRepository payTableRepository;

    @Before
    public void setUp() {
        MockApplication mockApplication = new MockApplication();
        payTableRepository = mockApplication.getDataModule().providePayTableRepository();
    }

    @Test
    public void requestedPayTableEqualsToExpected() {
        PayTable expectedPayTable = new PayTable("USD", getMockPayLineMap());
        assertEquals(expectedPayTable, payTableRepository.getPayTable());
    }

    private Map<Day, List<PayLine>> getMockPayLineMap() {
        Map<Day, List<PayLine>> mockPayLineMap = new HashMap<>();
        mockPayLineMap.put(Day.MON, Arrays.asList(
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
}
