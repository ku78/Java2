package ru.geekbrains.java.leve1.lesson2;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.InputMismatchException;

/** 1. Есть строка вида: "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0"; (другими словами матрица 4x4)
 10 3 1 2
 2 3 2 2
 5 6 7 1
 300 3 1 0
 Написать метод, на вход которого подаётся такая строка, метод должен преобразовать строку в двумерный массив типа String[][];
 2. Преобразовать все элементы массива в числа типа int, просуммировать, поделить полученную сумму на 2, и вернуть результат;
 3. Ваши методы должны бросить исключения в случаях:
 Если размер матрицы, полученной из строки, не равен 4x4;
 Если в одной из ячеек полученной матрицы не число; (например символ или слово)
 4. В методе main необходимо вызвать полученные методы, обработать возможные исключения и вывести результат расчета.
 5. * Написать собственные классы исключений для каждого из случаев*/

public class DZ2 {
    String str = "10 d 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";

    public static void main(String[] args) {
        DZ2 dz2 = new DZ2();

        try {
            dz2.stringOfInt(dz2.stringProcessing(dz2.str));
        }catch (ProcessingArrayEx ex){
            System.out.println(ex.toString());
        }catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\n" + e.toString());
        }catch (ProcessingNFEx ex){
            System.out.println("\n" + ex.toString());
        }catch (NumberFormatException e){
           System.out.println("\n" + e.toString());

        }

    }
    public String[][] stringProcessing(String str) throws ArrayIndexOutOfBoundsException{
        int col=0;
        System.out.println("Задание 1.Преобразованый маcсив: ");
        str= str.replaceAll("\n"," ");// метод позволяет заменить слово в строке.
        String str2[] = str.split(  " ");//возвращает массив строк, вычисленных путем разделения данной строки вокруг данного регулярного выражения.
        String str3[][] = new String[str2.length/4][str2.length/4];
        if(str3.length !=4) throw new ProcessingArrayEx("Массив не равен 4х4");
        for (int i = 0; i <str3.length ; i++) {
            for (int j = 0; j <str3[0].length ; j++) {
                    str3 [i][j] = str2[col++];
                    System.out.printf("%-4s",str3[i][j]);

            }//end for j
            System.out.println();
        }//end for i
        return str3;

    }//end stringProcessing

    public void stringOfInt(String[][]str) throws NumberFormatException{
        int f=0;
        int a[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int [][] b=new int[str.length][str.length];
        for (int i = 0; i <str.length ; i++) {
            for (int j = 0; j <str.length ; j++) {
                for (int ar:a){if(b[i][j]==ar) throw new ProcessingNFEx("В массиве символ");}

                    b[i][j] = Integer.parseInt(str[i][j]);
                    f=b[i][j]+f;
            }//end for j
        }//end for i
        f=f/2;
        System.out.println("Задание2.Сумма масива /2: "+f);
    }
    class  ProcessingNFEx extends NumberFormatException
    {
        public ProcessingNFEx(String s) {
            super(s);
        }
    }
    class  ProcessingArrayEx extends ArrayIndexOutOfBoundsException
    {

        public ProcessingArrayEx(String s) {
          super(s);

        }
    }
}

