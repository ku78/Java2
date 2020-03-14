package ru.geekbrains.java.leve1.lesson3;
import java.util.ArrayList;
import java.util.Arrays;

public class Person extends PhoneBook {
    public void newRec(String FIO, String phoneEmail){
        String[] arr = phoneEmail.split(" ");
        ArrayList<String> arrPhoneEmail = new ArrayList<>(Arrays.asList(arr));
        phoneBook.put(FIO,arrPhoneEmail);
    }
}
