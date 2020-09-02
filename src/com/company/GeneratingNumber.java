package com.company;

import java.util.Random;

public class GeneratingNumber {

    public GeneratingNumber(){

    }

    public static void gen(MainFormAppearance form){
        Random rnd = new Random();
        int countNull = 0;

        for (int i = 0; i < form.arrButton.length; i++){
            for (int j = 0; j < form.arrButton[i].length; j++){
                if (form.arrButton[i][j].getText() == ""){
                    countNull++;
                }
            }
        }

        countNull = rnd.nextInt(countNull);

        short countNullSecond = 0;

        for (int i = 0; i < form.arrButton.length; i++){
            for (int j = 0; j < form.arrButton[i].length; j++){
                if (countNull == 0 && form.arrButton[i][j].getText() == "" && countNullSecond == 0){
                    form.arrButton[i][j].setText((rnd.nextInt(100) < 90) ? "2" : "4");
                    countNullSecond++;
                }
                if (form.arrButton[i][j].getText() == ""){
                    countNullSecond++;
                }
                if (countNull == countNullSecond && form.arrButton[i][j].getText() == ""){
                    form.arrButton[i][j].setText((rnd.nextInt(100) < 90) ? "2" : "4");
                }
            }
        }

        Move.choiceColor(form.arrButton);
    }
}
