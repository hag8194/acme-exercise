package com.giordano.di.component;

import com.giordano.di.module.DomainModule;

public class DomainComponent {

    private DomainModule domainModule;

    private DomainComponent(DomainModule domainModule) {
        this.domainModule = domainModule;
    }

    public DomainModule getDomainModule() {
        return domainModule;
    }

    public static class Builder {
        private DomainModule domainModule;

        public Builder setDomainModule(DomainModule domainModule) {
            this.domainModule = domainModule;
            return this;
        }

        public DomainComponent build() {
            return new DomainComponent(domainModule);
        }
    }
}
