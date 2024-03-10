package edu.steria;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Employe> emp = new ArrayList<>();
        emp.add(new Employe(10,"priya","hr"));
        emp.add(new Employe(101,"pri","tech"));
        emp.add(new Employe(102,"priyathama","ed"));
        for(Employe e:emp)
        {
            System.out.println(e);
        }
        }
    }