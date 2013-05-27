/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Naoual Amasri
 */
@Entity
@Table(name = "lineapedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lineapedido.findAll", query = "SELECT l FROM Lineapedido l"),
    @NamedQuery(name = "Lineapedido.findByIdLineaPedido", query = "SELECT l FROM Lineapedido l WHERE l.idLineaPedido = :idLineaPedido"),
    @NamedQuery(name = "Lineapedido.findByCantidad", query = "SELECT l FROM Lineapedido l WHERE l.cantidad = :cantidad")})
public class Lineapedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idLineaPedido")
    private Integer idLineaPedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @JoinColumn(name = "ServicioConcertacion_idServicioConcertacion", referencedColumnName = "idServicioConcertacion")
    @ManyToOne(optional = false)
    private Servicioconcertacion servicioConcertacionidServicioConcertacion;
    @JoinColumn(name = "Concierto_idConcierto", referencedColumnName = "idConcierto")
    @ManyToOne(optional = false)
    private Concierto conciertoidConcierto;

    public Lineapedido() {
    }

    public Lineapedido(Integer idLineaPedido) {
        this.idLineaPedido = idLineaPedido;
    }

    public Lineapedido(Integer idLineaPedido, int cantidad) {
        this.idLineaPedido = idLineaPedido;
        this.cantidad = cantidad;
    }

    public Integer getIdLineaPedido() {
        return idLineaPedido;
    }

    public void setIdLineaPedido(Integer idLineaPedido) {
        this.idLineaPedido = idLineaPedido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Servicioconcertacion getServicioConcertacionidServicioConcertacion() {
        return servicioConcertacionidServicioConcertacion;
    }

    public void setServicioConcertacionidServicioConcertacion(Servicioconcertacion servicioConcertacionidServicioConcertacion) {
        this.servicioConcertacionidServicioConcertacion = servicioConcertacionidServicioConcertacion;
    }

    public Concierto getConciertoidConcierto() {
        return conciertoidConcierto;
    }

    public void setConciertoidConcierto(Concierto conciertoidConcierto) {
        this.conciertoidConcierto = conciertoidConcierto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLineaPedido != null ? idLineaPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lineapedido)) {
            return false;
        }
        Lineapedido other = (Lineapedido) object;
        if ((this.idLineaPedido == null && other.idLineaPedido != null) || (this.idLineaPedido != null && !this.idLineaPedido.equals(other.idLineaPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Lineapedido[ idLineaPedido=" + idLineaPedido + " ]";
    }
    
}
