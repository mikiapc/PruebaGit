/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Terminal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Naoual Amasri
 */
@Stateless
public class TerminalFacade extends AbstractFacade<Terminal> implements TerminalFacadeLocal {
    @PersistenceContext(unitName = "GUC2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TerminalFacade() {
        super(Terminal.class);
    }
    
    public List<Terminal> findNoBorrados(){
        return em.createQuery("SELECT t FROM Terminal t WHERE t.borrado LIKE 0")
                .getResultList();
    }
    
    public Terminal findById(String id){
        return (Terminal) em.createQuery("SELECT t FROM Terminal t WHERE t.idTerminal LIKE :custID")
                .setParameter("custID", id)
                .getSingleResult();
    }
    
}
