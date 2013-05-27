/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Gruporescate;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Naoual Amasri
 */
@Local
public interface GruporescateFacadeLocal {

    void create(Gruporescate gruporescate);

    void edit(Gruporescate gruporescate);

    void remove(Gruporescate gruporescate);

    Gruporescate find(Object id);

    List<Gruporescate> findAll();

    List<Gruporescate> findRange(int[] range);

    int count();
    
}
