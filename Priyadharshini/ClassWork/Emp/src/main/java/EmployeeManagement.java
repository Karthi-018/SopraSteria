public class EmployeeManagement {
    private String employeename;
    private int employeeid;
    private String dept;
    private double salary;

    public EmployeeManagement(java.lang.String employeename, int employeeid, java.lang.String dept, double salary) {
        this.employeename = employeename;
        this.employeeid = employeeid;
        this.dept = dept;
        this.salary = salary;
    }

    public java.lang.String getEmployeename() {
        return employeename;
    }

    public void setEmployeename(java.lang.String employeename) {
        this.employeename = employeename;
    }

    public int getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(int employeeid) {
        this.employeeid = employeeid;
    }

    public java.lang.String getDept() {
        return dept;
    }

    public void setDept(java.lang.String dept) {
        this.dept = dept;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployeeManagement{" +
                "employeename=" + employeename +
                ", employeeid=" + employeeid +
                ", dept=" + dept +
                ", salary=" + salary +
                '}';
    }
}
