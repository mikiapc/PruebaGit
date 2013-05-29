/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Linea;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Naoual Amasri
 */
@Stateless
public class LineaFacade extends AbstractFacade<Linea> implements LineaFacadeLocal {
    @PersistenceContext(unitName = "GUC2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LineaFacade() {
        super(Linea.class);
    }
    
    public List<Linea> findNoBorradas(){
        return em.createQuery("SELECT l FROM Linea l WHERE l.borrada LIKE 0")
                .getResultList();
    }
    
         
    public Linea findById(String id){
        return (Linea) em.createQuery("SELECT l FROM Linea l WHERE l.idLinea LIKE :custID")
                .setParameter("custID", id)
                .getSingleResult();
    }
    
}
