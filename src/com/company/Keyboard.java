package com.company;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class Keyboard{

    public static boolean keyPressed(KeyEvent k, MainFormAppearance mainForm) throws InterruptedException {
        try {
            Thread.sleep(100);
        } catch(InterruptedException ex) {}

        if(k.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (Move.moveRight(mainForm.arrButton)){
                GeneratingNumber.gen(mainForm);
            }
        }else if(k.getKeyCode() == KeyEvent.VK_DOWN) {
            if (Move.moveDown(mainForm.arrButton)){
                GeneratingNumber.gen(mainForm);
            }
        }else if(k.getKeyCode() == KeyEvent.VK_LEFT) {
            if (Move.moveLeft(mainForm.arrButton)){
                GeneratingNumber.gen(mainForm);
            }
        }else if(k.getKeyCode() == KeyEvent.VK_UP) {
            if (Move.moveUp(mainForm.arrButton)){
                GeneratingNumber.gen(mainForm);
            }
        }
        try {
            Thread.sleep(150);
        } catch(InterruptedException ex) {}

        return checkingLosses(mainForm.arrButton);
    }

    public static boolean checkingLosses(JButton[][] arrButton){
        for (int i = 0; i < arrButton.length; i++) {
            for (int j = 0; j < arrButton[i].length; j++) {
                if (arrButton[i][j].getText() == "") {
                    return false;
                }
                if (j + 1 < arrButton[i].length && arrButton[i][j].getText() == arrButton[i][j + 1].getText()) {
                    return false;
                }
                if (j - 1 >= 0 && arrButton[i][j].getText() == arrButton[i][j - 1].getText()) {
                    return false;
                }
                if (i + 1 < arrButton.length && arrButton[i][j].getText() == arrButton[i + 1][j].getText()) {
                    return false;
                }
                if (i - 1 >= 0 && arrButton[i][j].getText() == arrButton[i - 1][j].getText()) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkingWinnings(JButton[][] arrButton){
        for (int i = 0; i < arrButton.length; i++) {
            for (int j = 0; j < arrButton[i].length; j++) {
                if (arrButton[i][j].getText() == "2048") {
                    return true;
                }
            }
        }
        return false;
    }
}
