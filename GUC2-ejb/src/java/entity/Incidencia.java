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
@Table(name = "incidencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Incidencia.findAll", query = "SELECT i FROM Incidencia i"),
    @NamedQuery(name = "Incidencia.findByIdIncidencia", query = "SELECT i FROM Incidencia i WHERE i.idIncidencia = :idIncidencia"),
    @NamedQuery(name = "Incidencia.findByFechaHoraNotificacion", query = "SELECT i FROM Incidencia i WHERE i.fechaHoraNotificacion = :fechaHoraNotificacion"),
    @NamedQuery(name = "Incidencia.findByDescripcion", query = "SELECT i FROM Incidencia i WHERE i.descripcion = :descripcion"),
    @NamedQuery(name = "Incidencia.findByEstadoActual", query = "SELECT i FROM Incidencia i WHERE i.estadoActual = :estadoActual"),
    @NamedQuery(name = "Incidencia.findByFechaHoraResolucion", query = "SELECT i FROM Incidencia i WHERE i.fechaHoraResolucion = :fechaHoraResolucion"),
    @NamedQuery(name = "Incidencia.findBySolucion", query = "SELECT i FROM Incidencia i WHERE i.solucion = :solucion"),
    @NamedQuery(name = "Incidencia.findByLeida", query = "SELECT i FROM Incidencia i WHERE i.leida = :leida"),
    @NamedQuery(name = "Incidencia.findByBorrado", query = "SELECT i FROM Incidencia i WHERE i.borrado = :borrado")})
public class Incidencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idIncidencia")
    private Integer idIncidencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaHoraNotificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraNotificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "estadoActual")
    private String estadoActual;
    @Column(name = "fechaHoraResolucion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraResolucion;
    @Size(max = 200)
    @Column(name = "solucion")
    private String solucion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "leida")
    private boolean leida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "borrado")
    private boolean borrado;
    @JoinColumn(name = "Terminal_idTerminal", referencedColumnName = "idTerminal")
    @ManyToOne(optional = false)
    private Terminal terminalidTerminal;

    public Incidencia() {
    }

    public Incidencia(Integer idIncidencia) {
        this.idIncidencia = idIncidencia;
    }

    public Incidencia(Integer idIncidencia, Date fechaHoraNotificacion, String descripcion, String estadoActual, boolean leida, boolean borrado) {
        this.idIncidencia = idIncidencia;
        this.fechaHoraNotificacion = fechaHoraNotificacion;
        this.descripcion = descripcion;
        this.estadoActual = estadoActual;
        this.leida = leida;
        this.borrado = borrado;
    }

    public Integer getIdIncidencia() {
        return idIncidencia;
    }

    public void setIdIncidencia(Integer idIncidencia) {
        this.idIncidencia = idIncidencia;
    }

    public Date getFechaHoraNotificacion() {
        return fechaHoraNotificacion;
    }

    public void setFechaHoraNotificacion(Date fechaHoraNotificacion) {
        this.fechaHoraNotificacion = fechaHoraNotificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(String estadoActual) {
        this.estadoActual = estadoActual;
    }

    public Date getFechaHoraResolucion() {
        return fechaHoraResolucion;
    }

    public void setFechaHoraResolucion(Date fechaHoraResolucion) {
        this.fechaHoraResolucion = fechaHoraResolucion;
    }

    public String getSolucion() {
        return solucion;
    }

    public void setSolucion(String solucion) {
        this.solucion = solucion;
    }

    public boolean getLeida() {
        return leida;
    }

    public void setLeida(boolean leida) {
        this.leida = leida;
    }

    public boolean getBorrado() {
        return borrado;
    }

    public void setBorrado(boolean borrado) {
        this.borrado = borrado;
    }

    public Terminal getTerminalidTerminal() {
        return terminalidTerminal;
    }

    public void setTerminalidTerminal(Terminal terminalidTerminal) {
        this.terminalidTerminal = terminalidTerminal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIncidencia != null ? idIncidencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Incidencia)) {
            return false;
        }
        Incidencia other = (Incidencia) object;
        if ((this.idIncidencia == null && other.idIncidencia != null) || (this.idIncidencia != null && !this.idIncidencia.equals(other.idIncidencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Incidencia[ idIncidencia=" + idIncidencia + " ]";
    }
    
}
