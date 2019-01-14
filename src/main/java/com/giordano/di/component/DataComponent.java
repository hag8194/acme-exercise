package com.giordano.di.component;

import com.giordano.di.module.DataModule;

public class DataComponent extends Component {
    private DataModule dataModule;

    private DataComponent(DataModule dataModule) {
        this.dataModule = dataModule;
    }

    public DataModule getDataModule() {
        return dataModule;
    }

    public static class Builder {
        private DataModule dataModule;

        public Builder setDataModule(DataModule dataModule) {
            this.dataModule = dataModule;
            return this;
        }

        public DataComponent build() {
            return new DataComponent(dataModule);
        }
    }
}
