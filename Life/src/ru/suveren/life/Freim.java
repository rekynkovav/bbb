package ru.suveren.life;

import javax.swing.*;
import java.awt.*;

class Freim extends JFrame {
    static JPanel[][] jPanelMassive = new JPanel[Logika.POLE][Logika.POLE];
    private static boolean flag2 = false;
    static void go() {
        Freim frame = new Freim();
        frame.setTitle("Жизнь");
        frame.setSize(815, 838);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setLayout(null);
        panel.setVisible(true);
        frame.add(panel);

        for (int i = 0, x = 0, y = 0; i < jPanelMassive.length; i++, x += 8) {
            for (int j = 0; j < jPanelMassive[i].length; j++, y += 8) {
                jPanelMassive[i][j] = new JPanel();
                jPanelMassive[i][j].setBounds(x, y, 6, 6);
                jPanelMassive[i][j].setBackground(Color.BLUE);
                jPanelMassive[i][j].setVisible(flag2);
                panel.add(jPanelMassive[i][j]);
            }
            y = 0;
        }
        frame.setVisible(true);
    }
}
