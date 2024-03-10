public class Emp {
    private int id;
    private String name;
    private String dept;
    private double salary;

    public Emp(int id, java.lang.String name, java.lang.String dept, double salary) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    Emp() {
        System.out.println("no details");
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public java.lang.String getName() {
        return name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
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

    @java.lang.Override
    public java.lang.String toString() {
        return "Emp{" +
                "id=" + id +
                ", name=" + name +
                ", dept=" + dept +
                ", salary=" + salary +
                '}';
    }
}
