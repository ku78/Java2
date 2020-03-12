package ru.geekbrains.java.leve1.lesson3;

import java.util.*;

// 1. Создать массив с набором слов (20-30 слов, должны встречаться повторяющиеся):
//         - Найти список слов, из которых состоит текст (дубликаты не считать);
//         - Посчитать сколько раз встречается каждое слово (использовать HashMap);
//         2. Написать простой класс PhoneBook(внутри использовать HashMap):
//         - В качестве ключа использовать фамилию
//         - В каждой записи всего два поля: phone, e-mail
//         - Отдельный метод для поиска номера телефона по фамилии (ввели фамилию,
//         получили ArrayList телефонов), и отдельный метод для поиска e-mail по фамилии.
//         Следует учесть, что под одной фамилией может быть несколько записей. Итого должно
//         получиться 3 класса Main, PhoneBook, Person.
public class DZ3Z1 {
    private static String speech = "Теплое место на улице ждут отпечатков наших ног звездная пыль на сапогах мягкое кресло клетчатый плед не нажатый вовремя курок солнечный день в ослепительных снах группа крови на рукаве мой порядковый номер на рукаве пожелай мне удачи в бою пожелай мне не остаться в этой траве не остаться в этой траве пожелай мне удачи пожелай мне удачи и есть чем платить но я не хочу победы любой ценой я никому не хочу ставить ногу на грудь я хотел бы остаться с тобой просто остаться с тобой но высокая в небе звезда зовет меня в путь группа крови на рукаве мой порядковый номер на рукаве пожелай мне удачи в бою пожелай мне не остаться в этой траве не остаться в этой траве пожелай мне удачи пожелай мне удачи";

    public static void main(String[] args) {
        DZ3Z1 dz3Z1 = new DZ3Z1();
       dz3Z1.wordsListExcTakes(dz3Z1.wordsToArr(speech));
       dz3Z1.wordsOccursHM(dz3Z1.wordsToArr(speech));

    }
    public String [] wordsToArr(String words){//Создать массив с набором слов
        String [] wordsArr = words.replaceAll("[,.]","").split(" ");
        return wordsArr;
    }

    public void wordsListExcTakes(String [] wordsArr){//Найти список слов, из которых состоит текст (дубликаты не считать);
        Set<String> wordsLHS = new LinkedHashSet<>(Arrays.asList(wordsArr));
        System.out.println(wordsLHS.size()+" "+wordsLHS);
    }

    public void wordsOccursHM(String [] wordsArr){//Посчитать сколько раз встречается каждое слово (использовать HashMap);
        ArrayList<String> wordsAL = new ArrayList<>(Arrays.asList(wordsArr));
        HashMap<String, Integer> wordsHM = new HashMap<>();
        for (int i = 0; i < wordsArr.length; i++) {
            wordsHM.put(wordsArr[i], 0);//заполняем HashMap значениями из ArrayList
        }
        for (int i = 0; i < wordsAL.size(); i++) {
            String a = wordsAL.get(i);//копируем первое слово
            if(!wordsHM.containsKey(a)){//если в HashMap нет этого слова записываем его и фиксируем что оно одно
                wordsHM.put(a,1);
            }else{//end if
                wordsHM.put(a,wordsHM.get(a)+1);//иначе фиксируем что это слово не одно
            }//end else
        }//end for i
        for (Map.Entry entry : wordsHM.entrySet()) {
            System.out.println(entry.getKey() + " кол-во: "
                    + entry.getValue());
        }
    }
}
