/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Naoual Amasri
 */
@Entity
@Table(name = "llamada")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Llamada.findAll", query = "SELECT l FROM Llamada l"),
    @NamedQuery(name = "Llamada.findByIdLlamada", query = "SELECT l FROM Llamada l WHERE l.idLlamada = :idLlamada"),
    @NamedQuery(name = "Llamada.findByFechaHora", query = "SELECT l FROM Llamada l WHERE l.fechaHora = :fechaHora"),
    @NamedQuery(name = "Llamada.findByDuracion", query = "SELECT l FROM Llamada l WHERE l.duracion = :duracion"),
    @NamedQuery(name = "Llamada.findByImporte", query = "SELECT l FROM Llamada l WHERE l.importe = :importe"),
    @NamedQuery(name = "Llamada.findByCentralita", query = "SELECT l FROM Llamada l WHERE l.centralita = :centralita"),
    @NamedQuery(name = "Llamada.findByNumeroDestino", query = "SELECT l FROM Llamada l WHERE l.numeroDestino = :numeroDestino")})
public class Llamada implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idLlamada")
    private Integer idLlamada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaHora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "duracion")
    private double duracion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "importe")
    private double importe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "centralita")
    private boolean centralita;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "numeroDestino")
    private String numeroDestino;
    @JoinColumn(name = "CategoriaLlamadas_idCategoriaLlamadas", referencedColumnName = "idCategoriaLlamadas")
    @ManyToOne(optional = false)
    private Categoriallamadas categoriaLlamadasidCategoriaLlamadas;
    @JoinColumn(name = "Factura_idFactura", referencedColumnName = "idFactura")
    @ManyToOne(optional = false)
    private Facturaoperador facturaidFactura;
    @JoinColumn(name = "Linea_idLinea", referencedColumnName = "idLinea")
    @ManyToOne(optional = false)
    private Linea lineaidLinea;

    public Llamada() {
    }

    public Llamada(Integer idLlamada) {
        this.idLlamada = idLlamada;
    }

    public Llamada(Integer idLlamada, Date fechaHora, double duracion, double importe, boolean centralita, String numeroDestino) {
        this.idLlamada = idLlamada;
        this.fechaHora = fechaHora;
        this.duracion = duracion;
        this.importe = importe;
        this.centralita = centralita;
        this.numeroDestino = numeroDestino;
    }

    public Integer getIdLlamada() {
        return idLlamada;
    }

    public void setIdLlamada(Integer idLlamada) {
        this.idLlamada = idLlamada;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public boolean getCentralita() {
        return centralita;
    }

    public void setCentralita(boolean centralita) {
        this.centralita = centralita;
    }

    public String getNumeroDestino() {
        return numeroDestino;
    }

    public void setNumeroDestino(String numeroDestino) {
        this.numeroDestino = numeroDestino;
    }

    public Categoriallamadas getCategoriaLlamadasidCategoriaLlamadas() {
        return categoriaLlamadasidCategoriaLlamadas;
    }

    public void setCategoriaLlamadasidCategoriaLlamadas(Categoriallamadas categoriaLlamadasidCategoriaLlamadas) {
        this.categoriaLlamadasidCategoriaLlamadas = categoriaLlamadasidCategoriaLlamadas;
    }

    public Facturaoperador getFacturaidFactura() {
        return facturaidFactura;
    }

    public void setFacturaidFactura(Facturaoperador facturaidFactura) {
        this.facturaidFactura = facturaidFactura;
    }

    public Linea getLineaidLinea() {
        return lineaidLinea;
    }

    public void setLineaidLinea(Linea lineaidLinea) {
        this.lineaidLinea = lineaidLinea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLlamada != null ? idLlamada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Llamada)) {
            return false;
        }
        Llamada other = (Llamada) object;
        if ((this.idLlamada == null && other.idLlamada != null) || (this.idLlamada != null && !this.idLlamada.equals(other.idLlamada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Llamada[ idLlamada=" + idLlamada + " ]";
    }
    
}
