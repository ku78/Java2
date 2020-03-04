package ru.geekbrains.java.leve1;

import javax.swing.*;
import java.awt.*;
//Полностью разобраться с кодом
//Прочитать методичку к следующему уроку
//Написать класс Бэкграунд background, изменяющий цвет канвы в зависимости от времени
// * Реализовать добавление новых кружков по клику используя ТОЛЬКО массивы
//** Реализовать по клику другой кнопки удаление кружков (никаких эррейЛист)
public class MainCircles extends JFrame {//создаем класс MainCircles
    private static final int POS_X = 400;//Задаем координату x
    private static final int POS_Y = 200;//Задает координату y  (соответствуют верхнему левому углу)
    private static final int WINDOW_WIDTH = 800; //ширина
    private static final int WINDOW_HEIGHT = 600;//высота

    private Sprite[] sprites = new Sprite[10];//создаем массив объектов класса Spring, 10шт

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainCircles();//Создаем нашего приложения
            }
        });
    }

    private MainCircles() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//это нужно для того чтобы при закрытии окна закрывалась
                                                               // и программа, иначе она останется висеть в процессах
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);// методу передаются четыре параметра, определяющих новое
                                                            // расположение и размеры компонента
        setTitle("Circles");//название окна
        initApplication();//запускаем метод

        MainCanvas canvas = new MainCanvas(this);//создаем новый объект класса MainCanvas
        add(canvas);//Добавляем канву в окно
        setVisible(true);// Говорим чтоб было видимо
    }

    private void initApplication() {//Создаем метод initApplication, который заполняем массив объектами класса Ball
        for (int i = 0; i < sprites.length; i++) {
            sprites[i] = new Ball();
        }
    }

    public void onCanvasRepainted(MainCanvas canvas, Graphics g, float deltaTime) {//Создаем метод onCanvasRepainted с
                                                                                   // параметрами, в которые передаем
                                                                                   // канву, графику и время
        update(canvas, deltaTime);//обновление
        render(canvas, g);//отрисовка
    }

    private void update(MainCanvas canvas, float deltaTime) {//создание метода обновления
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].update(canvas, deltaTime);
        }
    }

    private void render(MainCanvas canvas, Graphics g) {//создаем метод отрисовки
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].render(canvas, g);
        }
    }
}