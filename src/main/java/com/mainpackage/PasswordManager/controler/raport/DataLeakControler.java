package com.mainpackage.PasswordManager.controler.raport;

import com.mainpackage.PasswordManager.service.LoginDataServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("raport")
public class DataLeakControler {
    private final String API_KEY = "f17657dce3df5f70fcde4cef39be3e1f";
    private final String TARGET_URL = "https://leak-lookup.com/api/search";
    private final String METHOD = "POST";
    private final String PROPERTY = "application/x-www-form-urlencoded";

    public DataLeakControler() throws MalformedURLException {
    }

    @GetMapping("/dataleak/{type}/{input}")
    public String isYourDataLeaked(@PathVariable String type,@PathVariable String input) throws IOException {
        HttpURLConnection connection = createConnection();
        addRequest(connection,type,input);
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            return showReslutRequest(connection);
        } else {
            return "Failed to get response from API. Response code: " + responseCode;
        }
    }

    public HttpURLConnection createConnection() throws IOException {
        HttpURLConnection connection;
        URL url = new URL(TARGET_URL);
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(METHOD);
        connection.setRequestProperty("Content-Type", PROPERTY);
        connection.setRequestProperty("Content-Language", "en-US");
        connection.setUseCaches(false);
        connection.setDoOutput(true);
        return connection;
    }

    public void addRequest(HttpURLConnection con,String type,String input) throws IOException {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("key", API_KEY);
        parameters.put("type", type);
        parameters.put("query", input);

        con.setDoOutput(true);
        try (DataOutputStream out = new DataOutputStream(con.getOutputStream())) {
            out.writeBytes(getParamsString(parameters));
            out.flush();
        }
    }

    public static String getParamsString(Map<String, String> params) throws UnsupportedEncodingException {
        return params.entrySet()
                .stream()
                .map(entry -> {
                    try {
                        return URLEncoder.encode(entry.getKey(), "UTF-8") + "=" + URLEncoder.encode(entry.getValue(), "UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.joining("&"));
    }

    public String showReslutRequest(HttpURLConnection connection) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }
}
