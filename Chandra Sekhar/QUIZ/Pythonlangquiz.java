package sopra.project.quiz;
import java.util.Scanner;
public class Pythonlangquiz {

    Scanner scan = new Scanner(System.in);
    int marks = 0;
    public Pythonlangquiz(int a1) {
        System.out.println(" Who is the father of C language?\n" +
                "1) Steve Jobs\n" +
                "2) James Gosling\n" +
                "3) Dennis Ritchie\n" +
                "4) Rasmus Lerdorf");  // answer is c
        System.out.println("Enter your choice : ");
        int userAns = scan.nextInt();
        if(userAns == a1)
        {
            marks = marks + 1;
        }
    }
    public Pythonlangquiz(int a1, int a2) {
        this(a1);
        System.out.println("2. Which of the following is not a valid C variable name?\n" +
                "1) int number;\n" +
                "2) float rate;\n" +
                "3) int variable_count;\n" +
                "4) int $main;"); // answer is d
        System.out.println("Enter your choice : ");
        int userAns = scan.nextInt();
        if(userAns == a1)
        {
            marks = marks + 1;
        }
    }
    public Pythonlangquiz(int a1, int a2, int a3) {
        this(a1, a2);
        System.out.println("All keywords in C are in ____________\n" +
                "1) LowerCase letters\n" +
                "2) UpperCase letters\n" +
                "3) CamelCase letters\n" +
                "4) None of the mentioned"); // answer is a
        System.out.println("Enter your choice : ");
        int userAns = scan.nextInt();
        if(userAns == a1)
        {
            marks = marks + 1;
        }
    }
    public Pythonlangquiz(int a1, int a2, int a3, int a4) {
        this(a1, a2, a3);
        System.out.println("4. Which of the following is true for variable names in C?\n" +
                "1) They can contain alphanumeric characters as well as special characters\n" +
                "2) It is not an error to declare a variable to be one of the keywords(like goto, static)\n" +
                "3) Variable names cannot start with a digit\n" +
                "4) Variable can be of any length");  // answer is c
        System.out.println("Enter your choice : ");
        int userAns = scan.nextInt();
        if(userAns == a1)
        {
            marks = marks + 1;
        }
    }
    public Pythonlangquiz(int a1, int a2, int a3, int a4, int a5) {
        this(a1, a2, a3, a4);
        System.out.println("5. Which is valid C expression?\n" +
                "1) int my_num = 100,000;\n" +
                "2) int my_num = 100000;\n" +
                "3) int my num = 1000;\n" +
                "4) int $my_num = 10000;"); // answer is b
        System.out.println("Select your option : ");
        System.out.println("Enter your choice : ");
        int userAns = scan.nextInt();
        if(userAns == a1)
        {
            marks = marks + 1;
        }
        System.out.println("\nYour Marks = " + marks);
    }
}
