package ru.geekbrains.java.leve1.lesson5;
//1. Необходимо написать два метода, которые делают следующее:
//        1) Создают одномерный длинный массив, например:
//
//static final int size = 10000000;
//static final int h = size / 2;
//        float[] arr = new float[size];
//
//        2) Заполняют этот массив единицами;
//        3) Засекают время выполнения: long a = System.currentTimeMillis();
//        4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
//        arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
//        5) Проверяется время окончания метода System.currentTimeMillis();
//        6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a);
//
//        Отличие первого метода от второго:
//        Первый просто бежит по массиву и вычисляет значения.
//        Второй разбивает массив на два массива, в двух потоках высчитывает новые значения и
//        потом склеивает эти массивы обратно в один.
//
//        Пример деления одного массива на два:
//
//        System.arraycopy(arr, 0, a1, 0, h);
//        System.arraycopy(arr, h, a2, 0, h);
//
//        Пример обратной склейки:
//
//        System.arraycopy(a1, 0, arr, 0, h);
//        System.arraycopy(a2, 0, arr, h, h);
//
//        Примечание:
//        System.arraycopy() – копирует данные из одного массива в другой:
//        System.arraycopy(массив-источник, откуда начинаем брать данные из массива-источника, массив-назначение, откуда начинаем записывать данные в массив-назначение, сколько ячеек копируем)
//        По замерам времени:
//        Для первого метода надо считать время только на цикл расчета:
//
//        for (int i = 0; i < size; i++) {
//        arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
//        }
//
//        Для второго метода замеряете время разбивки массива на 2, просчета каждого из двух массивов и склейки.


public class DZ5 {
    static final int size = 10000000;
    static final int h = size / 2;
    private static Thread thread1, thread2;


    public static void main(String[] args) {
        DZ5 dz5 = new DZ5();
       dz5.arr1();
       dz5.arr2();
    }//end main
    public void arr1(){
        long a = System.currentTimeMillis();// 3) Засекают время выполнения: long a = System.currentTimeMillis();
        float [] arr = new float[size];//      1) Создают одномерный длинный массив, например:
        fillsArrWithUnits(arr);
        System.currentTimeMillis();//        5) Проверяется время окончания метода System.currentTimeMillis();
        readNewValue(arr);
        System.out.println();
        System.out.println(("Выполненние метода1: "+(System.currentTimeMillis() - a))+" м.c.");//        6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a);
    }//end arr1

    public void arr2(){
        long a = System.currentTimeMillis();// 3) Засекают время выполнения: long a = System.currentTimeMillis();
        float [] arr = new float[size];//      1) Создают одномерный длинный массив, например:
        fillsArrWithUnits(arr);
        float a1[] = new float[h];
        float a2[] = new float[h];
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        System.out.println("Выполненние разбивки массива на 2: "+(double) ((System.currentTimeMillis() - a))+" м.c.");

        thread1 = new Thread(() -> {//первый поток
            long b = System.currentTimeMillis();
            readNewValue(a1);
            System.out.println();
            System.out.println("Выполненние первого потока: "+(double) ((System.currentTimeMillis() - b))+" м.c.");
        });
        thread2 = new Thread(() -> {//второй поток
            long b = System.currentTimeMillis();
            readNewValue(a2);
            System.out.println();
            System.out.println("Выполненние второго потока: "+(double) ((System.currentTimeMillis() - b))+" м.c.");
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        System.out.println("Склейка массива: "+(double) ((System.currentTimeMillis() - a))+" м.c.");

        System.currentTimeMillis();//        5) Проверяется время окончания метода System.currentTimeMillis();
        System.out.println();
        System.out.println("Выполненние метода2: "+(double) ((System.currentTimeMillis() - a))+" м.c.");//        6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a);
    }//end arr1
    public  void readNewValue(float[] arr){
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            //        4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            System.out.printf("%-8.2f",arr[i]);
        }//end for
        System.out.println();
        System.out.println("Расчет по формуле: "+(double) ((System.currentTimeMillis() - a))+" м.c.");
    }//end readNewValue

    private static void fillsArrWithUnits(float[] arr){ //             2) Заполняют этот массив единицами;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;

        }//end for
    }//end fillArrWithUnits

}
