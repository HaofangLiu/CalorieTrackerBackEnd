/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment1.service;

import Assignment1.Consumption;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
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
@Path("assignment1.consumption")
public class ConsumptionFacadeREST extends AbstractFacade<Consumption> {

    @PersistenceContext(unitName = "Assignment1PU")
    private EntityManager em;

    public ConsumptionFacadeREST() {
        super(Consumption.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Consumption entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Consumption entity) {
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
    public Consumption find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Consumption> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Consumption> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    @GET
    @Path("findByDate/{date}")
    @Produces({"application/json"})
    public List<Consumption> findByDate(@PathParam("date") String dateT) throws ParseException {
    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateT);
    Query query = em.createNamedQuery("Consumption.findByDate");
    query.setParameter("date", date);
    return query.getResultList();
    }
    
    @GET
    @Path("findByQuantity/{quantity}")
    @Produces({"application/json"})
    public List<Consumption> findByQuantity(@PathParam("quantity") int quantity) {
    Query query = em.createNamedQuery("Consumption.findByQuantity");
    query.setParameter("quantity", quantity);
    return query.getResultList();
    }
    
    @GET
    @Path("findByUserid/{userid}")
    @Produces({"application/json"})
    public List<Consumption> findByUserid(@PathParam("userid") int userid) {
    Query query = em.createNamedQuery("Consumption.findByUserid");
    query.setParameter("userid", userid);
    return query.getResultList();
    }
    
    @GET
    @Path("findByFoodid/{foodid}")
    @Produces({"application/json"})
    public List<Consumption> findByFoodid(@PathParam("foodid") int foodid) {
    Query query = em.createNamedQuery("Consumption.findByFoodid");
    query.setParameter("foodid", foodid);
    return query.getResultList();
    }
    
    
    @GET
    @Path("findByDateAndFoodname/{foodname}/{date}")
    @Produces({"application/json"})
    public List<Consumption> findByDateAndFoodname(@PathParam("foodname") String foodname, 
            @PathParam("date") String dateR) throws ParseException{
    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateR);
    Query nQuery = em.createNamedQuery("Consumption.findByDateAndFoodname");
    nQuery.setParameter("foodname", foodname);
    nQuery.setParameter("date", date);
    return nQuery.getResultList();
    }
   
    @GET
    @Path("calAllClorie/{userid}/{date}")
    @Produces({MediaType.TEXT_PLAIN})
    public BigDecimal calAllClorie(@PathParam("userid") Integer userid, 
            @PathParam("date") String date) throws ParseException{
    Date dateD = new SimpleDateFormat("yyyy-MM-dd").parse(date);
    TypedQuery<Consumption> nQuery = em.createQuery("SELECT c from Consumption c WHERE c.userid.userid = :userid "
            + "AND c.date = :date", Consumption.class);
     nQuery.setParameter("userid", userid);
      nQuery.setParameter("date", dateD);
      List<Consumption> fConThatDay = nQuery.getResultList();
      int totalClorieConsumed = 0;
        for (Consumption fConThatDay1 : fConThatDay) {
            totalClorieConsumed = fConThatDay1.getFoodid().getCalorieamount() * fConThatDay1.getQuantity() 
                    + totalClorieConsumed;
        }
         BigDecimal bigdecimal = BigDecimal.valueOf(totalClorieConsumed);
        return bigdecimal;
    }
    
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
