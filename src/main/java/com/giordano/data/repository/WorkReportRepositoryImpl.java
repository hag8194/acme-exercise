package com.giordano.data.repository;

import com.giordano.data.handler.FileHandler;
import com.giordano.data.mapper.WorkReportMapper;
import com.giordano.data.model.WorkReport;

import java.util.List;

public class WorkReportRepositoryImpl implements WorkReportRepository {
    private FileHandler fileHandler;
    private WorkReportMapper workReportMapper;

    public WorkReportRepositoryImpl(FileHandler fileHandler, WorkReportMapper workReportMapper) {
        this.fileHandler = fileHandler;
        this.workReportMapper = workReportMapper;
    }

    @Override
    public List<WorkReport> getAllWorkReport() {
        return workReportMapper.convert(fileHandler.importWorkReportFile());
    }
}
