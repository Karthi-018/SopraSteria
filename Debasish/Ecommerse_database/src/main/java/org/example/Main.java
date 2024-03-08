package org.example;
import java.sql.*;
import java.util.Scanner;
public class Main {
    public static void add(){
        Scanner sc=new Scanner(System.in);
        Connection connection=null;
        System.out.println("enter product name :");
        String product =sc.nextLine();
        System.out.println("enter product quantity :");
        int quantity=sc.nextInt();
        System.out.println("enter product price");
        int price=sc.nextInt();

        try{
            connection = DbConnection.getConnection();
            Statement  statement=connection.createStatement();
            ResultSet   resultSet=statement.executeQuery("select quantity from products where pname ='"+product+"';");
            if(!resultSet.next()){
                PreparedStatement ps = connection.prepareStatement("insert into products values(?,?,?)");
                ps.setString(1, product);
                ps.setInt(2, quantity);
                ps.setInt(3, price);
                ps.executeUpdate();
            } else  {
                PreparedStatement preparedStatement =connection.prepareStatement("update products set quantity = quantity+" +quantity+" where pname = '"+product+"';");
                preparedStatement.executeUpdate();
            }

        }catch (SQLException e){
            System.out.println(e);
        }
        finally {
            try{
                connection.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        admin();

    }
    public static void show() {
        Connection connection=null;
        try{
            connection=DbConnection.getConnection();
            Statement  statement=connection.createStatement();
            ResultSet   resultSet=statement.executeQuery("select * from products");
                while(resultSet.next()){
                    System.out.println(resultSet.getString(1)+" "+resultSet.getInt(2)+" "+resultSet.getInt(3));
                }

        }catch (SQLException e){
            System.out.println(e);
        }
        finally {
            try{
                connection.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        admin();

    }
    public static void update() {
        Scanner sc=new Scanner(System.in);
        Connection connection=null;
        System.out.println("enter product name whose price and quantity need to be changed :");
        String product =sc.nextLine();
//        System.out.println("enter product quantity :");
//        int quantity=sc.nextInt();
        System.out.println("enter product new  price");
        int price=sc.nextInt();
        System.out.println("enter product new  quantity");
        int quantity=sc.nextInt();

        try{
            connection=DbConnection.getConnection();
            PreparedStatement ps=connection.prepareStatement("update products set price = "+price+",quantity ="+quantity+" where pname = '"+product+"';");
            ps.executeUpdate();


        }catch (SQLException e){
            System.out.println(e);
        }
        finally {
            try{
                connection.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        admin();

    }
    public static void remove() {
        Scanner sc=new Scanner(System.in);
        Connection connection=null;
        System.out.println("enter product name you want to delete :");
        String product =sc.nextLine();
        try{
            connection=DbConnection.getConnection();
            PreparedStatement ps=connection.prepareStatement("delete from products where pname = '"+product+"'");
            ps.executeUpdate();


        }catch (SQLException e){
            System.out.println(e);
        }
        finally {
            try{
                connection.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        admin();

    }
    public static void search() {
        Connection connection=null;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter product name you want to search :");
        String pName=sc.nextLine();
        try{
            connection=DbConnection.getConnection();
            Statement  statement=connection.createStatement();
            ResultSet   resultSet=statement.executeQuery("select * from products where pname ='"+pName+"';");
            if(!resultSet.next()){
                System.out.println("product not found!!!");
            }
            else {

                    Statement  st=connection.createStatement();
                    ResultSet   res=st.executeQuery("select * from products where pname ='"+pName+"';");
                     while (res.next()) {
                    System.out.println(res.getString(1) + " " + res.getInt(2) + " " + res.getInt(3));

                    }
            }

        }catch (SQLException e){
            System.out.println(e);
        }
        finally {
            try{
                connection.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        userworkpage();
    }
    public static void buy(){
        Connection connection=null;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter product name you want to buy :");
        String pName=sc.nextLine();
        System.out.println("Enter number of product you want to buy :");
        int quantity=sc.nextInt();
        try{

            connection=DbConnection.getConnection();
            Statement  statement=connection.createStatement();
            ResultSet   resultSet=statement.executeQuery("select * from products where pname ='"+pName+"';");
            if(!resultSet.next()){
                System.out.println("product not Found !!!");
            }
             if (resultSet.getInt(2)>0 && resultSet.getInt(2)>=quantity) {
                PreparedStatement preparedStatement =connection.prepareStatement("update products set quantity = quantity -"+quantity+" where pname = '"+pName+"';");
                preparedStatement.executeUpdate();
                 System.out.println("Bill = "+resultSet.getInt(3)*quantity);
            }
            else{
                System.out.println("out off stock!!");
            }

            //show();

        }catch (SQLException e){
            System.out.println(e);
        }
        finally {
            try{
                connection.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        userworkpage();
    }
    public static void login(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to Just_By\npress 1 for Admin Log in\npress 2 for User Login");
        int input=sc.nextInt();
        //check credential
        if(input==1)
        {
            System.out.println("Enter id ");
            String id=sc.next();
            System.out.println("Enter Password");
            String pass=sc.next();
            if(id.equals("admin") && pass.equals("admin@123")) {
                admin();
            }
            else {
                System.out.println("Invalid User Id");
                login();
            }
        }
        else if(input==2) {
            System.out.println("press 1 for login\npress 2 for signup");
            int userInput=sc.nextInt();
            if(userInput==1){
                userloginpage();
            }
            else if(userInput==2){
                userregisterpage();
            }
            else {
                login();
            }
        }

    }
    public static void userloginpage() {
        System.out.println("login page");
        Scanner sc=new Scanner(System.in);
        System.out.println("enter User");
        String name=sc.next();
        System.out.println("Enter password");
        String pass=sc.next();
        Connection connection=null;
        try{
            connection=DbConnection.getConnection();
            Statement  statement=connection.createStatement();
            ResultSet   resultSet=statement.executeQuery("select * from user where userName='"+name+"';");
            if(!resultSet.next()){
                System.out.println("user doesn't Exist .Please,register ");
                userregisterpage();
            }
            else{
                Statement  st=connection.createStatement();
                ResultSet   re=st.executeQuery("select * from user where userName='"+name+"';");
                if(re.next())
                if(re.getString(2).equals(pass)){
                    System.out.println("Login successfully");
                    userworkpage();
                }
                else{
                    System.out.println("invalid password");
                    userloginpage();
                }

            }
        }catch (SQLException e){
            System.out.println(e);
        }
        finally {
            try{
                connection.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }

        }
    public static void userworkpage() {
        Scanner sc=new Scanner(System.in);

        System.out.println("press 1 for Search \npress 2 for buy\npress 3 for logout");
        int input=sc.nextInt();
        if(input==1){
            search();
        } else if (input==2) {
            buy();
        } else if (input==3) {
            login();
        } else {
            System.out.println("invalid option choosen ,");
            userworkpage();
        }

    }
    public static void userregisterpage() {
        System.out.println("Register page");
        Scanner sc=new Scanner(System.in);
        System.out.println("enter User");
        String name=sc.next();
        System.out.println("Enter password");
        String pass=sc.next();

        Connection connection=null;
        try{
            connection=DbConnection.getConnection();
            Statement  statement=connection.createStatement();
            ResultSet   resultSet=statement.executeQuery("select * from user where userName='"+name+"';");
            if(!resultSet.next()){
                PreparedStatement preparedStatement =connection.prepareStatement("insert into user values(?,?);");
                preparedStatement.setString(1,name);
                preparedStatement.setString(2,pass);
                preparedStatement.executeUpdate();
            }
            else{
                System.out.println("user already exist ");
            }

        }catch (SQLException e){
            System.out.println(e);
        }
        finally {
            try{
                connection.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        userloginpage();

    }
    public static void admin(){

            Scanner sc=new Scanner(System.in);
            System.out.println("press 1 for List All Item\npress 2 for add product\npress 3 for update product\npress 4 for remove a product\npress 0 for Log Out ");
            int input =sc.nextInt();
            if(input==1)
                show();
            else if(input==2)
                add();
            else if(input==3)
                update();
            else if(input==4)
                remove();
            else if(input==0)
                login();
            else {
                System.out.println("you need some sleep");
                admin();
            }


    }

    public static void main(String[] args) {
        login();
    }
}