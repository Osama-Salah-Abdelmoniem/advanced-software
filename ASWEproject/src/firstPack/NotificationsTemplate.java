package firstPack;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement(name = "notifiaction")
@XmlAccessorType(XmlAccessType.FIELD)


public class NotificationsTemplate {
		private int ID;
		private String Template;
	    private String Subject ;
	    private String Type;
	    private String Language;
	    private static ArrayList<Integer> PlaceHolders = new ArrayList<>();
	    public String getLanguage() {
	        return language;
	    }

	    public void setLanguage(String language) {
	        this.language = language;
	    }
	    
	    private String language;

	    public void setSubject(String subject) {
	        Subject = subject;
	    }
	   

	    public String getType() {
	        return Type;
	    }

	    public String getTemplate() {
	        return Template;
	    }

	    public String getSubject() {
	        return Subject;
	    }

	    public void setTemplate(String template) {
	        Template = template;
	    }

	    public void setType(String type) {
	        Type = type;
	    }

		public static ArrayList<Integer> getPlaceHolders() {
			return PlaceHolders;	
		}

		public static void setPlaceHolders(ArrayList<Integer> placeHolders) {
			PlaceHolders = placeHolders;
		}

		public int getID() {
			return ID;
		}

		public void setID(int iD) {
			ID = iD;
		}

		

}
