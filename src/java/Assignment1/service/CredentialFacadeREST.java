/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment1.service;

import Assignment1.Credential;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author haofangliu
 */
@Stateless
@Path("assignment1.credential")
public class CredentialFacadeREST extends AbstractFacade<Credential> {

    @PersistenceContext(unitName = "Assignment1PU")
    private EntityManager em;

    public CredentialFacadeREST() {
        super(Credential.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Credential entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Credential entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Credential find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Credential> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Credential> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    @GET
    @Path("findByUsername/{username}")
    @Produces({"application/json"})
    public List<Credential> findByUsername(@PathParam("username") String username) {
    Query query = em.createNamedQuery("Credential.findByUsername");
    query.setParameter("username", username);
    return query.getResultList();
    }
    
    @GET
    @Path("findByUsernameAndPasswordhashing/{username}/{passwordhashing}")
    @Produces({"application/json"})
    public List<Credential> findByUsernameAndPasswordhashing(@PathParam("username") String username, @PathParam("passwordhashing") String passwordhashing){
    TypedQuery<Credential> nQuery = em.createQuery("SELECT c from Credential c WHERE c.username = :username AND c.passwordhashing = :passwordhashing", Credential.class);
     nQuery.setParameter("username", username);
      nQuery.setParameter("passwordhashing", passwordhashing);
      return nQuery.getResultList();
    }
    
    @GET
    @Path("findByPasswordhashing/{passwordhashing}")
    @Produces({"application/json"})
    public List<Credential> findByPasswordhashing(@PathParam("passwordhashing") String passwordhashing) {
    Query query = em.createNamedQuery("Credential.findByPasswordhashing");
    query.setParameter("passwordhashing", passwordhashing);
    return query.getResultList();
    }
    
    @GET
    @Path("findBySignupdate/{signupdate}")
    @Produces({"application/json"})
    public List<Credential> findBySignupdate(@PathParam("signupdate") String signupDate) throws ParseException {
    Date signupdate = new SimpleDateFormat("yyyy-MM-dd").parse(signupDate);
    Query query = em.createNamedQuery("Credential.findBySignupdate");
    query.setParameter("signupdate", signupdate);
    return query.getResultList();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
