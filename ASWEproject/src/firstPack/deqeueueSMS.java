package firstPack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class deqeueueSMS implements Dequeue{

	@Override
	public int dequeueNotification() throws ClassNotFoundException, SQLException {
		int success;
		boolean done=false;
		success=read("SMSQ");
		done=delete("SMSQ");
		return success;
	}
}
