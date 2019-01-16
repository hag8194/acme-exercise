package com.giordano.domain;

import com.giordano.common.BaseTest;
import com.giordano.data.MockData;
import com.giordano.data.model.WorkReport;
import com.giordano.data.repository.PayTableRepository;
import com.giordano.data.repository.WorkReportRepository;
import com.giordano.domain.exception.InvalidWorkReportsSizeException;
import com.giordano.domain.model.PayReport;
import com.giordano.domain.service.PayReportService;
import com.giordano.domain.service.PayReportServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.when;

public class PayReportServiceTest extends BaseTest {

    @Mock
    PayTableRepository payTableRepository;

    @Mock
    WorkReportRepository workReportRepository;

    private PayReportService payReportService;

    @Before
    public void setUp() {
        payReportService = new PayReportServiceImpl(workReportRepository, payTableRepository);
    }

    @Test
    public void requestedPayReportEqualsToExpectedTest() {
        List<PayReport> expectedPayReports = MockDomainData.getMockPayReports();
        when(workReportRepository.getAllWorkReport()).thenReturn(MockData.getMockWorkReports());
        when(payTableRepository.getPayTable()).thenReturn(MockData.getMockPayTable());
        assertEquals(expectedPayReports, payReportService.getAllPayReports());
    }

    @Test(expected = InvalidWorkReportsSizeException.class)
    public void workReportsSizeValidationTest() {
        when(workReportRepository.getAllWorkReport()).thenReturn(MockData.getMockWorkReportsWithTwoItems());
        payReportService.getAllPayReports();
    }
}
