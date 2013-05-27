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
@Table(name = "mensaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mensaje.findAll", query = "SELECT m FROM Mensaje m"),
    @NamedQuery(name = "Mensaje.findByIdMensaje", query = "SELECT m FROM Mensaje m WHERE m.idMensaje = :idMensaje"),
    @NamedQuery(name = "Mensaje.findByFechaHoraEnvio", query = "SELECT m FROM Mensaje m WHERE m.fechaHoraEnvio = :fechaHoraEnvio"),
    @NamedQuery(name = "Mensaje.findByNumeroDestino", query = "SELECT m FROM Mensaje m WHERE m.numeroDestino = :numeroDestino")})
public class Mensaje implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMensaje")
    private Integer idMensaje;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaHoraEnvio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraEnvio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "numeroDestino")
    private String numeroDestino;
    @JoinColumn(name = "LineaMovil_Linea_idLinea", referencedColumnName = "Linea_idLinea")
    @ManyToOne(optional = false)
    private Lineamovil lineaMovilLineaidLinea;
    @JoinColumn(name = "Factura_idFactura", referencedColumnName = "idFactura")
    @ManyToOne(optional = false)
    private Facturaoperador facturaidFactura;
    @JoinColumn(name = "PrecioMensaje_idPrecioMensaje", referencedColumnName = "idPrecioMensaje")
    @ManyToOne(optional = false)
    private Preciomensaje precioMensajeidPrecioMensaje;

    public Mensaje() {
    }

    public Mensaje(Integer idMensaje) {
        this.idMensaje = idMensaje;
    }

    public Mensaje(Integer idMensaje, Date fechaHoraEnvio, String numeroDestino) {
        this.idMensaje = idMensaje;
        this.fechaHoraEnvio = fechaHoraEnvio;
        this.numeroDestino = numeroDestino;
    }

    public Integer getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(Integer idMensaje) {
        this.idMensaje = idMensaje;
    }

    public Date getFechaHoraEnvio() {
        return fechaHoraEnvio;
    }

    public void setFechaHoraEnvio(Date fechaHoraEnvio) {
        this.fechaHoraEnvio = fechaHoraEnvio;
    }

    public String getNumeroDestino() {
        return numeroDestino;
    }

    public void setNumeroDestino(String numeroDestino) {
        this.numeroDestino = numeroDestino;
    }

    public Lineamovil getLineaMovilLineaidLinea() {
        return lineaMovilLineaidLinea;
    }

    public void setLineaMovilLineaidLinea(Lineamovil lineaMovilLineaidLinea) {
        this.lineaMovilLineaidLinea = lineaMovilLineaidLinea;
    }

    public Facturaoperador getFacturaidFactura() {
        return facturaidFactura;
    }

    public void setFacturaidFactura(Facturaoperador facturaidFactura) {
        this.facturaidFactura = facturaidFactura;
    }

    public Preciomensaje getPrecioMensajeidPrecioMensaje() {
        return precioMensajeidPrecioMensaje;
    }

    public void setPrecioMensajeidPrecioMensaje(Preciomensaje precioMensajeidPrecioMensaje) {
        this.precioMensajeidPrecioMensaje = precioMensajeidPrecioMensaje;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMensaje != null ? idMensaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mensaje)) {
            return false;
        }
        Mensaje other = (Mensaje) object;
        if ((this.idMensaje == null && other.idMensaje != null) || (this.idMensaje != null && !this.idMensaje.equals(other.idMensaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Mensaje[ idMensaje=" + idMensaje + " ]";
    }
    
}
