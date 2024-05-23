package com.rest.Methods;



//Three steps to implement your function:

//Step#1 You can specify a string, including the chars A-Z and 0-9.

//Like.

    //    String candidateChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
//Step#2 Then if you would like to generate a random char from this candidate string. You can use

 //candidateChars.charAt(random.nextInt(candidateChars.length()));
//Step#3 At last, specify the length of random string to be generated (in your description, it is 17). Writer a for-loop and append the random chars generated in step#2 to StringBuilder object.

//Based on this, here is an example

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

