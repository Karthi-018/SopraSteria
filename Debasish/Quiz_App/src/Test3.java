import java.util.Scanner;
public class Test3 {
    public static void main(String[] args) {
        String questions[] = {"Who is the founder of java" , "Which Access specifier will not work outside its own class" , "what method is used to call the Parents class constructor"};
        String options[][] ={{"1.Albert Einstein","2.Nikola Tesla" , "3.Charles Darwin" ,"4.&&"},
                {"1.private","2.public","3.protected","4.default"},{"1.this()" , "2.super()","3.parent()","4.All"}
        };
        Scanner sc = new Scanner(System.in);
        int answers[] = {4,1,2};
        int num =0;
        int result[] = {0,0,0};
        int choice;
        int ch1;
        while(num<questions.length){
            System.out.println(questions[num]);
            for(int i=0;i<4;i++) {
                System.out.println(options[num][i]);
            }
            System.out.print("Enter your Choice: ");
            choice = sc.nextInt();
            System.out.println("1.Retake the question");
            System.out.println("2.Continue");
            System.out.println("3.Previous Question");
            System.out.print("Enter your choice: ");
            ch1=sc.nextInt();
            if(ch1==1){
                continue;
            }
            else if(ch1==2){
                if(choice>0 && choice<5){
                    if(choice == answers[num]){
                        result[num]++;
                    }
                }
                else{
                    System.out.println("--------------------");
                    System.out.println("Wrong Entry");
                    System.out.println("--------------------");
                    continue;
                }
                num++;
            }
            else if(ch1==3){
                if(num==0){
                    System.out.println("No Previous Question");
                    continue;
                }
                result[num-1]=0;
                num--;
            }
        }
        int res =0;
        for(int i=0;i<result.length;i++){
            res+=result[i];
        }
        System.out.println("Your score is "+res+"/3");

    }

}
