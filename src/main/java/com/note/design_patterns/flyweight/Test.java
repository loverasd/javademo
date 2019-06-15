package com.note.design_patterns.flyweight;

/**
 * @Classname Test
 * @Description TODO
 * @Date 2019/6/15 14:18
 * @Created by x1c
 */

import javax.swing.*;
import java.awt.*;
public class Test extends JFrame{
    private static final Color colors[] = { Color.red, Color.blue,
            Color.yellow, Color.orange,
            Color.black,  Color.white };
    private static final int WINDOW_WIDTH=400,
            WINDOW_HEIGHT=400,
            NUMBER_OF_LINES=10000;
    public Test() {
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        JButton button = new JButton("draw lines");
        final JPanel  panel  = new JPanel();
        contentPane.add(panel,  BorderLayout.CENTER);
        contentPane.add(button, BorderLayout.SOUTH);
        setBounds(20,20,WINDOW_WIDTH,WINDOW_HEIGHT);
        button.addActionListener(event -> {
            Graphics g = panel.getGraphics();
            for(int i=0; i < NUMBER_OF_LINES; ++i) {
                g.setColor(getRandomColor());
                g.drawLine(getRandomX(), getRandomY(),
                        getRandomX(), getRandomY());
            }
        });
    }
    public static void main(String[] args) {
        Test test = new Test();
        test.show();
    }
    private int getRandomX() {
        return (int)(Math.random()*WINDOW_WIDTH);
    }
    private int getRandomY() {
        return (int)(Math.random()*WINDOW_HEIGHT);
    }
    private Color getRandomColor() {
        return colors[(int)(Math.random()*colors.length)];
    }
}