package ru.geekbrains.java.leve1.lesson1;

import java.awt.*;

public class BackGroundColor extends Sprite {
    long lastFrameTime;
    public Thread timerThread;
    private int  time;
   // private Sprite[] sprites = new Sprite[10];
   static   float x=1.0f,y=1.0f,z=1.0f;
    private Color color;



    public BackGroundColor() {

        halfHeight = 600;//высота
        halfWidth = 800;//ширина


    }

    @Override
    public void update(MainCanvas canvas, float deltaTime) {
        x=(float) (100+Math.random() * 105);
              y=  (float) (Math.random());
              z=  (float) (Math.random());
        x=colorChoice(x);
         y=colorChoice(y);
         z=colorChoice(z);
         color= new Color(
                 (int) (x*255),
                 (int) (y * 255),
                 (int)  (z*255));
        try {
            Thread.sleep(120);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void render(MainCanvas canvas, Graphics g) {

                g.setColor(color);
                g.fillRect(0, 0, (int) getWidth(), (int) getHeight());


        }

    static private float colorChoice(float x){
        return (float)( Math.sqrt(Math.sin(x)+1)*Math.sqrt(-Math.sin(x)+1));
    }

    }







