package com.giordano.data.repository;

import com.giordano.data.handler.FileHandler;
import com.giordano.data.mapper.PayTableMapper;
import com.giordano.data.model.PayTable;

public class PayTableRepositoryImpl implements PayTableRepository {
    private FileHandler fileHandler;
    private PayTableMapper payTableMapper;

    public PayTableRepositoryImpl(FileHandler fileHandler, PayTableMapper payTableMapper) {
        this.fileHandler = fileHandler;
        this.payTableMapper = payTableMapper;
    }

    @Override
    public PayTable getPayTable() {
        return payTableMapper.convert(fileHandler.importPayTableFile());
    }
}
