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
@Table(name = "terminal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Terminal.findAll", query = "SELECT t FROM Terminal t"),
    @NamedQuery(name = "Terminal.findByIdTerminal", query = "SELECT t FROM Terminal t WHERE t.idTerminal = :idTerminal"),
    @NamedQuery(name = "Terminal.findByMarca", query = "SELECT t FROM Terminal t WHERE t.marca = :marca"),
    @NamedQuery(name = "Terminal.findByModelo", query = "SELECT t FROM Terminal t WHERE t.modelo = :modelo"),
    @NamedQuery(name = "Terminal.findByTipo", query = "SELECT t FROM Terminal t WHERE t.tipo = :tipo"),
    @NamedQuery(name = "Terminal.findByUbicacion", query = "SELECT t FROM Terminal t WHERE t.ubicacion = :ubicacion"),
    @NamedQuery(name = "Terminal.findByAsignado", query = "SELECT t FROM Terminal t WHERE t.asignado = :asignado"),
    @NamedQuery(name = "Terminal.findByBorrado", query = "SELECT t FROM Terminal t WHERE t.borrado = :borrado")})
public class Terminal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "idTerminal")
    private String idTerminal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "marca")
    private String marca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "modelo")
    private String modelo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo")
    private char tipo;
    @Size(max = 100)
    @Column(name = "ubicacion")
    private String ubicacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "asignado")
    private boolean asignado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "borrado")
    private boolean borrado;
    @JoinColumn(name = "Linea_idLinea", referencedColumnName = "idLinea")
    @ManyToOne
    private Linea lineaidLinea;
    @JoinColumn(name = "Usuario_nif", referencedColumnName = "nif")
    @ManyToOne
    private Usuario usuarionif;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "terminalidTerminal")
    private Collection<Incidencia> incidenciaCollection;

    public Terminal() {
    }

    public Terminal(String idTerminal) {
        this.idTerminal = idTerminal;
    }

    public Terminal(String idTerminal, String marca, String modelo, char tipo, boolean asignado, boolean borrado) {
        this.idTerminal = idTerminal;
        this.marca = marca;
        this.modelo = modelo;
        this.tipo = tipo;
        this.asignado = asignado;
        this.borrado = borrado;
    }

    public String getIdTerminal() {
        return idTerminal;
    }

    public void setIdTerminal(String idTerminal) {
        this.idTerminal = idTerminal;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public boolean getAsignado() {
        return asignado;
    }

    public void setAsignado(boolean asignado) {
        this.asignado = asignado;
    }

    public boolean getBorrado() {
        return borrado;
    }

    public void setBorrado(boolean borrado) {
        this.borrado = borrado;
    }

    public Linea getLineaidLinea() {
        return lineaidLinea;
    }

    public void setLineaidLinea(Linea lineaidLinea) {
        this.lineaidLinea = lineaidLinea;
    }

    public Usuario getUsuarionif() {
        return usuarionif;
    }

    public void setUsuarionif(Usuario usuarionif) {
        this.usuarionif = usuarionif;
    }

    @XmlTransient
    public Collection<Incidencia> getIncidenciaCollection() {
        return incidenciaCollection;
    }

    public void setIncidenciaCollection(Collection<Incidencia> incidenciaCollection) {
        this.incidenciaCollection = incidenciaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTerminal != null ? idTerminal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Terminal)) {
            return false;
        }
        Terminal other = (Terminal) object;
        if ((this.idTerminal == null && other.idTerminal != null) || (this.idTerminal != null && !this.idTerminal.equals(other.idTerminal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Terminal[ idTerminal=" + idTerminal + " ]";
    }
    
}
