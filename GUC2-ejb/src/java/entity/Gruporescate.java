/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "gruporescate")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gruporescate.findAll", query = "SELECT g FROM Gruporescate g"),
    @NamedQuery(name = "Gruporescate.findByIdGrupoRescate", query = "SELECT g FROM Gruporescate g WHERE g.idGrupoRescate = :idGrupoRescate"),
    @NamedQuery(name = "Gruporescate.findByArea", query = "SELECT g FROM Gruporescate g WHERE g.area = :area"),
    @NamedQuery(name = "Gruporescate.findBySubarea", query = "SELECT g FROM Gruporescate g WHERE g.subarea = :subarea"),
    @NamedQuery(name = "Gruporescate.findByBorrado", query = "SELECT g FROM Gruporescate g WHERE g.borrado = :borrado")})
public class Gruporescate implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idGrupoRescate")
    private Integer idGrupoRescate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "area")
    private String area;
    @Size(max = 45)
    @Column(name = "subarea")
    private String subarea;
    @Basic(optional = false)
    @NotNull
    @Column(name = "borrado")
    private boolean borrado;
    @OneToMany(mappedBy = "grupoRescateidGrupoRescate")
    private Collection<Linea> lineaCollection;

    public Gruporescate() {
    }

    public Gruporescate(Integer idGrupoRescate) {
        this.idGrupoRescate = idGrupoRescate;
    }

    public Gruporescate(Integer idGrupoRescate, String area, boolean borrado) {
        this.idGrupoRescate = idGrupoRescate;
        this.area = area;
        this.borrado = borrado;
    }

    public Integer getIdGrupoRescate() {
        return idGrupoRescate;
    }

    public void setIdGrupoRescate(Integer idGrupoRescate) {
        this.idGrupoRescate = idGrupoRescate;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSubarea() {
        return subarea;
    }

    public void setSubarea(String subarea) {
        this.subarea = subarea;
    }

    public boolean getBorrado() {
        return borrado;
    }

    public void setBorrado(boolean borrado) {
        this.borrado = borrado;
    }

    @XmlTransient
    public Collection<Linea> getLineaCollection() {
        return lineaCollection;
    }

    public void setLineaCollection(Collection<Linea> lineaCollection) {
        this.lineaCollection = lineaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGrupoRescate != null ? idGrupoRescate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gruporescate)) {
            return false;
        }
        Gruporescate other = (Gruporescate) object;
        if ((this.idGrupoRescate == null && other.idGrupoRescate != null) || (this.idGrupoRescate != null && !this.idGrupoRescate.equals(other.idGrupoRescate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Gruporescate[ idGrupoRescate=" + idGrupoRescate + " ]";
    }
    
}
