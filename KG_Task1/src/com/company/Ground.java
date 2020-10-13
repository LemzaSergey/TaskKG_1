package com.company;

import java.awt.*;

public class Ground implements Drawable {
    private int x, y, width, height;
    private Color ground, groundShadow;

    @Override
    public void draw(Graphics2D gr) {
        ground(gr, x, y, width, height, ground, groundShadow);
    }

    public static void ground(Graphics2D gr, int x, int y, int width, int height, Color ground, Color groundShadow) {
        GradientPaint grad = new GradientPaint(x, y, ground, x, y + height, groundShadow);
        gr.setPaint(grad);

        gr.fillOval(x, y, width, height);
    }


    public Ground(int x, int y, int width, int height, Color ground, Color groundShadow) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.ground = ground;
        this.groundShadow = groundShadow;
    }
}
