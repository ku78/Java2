package ru.geekbrains.java.leve1.lesson3;


//         2. Написать простой класс PhoneBook(внутри использовать HashMap):
//         - В качестве ключа использовать фамилию
//         - В каждой записи всего два поля: phone, e-mail
//         - Отдельный метод для поиска номера телефона по фамилии (ввели фамилию,
//         получили ArrayList телефонов), и отдельный метод для поиска e-mail по фамилии.
//         Следует учесть, что под одной фамилией может быть несколько записей. Итого должно
//         получиться 3 класса Main, PhoneBook, Person.
public class DZ3Z2 {


    public static void main(String[] args) {
        Person st = new Person();
        st.newRec("Иванов", "+7(900)111-11-11 giko@mail.com");
        st.newRec("Курочкин", "+7(900)123-11-11 kuragril@mail.com");
        st.printBook();
        st.phoneSearch();
        st.emailSearch();

    }
}
