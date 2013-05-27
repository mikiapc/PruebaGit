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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "ayuntamiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ayuntamiento.findAll", query = "SELECT a FROM Ayuntamiento a"),
    @NamedQuery(name = "Ayuntamiento.findByLocalidad", query = "SELECT a FROM Ayuntamiento a WHERE a.ayuntamientoPK.localidad = :localidad"),
    @NamedQuery(name = "Ayuntamiento.findByDireccion", query = "SELECT a FROM Ayuntamiento a WHERE a.ayuntamientoPK.direccion = :direccion"),
    @NamedQuery(name = "Ayuntamiento.findByTelefono", query = "SELECT a FROM Ayuntamiento a WHERE a.telefono = :telefono"),
    @NamedQuery(name = "Ayuntamiento.findByBorrado", query = "SELECT a FROM Ayuntamiento a WHERE a.borrado = :borrado")})
public class Ayuntamiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AyuntamientoPK ayuntamientoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Column(name = "borrado")
    private boolean borrado;
    @OneToMany(mappedBy = "ayuntamiento")
    private Collection<Usuario> usuarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ayuntamiento")
    private Collection<Concierto> conciertoCollection;

    public Ayuntamiento() {
    }

    public Ayuntamiento(AyuntamientoPK ayuntamientoPK) {
        this.ayuntamientoPK = ayuntamientoPK;
    }

    public Ayuntamiento(AyuntamientoPK ayuntamientoPK, String telefono, boolean borrado) {
        this.ayuntamientoPK = ayuntamientoPK;
        this.telefono = telefono;
        this.borrado = borrado;
    }

    public Ayuntamiento(String localidad, String direccion) {
        this.ayuntamientoPK = new AyuntamientoPK(localidad, direccion);
    }

    public AyuntamientoPK getAyuntamientoPK() {
        return ayuntamientoPK;
    }

    public void setAyuntamientoPK(AyuntamientoPK ayuntamientoPK) {
        this.ayuntamientoPK = ayuntamientoPK;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean getBorrado() {
        return borrado;
    }

    public void setBorrado(boolean borrado) {
        this.borrado = borrado;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @XmlTransient
    public Collection<Concierto> getConciertoCollection() {
        return conciertoCollection;
    }

    public void setConciertoCollection(Collection<Concierto> conciertoCollection) {
        this.conciertoCollection = conciertoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ayuntamientoPK != null ? ayuntamientoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ayuntamiento)) {
            return false;
        }
        Ayuntamiento other = (Ayuntamiento) object;
        if ((this.ayuntamientoPK == null && other.ayuntamientoPK != null) || (this.ayuntamientoPK != null && !this.ayuntamientoPK.equals(other.ayuntamientoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Ayuntamiento[ ayuntamientoPK=" + ayuntamientoPK + " ]";
    }
    
}
