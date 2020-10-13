package com.company;

import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel {
    private Sky sky = new Sky(0, 0, 1920, 750, new Color(70, 146, 255), new Color(185, 232, 224), Color.black);
    private Ground ground = new Ground(-1920 / 2, 500, 1920 * 2, 750, new Color(31, 175, 0), new Color(146, 252, 61));
    private House house = new House(200, 500, 500, 24, 10, 1, new Color(171, 105, 0), new Color(87, 53, 0), new Color(230, 178, 0), new Color(255, 164, 0), new Color(255, 148, 0));
    private House house2 = new House(1200, 450, 300, 14, 10, 2, new Color(171, 105, 0), new Color(87, 53, 0), new Color(230, 178, 0), new Color(255, 164, 0), new Color(255, 148, 0));
    private House house3 = new House(800, 420, 200, 10, 10, 3, new Color(171, 105, 0), new Color(87, 53, 0), new Color(230, 178, 0), new Color(255, 164, 0), new Color(255, 148, 0));
    private Cloud cloud = new Cloud(1700, 300, 80, 80, 5);
    private Flower flower = new Flower(1920, 1000, 60, 60, 200, new Color(12, 146, 0));
    private Wood wood = new Wood(1700, 650, 15, 100, new Color(41, 155, 26), new Color(3, 128, 0), new Color(255, 255, 255), new Color(185, 185, 185), new Color(255, 253, 195));
    private Wood wood2 = new Wood(1100, 550, 10, 100, new Color(41, 155, 26), new Color(3, 128, 0), new Color(255, 255, 255), new Color(185, 185, 185), new Color(255, 253, 195));
    private Wood wood3 = new Wood(80, 620, 10, 70, new Color(41, 155, 26), new Color(3, 128, 0), new Color(255, 255, 255), new Color(185, 185, 185), new Color(255, 253, 195));
    private Text text = new Text(1405, 470, "Скоро лето!");

    @Override
    public void paint(Graphics g) {
        Graphics2D gr = (Graphics2D) g;
        sky.draw(gr);
        ground.draw(gr);
        cloud.draw(gr);
        flower.draw(gr);
        house.draw(gr);
        house2.draw(gr);
        house3.draw(gr);
        wood.draw(gr);
        wood2.draw(gr);
        wood3.draw(gr);
        text.draw(gr);
    }
}
