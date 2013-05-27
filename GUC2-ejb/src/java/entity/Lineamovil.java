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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "lineamovil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lineamovil.findAll", query = "SELECT l FROM Lineamovil l"),
    @NamedQuery(name = "Lineamovil.findByMovil", query = "SELECT l FROM Lineamovil l WHERE l.movil = :movil"),
    @NamedQuery(name = "Lineamovil.findByLineaidLinea", query = "SELECT l FROM Lineamovil l WHERE l.lineaidLinea = :lineaidLinea")})
public class Lineamovil implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "movil")
    private boolean movil;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Linea_idLinea")
    private String lineaidLinea;
    @JoinColumn(name = "Linea_idLinea", referencedColumnName = "idLinea", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Linea linea;
    @JoinColumn(name = "PerfilGasto_idPerfilGasto", referencedColumnName = "idPerfilGasto")
    @ManyToOne(optional = false)
    private Perfilgasto perfilGastoidPerfilGasto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lineaMovilLineaidLinea")
    private Collection<Mensaje> mensajeCollection;

    public Lineamovil() {
    }

    public Lineamovil(String lineaidLinea) {
        this.lineaidLinea = lineaidLinea;
    }

    public Lineamovil(String lineaidLinea, boolean movil) {
        this.lineaidLinea = lineaidLinea;
        this.movil = movil;
    }

    public boolean getMovil() {
        return movil;
    }

    public void setMovil(boolean movil) {
        this.movil = movil;
    }

    public String getLineaidLinea() {
        return lineaidLinea;
    }

    public void setLineaidLinea(String lineaidLinea) {
        this.lineaidLinea = lineaidLinea;
    }

    public Linea getLinea() {
        return linea;
    }

    public void setLinea(Linea linea) {
        this.linea = linea;
    }

    public Perfilgasto getPerfilGastoidPerfilGasto() {
        return perfilGastoidPerfilGasto;
    }

    public void setPerfilGastoidPerfilGasto(Perfilgasto perfilGastoidPerfilGasto) {
        this.perfilGastoidPerfilGasto = perfilGastoidPerfilGasto;
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
        hash += (lineaidLinea != null ? lineaidLinea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lineamovil)) {
            return false;
        }
        Lineamovil other = (Lineamovil) object;
        if ((this.lineaidLinea == null && other.lineaidLinea != null) || (this.lineaidLinea != null && !this.lineaidLinea.equals(other.lineaidLinea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Lineamovil[ lineaidLinea=" + lineaidLinea + " ]";
    }
    
}
