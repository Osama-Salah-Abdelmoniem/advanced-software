package firstPack;

import java.sql.SQLException;
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

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/Crud")
public class CRUDcontroller {
	ICRUDoperation c=new CRUDoperations();
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
	
    @GET
    @Path("/read/{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public  NotificationsTemplate getNT(@PathParam("id") int id) throws SQLException, ClassNotFoundException {
        return c.read(id);
    }
    
    
    @POST
    @Path("/create")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public boolean createNT(NotificationsTemplate nt) throws SQLException, ClassNotFoundException{
    	return c.create(nt);
    }
    
    @PUT
    @Path("/update")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public boolean UpdateNT(NotificationsTemplate nt) throws SQLException, ClassNotFoundException{
    	return c.update(nt);
    }

    @DELETE
    @Path("/delete/{id}")
    public boolean deleteNT(@PathParam("id") int id) throws ClassNotFoundException, SQLException {
    	return c.delete(id);
    }
}
