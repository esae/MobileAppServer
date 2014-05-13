/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.fhnw.bscwi.esae.mobileappserver.service;

import ch.fhnw.bscwi.esae.mobileappserver.business.EmployeeEJB;
import ch.fhnw.bscwi.esae.mobileappserver.domain.Employee;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import org.glassfish.jersey.server.JSONP;

/**
 *
 * @author andreas.martin
 */
@Stateless
@Path("ch.fhnw.bscwi.esae.mobileappserver.service.employee")
public class EmployeeRESTService{

    @EJB
    EmployeeEJB employeeEJB;
    
    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Employee find(@PathParam("id") Integer id) {
        return employeeEJB.find(id);
    }
    
    @GET
    @JSONP(queryParam = JSONP.DEFAULT_QUERY)
    @Path("findById/{id}")
    @Produces({"application/javascript"})
    public Employee find(@QueryParam(JSONP.DEFAULT_QUERY) String callback, @PathParam("id") Long id) {
        return employeeEJB.find(id);
    }
    
    @GET
    @JSONP(queryParam = JSONP.DEFAULT_QUERY)
    @Path("findByName/{name}")
    @Produces({"application/javascript"})
    public List<Employee> findByName(@QueryParam(JSONP.DEFAULT_QUERY) String callback, @PathParam("name") String name) {
        return employeeEJB.findByName(name);
    }
    
    @GET
    @JSONP(queryParam = JSONP.DEFAULT_QUERY)
    @Path("findByName")
    @Produces({"application/javascript"})
    public List<Employee> findByName(@QueryParam(JSONP.DEFAULT_QUERY) String callback) {
        return findAll();
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<Employee> findAll() {
        return employeeEJB.findAll();
    }

}
