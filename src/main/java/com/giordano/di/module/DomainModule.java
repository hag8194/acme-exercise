package com.giordano.di.module;

import com.giordano.di.component.DataComponent;
import com.giordano.domain.service.WorkReportService;
import com.giordano.domain.service.WorkReportServiceImpl;

import java.util.Objects;

public class DomainModule extends Module {
    private DataModule dataModule;
    private WorkReportService workReportService;

    public DomainModule(DataComponent dataComponent) {
        this.dataModule = dataComponent.getDataModule();
    }

    public WorkReportService provideWorkReportService() {
        if(Objects.isNull(workReportService))
            workReportService = new WorkReportServiceImpl(dataModule.provideWorkReportRepository(),
                    dataModule.providePayTableRepository());
        return workReportService;
    }

}
