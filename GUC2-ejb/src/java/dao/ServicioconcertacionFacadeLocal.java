/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Servicioconcertacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Naoual Amasri
 */
@Local
public interface ServicioconcertacionFacadeLocal {

    void create(Servicioconcertacion servicioconcertacion);

    void edit(Servicioconcertacion servicioconcertacion);

    void remove(Servicioconcertacion servicioconcertacion);

    Servicioconcertacion find(Object id);

    List<Servicioconcertacion> findAll();

    List<Servicioconcertacion> findRange(int[] range);

    int count();
    
}
