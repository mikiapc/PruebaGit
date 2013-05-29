/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import dao.TerminalFacadeLocal;
import entity.Terminal;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Miki
 */
@ManagedBean
@RequestScoped
public class AltaTerminalBean {

    @EJB
    private TerminalFacadeLocal terminalFacade;
    private String marca, modelo, tipo, idTerminal;

    public String getIdTerminal() {
        return idTerminal;
    }

    public void setIdTerminal(String idTerminal) {
        this.idTerminal = idTerminal;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    /**
     * Creates a new instance of AltaTerminalBean
     */
    public String doNavigation() {
        
        Terminal terminal = new Terminal();
        terminal.setIdTerminal(idTerminal);
        terminal.setMarca(marca);
        terminal.setModelo(modelo);
        terminal.setTipo(tipo.charAt(0));
        terminal.setAsignado(false);
        terminal.setBorrado(false);
        terminalFacade.create(terminal);
        
        return "AltaTerminalJSF";
    }
}
