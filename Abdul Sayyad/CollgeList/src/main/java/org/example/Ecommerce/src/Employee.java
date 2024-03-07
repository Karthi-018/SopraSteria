
class Employee{
    private int eId;
    private String eName;

    public int geteId() {
        return eId;
    }

    public void seteId(int eId) {
        this.eId = eId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    public String toString(){
        return eId + " " + eName + " " + dept+" "+salary;
    }
    private String dept;
    private double salary;
    Employee(){
        System.out.println("No details");
    }
    Employee(String message){
        System.out.println(message);
    }
    Employee(int eId){
        this();
        this.eId = eId;
        System.out.println(this.eId);
    }
    Employee(int eId, String eName){
        this(eId);
        this.eName = eName;
        System.out.println(this.eName);

    }
    Employee(int eId, String eName,String dept){
        this(eId,eName);
        this.dept = dept;
        System.out.println(this.dept);
    }
    Employee(int eId, String eName,String dept ,double salary){
        this(eId,eName,dept);
        this.salary= salary;
        System.out.println(this.salary);
    }



}
