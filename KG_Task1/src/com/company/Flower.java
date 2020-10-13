package com.company;

import java.awt.*;

public class Flower implements Drawable {
    private int x, y, width, height, quantity;
    private Color stem;

    @Override
    public void draw(Graphics2D gr) {

        flower(gr, x, y, width, height, quantity, stem);
    }


    public Flower(int x, int y, int width, int height, int quantity, Color stem) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.quantity = quantity;
        this.stem = stem;

    }


    public static void flower(Graphics2D gr, int xConst, int yConst, int widthConst, int heightConst, int quantity, Color stem) {
        for (int i = 0; i < quantity; i++) {
            Color bud = new Color((int) (Math.random() * 0x1000000));
            Color middle = new Color((int) (Math.random() * 0x1000000));

            int x = (int) (Math.random() * xConst);
            int y = yConst - (int) (Math.random() * yConst / 2.3);
            int width = widthConst * y / yConst;
            int height = heightConst * y / yConst;
            gr.setPaint(stem);
            gr.fillPolygon(new int[]{x, x - width / 4 + width / 8, x + width / 16, x + width / 4, x}, new int[]{y, y - height, y - height / 4 - height / 8, y - height / 2 - height / 16, y}, 5);
            gr.setPaint(new Color(0x037100));
            gr.drawPolygon(new int[]{x, x - width / 4 + width / 8, x + width / 16, x + width / 4, x}, new int[]{y, y - height, y - height / 4 - height / 8, y - height / 2 - height / 16, y}, 5);
            ;

            gr.setPaint(bud);
            int x1 = x - width / 4 - width / 8 + width / 32;
            int y1 = y - height - height / 4;
            gr.fillArc(x1, y1, width / 2, height / 2, 10, 60);
            gr.fillArc(x1, y1, width / 2, height / 2, 100, 60);
            gr.fillArc(x1, y1, width / 2, height / 2, 190, 60);
            gr.fillArc(x1, y1, width / 2, height / 2, 280, 60);

            gr.setColor(middle);
            gr.fillOval(x1 + width / 8 + width / 20, y1 + height / 8 + height / 20, width / 5, height / 5);
        }
    }
}
