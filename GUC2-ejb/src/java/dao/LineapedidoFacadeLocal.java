/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Lineapedido;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Naoual Amasri
 */
@Local
public interface LineapedidoFacadeLocal {

    void create(Lineapedido lineapedido);

    void edit(Lineapedido lineapedido);

    void remove(Lineapedido lineapedido);

    Lineapedido find(Object id);

    List<Lineapedido> findAll();

    List<Lineapedido> findRange(int[] range);

    int count();
    
}
