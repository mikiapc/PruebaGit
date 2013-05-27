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
@Table(name = "preciomensaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Preciomensaje.findAll", query = "SELECT p FROM Preciomensaje p"),
    @NamedQuery(name = "Preciomensaje.findByIdPrecioMensaje", query = "SELECT p FROM Preciomensaje p WHERE p.idPrecioMensaje = :idPrecioMensaje"),
    @NamedQuery(name = "Preciomensaje.findByTipoMensaje", query = "SELECT p FROM Preciomensaje p WHERE p.tipoMensaje = :tipoMensaje"),
    @NamedQuery(name = "Preciomensaje.findByCoste", query = "SELECT p FROM Preciomensaje p WHERE p.coste = :coste"),
    @NamedQuery(name = "Preciomensaje.findByBorrado", query = "SELECT p FROM Preciomensaje p WHERE p.borrado = :borrado")})
public class Preciomensaje implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPrecioMensaje")
    private Integer idPrecioMensaje;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipoMensaje")
    private String tipoMensaje;
    @Basic(optional = false)
    @NotNull
    @Column(name = "coste")
    private double coste;
    @Basic(optional = false)
    @NotNull
    @Column(name = "borrado")
    private boolean borrado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "precioMensajeidPrecioMensaje")
    private Collection<Mensaje> mensajeCollection;

    public Preciomensaje() {
    }

    public Preciomensaje(Integer idPrecioMensaje) {
        this.idPrecioMensaje = idPrecioMensaje;
    }

    public Preciomensaje(Integer idPrecioMensaje, String tipoMensaje, double coste, boolean borrado) {
        this.idPrecioMensaje = idPrecioMensaje;
        this.tipoMensaje = tipoMensaje;
        this.coste = coste;
        this.borrado = borrado;
    }

    public Integer getIdPrecioMensaje() {
        return idPrecioMensaje;
    }

    public void setIdPrecioMensaje(Integer idPrecioMensaje) {
        this.idPrecioMensaje = idPrecioMensaje;
    }

    public String getTipoMensaje() {
        return tipoMensaje;
    }

    public void setTipoMensaje(String tipoMensaje) {
        this.tipoMensaje = tipoMensaje;
    }

    public double getCoste() {
        return coste;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }

    public boolean getBorrado() {
        return borrado;
    }

    public void setBorrado(boolean borrado) {
        this.borrado = borrado;
    }

    @XmlTransient
    public Collection<Mensaje> getMensajeCollection() {
        return mensajeCollection;
    }

    public void setMensajeCollection(Collection<Mensaje> mensajeCollection) {
        this.mensajeCollection = mensajeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrecioMensaje != null ? idPrecioMensaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Preciomensaje)) {
            return false;
        }
        Preciomensaje other = (Preciomensaje) object;
        if ((this.idPrecioMensaje == null && other.idPrecioMensaje != null) || (this.idPrecioMensaje != null && !this.idPrecioMensaje.equals(other.idPrecioMensaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Preciomensaje[ idPrecioMensaje=" + idPrecioMensaje + " ]";
    }
    
}
