package firstPack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class dequeueEmail implements Dequeue {

	@Override
	public int dequeueNotification() throws ClassNotFoundException, SQLException {
		boolean done=false;
		int success;
		success=read("EmailQ");
		done=delete("EmailQ");
		return success;
	}

}
