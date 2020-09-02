package com.company;

import javax.swing.*;
import java.awt.*;

public class Move {
    private static boolean boolAction;
    private static boolean[][] boolArr = new boolean[4][4];

    public Move() {

    }

    public static boolean moveRight(JButton[][] arrButton) {//смещение работает
        boolAction = false;
        clearArr(boolArr);

        for (int j = 0; j < arrButton.length; j++) {//строки
            for (int i = arrButton[j].length - 2; i >= 0; i--) {//столбики

                for (int f = i; arrButton[f][j].getText() != "" && f + 1 < arrButton.length; f++) {

                    if (arrButton[f + 1][j].getText() == "") {

                        arrButton[f + 1][j].setText(arrButton[f][j].getText());
                        arrButton[f][j].setText("");
                        boolArr[f + 1][j] = boolArr[f][j];
                        boolArr[f][j] = false;
                        boolAction = true;

                    } else if (
                            (!boolArr[f][j]) && (!boolArr[f + 1][j]) &&
                                    Integer.parseInt(arrButton[f][j].getText()) ==
                                            Integer.parseInt(arrButton[f + 1][j].getText())
                        ) {
                        arrButton[f + 1][j].setText(String.valueOf(Integer.parseInt(arrButton[f][j].getText()) * 2));
                        arrButton[f][j].setText("");

                        boolArr[f + 1][j] = true;
                        boolAction = true;
                    }
                }
            }
        }

        choiceColor(arrButton);

        return boolAction;
    }

    public static boolean moveLeft(JButton[][] arrButton) {
        boolAction = false;
        clearArr(boolArr);

        for (int j = 0; j < arrButton.length; j++) {//строки
            for (int i = 0; i < arrButton[j].length; i++) {//столбики

                for (int f = i; arrButton[f][j].getText() != "" && f - 1 >= 0; f--) {
                    if (arrButton[f - 1][j].getText() == "") {

                        arrButton[f - 1][j].setText(arrButton[f][j].getText());
                        arrButton[f][j].setText("");

                        boolArr[f - 1][j] = boolArr[f][j];
                        boolArr[f][j] = false;

                        boolAction = true;

                    } else if (
                            (!boolArr[f][j]) && (!boolArr[f - 1][j]) &&
                                    Integer.parseInt(arrButton[f][j].getText()) ==
                                            Integer.parseInt(arrButton[f - 1][j].getText())) {

                        arrButton[f - 1][j].setText(String.valueOf(Integer.parseInt(arrButton[f][j].getText()) * 2));
                        arrButton[f][j].setText("");

                        boolArr[f - 1][j] = true;
                        boolAction = true;
                    }
                }
            }
        }

        choiceColor(arrButton);

        return boolAction;
    }

    public static boolean moveUp(JButton[][] arrButton) {//смещение работает
        boolAction = false;
        clearArr(boolArr);

        for (int i = 0; i < arrButton.length; i++) {
            for (int j = 0; j < arrButton[i].length; j++) {
                for (int f = j; arrButton[i][f].getText() != "" && f - 1 >= 0; f--) {
                    if (arrButton[i][f - 1].getText() == "") {

                        arrButton[i][f - 1].setText(arrButton[i][f].getText());
                        arrButton[i][f].setText("");

                        boolArr[i][f - 1] = boolArr[i][f];
                        boolArr[i][f] = false;

                        boolAction = true;

                    } else if (
                            (!boolArr[i][f]) && (!boolArr[i][f - 1]) &&
                                    Integer.parseInt(arrButton[i][f].getText()) ==
                                            Integer.parseInt(arrButton[i][f - 1].getText())) {

                        arrButton[i][f - 1].setText(String.valueOf(Integer.parseInt(arrButton[i][f].getText()) * 2));
                        arrButton[i][f].setText("");

                        boolArr[i][f - 1] = true;
                        boolAction = true;
                    }
                }
            }
        }

        choiceColor(arrButton);

        return boolAction;
    }

