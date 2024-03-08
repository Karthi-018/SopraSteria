package org.example;
import java.util.*;
import java.sql.*;
import java.util.Date;

public class CollegeBo {
    Connection connection = null;
    Scanner sc = new Scanner(System.in);
    public static void add(){
        Scanner sc=new Scanner(System.in);
        System.out.println("college detail upadate page");

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
        try {
            Connection connection=DbConnection.getConnection();
            PreparedStatement ps=connection.prepareStatement("insert into college values(?,?,?,?,?,?,?);");
            ps.setString(1,collegeName.toLowerCase());
            ps.setString(2,collegeWeb.toLowerCase());
            ps.setString(3,collegeMob.toLowerCase());
            ps.setString(4,collegeFounder.toLowerCase());
            ps.setInt(5,collegeNumberOfDept);
            ps.setString(6,collegeLocation.toLowerCase());
            ps.setString(7,collegeStartingDate);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<College> findCollege(List<String> nameList){
        List<College> list=new ArrayList<>();
        try {
            connection=DbConnection.getConnection();
            Statement statement=connection.createStatement();
            for(String i:nameList){
                ResultSet resultSet=statement.executeQuery("select * from college where collegeName ='"+i+"';");
                if(!resultSet.next()) {
                    continue;
                }
                 String name=resultSet.getString(1);
                 String website=resultSet.getString(2);
                 String mobile=resultSet.getString(3);
                 String founder=resultSet.getString(4);
                 int numberOfDept=resultSet.getInt(5);
                 String location=resultSet.getString(6);
                 Date startingDate=resultSet.getDate(7);
                 College college=new College(name,website,mobile,founder,numberOfDept,location,startingDate);
                 list.add(college);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    public List<College> findCollege(Date startingDate){
        List<College> list=new ArrayList<>();
        String date = startingDate.getYear() + "-" + startingDate.getMonth() + "-" + startingDate.getDate();
        try {
            connection=DbConnection.getConnection();
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select * from college where collegeStartingDate ='"+date+"';");
            while (resultSet.next()) {
                String name = resultSet.getString(1);
                String website = resultSet.getString(2);
                String mobile = resultSet.getString(3);
                String founder = resultSet.getString(4);
                int numberOfDept = resultSet.getInt(5);
                String loc = resultSet.getString(6);
                Date stDate = resultSet.getDate(7);
                College college = new College(name, website, mobile, founder, numberOfDept, loc, stDate);
                list.add(college);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;

    }
    public List<College> findCollege(String location){
        List<College> list=new ArrayList<>();
        try {
            connection=DbConnection.getConnection();
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select * from college where collegeLocation ='"+location+"';");
            while (resultSet.next()) {
                String name = resultSet.getString(1);
                String website = resultSet.getString(2);
                String mobile = resultSet.getString(3);
                String founder = resultSet.getString(4);
                int numberOfDept = resultSet.getInt(5);
                String loc = resultSet.getString(6);
                Date stDate = resultSet.getDate(7);
                College college = new College(name, website, mobile, founder, numberOfDept, loc, stDate);
                list.add(college);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
