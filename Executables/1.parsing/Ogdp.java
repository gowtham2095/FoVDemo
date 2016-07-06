import java.util.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.lang.*;

public class Ogdp {

  public static void main(String[] args) throws SQLException,ClassNotFoundException {

	

	String csvFile = args[0]+".csv";
	BufferedReader br = null;
	String line = "";
int h=0;
if(args[0].equals("health"))
h=1;
	
String Split = ",";
try
{
Class.forName("com.mysql.jdbc.Driver");

        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+args[0],"root","ssn");
        Statement stmt=con.createStatement();


	

		br = new BufferedReader(new FileReader(csvFile));
                int temp=1,i,j=1960;
                while(temp<=5)
{
		line = br.readLine();
temp++;
}

                  while((line=br.readLine())!=null)
{
		        
			String[] country = line.split(Split);

                  if(country[1].contains("Rep.")||country[1].contains(" RB")||country[1].contains("The")||country[1].contains("Fed.")||country[0].contains(" SAR")||country[1].contains("FYR"))
{
                      
                      country[0]=country[0].replaceAll("\"","");
                      country[1]=country[1].replaceAll("\"","");
                      country[0]=country[0]+country[1];
                      country[2]=country[2].replaceAll("\"","");
                      System.out.print(country[0]+" "+country[2]);
                    stmt.executeUpdate("insert into country_code values('"+country[0]+"','"+country[2]+"')");
                    for(i=5+h;i<61+h;i++)
                    {
                      if(country[i].equals("\"\"")==false)
                       {
                         //System.out.println(j++);
                       country[i]=country[i].replaceAll("\"","");
                      stmt.executeUpdate("insert into country_gdp values('"+country[0]+"','"+j+"',"+Float.parseFloat(country[i])+")");
                         j++;
                         }
                     else
                      j++;

                     }
                    j=1960;


}
                      else  
{
                         country[0]=country[0].replaceAll("\"","");
                         country[0]=country[0].replaceAll("'","");
                         country[1]=country[1].replaceAll("\"","");
                        System.out.print(country[0]+" "+country[1]);
                       stmt.executeUpdate("insert into country_code values('"+country[0]+"','"+country[1]+"')");
                  for(i=4+h;i<60+h;i++)
                    {
                      if(country[i].equals("\"\"")==false)
                      {
                      //System.out.println(j++);
                      country[i]=country[i].replaceAll("\"","");
                      stmt.executeUpdate("insert into country_gdp values('"+country[0]+"','"+j+"',"+Float.parseFloat(country[i])+")");
                      j++;
                       } 
                      else
                      j++;

                     }
                    j=1960;
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

 