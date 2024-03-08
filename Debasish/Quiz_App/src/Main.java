import java.util.Scanner;

public class Main {
    static String qn[]=new String[10];
    static int an[]=new int[10];
    public static void load(){
        qn[0]="Ans is 1";
        an[0]=1;
        qn[1]="Ans is 2";
        an[1]=2;
        qn[2]="Ans is 3";
        an[2]=3;
        qn[3]="Ans is 4";
        an[3]=4;
        qn[4]="Ans is 5";
        an[4]=5;
        qn[5]="Ans is 6";
        an[5]=6;
        qn[6]="Ans is 7";
        an[6]=7;
        qn[7]="Ans is 8";
        an[7]=8;
        qn[8]="Ans is 9";
        an[8]=9;
        qn[9]="Ans is 10";
        an[9]=10;

    }
    static boolean choiceArray[]=new boolean[10];
    static int index=0;
    static int score=0;
    public static int takeInput(){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        return a;
    }
    public static void choose(){
        System.out.println("enter your choice");
        int a=takeInput();
        int choice=make_choice();
        if(choice==3){
            if(a==an[index-1]){
                score++;
                System.out.println("Correct!!!!!!");
                choiceArray[index-1]=true;
            }
            else {
                choiceArray[index-1]=false;
                System.out.println("Oops!!!!!!!!");
            }
        }
        if(choice==2){

        }
        if(choice==1){
            if(choiceArray[index]==true){
                if(index>=0)
                    score--;
                if(score==-1){
                    score=0;
                }
            }
        }

    }
    public static int make_choice(){
        System.out.println("press 1 for previous\npress 2 for reatempt\npress 3 for next");
        int input=takeInput();
        if(input==1){
            if(index>0)
                index--;
        }
        else if(input==2){

        }
        else if(input==3){
            index++;
        }
        else {
            make_choice();
        }
        return input;

    }

    public static void start(){
        System.out.println("MCQ quiz");

        while(index<10){
            System.out.println("Qn."+(index+1)+"  "+qn[index]);
            choose();
            System.out.println("your score "+score);
            System.out.println("-------------------------------------------");
        }
        System.out.println("End of the Quiz!!!!!!!!!!");
        System.out.println("You scored "+score+" out of 10");
    }
    public static void cheetSheet(){
        for(int i=0;i<10;i++){
            if(choiceArray[i]==false)
                System.out.println(qn[i]+"   "+choiceArray[i]+"   "+an[i]);
        }
    }

    public static void main(String[] args) {
        load();
        start();
        cheetSheet();
    }
}