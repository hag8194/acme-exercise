package com.giordano;

import com.giordano.di.module.DataModule;
import com.giordano.di.module.DomainModule;
import com.giordano.di.module.PresentationModule;
import org.junit.Before;
import org.junit.Test;


public class Main {
    private DataModule dataModule;
    private DomainModule domainModule;
    private PresentationModule presentationModule;

    @Before
    public void setUp() {
        MockApplication mockApplication = new MockApplication();
        dataModule = mockApplication.getDataModule();
        domainModule = mockApplication.getDomainModule();
        presentationModule = mockApplication.getPresentationModule();
    }

    @Test
    public void test() {

    }
}