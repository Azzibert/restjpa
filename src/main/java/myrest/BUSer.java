package myrest;

import monPaquet.Bu;
import monPaquet.Livre;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.UUID;

@Path("livres")
public class BUSer {

    Bu bibliojpa= new Bu() ;

    public BUSer(){

    }
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON ,MediaType.APPLICATION_XML})
    public List<Livre> getLivres(){
        System.out.println(bibliojpa.findAll());
        return bibliojpa.findAll();
    }
    @Path("livres/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
    public Livre getLivre(@PathParam("id") UUID uuid){
        return bibliojpa.findById(uuid);
    }
    @PUT
    @Produces({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
    public String create(Livre livre   ){

        bibliojpa.save(livre);
        return "ldfkmo";

    }
}

