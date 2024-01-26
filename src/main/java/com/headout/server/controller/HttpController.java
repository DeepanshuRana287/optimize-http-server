package com.headout.server.controller;

import com.headout.server.service.HttpService;
import com.headout.server.utils.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class HttpController {

    private static final String DATA_DIRECTORY = "dataFiles/";
    @Autowired
    private HttpService httpService;

    @GetMapping("/data")
    public ResponseEntity<APIResponse> getData(
            @RequestParam(name = "n") String fileName,
            @RequestParam(name = "m", required = false) Integer lineNumber
    ) {
        String filePath = DATA_DIRECTORY + fileName + ".txt";
        APIResponse apiResponse = new APIResponse();

        try {
            String data = (lineNumber != null) ? httpService.getSpecificLine(filePath, lineNumber) : httpService.getFileContent(filePath);

            setSuccessResponse(apiResponse, data);
        } catch (IOException ex) {
            setErrorResponse(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR, "Failure: " + ex.getMessage());
        } catch (RuntimeException ex) {
            setErrorResponse(apiResponse, HttpStatus.BAD_REQUEST, "Failure: " + ex.getMessage());
        }

        return new ResponseEntity<>(apiResponse, apiResponse.getHttpStatus());
    }

    private void setSuccessResponse(APIResponse apiResponse, String data) {
        apiResponse.setData(data);
        apiResponse.setHttpStatus(HttpStatus.OK);
        apiResponse.setMessage("Success");
    }

    private void setErrorResponse(APIResponse apiResponse, HttpStatus status, String message) {
        apiResponse.setHttpStatus(status);
        apiResponse.setMessage(message);
    }


}
