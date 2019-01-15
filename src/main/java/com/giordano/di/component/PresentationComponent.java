package com.giordano.di.component;

import com.giordano.di.module.PresentationModule;

public class PresentationComponent {

    private PresentationModule presentationModule;

    private PresentationComponent(PresentationModule presentationModule) {
        this.presentationModule = presentationModule;
    }

    public PresentationModule getPresentationModule() {
        return presentationModule;
    }

    public static class Builder {
        private PresentationModule presentationModule;

        public Builder setPresentationModule(PresentationModule presentationModule) {
            this.presentationModule = presentationModule;
            return this;
        }

        public PresentationComponent build() {
            return new PresentationComponent(presentationModule);
        }
    }
}
