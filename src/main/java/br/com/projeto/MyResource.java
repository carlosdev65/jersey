package br.com.projeto;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/")
public class MyResource {    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers(){
    	UserServer userServer = new UserServer();
    	return Response.ok(userServer.getUsers()).build();
    	
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("id") Long id){
    	UserServer userServer = new UserServer();
    	User user = userServer.findById(id);
    	return Response.ok(user).build();
    }  
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(User user){
    	UserServer userServer = new UserServer();    	
    	userServer.add(user);
    	return Response.ok(user).status(201).build();
    }  
    
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id) {
    	UserServer userServer = new UserServer();    	
    	userServer.delete(id);
        return Response.ok().status(204).build();
    }  
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Long id, User user) {
        UserServer userServer = new UserServer();
        User userUpdate = userServer.findById(id);
        
        if(userUpdate == null){
            return Response.noContent().build();
        }
        
        userUpdate.setNome(user.getNome());

        userUpdate.setEmail(user.getEmail());

        userServer.update(userUpdate);
        
        return Response.status(204).build();
     
    }    
    
}
