/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Facturaoperador;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Naoual Amasri
 */
@Local
public interface FacturaoperadorFacadeLocal {

    void create(Facturaoperador facturaoperador);

    void edit(Facturaoperador facturaoperador);

    void remove(Facturaoperador facturaoperador);

    Facturaoperador find(Object id);

    List<Facturaoperador> findAll();

    List<Facturaoperador> findRange(int[] range);

    int count();
    
}
