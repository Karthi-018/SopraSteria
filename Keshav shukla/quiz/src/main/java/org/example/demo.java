package org.example;
import java.util.*;

public class demo {
    static int flag = 1;
    static String[] ans = {"B", "A", "A", "B", "B","B","B","D"};
    static Scanner sc = new Scanner(System.in);
    static int[] score=new int[8];
    static int result=0;

    public void fan() {

        while (true) {
            System.out.println("enter 1 for next question\n" +
                    "enter 2 for previous question\n" +
                    "enter 3 for same question\n" +
                    "enter 4 for exit question");
            int opera = sc.nextInt();
            if(opera==4){
                break;
            }
            switch (opera) {
                case 1:
                    flag++;
                    search(flag);

                    break;
                case 2:
                    flag--;
                    search(flag);
                    break;
                case 3:search(flag);
                    break;
                default:
                    System.out.println("enter the correct choice");
            }
        }

    }
    void search(int flag){
        switch (flag){
            case 1:
                System.out.println("1" + "What is the capital of France?\n" +
                        "A) London\n" +
                        "B) Paris\n" +
                        "C) Berlin\n" +
                        "D) Rome");
                System.out.println(answer(0));
                break;
            case 2:
                System.out.println("Who wrote the famous play Romeo and Juliet?\n" +
                        "A) William Shakespeare\n" +
                        "B) Jane Austen\n" +
                        "C) Charles Dickens\n" +
                        "D) F. Scott Fitzgerald");
                System.out.println(answer(1));
                break;
            case 3:
                System.out.println("What is the chemical symbol for gold?\n" +
                        "A) Au\n" +
                        "B) Ag\n" +
                        "C) Fe\n" +
                        "D) Hg");
                System.out.println(answer(2));
                break;
            case 4:
                System.out.println("Which planet is known as the Red Planet?\n" +
                        "A) Venus\n" +
                        "B) Mars\n" +
                        "C) Jupiter\n" +
                        "D) Saturn");
                System.out.println(answer(3));
                break;
            case 5:
                System.out.println("What is the tallest mammal in the world?\n" +
                        "A) Elephant\n" +
                        "B) Giraffe\n" +
                        "C) Rhino\n" +
                        "D) Hippopotamus");
                System.out.println(answer(4));
                break;
            case 6:
                System.out.println("Who painted the Mona Lisa?\n" +
                        "A) Vincent van Gogh\n" +
                        "B) Leonardo da Vinci\n" +
                        "C) Pablo Picasso\n" +
                        "D) Claude Monet");
                System.out.println(answer(6));
                break;
            case 7:
                System.out.println("Which country is known as the Land of the Rising Sun?\n" +
                        "A) China\n" +
                        "B) Japan\n" +
                        "C) India\n" +
                        "D) South Korea");
                System.out.println(answer(6));
                break;
            case 8:
                System.out.println("What is the largest ocean on Earth?\n" +
                        "A) Atlantic Ocean\n" +
                        "B) Indian Ocean\n" +
                        "C) Arctic Ocean\n" +
                        "D) Pacific Ocean");
                System.out.println(answer(7));
                break;


            default:break;

        }

    }
    boolean answer(int j){
        String res = sc.next();
        if(res.equals(ans[j])){
            score[j]=1;
            return  true;
        }
        else{
            score[j]=0;
            return false;
        }
    }
    int max() {
        for (int i = 0; i < score.length; i++) {
            if (score[i] == 1) {
                result++;
            } else {
                continue;
            }

        }
        return result;
    }

}