/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Categoriallamadas;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Naoual Amasri
 */
@Stateless
public class CategoriallamadasFacade extends AbstractFacade<Categoriallamadas> implements CategoriallamadasFacadeLocal {
    @PersistenceContext(unitName = "GUC2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoriallamadasFacade() {
        super(Categoriallamadas.class);
    }
    
}
