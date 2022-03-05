package com.anas.jsimpleclock;

import javax.swing.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Simple Clock");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 200);
        add(new ClockPanel(this));
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
}
