package com.giordano.di.module;

import com.giordano.di.component.DomainComponent;
import com.giordano.presentation.controller.MainController;

import java.util.Objects;

public class PresentationModule extends Module {
    private DomainModule domainModule;
    private MainController mainController;

    public PresentationModule(DomainComponent domainComponent) {
        this.domainModule = domainComponent.getDomainModule();
    }

    public MainController provideMainController() {
        if(Objects.isNull(mainController))
            mainController = new MainController(domainModule.provideWorkReportService());
        return mainController;
    }
}
