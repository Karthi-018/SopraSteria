package edu.steria.training;
import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to Quiz App............");
            System.out.println("1. Start the Quiz App \n2.Exit");
            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();
            if (ch == 2)
            {
                System.out.println("Leaving the Quiz App...............");
                break;
            }
            else if(ch==1)
            {
                String py[] = {"1.Which of the following is the correct extension of the Python file?\na) .python\nb) .pl\nc) .py\nd) .p",
                        "2. Which keyword is used for function in Python language?\na) Function\nb) def\nc) Fun\nd) Define",
                        "3. Python supports the creation of anonymous functions at runtime, using a construct called __________\na) pi\nb) anonymous\nc) lambda\nd) none of the mentioned",
                        "4. Which of the following functions is a built-in function in python?\na) factorial()\nb) print()\nc) seed()\nd) sqrt()",
                        "5. Which of the following statements is used to create an empty set in Python?\na) ( )\nb) [ ]\nc) { }\nd) set()"};


                String pyAns[] = {"c", "b", "c", "b", "d"};

                String java[] = {"1. Which component is used to compile, debug and execute the java programs?\na) JRE\nb) JIT\nc) JDK\nd) JVM",
                                 "2. Which of the following is not an OOPS concept in Java?\na) Polymorphism\nb) Inheritance\nc) Compilation\nd) Encapsulation",
                                 "3. Which of the following is a type of polymorphism in Java Programming?\na) Multiple polymorphism\nb) Compile time polymorphism\nc) Multilevel polymorphism\nd) Execution time polymorphism",
                                 "4. Which of these are selection statements in Java?\na) break\nb) continue\nc) for()\nd) if()",
                                 "5. Which of these keywords is used to define interfaces in Java?\na) intf\nb) Intf\nc) interface\nd) Interface" };

                String javaAns[] = {"c","c","b","d","c"};

                String cpp[] = { "1. Which of the following is not a type of Constructor in C++?\na) Default constructor\nb) Parameterized constructor\nc) Copy constructor\nd) Friend constructor",
                                 "2. Which of the following correctly declares an array in C++?\na) array{10};\nb) array array[10];\nc) int array;\nd) int array[10];",
                                 "3. Which keyword is used to define the macros in c++?\na) #macro\nb) #define\nc) macro\nd) define",
                                 "4. What is Inheritance in C++?\na) Deriving new classes from existing classes\nb) Overloading of classes\nc) Classes with same names\nd) Wrapping of data into a single class",
                                 "5. What is the benefit of c++ input and output over c input and output?\na) Both Type safety & Exception\nb) Sequence container\nc) Exception\nd) Type safety"
                };

                String cppAns[] = { "d", "d", "b", "a" , "d"};

                System.out.println("Choose the Programming language to write the quiz..........");
                System.out.println("1.Python\n2.Java\n3.C++\n4.Exit");
                System.out.print("Enter your choice: ");

                int langch = sc.nextInt();
                switch (langch) {
                    case 1: Quiz qpy = new Quiz(py, pyAns);
                            qpy.fetchQues(0);
                            break;

                    case 2: Quiz qjava = new Quiz(java, javaAns);
                            qjava.fetchQues(0);
                            break;

                    case 3: Quiz qcpp = new Quiz(cpp, cppAns);
                            qcpp.fetchQues(0);
                            break;

                    case 4: break;

                    default: System.out.println("Invalid option.....");
                }
            }
            else
            {
                System.out.println("Improper option.........");
            }
        }
    }
}