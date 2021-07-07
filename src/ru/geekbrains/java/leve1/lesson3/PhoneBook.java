package ru.geekbrains.java.leve1.lesson3;

import java.util.*;

public class PhoneBook{
    HashMap<String, ArrayList<String>> phoneBook  = new HashMap<String, ArrayList<String>>();
    String email;
    public void printBook(){
        for (Map.Entry<String, ArrayList<String>> tk : phoneBook.entrySet()) {
            System.out.println(tk.getKey() + ": " + tk.getValue());
        }

    }//end printBook
    public void phoneSearch(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Для поиска введите фамилию:");
        String fio = sc.nextLine();
        for (Map.Entry<String, ArrayList<String>> tk : phoneBook.entrySet()) {
            if(phoneBook.containsKey(fio)){
                ArrayList<String> phone = new ArrayList<>(phoneBook.get(fio));
                System.out.println("Номер телефона " + fio + ": " + phone.get(0));
            } else System.out.println("Такого человека нет в телефонной книге");
            break;
        }
    }//end phoneSearch
    public void emailSearch(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Для поиска введите email:");
        email = sc.nextLine();
        for (Map.Entry<String, ArrayList<String>> tk : phoneBook.entrySet()) {
            if (phoneBook.containsValue(email)) {
//                if()
//                ArrayList<String> phone = new ArrayList<>(phoneBook.get(email));
                System.out.println(phoneBook.containsValue(email));
            } else System.out.println("Такого человека нет в телефонной книге");
            System.out.println(phoneBook.containsValue(email));
            System.out.println(tk.equals(email));
            break;
        }//end for
    }//end emailSearch

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneBook phoneBook1 = (PhoneBook) o;
        return email == phoneBook1.email;
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}//end PhoneBook

