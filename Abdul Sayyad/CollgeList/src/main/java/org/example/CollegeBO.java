package org.example;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class CollegeBO {
    Connection connection = null;
    Scanner sc = new Scanner(System.in);
    public void add(){
        System.out.print("Enter College name : ");
        String collegeName = sc.nextLine();
        System.out.print("Enter College Website : ");

        String collegeWeb = sc.nextLine();
        System.out.print("Enter College Mobile : ");

        String collegeMob = sc.nextLine();
        System.out.print("Enter College Founder : ");

        String collegeFounder = sc.nextLine();
        System.out.print("Enter College number of Departments : ");

        int collegeNumberOfDept  = sc.nextInt();
        System.out.print("Enter College Location : ");
        String collegeLocation = sc.next();
        System.out.print("Enter College Starting Date: ");
       String collegeStartingDate = sc.next();
       try{
           connection = Dbconnection.getConnection();
           PreparedStatement ps = connection.prepareStatement("insert into college values(?,?,?,?,?,?,?)");
           ps.setString(1,collegeName);
           ps.setString(2,collegeWeb);
           ps.setString(3,collegeMob);
           ps.setString(4,collegeFounder.toLowerCase());
           ps.setInt(5,collegeNumberOfDept);
           ps.setString(6,collegeLocation.toLowerCase());
           ps.setString(7,collegeStartingDate);
           ps.execute();
           System.out.println("College " +collegeName+" Added in database");
       }catch (SQLException e){
           System.out.println(e);
       }
    }
    public List<College> findCollege(List<String> nameList){
        List<College> list = new ArrayList<>();
        try {
            connection = Dbconnection.getConnection();
            Statement statement = connection.createStatement();
            for(String name:nameList){
                ResultSet resultSet = statement.executeQuery("select * from college where nam =" + "'" + name+ "'");
                if(!resultSet.next()) {
                    continue;
                }
                String collegeName = resultSet.getString(1);
                String collegeWebsite = resultSet.getString(2);
                String collegeMob = resultSet.getString(3);
                String collegeFounder = resultSet.getString(4);
                int collegeNumberOfDept = resultSet.getInt(5);
                String collegeLocation = resultSet.getString(6);
                Date collegedate = resultSet.getDate(7);
                College college = new College(collegeName,collegeWebsite,collegeMob,collegeFounder,collegeNumberOfDept,collegeLocation,collegedate);
                list.add(college);
            }


        }catch (SQLException e){
            System.out.println(e);
        }
        return list;
    }

    public List<College> findCollege(Date startingDate){
        String date = startingDate.getYear() + "-" + startingDate.getMonth() + "-" + startingDate.getDate();
        //System.out.println(date);
        List<College> list = new ArrayList<>();
        try {
            connection = Dbconnection.getConnection();
            Statement statement = connection.createStatement();

                ResultSet resultSet = statement.executeQuery("select * from college where startingdate =" + "'" + date+ "'");
                while (resultSet.next()) {
                    String collegeName = resultSet.getString(1);
                    String collegeWebsite = resultSet.getString(2);
                    String collegeMob = resultSet.getString(3);
                    String collegeFounder = resultSet.getString(4);
                    int collegeNumberOfDept = resultSet.getInt(5);
                    String collegeLocation = resultSet.getString(6);
                    Date collegedate = resultSet.getDate(7);
                    College college = new College(collegeName, collegeWebsite, collegeMob, collegeFounder, collegeNumberOfDept, collegeLocation, collegedate);
                    list.add(college);
                }
        }catch (SQLException e){
            System.out.println(e);
        }
       // Collections.sort(list,(o1,o2)->o1.getStartingDate().compareTo(o2.getStartingDate()));
        return list;
    }
    public List<College> findCollege(String location){
        List<College> list = new ArrayList<>();
        try {
            connection = Dbconnection.getConnection();
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from college where location =" + "'" + location+ "'");
            while (resultSet.next()) {
                String collegeName = resultSet.getString(1);
                String collegeWebsite = resultSet.getString(2);
                String collegeMob = resultSet.getString(3);
                String collegeFounder = resultSet.getString(4);
                int collegeNumberOfDept = resultSet.getInt(5);
                String collegeLocation = resultSet.getString(6);
                Date collegedate = resultSet.getDate(7);
                College college = new College(collegeName, collegeWebsite, collegeMob, collegeFounder, collegeNumberOfDept, collegeLocation, collegedate);
                list.add(college);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        // Collections.sort(list,(o1,o2)->o1.getStartingDate().compareTo(o2.getStartingDate()));
        return list;
    }


}
