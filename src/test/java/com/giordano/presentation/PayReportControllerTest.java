package com.giordano.presentation;

import com.giordano.common.BaseTest;
import com.giordano.domain.MockDomainData;
import com.giordano.domain.service.PayReportService;
import com.giordano.presentation.controller.PayReportController;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

public class PayReportControllerTest extends BaseTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Mock
    PayReportService payReportService;

    @Before
    public void setUp() {
        when(payReportService.getAllPayReports()).thenReturn(MockDomainData.getMockPayReports());
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void setDown() {
        System.setOut(originalOut);
    }

    @Test
    public void outputExpectedStringValueTest() {
        PayReportController payReportController = new PayReportController(payReportService);
        payReportController.generatePayReport();

        assertThat(outContent.toString(), is(MockPresentationData.MOCK_VIEW_OUTPUT));
    }
}
