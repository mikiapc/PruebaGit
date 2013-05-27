/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Naoual Amasri
 */
@Entity
@Table(name = "servicioconcertacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servicioconcertacion.findAll", query = "SELECT s FROM Servicioconcertacion s"),
    @NamedQuery(name = "Servicioconcertacion.findByIdServicioConcertacion", query = "SELECT s FROM Servicioconcertacion s WHERE s.idServicioConcertacion = :idServicioConcertacion"),
    @NamedQuery(name = "Servicioconcertacion.findByDescripcion", query = "SELECT s FROM Servicioconcertacion s WHERE s.descripcion = :descripcion"),
    @NamedQuery(name = "Servicioconcertacion.findByCaracter\u00edsticas", query = "SELECT s FROM Servicioconcertacion s WHERE s.caracter\u00edsticas = :caracter\u00edsticas"),
    @NamedQuery(name = "Servicioconcertacion.findByBorrado", query = "SELECT s FROM Servicioconcertacion s WHERE s.borrado = :borrado")})
public class Servicioconcertacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idServicioConcertacion")
    private Integer idServicioConcertacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 200)
    @Column(name = "caracter\u00edsticas")
    private String características;
    @Basic(optional = false)
    @NotNull
    @Column(name = "borrado")
    private boolean borrado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicioConcertacionidServicioConcertacion")
    private Collection<Lineapedido> lineapedidoCollection;

    public Servicioconcertacion() {
    }

    public Servicioconcertacion(Integer idServicioConcertacion) {
        this.idServicioConcertacion = idServicioConcertacion;
    }

    public Servicioconcertacion(Integer idServicioConcertacion, String descripcion, boolean borrado) {
        this.idServicioConcertacion = idServicioConcertacion;
        this.descripcion = descripcion;
        this.borrado = borrado;
    }

    public Integer getIdServicioConcertacion() {
        return idServicioConcertacion;
    }

    public void setIdServicioConcertacion(Integer idServicioConcertacion) {
        this.idServicioConcertacion = idServicioConcertacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCaracterísticas() {
        return características;
    }

    public void setCaracterísticas(String características) {
        this.características = características;
    }

    public boolean getBorrado() {
        return borrado;
    }

    public void setBorrado(boolean borrado) {
        this.borrado = borrado;
    }

    @XmlTransient
    public Collection<Lineapedido> getLineapedidoCollection() {
        return lineapedidoCollection;
    }

    public void setLineapedidoCollection(Collection<Lineapedido> lineapedidoCollection) {
        this.lineapedidoCollection = lineapedidoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idServicioConcertacion != null ? idServicioConcertacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servicioconcertacion)) {
            return false;
        }
        Servicioconcertacion other = (Servicioconcertacion) object;
        if ((this.idServicioConcertacion == null && other.idServicioConcertacion != null) || (this.idServicioConcertacion != null && !this.idServicioConcertacion.equals(other.idServicioConcertacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Servicioconcertacion[ idServicioConcertacion=" + idServicioConcertacion + " ]";
    }
    
}
