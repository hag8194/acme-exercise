package com.giordano.data.handler;

import com.giordano.data.utils.FileUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileHandler {
    public Stream<String> importWorkReportFile() {
        Path path = Paths.get(FileUtils.WORK_REPORT_FILE_PATH);
        return getStreamFromFile(path);
    }

    public Stream<String> importPayTableFile() {
        Path path = Paths.get(FileUtils.PAY_TABLE_FILE_PATH);
        return getStreamFromFile(path);
    }

    private Stream<String> getStreamFromFile(Path path) {
        Stream<String> stream = null;
        try {
            stream = Files.lines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stream;
    }
}
