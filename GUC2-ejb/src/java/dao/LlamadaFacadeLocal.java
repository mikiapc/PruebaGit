/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Llamada;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Naoual Amasri
 */
@Local
public interface LlamadaFacadeLocal {

    void create(Llamada llamada);

    void edit(Llamada llamada);

    void remove(Llamada llamada);

    Llamada find(Object id);

    List<Llamada> findAll();

    List<Llamada> findRange(int[] range);

    int count();
    
}
