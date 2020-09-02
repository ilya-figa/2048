package com.company;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        MainFormAppearance mainForm = new MainFormAppearance();

        mainForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainForm.setFocusable(true);

        GeneratingNumber.gen(mainForm);

        mainForm.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                try {
                    if (Keyboard.keyPressed(e, mainForm)){

                        JOptionPane.showMessageDialog(mainForm, "You lose");

                        try {
                            Thread.sleep(2000);
                        } catch(InterruptedException ex) {}

                        System.exit(0);
                    }else if(Keyboard.checkingWinnings(mainForm.arrButton)){
                        JOptionPane.showMessageDialog(mainForm, "You win");

                        try {
                            Thread.sleep(2000);
                        } catch(InterruptedException ex) {}

                        System.exit(0);
                    }
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });



    }
}
