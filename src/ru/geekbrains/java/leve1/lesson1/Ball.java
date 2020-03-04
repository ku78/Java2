package ru.geekbrains.java.leve1.lesson1;


import java.awt.*;

public class Ball extends Sprite {
    private final Color color = new Color(
            (int) (Math.random() * 255),
            (int) (Math.random() * 255),
            (int) (Math.random() * 255)
    );
    private float vX = (float) (100f + (Math.random() * 200f));
    private float vY = (float) (100f + (Math.random() * 200f));

    Ball() {
        halfHeight = 20 + (float) (Math.random() * 50f);
        halfWidth = halfHeight;
    }

    @Override
    public void update(MainCanvas canvas, float deltaTime) {//переопределяем метод обновления
        x += vX * deltaTime;
        y += vY * deltaTime;
        if (getLeft() < canvas.getLeft()) {
            setLeft(canvas.getLeft());
            vX = -vX;
        }
        if (getRight() > canvas.getRight()) {
            setRight(canvas.getRight());
            vX = -vX;
        }
        if (getTop() < canvas.getTop()) {
            setTop(canvas.getTop());
            vY = -vY;
        }
        if (getBottom() > canvas.getBottom()) {
            setBottom(canvas.getBottom());
            vY = -vY;
        }

    }

    @Override
    public void render(MainCanvas canvas, Graphics g) {//переопределяем метод отрисовки
        g.setColor(color);
        g.fillOval((int) getLeft(), (int) getTop(),//метод  fillOval рисует круг
                (int) getWidth(), (int) getHeight());
    }
}