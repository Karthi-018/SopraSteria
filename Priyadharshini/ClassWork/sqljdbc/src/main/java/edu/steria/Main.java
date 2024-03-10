package edu.steria;
import java.util.*;
import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
//        int id=sc.nextInt();
//        String eName=sc.next();
//        String dept=sc.next();
//        int salary=sc.nextInt();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo", "root", "root");
            System.out.println("connected.....");
//            PreparedStatement ps= connection.prepareStatement("Insert into employee values(" + id + ", '"+ eName + "', '" + dept + "', " + salary + ")");
//            ps.executeUpdate();
            PreparedStatement ps= connection.prepareStatement("Insert into employee values(?,?,?,?)");
            ps.setInt(1,sc.nextInt());
            ps.setString(2,sc.next());
            ps.setString(3,sc.next());
            ps.setInt(4,sc.nextInt());
            ps.executeUpdate();
//            Statement statement = connection.createStatement();
//            statement.executeUpdate("Insert into employee values(" + id + ", '"+ eName + "', '" + dept + "', " + salary + ")");
//            ResultSet resultSet= statement.executeQuery("select * from employee");
//            while (resultSet.next()) {
//                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3) + " " + resultSet.getInt(4));
//            }
        }
        catch(ClassNotFoundException e)
        {
            System.out.println(e);
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
    }
}