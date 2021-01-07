package firstPack;


import java.sql.*;
import java.util.ArrayList;

public interface ICRUDoperation {
    public Connection establish_connection() throws SQLException, ClassNotFoundException;
    public NotificationsTemplate read(int id) throws SQLException, ClassNotFoundException  ;
    public boolean create(NotificationsTemplate nt) throws SQLException, ClassNotFoundException;
    public boolean delete(int id) throws SQLException, ClassNotFoundException;
    public boolean update(NotificationsTemplate nt) throws SQLException, ClassNotFoundException;
}