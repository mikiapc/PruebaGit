/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Servicioconcertacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Naoual Amasri
 */
@Stateless
public class ServicioconcertacionFacade extends AbstractFacade<Servicioconcertacion> implements ServicioconcertacionFacadeLocal {
    @PersistenceContext(unitName = "GUC2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ServicioconcertacionFacade() {
        super(Servicioconcertacion.class);
    }
    
}