    public static boolean moveDown(JButton[][] arrButton) {//смещение работает
        boolAction = false;
        clearArr(boolArr);

        for (int i = 0; i < arrButton.length; i++) {
            for (int j = arrButton[i].length - 1; j >= 0; j--) {
                for (int f = j; arrButton[i][f].getText() != "" && f + 1 < arrButton[i].length; f++) {
                    if (arrButton[i][f + 1].getText() == "") {

                        arrButton[i][f + 1].setText(arrButton[i][f].getText());
                        arrButton[i][f].setText("");

                        boolArr[i][f + 1] = boolArr[i][f];
                        boolArr[i][f] = false;

                        boolAction = true;
                    } else if (
                            (!boolArr[i][f]) && (!boolArr[i][f + 1]) &&
                                    Integer.parseInt(arrButton[i][f].getText()) ==
                                            Integer.parseInt(arrButton[i][f + 1].getText())) {

                        arrButton[i][f + 1].setText(String.valueOf(Integer.parseInt(arrButton[i][f].getText()) * 2));
                        arrButton[i][f].setText("");

                        boolArr[i][f + 1] = true;
                        boolAction = true;
                    }
                }
            }
        }

        choiceColor(arrButton);

        return boolAction;
    }

    public static void test(JButton[][] arrButton) {
        System.out.println("--------------------");
        for (int i = 0; i < arrButton.length; i++) {
            for (int j = 0; j < arrButton[i].length; j++) {
                if (arrButton[j][i].getText() == "") {
                    System.out.print(0 + " ");
                } else {
                    System.out.print(arrButton[j][i].getText() + " ");
                }
            }
            System.out.println();
        }
    }

    public static void choiceColor(JButton[][] arrButton) {
        Font font;
        Color color;

        for (int i = 0; i < arrButton.length; i++) {
            for (int j = 0; j < arrButton[i].length; j++) {
                switch (arrButton[i][j].getText()) {
                    case "":
                        font = new Font("", Font.PLAIN, 35);
                        color = new Color(255, 255, 255);

                        arrButton[i][j].setBackground(color);
                        arrButton[i][j].setFont(font);
                        break;
                    case "2":
                        font = new Font("2", Font.PLAIN, 35);
                        color = new Color(255, 255, 224);

                        arrButton[i][j].setBackground(color);
                        arrButton[i][j].setFont(font);
                        break;
                    case "4":
                        font = new Font("4", Font.PLAIN, 35);
                        color = new Color(255, 250, 205);

                        arrButton[i][j].setBackground(color);
                        arrButton[i][j].setFont(font);
                        break;
                    case "8":
                        font = new Font("8", Font.PLAIN, 35);
                        color = new Color(255, 160, 122);

                        arrButton[i][j].setBackground(color);
                        arrButton[i][j].setFont(font);
                        break;
                    case "16":
                        font = new Font("16", Font.PLAIN, 30);
                        color = new Color(255, 127, 80);

                        arrButton[i][j].setBackground(color);
                        arrButton[i][j].setFont(font);
                        break;
                    case "32":
                        font = new Font("32", Font.PLAIN, 30);
                        color = new Color(255, 99, 71);

                        arrButton[i][j].setBackground(color);
                        arrButton[i][j].setFont(font);
                        break;
                    case "64":
                        font = new Font("64", Font.PLAIN, 30);
                        color = new Color(255, 69, 0);

                        arrButton[i][j].setBackground(color);
                        arrButton[i][j].setFont(font);
                        break;
                    case "128":
                        font = new Font("128", Font.PLAIN, 22);
                        color = new Color(255, 255, 150);

                        arrButton[i][j].setBackground(color);
                        arrButton[i][j].setFont(font);
                        break;
                    case "256":
                        font = new Font("256", Font.PLAIN, 22);
                        color = new Color(255, 255, 50);

                        arrButton[i][j].setBackground(color);
                        arrButton[i][j].setFont(font);
                        break;
                    case "512":
                        font = new Font("512", Font.PLAIN, 22);
                        color = new Color(255, 200, 100);

                        arrButton[i][j].setBackground(color);
                        arrButton[i][j].setFont(font);
                        break;
                    case "1024":
                        font = new Font("1024", Font.PLAIN, 16);
                        color = new Color(255, 200, 50);

                        arrButton[i][j].setBackground(color);
                        arrButton[i][j].setFont(font);
                        break;
                    case "2048":
                        font = new Font("2048", Font.PLAIN, 16);
                        color = new Color(255, 200, 0);

                        arrButton[i][j].setBackground(color);
                        arrButton[i][j].setFont(font);
                        break;
                    default:

                        break;
                }
            }
        }
    }

    private static void clearArr(boolean[][] arrBool) {
        for (int i = 0; i < arrBool.length; i++) {
            for (int j = 0; j < arrBool[i].length; j++) {
                arrBool[i][j] = false;
            }
        }
    }
}