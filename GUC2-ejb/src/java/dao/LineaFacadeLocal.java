/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Linea;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Naoual Amasri
 */
@Local
public interface LineaFacadeLocal {

    void create(Linea linea);

    void edit(Linea linea);

    void remove(Linea linea);

    Linea find(Object id);

    List<Linea> findAll();

    List<Linea> findRange(int[] range);

    int count();
    
}
