package edu.sopra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class User {



    Scanner sc=new Scanner(System.in);
    Connection con=null;
    PreparedStatement ps=null;
    public void list()
    {
        try
        {
            con=DbConnection.getConnection();
            ps= con.prepareStatement("select * from product");
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                System.out.println(rs.getString(1)+"   "+rs.getString(2)+"   "+rs.getFloat(3)+"    "+rs.getInt(4));
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    public void search(String s)
    {
        try
        {
            con=DbConnection.getConnection();
            ps= con.prepareStatement("select * from product where pname=?");
            ps.setString(1,s);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                System.out.println("Product found");
            }
            else {
                System.out.println("Product not found.");
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }


    public void buy(String s) {


            try {


                while (true) {
                    con = DbConnection.getConnection();
                    ps = con.prepareStatement("select * from product where pname=?");
                    ps.setString(1, s);
                    ResultSet rs = ps.executeQuery();
                    String name = null;
                    int num = 0;
                    if (rs.next()) {
                        name = rs.getString(1);
                        num = rs.getInt(4);
                        System.out.println("Search element found");
                        System.out.println("-----------------");
                        System.out.println("Press 1 to process the transaction ");
                        System.out.println("Press 2 to go back");
                        int temp = sc.nextInt();
                        if (temp == 1) {
                            System.out.println(name + "  " + num);
                            transaction(name, num);
                            break;
                        } else if (temp == 2) {
                            break;
                        }

                    } else {
                        System.out.println("No such product present ");

                    }
                    break;
                }


            }
            catch (Exception e)
            {
                System.out.println(e);
            }



    }

    public void transaction(String name,int num)
    {

        try
        {
            con=DbConnection.getConnection();
            ps=con.prepareStatement("update product set pquantity=? where pname=?");
            num=num-1;
            ps.setInt(1,num);
            ps.setString(2,name);
            ps.executeUpdate();


            if(num==0)
            {
                ps=con.prepareStatement("delete from product where pname=?");
                ps.setString(1,name);
                ps.executeUpdate();
            }

            System.out.println("Payment sucessfull");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }



}
