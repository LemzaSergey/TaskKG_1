package com.company;

import java.awt.*;

public class Wood implements Drawable {
    private int x, y, width, height;
    private Color crown, crownShadow, trunk, trunkShadow, branches; //крона, ствол, ветви


    public Wood(int x, int y, int width, int height, Color crown, Color crownShadow, Color trunk, Color trunkShadow, Color branches) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.crown = crown;
        this.crownShadow = crownShadow;
        this.trunk = trunk;
        this.trunkShadow = trunkShadow;
        this.branches = branches;

    }

    @Override
    public void draw(Graphics2D gr) {
        wood(gr, x, y, width, height, crown, crownShadow, trunk, trunkShadow, branches);
    }

    public static void wood(Graphics2D gr, int x, int y, int width, int height, Color crown, Color crownShadow, Color trunk, Color trunkShadow, Color branches) {

        GradientPaint gradTrunk = new GradientPaint(x, y, trunkShadow, x + width / 4, y, trunk);
        gr.setPaint(gradTrunk);
        gr.fillRect(x, y, width / 2, -height);

        GradientPaint gradTrunkShadow = new GradientPaint(x + width - width / 4, y, trunk, x + width, y, trunkShadow);
        gr.setPaint(gradTrunkShadow);
        gr.fillRect(x + width / 2, y, width / 2, -height);
        for (int i = 1; i < 10; i++) {
            gr.setPaint(new Color(0x281300));
            gr.drawLine(x + width / 6 + i * width / 20, y - i * height / 10, x + width / 6 + width / 6 + i * width / 20, y - i * height / 10);
            gr.drawLine(x + width / 2 + width / 4 - i * width / 20, y - i * height / 10 + height / 20, x + width / 2 + width / 4 + width / 6 - i * width / 20, y - i * height / 10 + height / 20);
        }
        GradientPaint gradCrown = new GradientPaint(x - width * 4 + width / 2, y - height * 3 + height / 8, crownShadow, x + width / 4, y - height * 3 + height / 8, crown);

        gr.setPaint(gradCrown);
        gr.fillOval(x - width * 4 + width / 2, y - height * 3 + height / 8, width * 8, height * 2);
        GradientPaint gradCrown2 = new GradientPaint(x + width / 2, y - height * 3 + height / 8, new Color(0x00000FF, true), x + width / 4 + width * 4, y - height * 3 + height / 8, crownShadow);
        gr.setPaint(gradCrown2);
        gr.fillOval(x - width * 4 + width / 2, y - height * 3 + height / 8, width * 8, height * 2);

        gr.setPaint(branches);
        for (int i = 0; i < 4; i++) {
            gr.drawLine(x, y - height * i / 4 - height, x - width * 3 + width / 2, y - height * i / 4 - height - height / 2);
            gr.drawLine(x + width, y - height * i / 4 - height - height / 8, x + width * 3 + width / 2, y - height * i / 4 - height - height / 2);
        }
        gr.drawLine(x + width / 2, y - height, x + width / 2, y - height * 2 - height / 2 - height / 4);

        gr.drawLine(x, y - height * 2, x - width - width / 2, y - height * 2 - height / 2 - height / 8);
        gr.drawLine(x + width, y - height * 2, x + width * 2 + width / 2, y - height * 2 - height / 2 - height / 8);


    }

}
