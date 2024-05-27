package com.rest.Methods;

import java.util.Random;
import java.util.random.RandomGenerator;

public class Gender {

    public static String getRandomGender() {
        String[] genders = {"Male", "Female"};
        Random random = new Random();
        int index = random.nextInt(genders.length);
        return genders[index];

    }
}
