package com.company;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        MainWindow mn = new MainWindow();
        mn.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mn.setSize(1920,1000);
        mn.setLocation(0,0);
        mn.setVisible(true);
    }
}