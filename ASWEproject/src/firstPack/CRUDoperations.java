package firstPack;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import firstPack.NotificationsTemplate;

public class CRUDoperations implements ICRUDoperation {
	
	ArrayList <NotificationsTemplate> Arr =new ArrayList<NotificationsTemplate>();
	 private  String url="jdbc:mysql://localhost:3306/sw";
	    public Connection  establish_connection() throws SQLException, ClassNotFoundException {

	         //\connect root@localhost
	    	 Class.forName("com.mysql.jdbc.Driver");
	            Connection conn= DriverManager.getConnection(url,"root","Password123#@!");
	         //   System.out.println("good");
	            return conn;
	    }
	    public NotificationsTemplate read(int id) throws SQLException, ClassNotFoundException {
	        
	    	Connection conn=establish_connection();
	        String query="SELECT * FROM temp WHERE ID ='"+id+"'";
	        Statement st=conn.createStatement();
	        ResultSet re=st.executeQuery(query);
	        NotificationsTemplate nt=new NotificationsTemplate();
	        if(re.next())
	        {        	
	        	nt.setID(re.getInt("ID"));
	        	nt.setSubject(re.getString("subject"));
	        	nt.setTemplate(re.getString("content"));
	        	nt.setType(re.getString("type"));
	        	nt.setLanguage(re.getString("language"));
	
	        }
	        st.close();
	        return nt;
	    }
	    public boolean create(NotificationsTemplate nt) throws SQLException, ClassNotFoundException {
	        Connection conn=establish_connection();
	        String query="INSERT INTO temp (subject,content,type,language,ID)"+" VALUES(?, ?, ?,?,?) ";
	        PreparedStatement preparedStmt = conn.prepareStatement(query);
	        preparedStmt.setString(1,nt.getSubject());
	        preparedStmt.setString(2,nt.getTemplate());
	        preparedStmt.setString(3,nt.getType());
	        preparedStmt.setString(4,nt.getLanguage());
	        preparedStmt.setInt(5,nt.getID());
	        int re=preparedStmt.executeUpdate();
	        if(re>0) return true;
	        else return false;
	    }
	    public boolean delete(int id) throws SQLException, ClassNotFoundException {
	        Connection conn=establish_connection();
	        String query="DELETE FROM temp WHERE ID=?";
	        PreparedStatement preparedStmt = conn.prepareStatement(query);
	        preparedStmt.setInt(1,id);
	        int re=preparedStmt.executeUpdate();
	        if(re>0) return true;
	        else return false;

	    }
	    public boolean update(NotificationsTemplate nt) throws SQLException, ClassNotFoundException {
	        Connection conn=establish_connection();
	        String query="UPDATE temp set subject=?,content=?,type=?,language=? where ID=?";
	        PreparedStatement preparedStmt = conn.prepareStatement(query);
	        preparedStmt.setString(1,nt.getSubject());
	        preparedStmt.setString(2,nt.getTemplate());
	        preparedStmt.setString(3,nt.getType());
	        preparedStmt.setString(4,nt.getLanguage());
	        preparedStmt.setInt(5,nt.getID());
	        int re=preparedStmt.executeUpdate();
	        if(re>0) return true;
	        else return false;
	    }



}
