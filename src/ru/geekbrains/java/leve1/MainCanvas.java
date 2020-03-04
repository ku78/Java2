package ru.geekbrains.java.leve1;

import javax.swing.*;
import java.awt.*;

public class MainCanvas extends JPanel {//создаем класс MainCanvas и наследуем JPanel

    long lastFrameTime;
    private final MainCircles controller;

    MainCanvas(MainCircles controller) {//создаем контрутор
        lastFrameTime = System.nanoTime();// возвращает наносекунды
        this.controller = controller;
    }

    @Override
    protected void paintComponent(Graphics g) {//создаем метод рисования на конве
        super.paintComponent(g);

        long currentTime = System.nanoTime();
        float deltaTime = (currentTime - lastFrameTime) * 0.000000001f;
        controller.onCanvasRepainted(this, g, deltaTime);

        try {
            Thread.sleep(16);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lastFrameTime = currentTime;
        repaint();
    }
//создаем гетеры
    public int getLeft() { return 0; }
    public int getRight() { return getWidth() - 1; }
    public int getTop() { return 0; }
    public int getBottom() { return getHeight() - 1; }

}