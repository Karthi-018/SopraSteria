package edu.sopra;

import java.util.Objects;

public class Employee {
    private String name;
    private int id;
    private String dept;
    static int i =0;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public static int getI() {
        return i;
    }

    public static void setI(int i) {
        Employee.i = i;
    }

    Employee(String name, int id, String dept)
    {
        this.id=id;
        this.name=name;
        this.dept=dept;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", dept='" + dept + '\'' +
                '}';
    }





}
