package org.example.task3;

import org.example.task2.HttpStatusImageDownloader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HttpImageStatusCli {
    private HttpStatusImageDownloader httpStatusImageDownloader;

    public HttpImageStatusCli() {
        this.httpStatusImageDownloader = new HttpStatusImageDownloader();
    }

    public void askStatus() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.print("Enter HTTP status code: ");
            String input = bufferedReader.readLine();

            try {
                int statusCode = Integer.parseInt(input);
                httpStatusImageDownloader.downloadStatusImage(statusCode);
            } catch (NumberFormatException e) {
                System.out.println("Please enter valid number.");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } catch (IOException e) {
            System.err.println("Error reading input: " + e.getMessage());
        }
    }
}
