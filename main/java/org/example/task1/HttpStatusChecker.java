package org.example.task1;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusChecker {
    private static final String BASE_URL = "https://http.cat/";

    public String getStatusImage(int code) throws IOException {
        String url = BASE_URL + code + ".jpg";
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            return url;
        } else {
            throw new IOException("Error fetching image URL. Response code: " + responseCode);
        }
    }
}