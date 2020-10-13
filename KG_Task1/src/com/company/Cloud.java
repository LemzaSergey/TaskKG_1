package com.company;

import java.awt.*;

public class Cloud implements Drawable {
    private int x, y, width, height, quantity;

    public Cloud(int x, int y, int width, int height, int quantity) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.quantity = quantity;
    }
    @Override
    public void draw(Graphics2D gr) {
        for (int i = 0; i < quantity; i++) {
            clouds(gr, x, y, width, height);
        }
    }

    public static void clouds(Graphics2D gr, int x, int y, int width, int height) {
        x = (int) (Math.random() * x);
        y = (int) (Math.random() * y);

        for (int k = 0; k < 15; k++) {
            int i = (int) (Math.random() * width) * 3;
            int j = (int) (Math.random() * height);
            int radius = (width+height)/4;
            float fractions[] = {0.1f, 1.0f};
            Color colors[] = {new Color(0xCCDAFF), new Color(0, 0, 0, 0)};
            RadialGradientPaint paint = new RadialGradientPaint(x + (width / 2) + i, y + (height / 2) + j, radius, fractions, colors);
            gr.setPaint(paint);
            gr.fillOval(x + i, y + j, width, height);
        }

    }
}
