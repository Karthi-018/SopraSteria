package edu.steria;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.lang.*;
import java.util.*;


public class Main {
    public static void main(String[] args)  {

        Scanner sc=new Scanner(System.in);
        Connection connection =null;
        try {
             connection =dbconnection.getConnection();
            Statement s= connection.createStatement();
            s.executeQuery("Select * from employee");
        }
        catch (SQLException e){
            System.out.println(e);

        }



    }
}