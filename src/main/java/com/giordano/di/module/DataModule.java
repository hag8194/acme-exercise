package com.giordano.di.module;

import com.giordano.data.handler.FileHandler;
import com.giordano.data.mapper.PayTableMapper;
import com.giordano.data.mapper.WorkReportMapper;
import com.giordano.data.model.WorkReport;
import com.giordano.data.repository.PayTableRepository;
import com.giordano.data.repository.PayTableRepositoryImpl;
import com.giordano.data.repository.WorkReportRepository;
import com.giordano.data.repository.WorkReportRepositoryImpl;

import java.util.Objects;

public class DataModule extends Module {
    private FileHandler fileHandler;
    private WorkReportMapper workReportMapper;
    private PayTableMapper payTableMapper;
    private WorkReportRepository workReportRepository;
    private PayTableRepository payTableRepository;

    public FileHandler provideFileHandler() {
        if(Objects.isNull(fileHandler))
            fileHandler = new FileHandler();
        return fileHandler;
    }

    public WorkReportMapper provideWorkReportMapper() {
        if(Objects.isNull(workReportMapper))
            workReportMapper = new WorkReportMapper();
        return workReportMapper;
    }

    public PayTableMapper providePayTableMapper() {
        if(Objects.isNull(payTableMapper))
            payTableMapper = new PayTableMapper();
        return payTableMapper;
    }

    public WorkReportRepository provideWorkReportRepository() {
        if(Objects.isNull(workReportRepository))
            workReportRepository = new WorkReportRepositoryImpl(provideFileHandler(), provideWorkReportMapper());
        return workReportRepository;
    }

    public PayTableRepository providePayTableRepository() {
        if(Objects.isNull(payTableRepository))
            payTableRepository = new PayTableRepositoryImpl(provideFileHandler(), providePayTableMapper());
        return payTableRepository;
    }
}
