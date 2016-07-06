import java.util.*;
import java.io.*;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
import java.sql.*;
import java.lang.*;

public class Classification
{
   public static void main(String[] args) throws SQLException,ClassNotFoundException
         

    {

     try
         {
          int[] h=new int[4];
           if(args[0].equals("health"))
             {
               h[0]=10;
               h[1]=6;
               h[2]=4;
               h[3]=2;
             }
            else if(args[0].equals("education"))
             {
               h[0]=8;
               h[1]=6;
               h[2]=4;
               h[3]=2;
             }
             else if(args[0].equals("public-tax"))
             {
               h[0]=25;
               h[1]=15;
               h[2]=10;
               h[3]=0;
             }
             else if(args[0].equals("public-cash"))
             {
               h[0]=5;
               h[1]=0;
               h[2]=-4;
               h[3]=-10;
             }
             else
              {
               System.out.println("Recompile with proper database name");
               System.exit(0);
                 }
           Class.forName("com.mysql.jdbc.Driver");

           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+args[0],"root","ssn");
           Statement stmt=con.createStatement();
           Statement stmt2=con.createStatement();
           
           String sql="select country from country_code";
           ResultSet rs = stmt.executeQuery(sql);
        
         while(rs.next())
               {
                String s =rs.getString("country");
                System.out.println(s);
                
                stmt2.executeUpdate("insert into country_class(country) values('"+s+"')");




                 }
        
           Statement stmt3 = con.createStatement();
           Statement stmt4 = con.createStatement();
           String sql1="select country,avg(val) as val from country_gdp group by country";
           ResultSet rs1=stmt4.executeQuery(sql1);
           while(rs1.next())
                   {
                     String s=rs1.getString("country");
                     float k=rs1.getFloat("val");
                     int j=0;
                     if(k>h[0])
                        j=4;
                      else if(k>h[1])
                         j=3;
                       else if(k>h[2])
                         j=2;
                        else if(k>h[3])
                         j=1;
                      stmt3.execute("update country_class set rank="+j+" where country='"+s+"'");
                          }



         }

 catch(Exception e)
{
     e.printStackTrace();

}



    }


}