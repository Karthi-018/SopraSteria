package steria.emp.test;

public class Employee {

    private int empCode;
    private int empSalary;
    private String empName;
    private String empWork;

    public Employee(int empCode, int empSalary, String empName, String empWork) {
        this.empCode = empCode;
        this.empSalary = empSalary;
        this.empName = empName;
        this.empWork = empWork;
    }

    public int getEmpCode() {
        return empCode;
    }

    public void setEmpCode(int empCode) {
        this.empCode = empCode;
    }

    public int getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(int empSalary) {
        this.empSalary = empSalary;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpWork() {
        return empWork;
    }

    public void setEmpWork(String empWork) {
        this.empWork = empWork;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empCode=" + empCode +
                ", empSalary=" + empSalary +
                ", empName='" + empName + '\'' +
                ", empWork='" + empWork + '\'' +
                '}';
    }
}