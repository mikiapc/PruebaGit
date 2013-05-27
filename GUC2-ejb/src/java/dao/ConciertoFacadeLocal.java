/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Concierto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Naoual Amasri
 */
@Local
public interface ConciertoFacadeLocal {

    void create(Concierto concierto);

    void edit(Concierto concierto);

    void remove(Concierto concierto);

    Concierto find(Object id);

    List<Concierto> findAll();

    List<Concierto> findRange(int[] range);

    int count();
    
}
