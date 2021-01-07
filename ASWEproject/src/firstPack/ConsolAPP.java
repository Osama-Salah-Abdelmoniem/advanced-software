package firstPack;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Scanner;

class ConsolAPP {
	private static Dequeue de;
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		int successSMS,successEmail,failur=0;
		de=new dequeueEmail();
		successEmail=de.dequeueNotification();
		de=new deqeueueSMS();
		successSMS=de.dequeueNotification();
		System.out.println("Success SMS Notifications: " +successSMS);
		System.out.println("Success EMAIL Notifications: " +successEmail);
		System.out.println("Failed Notifications: " +failur);
	}
}
