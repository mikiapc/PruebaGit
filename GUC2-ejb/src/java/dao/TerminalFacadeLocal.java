/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Terminal;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Naoual Amasri
 */
@Local
public interface TerminalFacadeLocal {

    void create(Terminal terminal);

    void edit(Terminal terminal);

    void remove(Terminal terminal);

    Terminal find(Object id);
    
    Terminal findById(String id);

    List<Terminal> findAll();
    
    List<Terminal> findNoBorrados();

    List<Terminal> findRange(int[] range);
    
    

    int count();
    
}
