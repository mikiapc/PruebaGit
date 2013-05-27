/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Lineamovil;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Naoual Amasri
 */
@Local
public interface LineamovilFacadeLocal {

    void create(Lineamovil lineamovil);

    void edit(Lineamovil lineamovil);

    void remove(Lineamovil lineamovil);

    Lineamovil find(Object id);

    List<Lineamovil> findAll();

    List<Lineamovil> findRange(int[] range);

    int count();
    
}
