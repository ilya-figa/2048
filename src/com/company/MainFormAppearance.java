package com.company;

import javax.swing.*;
import java.awt.*;

public class MainFormAppearance extends JFrame{

    public JButton[][] arrButton = new JButton[4][4];

    public MainFormAppearance() throws HeadlessException{

        Panel panel = new Panel();

        setSize(294, 318);
        setBackground(Color.BLACK);

        Font font = new Font("", Font.PLAIN, 30);

        for (int i = 0; i < arrButton.length; i++) {
            for (int j = 0; j < arrButton[i].length; j++) {
                arrButton[i][j] = new JButton();

                arrButton[i][j].setLocation((i * 70), (j * 70)); // расположение кнопки
                arrButton[i][j].setSize(70, 70); // размер кнопки
                arrButton[i][j].setBackground(Color.WHITE);
                arrButton[i][j].setFont(font);

                add(arrButton[i][j]); // добавляем кнопку на поверхность
            }
        }

        add(panel);

        setVisible(true);
    }
}
