/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import dao.TerminalFacadeLocal;
import entity.Terminal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Miki
 */
@ManagedBean
@RequestScoped
public class GestionTerminalesBean implements Serializable {
    
    @EJB
    private TerminalFacadeLocal terminalFacade;
    private List<Terminal> terminales;
    
    private String idModificar;

    public String getIdModificar() {
        return idModificar;
    }

    public void setIdModificar(String idModificar) {
        this.idModificar = idModificar;
    }

   

    public List<Terminal> getTerminales() {
        return terminales;
    }

    public void setTerminales(List<Terminal> terminales) {
        this.terminales = terminales;
    }
    
    public String eliminarTerminal(){
        
        System.out.println("Entra en eliminarTErminal()");
        Terminal terminal = terminalFacade.findById(idModificar);
        terminal.setBorrado(true);
        terminalFacade.edit(terminal);
        
        
        
        
        return null;
    }
    
    public String modificarTerminal(){
        
        
        
        return null;
    }

    
    @PostConstruct
    public void cargarTerminales(){
        terminales = terminalFacade.findNoBorrados();
    }
    
    public GestionTerminalesBean(){
        
    }
}
