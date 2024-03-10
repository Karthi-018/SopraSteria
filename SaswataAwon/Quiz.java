package edu.steria.branch;
import java.util.*;

public class Quiz {

    String[][] ques=new String[10][2];
    String[] answer=new String[10];
    static int count=0;


    public void decision(){
        Scanner d=new Scanner(System.in);
        System.out.print("Ready for the Grand Quiz ( yes or no ) : ");
        String dec= d.nextLine();

        if(dec.equals("yes")){
            System.out.println("For every right answer +2 and for every wrong answer -1 ");
            System.out.println("-----------------------------------------------------------");
            question();
        }
        else{
            System.out.println("Be ready and rejoin!!");
            System.out.println("-----------------------------------------------------------");
            System.exit(0);
        }
    }

    public void question() {
        Scanner q = new Scanner(System.in);
        ques[0][0] = "What is the capital of India?";
        ques[1][0] = "Which river is known as the “Ganga of the South”??";
        ques[2][0] = "Who wrote the Indian national anthem, “Jana Gana Mana”";
        ques[3][0] = "Which festival is popularly known as the “Festival of Lights”?";
        ques[4][0] = "Who was the first woman Prime Minister of India?";
        ques[5][0] = "Which monument is a symbol of love and is located in Agra?";
        ques[6][0] = "Which animal is the national symbol of India?";
        ques[7][0] = "Who is known as the “Father of the Nation” in India?";
        ques[8][0] = "Which state is famous for the backwaters and houseboats?";
        ques[9][0] = "Which festival marks the beginning of the harvest season in India?";

        ques[0][1] = "B";
        ques[1][1] = "C";
        ques[2][1] = "A";
        ques[3][1] = "D";
        ques[4][1] = "B";
        ques[5][1] = "C";
        ques[6][1] = "A";
        ques[7][1] = "D";
        ques[8][1] = "A";

        ques[9][1] = "B";


        for (int i = 0; i < 10; i++) {
            System.out.println((i + 1) + ")  " + ques[i][0]);
            showOption(i);
            System.out.print("Your Answer (Choose correct Option)(A/B/C/D) : ");
            answer[i] = q.nextLine();
            if(i==9){
               System.out.print("Want to move to previous question OR submit (P/S): ");
               String a=q.nextLine();
               if(a.equals("S")) {
                   check();
                   System.exit(0);
               }
               else{
                   i=i-2;
               }
            }
            else {
                boolean ch = move();

                if (!ch && i != 0) {
                    i=i-2;
                }
            }
        }
    }

    boolean move(){
        Scanner d=new Scanner(System.in);
        System.out.print("Do you want to move to NEXT or PREVIOUS (N/P) : ");
        String dec=d.nextLine();
        System.out.println("-----------------------------------------------------------");

        return !dec.equals("P");


    }

    void showOption(int index){
        if(index==0)
            System.out.println("A) Mumbai \nB) Delhi \nC)Chennai \nD) Kolkata ");
        else if(index==1)
            System.out.println("A) Yamuna \nB) Tista \nC) Kaveri \nD) Torsha ");
        else if(index==2)
            System.out.println("A) Mohmmad Ali \nB) Kishore Kumar \nC) Rabindranath Tagore \nD) Swami Vivekananda ");
        else if(index==3)
            System.out.println("A) Pongal \nB) Navratri \nC) New year \nD) Diwali ");
        else if(index==4)
            System.out.println("A) Indira Gandhi \nB) Pratibha Patil \nC) Sonia Gandhi \nD) Sushma Swaraj ");
        else if(index==5)
            System.out.println("A) Gurdwar \nB) Red Fort \nC) Taj Mahal \nD) Qutub Minar ");
        else if(index==6)
            System.out.println("A) Lion \nB) Tiger \nC) Peacock \nD) Elephant ");

        else if(index==7)
            System.out.println("A) Subhash Chandra Bose \nB) Master da Surya Sen \nC) Akbar \nD) Gandhi ");
        else if(index==8)
            System.out.println("A) Kerala \nB) Tamil Nadu \nC) West Bengal \nD) Orissa");
        else if(index==9)
            System.out.println("A) Pongal \nB) Makar Sankrati \nC) Diwali \nD) Holi");


    }

    void check(){
        for(int i=0;i<10;i++){
            if(ques[i][1].equals(answer[i])){
                count=count+2;
            }
            else if(count==0){
                continue;
            }
            else{
                count--;
            }
        }
        System.out.println("Your total Score : " + count);
    }

    public static void main(String[] args) {
        Quiz quiz=new Quiz();

        quiz.decision();
        quiz.question();

    }



}

