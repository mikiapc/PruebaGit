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
@Table(name = "facturaoperador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Facturaoperador.findAll", query = "SELECT f FROM Facturaoperador f"),
    @NamedQuery(name = "Facturaoperador.findByIdFactura", query = "SELECT f FROM Facturaoperador f WHERE f.idFactura = :idFactura"),
    @NamedQuery(name = "Facturaoperador.findByFechaEmision", query = "SELECT f FROM Facturaoperador f WHERE f.fechaEmision = :fechaEmision"),
    @NamedQuery(name = "Facturaoperador.findByFechaHoraInicio", query = "SELECT f FROM Facturaoperador f WHERE f.fechaHoraInicio = :fechaHoraInicio"),
    @NamedQuery(name = "Facturaoperador.findByFechaHoraFin", query = "SELECT f FROM Facturaoperador f WHERE f.fechaHoraFin = :fechaHoraFin"),
    @NamedQuery(name = "Facturaoperador.findByImporteTotal", query = "SELECT f FROM Facturaoperador f WHERE f.importeTotal = :importeTotal"),
    @NamedQuery(name = "Facturaoperador.findByMinutosTotales", query = "SELECT f FROM Facturaoperador f WHERE f.minutosTotales = :minutosTotales")})
public class Facturaoperador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFactura")
    private Integer idFactura;
    @Column(name = "fechaEmision")
    @Temporal(TemporalType.DATE)
    private Date fechaEmision;
    @Column(name = "fechaHoraInicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraInicio;
    @Column(name = "fechaHoraFin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraFin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "importeTotal")
    private double importeTotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "minutosTotales")
    private double minutosTotales;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facturaidFactura")
    private Collection<Mensaje> mensajeCollection;
    @JoinColumn(name = "Usuario_nif", referencedColumnName = "nif")
    @ManyToOne(optional = false)
    private Usuario usuarionif;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facturaidFactura")
    private Collection<Llamada> llamadaCollection;

    public Facturaoperador() {
    }

    public Facturaoperador(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public Facturaoperador(Integer idFactura, double importeTotal, double minutosTotales) {
        this.idFactura = idFactura;
        this.importeTotal = importeTotal;
        this.minutosTotales = minutosTotales;
    }

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(Date fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public Date getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(Date fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }

    public double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }

    public double getMinutosTotales() {
        return minutosTotales;
    }

    public void setMinutosTotales(double minutosTotales) {
        this.minutosTotales = minutosTotales;
    }

    @XmlTransient
    public Collection<Mensaje> getMensajeCollection() {
        return mensajeCollection;
    }

    public void setMensajeCollection(Collection<Mensaje> mensajeCollection) {
        this.mensajeCollection = mensajeCollection;
    }

    public Usuario getUsuarionif() {
        return usuarionif;
    }

    public void setUsuarionif(Usuario usuarionif) {
        this.usuarionif = usuarionif;
    }

    @XmlTransient
    public Collection<Llamada> getLlamadaCollection() {
        return llamadaCollection;
    }

    public void setLlamadaCollection(Collection<Llamada> llamadaCollection) {
        this.llamadaCollection = llamadaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFactura != null ? idFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Facturaoperador)) {
            return false;
        }
        Facturaoperador other = (Facturaoperador) object;
        if ((this.idFactura == null && other.idFactura != null) || (this.idFactura != null && !this.idFactura.equals(other.idFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Facturaoperador[ idFactura=" + idFactura + " ]";
    }
    
}
