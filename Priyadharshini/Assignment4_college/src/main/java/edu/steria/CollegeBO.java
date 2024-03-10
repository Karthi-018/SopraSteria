package edu.steria;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.util.*;
import java.util.Date;
public class CollegeBO {
    Scanner sc = new Scanner(System.in);

    public List<String> addname(int n, List<String> nameList) {
        String name = null;
        for (int i = 0; i < n; i++) {
            name = sc.next();
            nameList.add(name);
        }
        return nameList;
    }
    public List<College> sort(List<College> college1)
    {
        System.out.println("enter the method to sort");
        System.out.println("1.sort by collegename\n2.sort by date\n3.sort by number of dept");
        int opt=sc.nextInt();
        switch(opt)
        {
            case 1:
                Collections.sort(college1, (o1, o2) -> o1.getName().compareTo(o2.getName()));
                break;
            case 2:
                Collections.sort(college1, (o1, o2) -> o1.getStartingdate().compareTo(o2.getStartingdate()));
                break;
            case 3:
                Collections.sort(college1, (o1, o2) -> o1.getNumberOfdept() > o2.getNumberOfdept() ? 1 : -1);
                break;
            default:
                System.out.println("Invalid");
                break;
        }
        return college1;
    }

    public List<College> findCollege(List<String> nameList) {
        List<College> college = new ArrayList<>();
        try {
            Connection cont = null;
            cont = DBconnection.getConnection();
            Statement s = cont.createStatement();
//            ResultSet resultSet = s.executeQuery("select cname from college ");


            for (String i : nameList) {
                ResultSet resultSet = s.executeQuery("select * from college where cname='" + i + "'; ");
                if (resultSet.next()) {
                    college.add(new College(resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getInt(6),
                            resultSet.getString(7),
                            resultSet.getDate(8)));

                }
            }


        } catch (SQLException e) {
            System.out.println(e);
        } catch (NullPointerException e) {
            System.out.println("No data found");
        }
        return college;
    }


    public List<College> findCollege(String startingDate) {
        List<College> college = new ArrayList<>();
        try {
            Connection cont = null;
            cont = DBconnection.getConnection();
            Statement s = cont.createStatement();
//            ResultSet resultSet = s.executeQuery("select cname from college ");


            ResultSet resultSet = s.executeQuery("select * from college where startingdate='" + startingDate + "'; ");
            if (resultSet.next()) {
                college.add(new College(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getInt(6),
                        resultSet.getString(7),
                        resultSet.getDate(8)));


            }


        } catch (SQLException e) {
            System.out.println(e);
        } catch (NullPointerException e) {
            System.out.println("No data found");
        }
        return college;

    }


        public List<College> findCollege1(String loc) {
            List<College> college = new ArrayList<>();
            try {
                Connection cont = null;
                cont = DBconnection.getConnection();
                Statement s = cont.createStatement();

                ResultSet resultSet = s.executeQuery("SELECT * FROM college WHERE location='" + loc + "'; ");
                while(resultSet.next()) {
                    college.add(new College(resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getInt(6),
                            resultSet.getString(7),
                            resultSet.getDate(8)));
                }
            } catch (SQLException e) {
                System.out.println(e);
            } catch (NullPointerException e) {
                System.out.println("No data found");
            }
            System.out.println(college);
            return college;
        }

    }



