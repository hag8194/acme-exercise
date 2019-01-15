package com.giordano.di.module;

import com.giordano.di.component.DomainComponent;
import com.giordano.presentation.controller.PayReportController;

import java.util.Objects;

public class PresentationModule extends Module {
    private DomainModule domainModule;
    private PayReportController payReportController;

    public PresentationModule(DomainComponent domainComponent) {
        this.domainModule = domainComponent.getDomainModule();
    }

    public PayReportController provideMainController() {
        if(Objects.isNull(payReportController))
            payReportController = new PayReportController(domainModule.provideWorkReportService());
        return payReportController;
    }
}
