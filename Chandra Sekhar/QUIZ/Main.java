package sopra.project.quiz;
import java.util.Scanner;
public class Main {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("***** Welcome to the Language Quiz *****");

        System.out.println("\n1.Enter the Quiz\n2.Exit the Quiz");
        int choice = scan.nextInt();
        if(choice == 1)
        {
            System.out.println("Select the Language for the Quiz");
            System.out.println("1.C\n2.C++\n3.Java\n4.Python");
            int select = scan.nextInt();
            switch(select)
            {
                case 1: Clangquiz obj1 = new Clangquiz(3, 4, 1, 3, 2); break;
                case 2: Cpluslangquiz obj2 = new Cpluslangquiz(3, 4, 1, 3, 2); break;
                case 3: Javalangquiz obj3 = new Javalangquiz(3, 4, 1, 3, 2); break;
                case 4: Pythonlangquiz obj4 = new Pythonlangquiz(3, 4, 1, 3, 2); break;

                default:
                    System.out.println("Enter the right choice !!");
            }
        }

        else
        {
            System.out.println("*** THE END ***");
        }

    }
}