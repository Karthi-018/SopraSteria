package edu.steria.training;

public class Employee {

        private int empId;
        private String empName;
        private String dept;
        private double empSalary;

        void setEmpId(int id)
        {
            empId=id;
        }
        int getEmpId()
        {
            return empId;
        }
        void setEmpName(String name)
        {
            empName=name;
        }
        String getEmpName()
        {
            return empName;
        }
        void setDept(String dep)
        {
            dept=dep;
        }
        String getDept()
        {
            return dept;
        }
        void setSalary(int salary)
        {
            empSalary=salary;
        }
        double getEmpSalary()
        {
            return empSalary;
        }

        public String toString()
        {
            return "\nEmployee ID:"+empId+"\nEmployee Name:"+empName+"\nEmployee Department:"+dept;
        }
    }


