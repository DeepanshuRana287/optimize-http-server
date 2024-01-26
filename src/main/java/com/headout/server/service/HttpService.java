package com.headout.server.service;


import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HttpService {
    public String getFileContent(String filePath) throws IOException {
        Resource resource = new ClassPathResource(filePath);
        return StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);
    }

    public String getSpecificLine(String filePath, int lineNumber) throws IOException {
        Resource resource = new ClassPathResource(filePath);
        List<String> lines = readLinesFromResource(resource);

        if (lineNumber >= 1 && lineNumber <= lines.size()) {
            return lines.get(lineNumber - 1);
        } else {
            throw new RuntimeException("Invalid Line Number");
        }
    }

    private List<String> readLinesFromResource(Resource resource) throws IOException {
        try (InputStream inputStream = resource.getInputStream();
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(inputStreamReader)) {

            return reader.lines().collect(Collectors.toList());
        }
    }
}
