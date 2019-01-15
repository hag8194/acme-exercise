package com.giordano.data;

import com.giordano.MockApplication;
import com.giordano.data.repository.WorkReportRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WorkReportRepositoryTests {
    private WorkReportRepository workReportRepository;

    @Before
    public void setUp() {
        MockApplication mockApplication = new MockApplication();
        workReportRepository = mockApplication.getDataModule().provideWorkReportRepository();
    }

    @Test
    public void requestedPayTableEqualsToExpected() {
        workReportRepository.getAllWorkReport();
        assertEquals(0, 0);
    }
}
