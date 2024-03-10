package org.example.task2;

import java.io.IOException;

public class HttpStatusImageDownloaderTests {
    public static void main(String[] args) {
        HttpStatusImageDownloader httpStatusImageDownloader = new HttpStatusImageDownloader();

        try {
            httpStatusImageDownloader.downloadStatusImage(100);
        } catch (IOException e) {
            System.out.println("Error downloading image: " + e.getMessage());
        }

        try {
            httpStatusImageDownloader.downloadStatusImage(800);
        } catch (IOException e) {
            System.out.println("Error downloading image: " + e.getMessage());
        }
    }
}

