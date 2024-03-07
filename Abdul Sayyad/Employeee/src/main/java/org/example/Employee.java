package org.example;

import java.util.Comparator;

public class Employee {
    int eId;
    String eName;
    String eDept;
    int  salary;
    Employee(){
    }
    Employee(int eId,String eName,String eDept,int salary){
        this.eId = eId;
        this.eName = eName;
        this.eDept = eDept;
        this.salary = salary;
    }
//    @Override
//    public int compareTo(Employee e){
//        if(this.salary<e.salary)return 1;
//        else return -1;
//    }

    @Override
    public String toString() {
        return "Employee{" +
                "eId=" + eId +
                ", eName='" + eName + '\'' +
                ", eDept='" + eDept + '\'' +
                ", salary=" + salary +
                '}';
    }
}
