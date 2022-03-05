package com.anas.jsimpleclock;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ClockPanel extends JPanel {
    private JLabel timeLabel, dayLabel;

    public ClockPanel(JFrame frame) {
        initComponents();
        super.setPreferredSize(frame.getSize());
        super.setLayout(new FlowLayout());

        setUpTimeLabel();
        setUpDayLabel();
        updateDate();

        super.add(timeLabel);
        super.add(dayLabel);
    }

    private void setUpDayLabel() {
        dayLabel.setForeground(new Color(0x000000));
        dayLabel.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 50));
    }

    private void updateDate() {
        new Thread(() -> {
            while (true) {
                timeLabel.setText(new SimpleDateFormat("hh:mm:ss a").format(Calendar.getInstance().getTime()));
                dayLabel.setText(new SimpleDateFormat("E").format(Calendar.getInstance().getTime()));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void setUpTimeLabel() {
        timeLabel.setBackground(new Color(0x000000));
        timeLabel.setOpaque(true);
        timeLabel.setForeground(new Color(0x00FF00));
        timeLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 60));
    }

    private void initComponents() {
        timeLabel = new JLabel();
        dayLabel = new JLabel();
    }
}
