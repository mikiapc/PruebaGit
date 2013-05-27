/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Perfilgasto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Naoual Amasri
 */
@Local
public interface PerfilgastoFacadeLocal {

    void create(Perfilgasto perfilgasto);

    void edit(Perfilgasto perfilgasto);

    void remove(Perfilgasto perfilgasto);

    Perfilgasto find(Object id);

    List<Perfilgasto> findAll();

    List<Perfilgasto> findRange(int[] range);

    int count();
    
}
