/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.fhnw.bscwi.esae.mobileappserver.business;

import ch.fhnw.bscwi.esae.mobileappserver.domain.Employee;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author andreas.martin
 */
@Stateless
public class EmployeeEJB extends AbstractFacade<Employee> {
    @PersistenceContext(unitName = "ch.fhnw.bscwi.esae_MobileAppServer_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmployeeEJB() {
        super(Employee.class);
    }
    
    public List<Employee> findByName(String name) {
        return em.createNamedQuery("Employee.findByName").setParameter("name", "%"+name.toLowerCase()+"%").getResultList();
    }
    
}
