package edu.steria.training;

public class Employee
{
    private String empName;
    private int empId;
    private String empDept;
    private double salary;

    public Employee(String empName, int empId, String empDept,double salary)
    {
        this.empName = empName;
        this.empId = empId;
        this.empDept = empDept;
        this.salary = salary;
    }

    public double getSalary()
    {
        return salary;
    }

    public void setSalary(double salary)
    {
        this.salary = salary;
    }

    public String getEmpName()
    {
        return empName;
    }

    public int getEmpId()
    {
        return empId;
    }

    public String getEmpDept()
    {
        return empDept;
    }

    public void setEmpName(String empName)
    {
        this.empName = empName;
    }

    public void setEmpId(int empId)
    {
        this.empId = empId;
    }

    public void setEmpDept(String empDept)
    {
        this.empDept = empDept;
    }

    @Override
    public String toString()
    {
        return "Employee{" +
                "empName='" + empName + '\'' +
                ", empId=" + empId +
                ", empDept='" + empDept + '\'' +
                ", salary ='" + salary + '\'' +
                '}';
    }


}
