package firstPack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

interface Dequeue {
	public int dequeueNotification() throws ClassNotFoundException, SQLException;
	default public int read(String type) throws ClassNotFoundException, SQLException{
		int success=0;
		String url="jdbc:mysql://localhost:3306/sw";
	    Class.forName("com.mysql.jdbc.Driver");
	    Connection conn= DriverManager.getConnection(url,"root","Password123#@!");
	    String query="SELECT * FROM "+type+";";
        Statement st=conn.createStatement();
        ResultSet re=st.executeQuery(query);
        while(re.next())
        {        	
        	System.out.println(re.getString("content"));
        	success++;
        }
        st.close();
		return success;
	}
	default public boolean delete(String type) throws SQLException, ClassNotFoundException{
		String url="jdbc:mysql://localhost:3306/sw";
	    Class.forName("com.mysql.jdbc.Driver");
	    Connection conn= DriverManager.getConnection(url,"root","Password123#@!");
		String query="DELETE FROM "+type+";";
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        int re=preparedStmt.executeUpdate();
        if(re>0) {
        	System.out.println("Dequeued");
        	return true;
        } 
        else return false;
	}
	}
