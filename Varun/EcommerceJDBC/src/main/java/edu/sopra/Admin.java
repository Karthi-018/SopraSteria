package edu.sopra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.*;

public class Admin {
        Scanner sc=new Scanner(System.in);
        Connection con=null;
        PreparedStatement ps=null;














        public void add() {

                List<String> li=new ArrayList<>();



                try
                {
                        con=DbConnection.getConnection();
                        ps= con.prepareStatement("select pname from product");
                        ResultSet rs=ps.executeQuery();
                        while(rs.next())
                        {
                                li.add(rs.getString(1));
                        }
                }
                catch(Exception e)
                {
                        System.out.println(e);
                }




                int flag=0;
                try
                {

                        System.out.print("Enter the product name :  ");
                        String pro=sc.next();
                        if(li==null)
                        {
                                li.add(pro);
                        }
                        for(String i: li)
                        {
                                if(i.equals(pro))
                                {
                                        flag=1;
                                        break;
                                }
                        }

                        con=DbConnection.getConnection();
                        ps=con.prepareStatement("insert into product values(?,?,?,?)");
                        ps.setString(1,pro);
                        System.out.print("Enter the product Description :  ");
                        String prodesc=sc.next();
                        ps.setString(2,prodesc);
                        System.out.print("Enter the product Price :  ");
                        float pri=sc.nextFloat();
                        ps.setFloat(3,pri);
                        System.out.print("Enter the product Quantity :  ");
                        int quan=sc.nextInt();
                        ps.setInt(4,quan);

                        if(flag!=0)
                        {
                                System.out.println("Product already exist ");
                        }
                        else {
                                li.add(pro);
                                ps.executeUpdate();
                        }


                        System.out.println("List : "+li);

                }
                catch(Exception e)
                {
                        System.out.println(e);
                }

        }



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



        public void edit(String name)
        {
                try
                {
                        ps= con.prepareStatement("update product set pname=?,pdes=?,pprice=?,pquantity=? where pname=?");
                        System.out.print("enter the name to be updated : ");
                        ps.setString(1,sc.next());
                        System.out.print("enter the description to be updated : ");
                        ps.setString(2,sc.next());
                        System.out.print("enter the Price to be updated : ");
                        ps.setFloat(3,sc.nextFloat());
                        System.out.print("enter the Quantity to be updated : ");
                        ps.setInt(4,sc.nextInt());

                        ps.setString(5,name);


                        ps.executeUpdate();

                }
                catch(Exception e)
                {
                        System.out.println(e);
                }

        }


        public void delete(String name)
        {
                try
                {
                        con=DbConnection.getConnection();
                        ps= con.prepareStatement("select * from product where pname=?");
                        ps.setString(1,name);
                        ResultSet rs=ps.executeQuery();
                        if (rs!=null)
                        {
                                PreparedStatement ps1=con.prepareStatement("delete from product where pname=?");
                                ps1.setString(1,name);
                                ps1.executeUpdate();
                        }
                        else
                        {
                                System.out.println("No element found");
                        }

                }
                catch(Exception e)
                {
                        System.out.println(e);
                }

        }


}
