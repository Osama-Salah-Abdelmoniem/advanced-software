package com.company;

import java.sql.*;

public class CRUDoperations {
    private  String url="jdbc:mysql://localhost:1234/sw";
    private  Connection  establish_connection() throws SQLException {

         //\connect root@localhost
            Connection conn= DriverManager.getConnection(url,"fouad","1234");
         //   System.out.println("good");
            return conn;
    }
    public void read(String subject) throws SQLException {
        Connection conn=establish_connection();
        String query="SELECT * FROM temp WHERE subject='"+subject+"'";

        Statement st=conn.createStatement();
        ResultSet re=st.executeQuery(query);
        while(re.next())
        {
            System.out.println(re.getInt("id"));
            System.out.println(re.getString("subject"));
            System.out.println(re.getString("content"));
            System.out.println(re.getString("type"));
            System.out.println(re.getString("language"));
            System.out.println(re.getString("placeholders"));
        }
        st.close();
    }
    public void create(String subject,String content,String type,String placeholders ,String language) throws SQLException {
        Connection conn=establish_connection();
        String query="INSERT INTO temp (subject,content,type,placeholders,language)"+" VALUES(?, ?, ?, ?,?) ";
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setString(1,subject);
        preparedStmt.setString(2,content);
        preparedStmt.setString(3,type);
        preparedStmt.setString(4,placeholders);
        preparedStmt.setString(5,language);
        preparedStmt.execute();

    }
    public void delete(String subject) throws SQLException {
        Connection conn=establish_connection();
        String query="DELETE FROM temp WHERE subject=?";
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setString(1,subject);
        preparedStmt.execute();

    }
    public  void update(String subject,String n_subject ,String n_content,String n_type,String n_placeholders,String language) throws SQLException {
        Connection conn=establish_connection();
        String query="UPDATE temp set subject=?,content=?,type=?,placeholders=?,language=? where subject=?";
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setString(1,n_subject);
        preparedStmt.setString(2,n_content);
        preparedStmt.setString(3,n_type);
        preparedStmt.setString(4,n_placeholders);
        preparedStmt.setString(5,language);
        preparedStmt.setString(6,subject);
        preparedStmt.execute();
    }





}
