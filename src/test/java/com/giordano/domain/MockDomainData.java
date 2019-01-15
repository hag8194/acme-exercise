package com.giordano.domain;

import com.giordano.domain.model.PayReport;

import java.util.Arrays;
import java.util.List;

public final class MockDomainData {
    public static List<PayReport> getMockPayReports() {
        return Arrays.asList(
            new PayReport("RENE", 215.0, "USD"),
            new PayReport("ASTRID", 85.0, "USD"),
            new PayReport("PEDRO", 215.0, "USD"),
            new PayReport("JESUS", 85.0, "USD"),
            new PayReport("CESAR", 85.0, "USD")
        );
    }
}
