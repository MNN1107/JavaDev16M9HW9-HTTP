package org.example.task1;

import java.io.IOException;

public class HttpStatusCheckerTests {
    public static void main(String[] args){

        HttpStatusChecker httpStatusChecker = new HttpStatusChecker();

        try{
            String imageUrl = httpStatusChecker.getStatusImage(520);
            System.out.println("Image URL for status code 520: " + imageUrl);
        }catch (IOException e){
            System.err.println("Error fetching image URL: " + e.getMessage());
        }

        try{
            String imageUrl = httpStatusChecker.getStatusImage(5300);
            System.out.println("Image URL for status code 10000: " + imageUrl);
        }catch (IOException e){
            System.err.println("Error fetching image URL: " + e.getMessage());
        }

        try{
            String imageUrl = httpStatusChecker.getStatusImage(301);
            System.out.println("Image URL for status code 301: " + imageUrl);
        }catch (IOException e){
            System.err.println("Error fetching image URL: " + e.getMessage());
        }
    }
}
