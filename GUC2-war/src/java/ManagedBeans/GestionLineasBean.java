/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import dao.LineaFacadeLocal;
import entity.Linea;
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
public class GestionLineasBean {

    @EJB
    private LineaFacadeLocal lineaFacade;
    private String idModificar;

    public String getIdModificar() {
        return idModificar;
    }

    public void setIdModificar(String idModificar) {
        this.idModificar = idModificar;
    }

    public LineaFacadeLocal getLineaFacade() {
        return lineaFacade;
    }

    public void setLineaFacade(LineaFacadeLocal lineaFacade) {
        this.lineaFacade = lineaFacade;
    }
    private List<Linea> lineas;

    public List<Linea> getLineas() {
        return lineas;
    }

    public void setLineas(List<Linea> lineas) {
        this.lineas = lineas;
    }
    
    public String eliminarLinea(){
        
        Linea linea = lineaFacade.findById(idModificar);
        linea.setBorrada(true);
        lineaFacade.edit(linea);
        
        return null;
        
    }
    
    @PostConstruct
    public void cargarLineas(){
        lineas = lineaFacade.findNoBorradas();
    }
    
    public GestionLineasBean() {
    }
}
