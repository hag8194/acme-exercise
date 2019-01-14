package com.giordano;

import com.giordano.di.component.DataComponent;
import com.giordano.di.component.DomainComponent;
import com.giordano.di.component.PresentationComponent;
import com.giordano.di.module.DataModule;
import com.giordano.di.module.DomainModule;
import com.giordano.di.module.PresentationModule;
import com.giordano.presentation.controller.MainController;

import java.util.Objects;

public class Application {
    protected static DataComponent dataComponent;
    protected static DomainComponent domainComponent;
    protected static PresentationComponent presentationComponent;

    private DataComponent getDataComponent() {
        if(Objects.isNull(dataComponent))
            dataComponent = new DataComponent.Builder()
                .setDataModule(new DataModule())
                .build();
        return dataComponent;
    }

    private DomainComponent getDomainComponent(DataComponent dataComponent) {
        if(Objects.isNull(domainComponent))
            domainComponent = new DomainComponent.Builder()
                .setDomainModule(new DomainModule(dataComponent))
                .build();
        return domainComponent;
    }

    private PresentationComponent getPresentationComponent(DomainComponent domainComponent) {
        if(Objects.isNull(presentationComponent))
            presentationComponent = new PresentationComponent.Builder()
                .setPresentationModule(new PresentationModule(domainComponent))
                .build();
        return presentationComponent;
    }

    protected Application() {
        dataComponent = getDataComponent();
        domainComponent = getDomainComponent(dataComponent);
        presentationComponent = getPresentationComponent(domainComponent);
    }

    void start() {
        PresentationModule presentationModule = presentationComponent.getPresentationModule();
        MainController mainController = presentationModule.provideMainController();
        mainController.generatePayReport();
    }
}
