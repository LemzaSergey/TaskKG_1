package com.company;

import java.awt.*;

public class Sun implements Drawable {
    private int x, y, width, height;
    private Color c;

    @Override
    public void draw(Graphics2D gr) {
        sun(gr, x, y, width, height, c);
    }

    public static void sun(Graphics2D gr, int x, int y, int width, int height, Color c) {

        int radius = 170;
        float fractions[] = { 0.2f, 1.0f };
        Color colors[] = { new Color(255, 190, 0,255), new Color(0,0,0, 0) };
        RadialGradientPaint paint =
                new RadialGradientPaint(x+(width/2),y+(height/2), radius, fractions, colors);
        gr.setPaint(paint);
       // gr.setColor(c);
        gr.fillOval(x, y, width, height);
        gr.setColor(c);
        gr.fillOval(x+width/2-width/12,y+height/2-height/12, width/6, height/6);
/*
        gr.setComposite(AlphaComposite.DstOut);
        gr.fillOval(x - radius, y - radius, radius * 2, radius * 2);*/
    }

    public Sun(int x, int y, int width, int height, Color c) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.c = c;
    }
}
