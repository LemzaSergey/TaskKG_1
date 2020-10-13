package com.company;


import java.awt.*;

public class House implements Drawable {
    private int x, y, width, height, numberCrowns, type;
    private Color board, boardShadow, roof, roofShadow, straw;

    public House(int x, int y, int width, int height, int numberCrowns, int type, Color board, Color boardShadow, Color roof, Color roofShadow, Color straw) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.numberCrowns = numberCrowns;
        this.type = type;
        this.board = board;
        this.boardShadow = boardShadow;
        this.roof = roof;
        this.roofShadow = roofShadow;
        this.straw = straw;

    }

    public void draw(Graphics2D gr) {
        house(gr, x, y, width, height, numberCrowns, type, board, boardShadow);
        roof(gr, x, y, width, height, roof, roofShadow, straw, board, boardShadow);
        if (type == 1) {
            window(gr, x + width / 6, y + height * 2, width / 8, height * 4);
            window(gr, x + width / 2 - width / 8, y + height * 2, width / 8, height * 4);
            window(gr, x + width - width / 4 - width / 64, y + height * 2, width / 8, height * 4);
        }
        if (type == 2) {
            window(gr, x + width / 6, y + height * 2, width / 8, height * 4);
            window(gr, x + width / 2 - width / 8, y + height * 2, width / 8, height * 4);
            door(gr, x + width - width / 4 - width / 64, y + height * 2, width / 8, height * 7, board, boardShadow);
        }
        if (type == 3) {
            window(gr, x + width / 6, y + height * 2, width / 8, height * 4);
            window(gr, x + width / 2 - width / 16, y + height * 2, width / 8, height * 4);
            window(gr, x + width - width / 4 - width / 64, y + height * 2, width / 8, height * 4);
        }
    }

    public static void roof(Graphics2D gr, int x, int y, int width, int height, Color roof, Color roofShadow, Color straw, Color board, Color boardShadow) {
        gr.setPaint(board);
        gr.fillRect(x + width / 4, y - width / 4 - height, height * 2, width / 4);
        gr.setPaint(boardShadow);
        for (int i = 0; i <= height * 2; ) {
            gr.drawLine(x + width / 4 + i, y - width / 4 - height, x + width / 4 + i, y - height);
            i = i + height / 2;
        }
        float fractions[] = {0.6f, 1.0f};
        Color colors[] = {roof, roofShadow};
        RadialGradientPaint paint = new RadialGradientPaint(x + width / 2, y + width / 3, width / 2, fractions, colors);
        gr.setPaint(paint);

        gr.fillPolygon(new int[]{x - height, x - height, x + width / 2, x + width + height, x + width + height}, new int[]{y, y - height / 4, y - width / 4, y - height / 4, y}, 5);

        gr.setPaint(straw);
        int i = x - height;
        while (i < x + width + height) {
            gr.drawLine(x + width / 2, y - width / 4, i, y - height / 4);
            i = i + 10;
        }
        gr.setPaint(board);
        gr.fillRect(x - height, y - height / 4, width + 2 * height, height / 4);

    }

    public static void house(Graphics2D gr, int x, int y, int width, int height, int numberCrowns, int type, Color board, Color boardShadow) {
        for (int i = 0; i < numberCrowns; i++) {
            GradientPaint gradBoard = new GradientPaint(x, y, boardShadow, x, y + (height / 2), board);
            gr.setPaint(gradBoard);
            gr.fillRect(x, y, width, height / 2);

            GradientPaint gradBoardShadow = new GradientPaint(x, y + (height / 2), board, x, y + height, boardShadow);
            gr.setPaint(gradBoardShadow);
            gr.fillRect(x, y + (height / 2), width, height / 2);

            float fractions[] = {0.6f, 1.0f};
            Color colors[] = {board, boardShadow};
            RadialGradientPaint logLeft = new RadialGradientPaint(x + height, y + height / 2, height / 2, fractions, colors);
            gr.setPaint(logLeft);
            gr.fillOval(x + height / 2, y, height, height);

            RadialGradientPaint logRight = new RadialGradientPaint(x + width - height, y + height / 2, height / 2, fractions, colors);
            gr.setPaint(logRight);
            gr.fillOval(x + width - height * 2 + height / 2, y, height, height);

            if (type == 1) {
                RadialGradientPaint log = new RadialGradientPaint(x + width / 2 + width / 10 + height / 2, y + height / 2, height / 2, fractions, colors);
                gr.setPaint(log);
                gr.fillOval(x + width / 2 + width / 10, y, height, height);
            }
            if (type == 2) {
                RadialGradientPaint log = new RadialGradientPaint(x + width / 2 + width / 10 + height / 2, y + height / 2, height / 2, fractions, colors);
                gr.setPaint(log);
                gr.fillOval(x + width / 2 + width / 10, y, height, height);
            }
            if (type == 3) {
            }
            y = y + height;
        }
    }

    public static void window(Graphics2D gr, int x, int y, int width, int height) {
        gr.setPaint(new Color(255, 255, 255));
        gr.fillPolygon(new int[]{x, x + width / 2, x}, new int[]{y, y, y + height}, 3);
        gr.fillPolygon(new int[]{x + width / 2, x + width, x + width}, new int[]{y, y, y + height}, 3);
        gr.setPaint(new Color(255, 251, 136, 153));
        gr.fillPolygon(new int[]{x + width / 2, x + width, x}, new int[]{y, y + height, y + height}, 3);
        gr.setPaint(new Color(103, 200, 255, 65));
        gr.fillRect(x, y, width, height);
        gr.setPaint(new Color(0xFFFFFF));
        gr.fillRect(x - width / 6, y - width / 6, width + width / 3, width / 6);
        gr.fillRect(x - width / 6, y + height, width + width / 3, width / 6);
        gr.fillRect(x - width / 8, y, width / 8, height);
        gr.fillRect(x + width, y, width / 8, height);
        gr.fillRect(x + width / 2 - width / 16, y, width / 8, height);


    }

    public static void door(Graphics2D gr, int x, int y, int width, int height, Color board, Color boardShadow) {
        gr.setPaint(boardShadow);
        gr.fillRect(x - width / 8, y - width / 8, width + width / 4, height + width / 4);
        gr.setPaint(board);
        gr.fillRect(x, y, width, height);
        gr.setPaint(boardShadow);

        for (int i = 0; i <= width; ) {
            gr.drawLine(x + i, y, x + i, y + height);
            i = i + width / 4;
        }
        gr.fillOval(x + width - width / 6, y + height / 2, width / 8, width / 8);


    }
}

