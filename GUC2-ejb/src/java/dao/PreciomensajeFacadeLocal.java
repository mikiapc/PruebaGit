/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Preciomensaje;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Naoual Amasri
 */
@Local
public interface PreciomensajeFacadeLocal {

    void create(Preciomensaje preciomensaje);

    void edit(Preciomensaje preciomensaje);

    void remove(Preciomensaje preciomensaje);

    Preciomensaje find(Object id);

    List<Preciomensaje> findAll();

    List<Preciomensaje> findRange(int[] range);

    int count();
    
}
