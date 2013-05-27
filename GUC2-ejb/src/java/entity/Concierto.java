/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Naoual Amasri
 */
@Entity
@Table(name = "concierto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Concierto.findAll", query = "SELECT c FROM Concierto c"),
    @NamedQuery(name = "Concierto.findByIdConcierto", query = "SELECT c FROM Concierto c WHERE c.idConcierto = :idConcierto"),
    @NamedQuery(name = "Concierto.findByAnnoPlan", query = "SELECT c FROM Concierto c WHERE c.annoPlan = :annoPlan"),
    @NamedQuery(name = "Concierto.findByFechaHoraFirma", query = "SELECT c FROM Concierto c WHERE c.fechaHoraFirma = :fechaHoraFirma")})
public class Concierto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idConcierto")
    private Integer idConcierto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "annoPlan")
    private int annoPlan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaHoraFirma")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraFirma;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "conciertoidConcierto")
    private Collection<Lineapedido> lineapedidoCollection;
    @JoinColumns({
        @JoinColumn(name = "Ayuntamiento_localidad", referencedColumnName = "localidad"),
        @JoinColumn(name = "Ayuntamiento_direccion", referencedColumnName = "direccion")})
    @ManyToOne(optional = false)
    private Ayuntamiento ayuntamiento;

    public Concierto() {
    }

    public Concierto(Integer idConcierto) {
        this.idConcierto = idConcierto;
    }

    public Concierto(Integer idConcierto, int annoPlan, Date fechaHoraFirma) {
        this.idConcierto = idConcierto;
        this.annoPlan = annoPlan;
        this.fechaHoraFirma = fechaHoraFirma;
    }

    public Integer getIdConcierto() {
        return idConcierto;
    }

    public void setIdConcierto(Integer idConcierto) {
        this.idConcierto = idConcierto;
    }

    public int getAnnoPlan() {
        return annoPlan;
    }

    public void setAnnoPlan(int annoPlan) {
        this.annoPlan = annoPlan;
    }

    public Date getFechaHoraFirma() {
        return fechaHoraFirma;
    }

    public void setFechaHoraFirma(Date fechaHoraFirma) {
        this.fechaHoraFirma = fechaHoraFirma;
    }

    @XmlTransient
    public Collection<Lineapedido> getLineapedidoCollection() {
        return lineapedidoCollection;
    }

    public void setLineapedidoCollection(Collection<Lineapedido> lineapedidoCollection) {
        this.lineapedidoCollection = lineapedidoCollection;
    }

    public Ayuntamiento getAyuntamiento() {
        return ayuntamiento;
    }

    public void setAyuntamiento(Ayuntamiento ayuntamiento) {
        this.ayuntamiento = ayuntamiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConcierto != null ? idConcierto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Concierto)) {
            return false;
        }
        Concierto other = (Concierto) object;
        if ((this.idConcierto == null && other.idConcierto != null) || (this.idConcierto != null && !this.idConcierto.equals(other.idConcierto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Concierto[ idConcierto=" + idConcierto + " ]";
    }
    
}
