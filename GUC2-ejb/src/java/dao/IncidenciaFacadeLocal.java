/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Incidencia;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Naoual Amasri
 */
@Local
public interface IncidenciaFacadeLocal {

    void create(Incidencia incidencia);

    void edit(Incidencia incidencia);

    void remove(Incidencia incidencia);

    Incidencia find(Object id);

    List<Incidencia> findAll();

    List<Incidencia> findRange(int[] range);

    int count();
    
}
