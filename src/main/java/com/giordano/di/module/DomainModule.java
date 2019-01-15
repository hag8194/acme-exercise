package com.giordano.di.module;

import com.giordano.di.component.DataComponent;
import com.giordano.domain.service.PayReportService;
import com.giordano.domain.service.PayReportServiceImpl;

import java.util.Objects;

public class DomainModule extends Module {
    private DataModule dataModule;
    private PayReportService payReportService;

    public DomainModule(DataComponent dataComponent) {
        this.dataModule = dataComponent.getDataModule();
    }

    public PayReportService provideWorkReportService() {
        if(Objects.isNull(payReportService))
            payReportService = new PayReportServiceImpl(dataModule.provideWorkReportRepository(),
                    dataModule.providePayTableRepository());
        return payReportService;
    }

}
