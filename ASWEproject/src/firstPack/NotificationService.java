package firstPack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import firstPack.NotificationsTemplate;

@Path("/sendNT")
public class NotificationService {
		ICRUDoperation c=new CRUDoperations();
		public String Read(int id) throws ClassNotFoundException, SQLException {
			return c.read(id).getTemplate();
		}
		@POST
		@Path("/send/{id}/{type}/{placeholders}/{email_or_phonenumber}")
		@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
		public boolean sendNT(@PathParam("id") int id,@PathParam("type") String type,@PathParam("placeholders") String placeholders,@PathParam("email_or_phonenumber") String email_or_phonenumber) throws ClassNotFoundException, SQLException {
			boolean check=false;
			String temp=Read(id);
			String Template=prepareTemplate(temp,placeholders);
			String subject=c.read(id).getSubject();
			String language=c.read(id).getLanguage();
			if(type.equals("sms")) {
				String table="SMSQ";
				check=insertQ(table,"phonenumber",subject,Template,language,email_or_phonenumber);
			}
			else if(type.equals("email")) {
				String table="EmailQ";
				check=insertQ(table,"email",subject,Template,language,email_or_phonenumber);
			}
			
			return check;
		}
		public boolean insertQ(String table,String reciver,String subject,String content,String language,String phone_or_email) throws SQLException, ClassNotFoundException {
			Connection conn=c.establish_connection();
			 String query="INSERT INTO "+table+ " (subject,content,language,"+reciver+")"+" VALUES(?,?,?,?) ";
		        PreparedStatement preparedStmt = conn.prepareStatement(query);
		        preparedStmt.setString(1,subject);
		        preparedStmt.setString(2,content);
		        preparedStmt.setString(3,language);
		        preparedStmt.setString(4, phone_or_email);
		        int re=preparedStmt.executeUpdate();
		        if(re>0) return true;
		        else return false;
		}
		public ArrayList getPH(String temp) {
			ArrayList<Integer> PlaceHolders = new ArrayList<>();
			;
			Parser p=new Parser();
			boolean check=p.Parse(temp);
			if(check) {
				String ph=p.getPlaceHolders();
				String[] arr=ph.split("");  // [1,2,5]
				for(int i=0;i<arr.length;i++) {
					if(i%2!=0) {
						PlaceHolders.add(Integer.parseInt(arr[i]));
						}
				}
			}
			return PlaceHolders;
		}
		public String prepareTemplate(String temp,String actualPH) {  
			ArrayList<Integer> PlaceHolders = new ArrayList<>();
			String finaltemp="";
			String[] tempArr=temp.split(" ");
			PlaceHolders=getPH(temp);
			String[] arr=actualPH.split(",");
			for(int i=0; i<arr.length;i++) { 
				tempArr[PlaceHolders.get(i)]=arr[i];
			}
			for(int j=0; j<tempArr.length;j++) {
				finaltemp+=tempArr[j] + " ";
			}
			return finaltemp;
		}
}
