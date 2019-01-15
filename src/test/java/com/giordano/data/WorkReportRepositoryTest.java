package com.giordano.data;

import com.giordano.MockApplication;
import com.giordano.common.BaseTest;
import com.giordano.data.model.WorkReport;
import com.giordano.data.repository.WorkReportRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class WorkReportRepositoryTest  extends BaseTest {
    private WorkReportRepository workReportRepository;

    @Before
    public void setUp() {
        MockApplication mockApplication = new MockApplication();
        workReportRepository = mockApplication.getDataModule().provideWorkReportRepository();
    }

    @Test
    public void requestedPayTableEqualsToExpectedTest() {
        List<WorkReport> expectedMockReports = MockData.getMockWorkReports();
        assertEquals(expectedMockReports, workReportRepository.getAllWorkReport());
    }
}
