package com.giordano.di.component;

import com.giordano.di.module.PresentationModule;

public class PresentationComponent extends Component {

    private DomainComponent domainComponent;
    private PresentationModule presentationModule;

    private PresentationComponent(DomainComponent domainComponent, PresentationModule presentationModule) {
        this.domainComponent = domainComponent;
        this.presentationModule = presentationModule;
    }

    public DomainComponent getDomainComponent() {
        return domainComponent;
    }

    public PresentationModule getPresentationModule() {
        return presentationModule;
    }

    public static class Builder {
        private DomainComponent domainComponent;
        private PresentationModule presentationModule;

        public Builder setDomainComponent(DomainComponent domainComponent) {
            this.domainComponent = domainComponent;
            return this;
        }

        public Builder setPresentationModule(PresentationModule presentationModule) {
            this.presentationModule = presentationModule;
            return this;
        }

        public PresentationComponent build() {
            return new PresentationComponent(domainComponent, presentationModule);
        }
    }
}
