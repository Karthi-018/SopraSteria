package org.example;

public class Employee {
    private int eId;
    private String name;
    private String dept;
    private double sal;
    public Employee(int eID, String name, String dept, double sal) {
        this.eId = eID;
        this.name = name;
        this.dept = dept;
        this.sal = sal;
    }

    public int geteId() {
        return eId;
    }

    public void seteId(int eId) {
        this.eId = eId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
    public double getSal() {
        return sal;
    }
    public void setSal(double sal) {
        this.sal = sal;
    }
    @Override
    public String toString() {
        return "{" +
                "eID=" + eId +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", sal=" + sal +
                '}';
    }
}