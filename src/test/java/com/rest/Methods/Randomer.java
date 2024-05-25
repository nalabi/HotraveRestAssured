package com.rest.Methods;
import java.util.Random;

public class Randomer {


    public static String generateRandomChars() {
        StringBuilder sb = new StringBuilder();
        String RandUser = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        Random rand = new Random();
        int length = 15;
        for (int i = 0; i < length; i++) {
            int index = rand.nextInt(RandUser.length());
            char RandomChar = RandUser.charAt(index);
            sb.append(RandomChar);
        }
return sb.toString();
    }


}

