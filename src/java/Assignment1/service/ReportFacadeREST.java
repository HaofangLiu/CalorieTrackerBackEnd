/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment1.service;

import Assignment1.Report;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
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
@Path("assignment1.report")
public class ReportFacadeREST extends AbstractFacade<Report> {

    @PersistenceContext(unitName = "Assignment1PU")
    private EntityManager em;

    public ReportFacadeREST() {
        super(Report.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Report entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Report entity) {
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
    public Report find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Report> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Report> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    @GET
    @Path("findByUserid/{userid}")
    @Produces({"application/json"})
    public List<Report> findByUserid(@PathParam("userid") int userid) {
    Query query = em.createNamedQuery("Report.findByUserid");
    query.setParameter("userid", userid);
    return query.getResultList();
    }

    @GET
    @Path("findByDate/{date}")
    @Produces({"application/json"})
    public List<Report> findByDate(@PathParam("date") String dateEnter) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateEnter);
        Query query = em.createNamedQuery("Report.findByDate");
        query.setParameter("date", date);
        return query.getResultList();
    }

    @GET
    @Path("findByTotalcalorieconsumed/{totalcalorieconsumed}")
    @Produces({"application/json"})
    public List<Report> findByTotalcalorieconsumed(@PathParam("totalcalorieconsumed") int totalcalorieconsumed) {
        Query query = em.createNamedQuery("Report.findByTotalcalorieconsumed");
        query.setParameter("totalcalorieconsumed", totalcalorieconsumed);
        return query.getResultList();
    }

    @GET
    @Path("findByTotalcalorieburned/{totalcalorieburned}")
    @Produces({"application/json"})
    public List<Report> findByTotalcalorieburned(@PathParam("totalcalorieburned") int totalcalorieburned) {
        Query query = em.createNamedQuery("Report.findByTotalcalorieburned");
        query.setParameter("totalcalorieburned", totalcalorieburned);
        return query.getResultList();
    }

    @GET
    @Path("findByTotalsteptaken/{totalsteptaken}")
    @Produces({"application/json"})
    public List<Report> findByTotalsteptaken(@PathParam("totalsteptaken") int totalsteptaken) {
        Query query = em.createNamedQuery("Report.findByTotalsteptaken");
        query.setParameter("totalsteptaken", totalsteptaken);
        return query.getResultList();
    }

    @GET
    @Path("findBySetcaloriegoalthatday/{setcaloriegoalthatday}")
    @Produces({"application/json"})
    public List<Report> findBySetcaloriegoalthatday(@PathParam("setcaloriegoalthatday") int setcaloriegoalthatday) {
        Query query = em.createNamedQuery("Report.findBySetcaloriegoalthatday");
        query.setParameter("setcaloriegoalthatday", setcaloriegoalthatday);
        return query.getResultList();
    }

    @GET
    @Path("findByFirstnameAndReportdate/{firstname}/{date}")
    @Produces({"application/json"})
    public List<Report> findByFirstnameAndReportdate(@PathParam("firstname") String firstname, 
            @PathParam("date") String date) throws ParseException {
        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        TypedQuery<Report> nQuery = em.createQuery("SELECT r from Report r WHERE r.userid.firstname = :firstname "
                + "AND r.date = :date", Report.class);
        nQuery.setParameter("firstname", firstname);
        nQuery.setParameter("date", date1);
        return nQuery.getResultList();
    }

    @GET
    @Path("calculateRemaining/{userid}/{date}")
    @Produces({MediaType.APPLICATION_JSON})
    public Object calculateRemaining(@PathParam("userid") int userid, 
            @PathParam("date") String date) throws ParseException {
        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        TypedQuery<Report> queryList = em.createQuery("SELECT r from Report r WHERE r.userid.userid = :userid "
                + "AND r.date = :date",Report.class);
        queryList.setParameter("userid", userid);
        queryList.setParameter("date", date1);
        List<Report> reQueryList = queryList.getResultList();
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        for (Report row : reQueryList) {
            JsonObject personObject = Json.createObjectBuilder().
                    add("totalcalorieconsumed", row.getTotalcalorieconsumed())
                    .add("totalcalorieburned", row.getTotalcalorieburned())
                    .add("remainingcalorie", row.getSetcaloriegoalthatday() - 
                            ( row.getTotalcalorieconsumed() - row.getTotalcalorieburned())).build();
            arrayBuilder.add(personObject);
        }
        JsonArray jArray = arrayBuilder.build();
        return jArray;
    }

    
    @GET
    @Path("calculateRemAndSteps/{userid}/{date1}/{date2}")
    @Produces({MediaType.APPLICATION_JSON})
    public Object calculateRemAndSteps(@PathParam("userid") int userid, @PathParam("date1") String date1, 
            @PathParam("date2") String date2) throws ParseException {
        Date date11 = new SimpleDateFormat("yyyy-MM-dd").parse(date1);
        Date date22 = new SimpleDateFormat("yyyy-MM-dd").parse(date2);
        TypedQuery<Report> queryList = em.createQuery("SELECT r from Report r WHERE r.userid.userid = :userid "
                + "AND r.date BETWEEN :date1 AND :date2",Report.class);
        queryList.setParameter("userid", userid);
        queryList.setParameter("date1", date11);
        queryList.setParameter("date2", date22);
        List<Report> reQueryList = queryList.getResultList();
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        Integer totalCon = 0;
        Integer totalBurn = 0;
        Integer totalStep = 0;
        for (Report row : reQueryList) {
            totalCon = totalCon + row.getTotalcalorieconsumed();
            totalBurn = totalBurn + row.getTotalcalorieburned();
            totalStep = totalStep + row.getTotalsteptaken();
        }
        JsonObject personObject = Json.createObjectBuilder().
                    add("totalcalorieconsumed", totalCon.toString())
                    .add("totalcalorieburned", totalBurn.toString())
                    .add("totalstepstaken", totalStep.toString()).build();
            arrayBuilder.add(personObject);
        JsonArray jArray = arrayBuilder.build();
        return jArray;
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
