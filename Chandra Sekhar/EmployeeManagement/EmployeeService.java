package sopra.project.employee;

public class EmployeeService {

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

    public void editEmp(String name, int salary)
    {
        for(Employee temp: emp)
        {
            if(name.equals(temp.getEmpName()))
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

    public void delete(String name)
    {
        for(int i = 0; i < emp.length; i++)
        {
            if(emp[i].getEmpName().equals(name))   //If element found
            {
                for(int j = i; j < emp.length - 1; j++)
                {
                    emp[j] = emp[j+1];
                }
                break;
            }
        }
    }



}

//int elem = sc.nextInt();
//
//    for(int i = 0; i < arr.length; i++)
//        {
//        if(arr[i] == elem)   //If element found
//        {
//        // shifting elements
//        for(int j = i; j < arr.length - 1; j++)
//        {
//arr[j] = arr[j+1];
//        }
//        break;
//        }
//        }
//
//        System.out.println("Elements after deletion " );
//       for(int i = 0; i < arr.length-1; i++)
//        {
//        System.out.print(arr[i]+ " ");
//       }
//               }
//               }






















