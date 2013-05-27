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
@Table(name = "perfilgasto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Perfilgasto.findAll", query = "SELECT p FROM Perfilgasto p"),
    @NamedQuery(name = "Perfilgasto.findByIdPerfilGasto", query = "SELECT p FROM Perfilgasto p WHERE p.idPerfilGasto = :idPerfilGasto"),
    @NamedQuery(name = "Perfilgasto.findByTipoSaldo", query = "SELECT p FROM Perfilgasto p WHERE p.tipoSaldo = :tipoSaldo"),
    @NamedQuery(name = "Perfilgasto.findByBorrado", query = "SELECT p FROM Perfilgasto p WHERE p.borrado = :borrado")})
public class Perfilgasto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPerfilGasto")
    private Integer idPerfilGasto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "tipoSaldo")
    private String tipoSaldo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "borrado")
    private boolean borrado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perfilGastoidPerfilGasto")
    private Collection<Lineamovil> lineamovilCollection;

    public Perfilgasto() {
    }

    public Perfilgasto(Integer idPerfilGasto) {
        this.idPerfilGasto = idPerfilGasto;
    }

    public Perfilgasto(Integer idPerfilGasto, String tipoSaldo, boolean borrado) {
        this.idPerfilGasto = idPerfilGasto;
        this.tipoSaldo = tipoSaldo;
        this.borrado = borrado;
    }

    public Integer getIdPerfilGasto() {
        return idPerfilGasto;
    }

    public void setIdPerfilGasto(Integer idPerfilGasto) {
        this.idPerfilGasto = idPerfilGasto;
    }

    public String getTipoSaldo() {
        return tipoSaldo;
    }

    public void setTipoSaldo(String tipoSaldo) {
        this.tipoSaldo = tipoSaldo;
    }

    public boolean getBorrado() {
        return borrado;
    }

    public void setBorrado(boolean borrado) {
        this.borrado = borrado;
    }

    @XmlTransient
    public Collection<Lineamovil> getLineamovilCollection() {
        return lineamovilCollection;
    }

    public void setLineamovilCollection(Collection<Lineamovil> lineamovilCollection) {
        this.lineamovilCollection = lineamovilCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerfilGasto != null ? idPerfilGasto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perfilgasto)) {
            return false;
        }
        Perfilgasto other = (Perfilgasto) object;
        if ((this.idPerfilGasto == null && other.idPerfilGasto != null) || (this.idPerfilGasto != null && !this.idPerfilGasto.equals(other.idPerfilGasto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Perfilgasto[ idPerfilGasto=" + idPerfilGasto + " ]";
    }
    
}
