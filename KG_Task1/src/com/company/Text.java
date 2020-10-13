package com.company;

import java.awt.*;

public class Text implements Drawable {
    private int x, y;
    private String strings;

    public Text(int x, int y, String strings) {
        this.x = x;
        this.y = y;
        this.strings = strings;

    }

    @Override
    public void draw(Graphics2D gr) {
        text(gr, x, y, strings);
    }

    public static void text(Graphics2D gr, int x, int y, String strings) {
        gr.drawString(strings, x, y);
    }
}
