package bankManagementSystemDBMS;
	import java.sql.*;
	class Input{
	public static final String URL ="jdbc:oracle:thin:@localhost:1521:system";
	String user="system";
	String pass="antriksh007";
	
	public ResultSet execute(String query)  {
		try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e){System.out.println("Could not load driver");}
		ResultSet rs = null;
		try{
		Connection con=DriverManager.getConnection(URL,user,pass);
		Statement stmt=con.createStatement();
		rs=stmt.executeQuery(query);
		/*while(rs.next())
        {
     	   System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getString(3)+"  "+rs.getString(4));
        }*/
		System.out.println("Query executed");
		}catch(SQLSyntaxErrorException e){
			System.err.println(e.getMessage());
		}
		catch(SQLException e){e.printStackTrace();}
		
	return rs;

	   }
	}