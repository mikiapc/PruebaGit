/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Ayuntamiento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Naoual Amasri
 */
@Local
public interface AyuntamientoFacadeLocal {

    void create(Ayuntamiento ayuntamiento);

    void edit(Ayuntamiento ayuntamiento);

    void remove(Ayuntamiento ayuntamiento);

    Ayuntamiento find(Object id);

    List<Ayuntamiento> findAll();

    List<Ayuntamiento> findRange(int[] range);

    int count();
    
}
