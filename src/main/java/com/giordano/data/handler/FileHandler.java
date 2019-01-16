package com.giordano.data.handler;

import com.giordano.data.utils.FileUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public class FileHandler {
    private ClassLoader classLoader;
    private FileSystem fs = null;

    public FileHandler() {
        classLoader = getClass().getClassLoader();
    }

    public Stream<String> importWorkReportFile() {
        Stream<String> stream = null;
        try {
            URI uri = Objects.requireNonNull(classLoader.getResource(FileUtils.WORK_REPORT_FILE_PATH)).toURI();
            final Map<String, String> env = new HashMap<>();
            final String[] array = uri.toString().split("!");

            final Path path;
            if(array.length == 2) {
                if(Objects.nonNull(fs))
                    fs.close();
                fs = FileSystems.newFileSystem(URI.create(array[0]), env);
                path = fs.getPath(array[1]);
            } else {
                path = Paths.get(uri);
            }
            stream = getStreamFromFile(path);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
        return stream;
    }

    public Stream<String> importPayTableFile() {
        Stream<String> stream = null;
        try {
            URI uri = Objects.requireNonNull(classLoader.getResource(FileUtils.PAY_TABLE_FILE_PATH)).toURI();
            final Map<String, String> env = new HashMap<>();
            final String[] array = uri.toString().split("!");

            final Path path;
            if(array.length == 2) {
                if(Objects.nonNull(fs))
                    fs.close();
                fs = FileSystems.newFileSystem(URI.create(array[0]), env);
                path = fs.getPath(array[1]);
            } else {
                path = Paths.get(uri);
            }
            stream = getStreamFromFile(path);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
        return stream;
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
