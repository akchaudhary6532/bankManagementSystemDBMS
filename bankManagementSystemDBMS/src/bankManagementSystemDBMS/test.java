package bankManagementSystemDBMS;
import java.sql.*;
public class test {
	
	public static final String URL ="jdbc:oracle:thin:@localhost:1521:system";
	static String user="system";
	static String pass="antriksh007";
	
	public static void main(String []ars)  {
		try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e){System.out.println("Could not load driver");}
		ResultSet rs = null;
		try{
		Connection con=DriverManager.getConnection(URL,user,pass);
		Statement stmt=con.createStatement();
		//stmt.executeQuery("delete from bank");
		//stmt.executeQuery("Insert into bank(code,name) values('SwB','SBI')");
		rs=stmt.executeQuery("select * from bank");
		while(rs.next())
        {
     	   System.out.println(rs.getString(1)+"  "+rs.getString(2));//rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getString(3)+"  "+rs.getString(4));
        }
		System.out.println("Sucess");
		}catch(SQLException e){System.out.println("SQLException");
		 e.printStackTrace();}
		
	   }
	}
