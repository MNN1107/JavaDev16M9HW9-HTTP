package org.example.task2;

import org.example.task1.HttpStatusChecker;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusImageDownloader {
    private HttpStatusChecker httpStatusChecker;

    public HttpStatusImageDownloader(){
        this.httpStatusChecker = new HttpStatusChecker();
    }
    public void downloadStatusImage(int code) throws IOException {
        String imageUrl = httpStatusChecker.getStatusImage(code);

        URL url = new URL(imageUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if(responseCode == HttpURLConnection.HTTP_OK) {
            String fileName = "status_" + code + ".jpg";
            try (InputStream inputStream = connection.getInputStream();
                 OutputStream outputStream = new FileOutputStream(fileName)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                System.out.println("Image downloaded successfully.");
            } catch (IOException e) {
                throw new IOException("Failed to download image: " + e.getMessage());
            }
            } else {
                throw new IOException("HTTP status code: " + responseCode);
            }
        }
    }

