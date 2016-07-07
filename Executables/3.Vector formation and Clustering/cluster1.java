import java.util.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.lang.*;

public class Cluster1 {

  public static void main(String[] args) throws SQLException,ClassNotFoundException {

	

	String csvFile = args[0]+".csv";
	BufferedReader br = null;
	String line = "";

	
String Split = ",";
try
{
Class.forName("com.mysql.jdbc.Driver");

        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vector","root","ssn");
        Statement stmt=con.createStatement();


	

		br = new BufferedReader(new FileReader(csvFile));
                int i;

		line = br.readLine();


                  while((line=br.readLine())!=null)
{
		        
			String[] country = line.split(Split);

             /*     if(country[2].contains("Rep.")||country[2].contains(" RB")||country[2].contains("The")||country[2].contains("Fed.")||country[1].contains(" SAR")||country[2].contains("FYR"))
{
                      
                      country[1]=country[1].replaceAll("\"","");
                      country[2]=country[2].replaceAll("\"","");
                      country[1]=country[1]+country[2];
                      country[3]=country[3].replaceAll("\"","");
                      System.out.print(country[1]+" "+country[2]);
                    stmt.executeUpdate("insert into country_cluster values('"+country[1]+"',"+Integer.parseInt(country[3])+")");
                    


}
*/
                        
{
                         country[1]=country[1].replaceAll("\"","");
                         country[1]=country[1].replaceAll("'","");
                         country[2]=country[2].replaceAll("\"","");
                        System.out.print(country[1]+" "+country[2]);
                       stmt.executeUpdate("insert into country_cluster values('"+country[1]+"',"+Integer.parseInt(country[2])+")");
                  
}
                     System.out.println();

} 


		

	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}


 finally {
		if (br != null) {
			try {
				br.close();
			} catch (IOException e)
                         {
				                      e.printStackTrace();
			}
		}
	}

	System.out.println("Done");

  }
  }

 