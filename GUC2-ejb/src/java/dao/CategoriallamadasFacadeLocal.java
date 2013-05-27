/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Categoriallamadas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Naoual Amasri
 */
@Local
public interface CategoriallamadasFacadeLocal {

    void create(Categoriallamadas categoriallamadas);

    void edit(Categoriallamadas categoriallamadas);

    void remove(Categoriallamadas categoriallamadas);

    Categoriallamadas find(Object id);

    List<Categoriallamadas> findAll();

    List<Categoriallamadas> findRange(int[] range);

    int count();
    
}
