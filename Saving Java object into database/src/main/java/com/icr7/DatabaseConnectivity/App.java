package com.icr7.DatabaseConnectivity;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       String jdbcUrl="jdbc:mysql://localhost:3306/icr7_users?useSSL=false";
       String user="icr7db";
       String pass="0298";
       try {
    	   System.out.println( "connecting to database: "+jdbcUrl);
    	   
    	   Connection myConn =
    			   DriverManager.getConnection(jdbcUrl,user,pass);
    	   
    	   System.out.println("Connection successful!!!");
       }
       catch(Exception exc){
    	   exc.printStackTrace();
       }
    }
}
