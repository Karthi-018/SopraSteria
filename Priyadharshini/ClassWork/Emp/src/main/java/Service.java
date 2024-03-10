public class Service {
    static EmployeeManagement[] em = new EmployeeManagement[10];
    int k = 0;

    public void add(String employeename, int employeeid, String dept, double salary) {
        EmployeeManagement emp = new EmployeeManagement(employeename, employeeid, dept, salary);
        em[k++] = emp;

    }
}
