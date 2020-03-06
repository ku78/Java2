package ru.geekbrains.java.leve1.lesson1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

    Sprite bc = new BackGroundColor();
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
       // new BackGroundColor();


       initApplication();//запускаем метод

        MainCanvas canvas = new MainCanvas(this);//создаем новый объект класса MainCanvas

        add(canvas);//Добавляем канву в окно

        setVisible(true);// Говорим чтоб было видимо
        this.addMouseListener(getMouse());

    }

    private void initApplication() {//Создаем метод initApplication, который заполняем массив объектами класса Ball



        for (int j = 0; j < sprites.length; j++) {
          sprites[j] = new Ball();
            addRemove.priviousBall_id++;
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
        bc.update(canvas, deltaTime);
    }

    private void render(MainCanvas canvas, Graphics g) {//создаем метод отрисовки
        bc.render(canvas, g);

        for (int i = 0; i < sprites.length; i++) {
            sprites[i].render(canvas, g);
        }

    }
    private MouseListener getMouse(){
        return   new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton()==MouseEvent.BUTTON1){
                   // sprites[addRemove.priviousBall_id++]=new Ball(e.getX(),e.getY());}
                    System.out.println("Button1");}

                else if (e.getButton()==MouseEvent.BUTTON3){
//                    System.out.println(e.getX()+" "+e.getY());
//                    int idOfSprite=addRemove.findSpriteNumber(e.getX(),e.getY(),sprites);
//                    if (idOfSprite>=0){
//                        sprites[idOfSprite]=null;}
                    System.out.println("Button2");

                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        };
    }

}
class addRemove{
    static    int priviousBall_id=0;
    public static final int auto_generated_balls=10;

    public static int findSpriteNumber(int x,int y,Sprite sprites[]){
        int nuber=-1;
        for (Sprite sprite:sprites){
            ++nuber;
            if (sprite!=null){
                if (
                        Math.pow((double)(x-sprite.x),2)+Math.pow((double)(y-sprite.y),2)<=Math.pow(sprite.halfHeight,2)
                )return nuber;
            }}
        return nuber;
    }

}