package edu.steria;
import java.sql.*;
import java.lang.*;


    public class Main {
        public static void main(String[] args) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo", "root", "root");
                System.out.println("connected.....");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from employee");
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3) + " " + resultSet.getInt(4));
                }
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