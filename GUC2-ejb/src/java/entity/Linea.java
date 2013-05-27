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
@Table(name = "linea")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Linea.findAll", query = "SELECT l FROM Linea l"),
    @NamedQuery(name = "Linea.findByIdLinea", query = "SELECT l FROM Linea l WHERE l.idLinea = :idLinea"),
    @NamedQuery(name = "Linea.findByOperadora", query = "SELECT l FROM Linea l WHERE l.operadora = :operadora"),
    @NamedQuery(name = "Linea.findByAnchoBanda", query = "SELECT l FROM Linea l WHERE l.anchoBanda = :anchoBanda"),
    @NamedQuery(name = "Linea.findByEtiquetada", query = "SELECT l FROM Linea l WHERE l.etiquetada = :etiquetada"),
    @NamedQuery(name = "Linea.findByAsignada", query = "SELECT l FROM Linea l WHERE l.asignada = :asignada"),
    @NamedQuery(name = "Linea.findByBorrada", query = "SELECT l FROM Linea l WHERE l.borrada = :borrada")})
public class Linea implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "idLinea")
    private String idLinea;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "operadora")
    private String operadora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ancho_banda")
    private int anchoBanda;
    @Basic(optional = false)
    @NotNull
    @Column(name = "etiquetada")
    private boolean etiquetada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "asignada")
    private boolean asignada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "borrada")
    private boolean borrada;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "linea")
    private Lineafija lineafija;
    @JoinColumn(name = "GrupoRescate_idGrupoRescate", referencedColumnName = "idGrupoRescate")
    @ManyToOne
    private Gruporescate grupoRescateidGrupoRescate;
    @JoinColumn(name = "Usuario_nif", referencedColumnName = "nif")
    @ManyToOne
    private Usuario usuarionif;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "linea")
    private Lineamovil lineamovil;
    @OneToMany(mappedBy = "lineaidLinea")
    private Collection<Terminal> terminalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lineaidLinea")
    private Collection<Llamada> llamadaCollection;

    public Linea() {
    }

    public Linea(String idLinea) {
        this.idLinea = idLinea;
    }

    public Linea(String idLinea, String operadora, int anchoBanda, boolean etiquetada, boolean asignada, boolean borrada) {
        this.idLinea = idLinea;
        this.operadora = operadora;
        this.anchoBanda = anchoBanda;
        this.etiquetada = etiquetada;
        this.asignada = asignada;
        this.borrada = borrada;
    }

    public String getIdLinea() {
        return idLinea;
    }

    public void setIdLinea(String idLinea) {
        this.idLinea = idLinea;
    }

    public String getOperadora() {
        return operadora;
    }

    public void setOperadora(String operadora) {
        this.operadora = operadora;
    }

    public int getAnchoBanda() {
        return anchoBanda;
    }

    public void setAnchoBanda(int anchoBanda) {
        this.anchoBanda = anchoBanda;
    }

    public boolean getEtiquetada() {
        return etiquetada;
    }

    public void setEtiquetada(boolean etiquetada) {
        this.etiquetada = etiquetada;
    }

    public boolean getAsignada() {
        return asignada;
    }

    public void setAsignada(boolean asignada) {
        this.asignada = asignada;
    }

    public boolean getBorrada() {
        return borrada;
    }

    public void setBorrada(boolean borrada) {
        this.borrada = borrada;
    }

    public Lineafija getLineafija() {
        return lineafija;
    }

    public void setLineafija(Lineafija lineafija) {
        this.lineafija = lineafija;
    }

    public Gruporescate getGrupoRescateidGrupoRescate() {
        return grupoRescateidGrupoRescate;
    }

    public void setGrupoRescateidGrupoRescate(Gruporescate grupoRescateidGrupoRescate) {
        this.grupoRescateidGrupoRescate = grupoRescateidGrupoRescate;
    }

    public Usuario getUsuarionif() {
        return usuarionif;
    }

    public void setUsuarionif(Usuario usuarionif) {
        this.usuarionif = usuarionif;
    }

    public Lineamovil getLineamovil() {
        return lineamovil;
    }

    public void setLineamovil(Lineamovil lineamovil) {
        this.lineamovil = lineamovil;
    }

    @XmlTransient
    public Collection<Terminal> getTerminalCollection() {
        return terminalCollection;
    }

    public void setTerminalCollection(Collection<Terminal> terminalCollection) {
        this.terminalCollection = terminalCollection;
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
        hash += (idLinea != null ? idLinea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Linea)) {
            return false;
        }
        Linea other = (Linea) object;
        if ((this.idLinea == null && other.idLinea != null) || (this.idLinea != null && !this.idLinea.equals(other.idLinea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Linea[ idLinea=" + idLinea + " ]";
    }
    
}
