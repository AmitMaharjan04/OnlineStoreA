/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcdemo;

import java.sql.*;
import java.util.*;

/**
 *
 * @author student
 */
public class JDBCDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        int category_id,stock,discount;
        String pname,unit;
        float price;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter category_id:");
        category_id=sc.nextInt();
        System.out.println("Enter product name:");
        pname=sc.next();
        System.out.println("Enter unit:");
        unit=sc.next();
        System.out.println("Enter price:");
        price=sc.nextFloat();
        System.out.println("Enter stock:");
        stock=sc.nextInt();
        System.out.println("Enter discount:");
        discount=sc.nextInt();
        String url="jdbc:mysql://localhost:3306/onlinestorea";
        String user="Ravi";
        String pass="ROOT";
        String query="Select * from products";
        String insertQuery=String.format("Insert into products (category_id,name,price,discount,unit,stock) values(%d,'%s',%f,%d,'%s',%d)",category_id,pname,price,discount,unit,stock);
        Connection con=DriverManager.getConnection
                (url,user,pass);
        Statement st=con.createStatement();
        //ResultSet rs=st.executeQuery(query);
        int rowCount=st.executeUpdate(insertQuery);
        System.out.println(rowCount +"_row added Successfully");
        //System.out.println("Name\t\tPrice\t\tStock");
        /*while(rs.next())
            System.out.println(rs.getString(3)+"\t\tRs"+rs.getString(4)+"\t\t"+rs.getString(7)+rs.getString(6));*/
          con.close();
                
    }
    
}
