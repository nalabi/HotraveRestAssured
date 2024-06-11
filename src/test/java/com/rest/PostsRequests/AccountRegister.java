package com.rest.PostsRequests;

import com.rest.Methods.Gender;
import com.rest.Methods.Randomer;

public class AccountRegister {

    private String email;
    private String username;
    private String knownAs;
    private String gender;
    private String dateOfBirth;
    private String city;
    private String country;
    private String password;
    private String confirmPassword;


    // Getters and setters
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getKnownAs() { return knownAs; }
    public void setKnownAs(String knownAs) { this.knownAs = knownAs; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getConfirmPassword() { return confirmPassword; }
    public void setConfirmPassword(String confirmPassword) { this.confirmPassword = confirmPassword; }


    public String emptyEmail() {

        setEmail("");
        setUsername(Randomer.generateRandomChars() + "@test.com");
        setKnownAs(Randomer.generateRandomName());
        setGender(Gender.getRandomGender());
        setDateOfBirth("2000-05-22T15:56:15.057Z");
        setCity("Durban");
        setCountry("South Africa");
        setPassword("444PCCle");
        return "The Email field is required.";
    }

    public void emptyPassword() {
        AccountRegister user = new AccountRegister();
        user.setEmail(Randomer.generateRandomChars()+"@test.com");
        user.setUsername(Randomer.generateRandomChars()+"@test.com");
        user.setKnownAs(Randomer.generateRandomName());
        user.setGender(Gender.getRandomGender());
        user.setDateOfBirth("2000-05-22T15:56:15.057Z");
        user.setCity("Durban");
        user.setCountry("South Africa");
        user.setPassword("");

    }
    public void emptyConfirmPassword() {
        AccountRegister user = new AccountRegister();
        user.setEmail(Randomer.generateRandomChars()+"@test.com");
        user.setUsername(Randomer.generateRandomChars()+"@test.com");
        user.setKnownAs(Randomer.generateRandomName());
        user.setGender(Gender.getRandomGender());
        user.setDateOfBirth("2000-05-22T15:56:15.057Z");
        user.setCity("Durban");
        user.setCountry("South Africa");
        user.setPassword("444Pule");
    }
    public void emptyGender() {
        AccountRegister user = new AccountRegister();
        user.setEmail(Randomer.generateRandomChars()+"@test.com");
        user.setUsername(Randomer.generateRandomChars()+"@test.com");
        user.setKnownAs(Randomer.generateRandomName());
        user.setGender("");
        user.setDateOfBirth("2000-05-22T15:56:15.057Z");
        user.setCity("Durban");
        user.setCountry("South Africa");
        user.setPassword("444Pule");
    }
    public void emptyDateOfBirth() {
        AccountRegister user = new AccountRegister();
        user.setEmail(Randomer.generateRandomChars()+"@test.com");
        user.setUsername(Randomer.generateRandomChars()+"@test.com");
        user.setKnownAs(Randomer.generateRandomName());
        user.setGender(Gender.getRandomGender());
        user.setDateOfBirth("");
        user.setCity("Durban");
        user.setCountry("South Africa");
        user.setPassword("444Pule");
    }
    public void emptyCity() {
        AccountRegister user = new AccountRegister();
        user.setEmail(Randomer.generateRandomChars()+"@test.com");
        user.setUsername(Randomer.generateRandomChars()+"@test.com");
        user.setKnownAs(Randomer.generateRandomName());
        user.setGender(Gender.getRandomGender());
        user.setDateOfBirth("2000-05-22T15:56:15.057Z");
        user.setCity("");
        user.setCountry("South Africa");
        user.setPassword("444Pule");
    }
    public void emptyCountry() {
        AccountRegister user = new AccountRegister();
        user.setEmail(Randomer.generateRandomChars()+"@test.com");
        user.setUsername(Randomer.generateRandomChars()+"@test.com");
        user.setKnownAs(Randomer.generateRandomName());
        user.setGender(Gender.getRandomGender());
        user.setDateOfBirth("2000-05-22T15:56:15.057Z");
        user.setCity("Durban");
        user.setCountry("");
        user.setPassword("444Pule");
    }

}


