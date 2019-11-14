/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment1.service;

import Assignment1.Userapp;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
//mport static javax.persistence.TemporalType.DATE;
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
@Path("assignment1.userapp")
public class UserappFacadeREST extends AbstractFacade<Userapp> {

    @PersistenceContext(unitName = "Assignment1PU")
    private EntityManager em;

    public UserappFacadeREST() {
        super(Userapp.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Userapp entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Userapp entity) {
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
    public Userapp find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Userapp> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Userapp> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @GET
    @Path("findByFirstname/{firstname}")
    @Produces({"application/json"})
    public List<Userapp> findByFirstname(@PathParam("firstname") String firstname) {
    Query query = em.createNamedQuery("Userapp.findByFirstname");
    query.setParameter("firstname", firstname);
    return query.getResultList();
    }
    
    @GET
    @Path("findBySurname/{surname}")
    @Produces({"application/json"})
    public List<Userapp> findBySurname(@PathParam("surname") String surname) {
    Query query = em.createNamedQuery("Userapp.findBySurname");
    query.setParameter("surname", surname);
    return query.getResultList();
    }
    
    @GET
    @Path("findByEmail/{email}")
    @Produces({"application/json"})
    public List<Userapp> findByEmail(@PathParam("email") String email) {
    Query query = em.createNamedQuery("Userapp.findByEmail");
    query.setParameter("email", email);
    return query.getResultList();
    }
    
    @GET
    @Path("findByDob/{dob}")
    @Produces({"application/json"})
    public List<Userapp> findByDob(@PathParam("dob") String dobEnter) throws ParseException {
    
    Date dob = new SimpleDateFormat("yyyy-MM-dd").parse(dobEnter);
    Query query = em.createNamedQuery("Userapp.findByDob");
    query.setParameter("dob", dob);
    return query.getResultList();
    }
    
    @GET
    @Path("findByHeight/{height}")
    @Produces({"application/json"})
    public List<Userapp> findByHeight(@PathParam("height") Integer height) {
    Query query = em.createNamedQuery("Userapp.findByHeight");
    query.setParameter("height", height);
    return query.getResultList();
    }
    
    @GET
    @Path("findByWeight/{weight}")
    @Produces({"application/json"})
    public List<Userapp> findByWeight(@PathParam("weight") BigDecimal weight) {
    Query query = em.createNamedQuery("Userapp.findByWeight");
    query.setParameter("weight", weight);
    return query.getResultList();
    }
    
    @GET
    @Path("findByGender/{gender}")
    @Produces({"application/json"})
    public List<Userapp> findByGender(@PathParam("gender") String gender) {
    Query query = em.createNamedQuery("Userapp.findByGender");
    query.setParameter("gender", gender);
    return query.getResultList();
    }
    
    @GET
    @Path("findByAddress/{address}")
    @Produces({"application/json"})
    public List<Userapp> findByAddress(@PathParam("address") String address) {
    Query query = em.createNamedQuery("Userapp.findByAddress");
    query.setParameter("address", address);
    return query.getResultList();
    }
    
    @GET
    @Path("findByPostcode/{postcode}")
    @Produces({"application/json"})
    public List<Userapp> findByPostcode(@PathParam("postcode") Integer postcode) {
    Query query = em.createNamedQuery("Userapp.findByPostcode");
    query.setParameter("postcode", postcode);
    return query.getResultList();
    }
    
    @GET
    @Path("findByLevelofactivityonetofive/{levelofactivityonetofive}")
    @Produces({"application/json"})
    public List<Userapp> findByLevelofactivityonetofive(@PathParam("levelofactivityonetofive") Integer levelofactivityonetofive) {
    Query query = em.createNamedQuery("Userapp.findByLevelofactivityonetofive");
    query.setParameter("levelofactivityonetofive", levelofactivityonetofive);
    return query.getResultList();
    }
    
    @GET
    @Path("findBySteppermile/{steppermile}")
    @Produces({"application/json"})
    public List<Userapp> findBySteppermile(@PathParam("steppermile") Integer steppermile) {
    Query query = em.createNamedQuery("Userapp.findBySteppermile");
    query.setParameter("steppermile", steppermile);
    return query.getResultList();
    }
    
    @GET
    @Path("findByFirstnameAndSurname/{firstname}/{surname}")
    @Produces({"application/json"})
    public List<Userapp> findByFirstnameAndSurname(@PathParam("firstname") String firstname, @PathParam("surname") String surname){
    TypedQuery<Userapp> nQuery = em.createQuery("SELECT u from Userapp u WHERE u.firstname = :firstname "
            + "AND u.surname = :surname", Userapp.class);
     nQuery.setParameter("firstname", firstname);
      nQuery.setParameter("surname", surname);
      return nQuery.getResultList();
    }
    
    @GET
    @Path("calculateCaloriePerStep/{clorieid}")
    @Produces({MediaType.TEXT_PLAIN})
    public BigDecimal calculateCaloriePerStep(@PathParam("clorieid") Integer clorieid){
        Userapp newUser = super.find(clorieid);
        double caloriePerStep = newUser.getWeight().doubleValue() * 2.2 * 0.49 / newUser.getSteppermile();
        BigDecimal bigdecimal = BigDecimal.valueOf(caloriePerStep);
        return bigdecimal;
    }
    
    @GET
    @Path("amountBMR/{bmrid}")
    @Produces({MediaType.TEXT_PLAIN})
    public BigDecimal amountBMR(@PathParam("bmrid") Integer bmrid){
        Userapp newUser = super.find(bmrid);
        Calendar curr = Calendar.getInstance();
            Calendar born = Calendar.getInstance();
            Date bitrh = newUser.getDob();
            born.setTime(bitrh);
            int age = curr.get(Calendar.YEAR) - born.get(Calendar.YEAR);
        if (newUser.getGender().equalsIgnoreCase("M")){
            double maleBMR = (newUser.getWeight().doubleValue() * 13.75) + (5.003 * (double)newUser.getHeight()) 
                    - (6.755 * (double)age) + 66.5;
            BigDecimal bigdecimal = BigDecimal.valueOf(maleBMR);
            return bigdecimal;
        }
        else{
            double femaleBMR = (newUser.getWeight().doubleValue() * 9.563) + (1.85 * (double)newUser.getHeight()) 
                    - (4.676 * (double)age) + 655.1;
            BigDecimal bigdecimal = BigDecimal.valueOf(femaleBMR);
            return bigdecimal;
        }
    }   
    
    @GET
    @Path("calculateCaloriePBurned/{clorieid}")
    @Produces({MediaType.TEXT_PLAIN})
    public BigDecimal calculateCaloriePBurned(@PathParam("clorieid") Integer clorieid){
        Userapp newUser = super.find(clorieid);
        int level = newUser.getLevelofactivityonetofive();
        double bmr = amountBMR(clorieid).doubleValue();
        double clorieburned = 0;
        switch(level){
            case 1 : clorieburned = bmr * 1.2;break;
            case 2 : clorieburned = bmr * 1.375;break;
            case 3 : clorieburned = bmr * 1.55;break;
            case 4 : clorieburned = bmr * 1.725;break;
            case 5 : clorieburned = bmr * 1.9;break;
        }
        BigDecimal bigdecimal = BigDecimal.valueOf(clorieburned);
        return bigdecimal;
    }
    
    
    
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
