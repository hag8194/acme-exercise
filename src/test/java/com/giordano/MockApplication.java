package com.giordano;

import com.giordano.di.module.DataModule;
import com.giordano.di.module.DomainModule;
import com.giordano.di.module.PresentationModule;

public class MockApplication extends Application {
    public DataModule getDataModule() {
        return dataComponent.getDataModule();
    }

    public DomainModule getDomainModule() {
        return domainComponent.getDomainModule();
    }

    public PresentationModule getPresentationModule() {
        return presentationComponent.getPresentationModule();
    }
}
