package steria.emp.test;

public class EmpOpr {

    static Employee emp[] = new Employee[5];
    static int i = 0;

    public void addEmp(Employee e)
    {
        emp[i++] = e;
    }

    public void viewEmp()
    {
        for(Employee temp: emp)
        {
            System.out.println(temp);
        }
    }

    public void editEmp(int eid, int salary)
    {
        for(Employee temp: emp)
        {
            if(eid == temp.getEmpCode())
            {
                temp.setEmpSalary(salary);
            }
        }

    }

    public void searchEmp(int eid)
    {
        for(Employee temp: emp)
        {
            if(eid == (temp.getEmpCode()))
            {
                System.out.println(temp);
            }
        }
    }



}
