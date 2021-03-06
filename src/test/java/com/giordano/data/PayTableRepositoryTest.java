package com.giordano.data;

import com.giordano.MockApplication;
import com.giordano.common.BaseTest;
import com.giordano.data.model.PayTable;
import com.giordano.data.repository.PayTableRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PayTableRepositoryTest  extends BaseTest {
    private PayTableRepository payTableRepository;

    @Before
    public void setUp() {
        MockApplication mockApplication = new MockApplication();
        payTableRepository = mockApplication.getDataModule().providePayTableRepository();
    }

    @Test
    public void requestedPayTableEqualsToExpectedTest() {
        PayTable expectedPayTable = MockData.getMockPayTable();
        assertEquals(expectedPayTable, payTableRepository.getPayTable());
    }

}
