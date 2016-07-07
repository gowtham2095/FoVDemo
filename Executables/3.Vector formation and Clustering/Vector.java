import java.util.*;
import java.io.*;
import java.sql.*;
import java.lang.*;

public class Vector
{
          
           public static void main(String args[])throws SQLException,ClassNotFoundException

                   {

                  try{   Class.forName("com.mysql.jdbc.Driver");

                    Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+args[0],"root","ssn");
                    Connection con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+args[1],"root","ssn");
                    Connection con3=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+args[2],"root","ssn");
                    Connection con4=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+args[3],"root","ssn");
                    Connection con5=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+args[4],"root","ssn");
                   
                    Statement stmt1=con1.createStatement();
                    Statement stmt2=con2.createStatement();
                    Statement stmt3=con3.createStatement();
                    Statement stmt4=con4.createStatement();
                    Statement stmt5=con5.createStatement();

                    String sql1="select country, rank from country_class";
                    ResultSet rs1 = stmt1.executeQuery(sql1);
                    String sql2="select rank from country_class";
                    ResultSet rs2 = stmt2.executeQuery(sql2);
                    String sql3="select rank from country_class";
                    ResultSet rs3 = stmt3.executeQuery(sql3);
                    String sql4="select rank from country_class";
                    ResultSet rs4 = stmt4.executeQuery(sql4);

                    int k1,k2,k3,k4;
                    PrintWriter pw = new PrintWriter(new File("test.csv"));
		    StringBuilder sb = new StringBuilder();
                    sb.append("country");
	            sb.append(",");
	            sb.append("health");
                    sb.append(",");
		    sb.append("education");
		    sb.append(",");
		    sb.append("public-cash");
                    sb.append(",");
		    sb.append("public-tax");
		    sb.append("\n");
                    while(rs1.next()&&rs2.next()&&rs3.next()&&rs4.next())
                      {
                        String s=rs1.getString("country");
			//System.out.println("Test");
                        k1=rs1.getInt("rank");
                        k2=rs2.getInt("rank");
			k3=rs3.getInt("rank");
			k4=rs4.getInt("rank");
                        stmt5.executeUpdate("insert into country_vector values('"+s+"',"+k1+","+k2+","+k3+","+k4+")");
                        sb.append(s);
	                sb.append(",");
	            	sb.append(k1);
                    	sb.append(",");
		     	sb.append(k2);
		   	sb.append(",");
		    	sb.append(k3);
                    	sb.append(",");
		    	sb.append(k4);
		    	sb.append("\n");
                     }
                    

                    pw.write(sb.toString());
                    pw.close();
}
catch(Exception e)
{
e.printStackTrace();
}
                     }




}