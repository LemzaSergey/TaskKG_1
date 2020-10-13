package com.company;

import java.awt.*;

public class Sky implements Drawable {
    private int x, y, width, height;
    private Color c1, c2, bird;
    private Sun s = new Sun(1500, 0, 500, 500, new Color(255, 179, 0));

    @Override
    public void draw(Graphics2D gr) {
        sky(gr, x, y, width, height, c1, c2);
        s.draw(gr);
        bird(gr, width, height, bird);
    }

    public static void sky(Graphics2D gr, int x, int y, int width, int height, Color c1, Color c2) {
        //небо
        GradientPaint grad = new GradientPaint(x, y, c1, width, height, c2);
        gr.setPaint(grad);
        gr.fillRect(x, y, width, height);
    }

    public static void bird(Graphics2D gr, int width, int height, Color bird) {
        gr.setColor(bird);
        int num = 0;
        while (num < 10) {
            int i = (int) (Math.random() * width);
            int j = (int) (Math.random() * height / 2);
            gr.fillPolygon(new int[]{i, i + 15, i + 30, i + 15}, new int[]{j + 15, j + 30, j + 15, j + 25}, 4);
            num++;
        }
    }

    public Sky(int x, int y, int width, int height, Color c1, Color c2, Color bird) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.c1 = c1;
        this.c2 = c2;
        this.bird = bird;
    }
}
