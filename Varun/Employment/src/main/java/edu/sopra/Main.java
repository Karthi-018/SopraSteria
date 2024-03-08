package edu.sopra;
import java.util.*;
public class Main {
    public static void main(String[] args) {

        EmployeeService es = new EmployeeService();
        es.add();
        es.list();
        es.Delete();
        es.list();

//        es.showAllEmployee();


    }
}