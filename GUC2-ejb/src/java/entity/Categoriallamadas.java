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
@Table(name = "categoriallamadas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categoriallamadas.findAll", query = "SELECT c FROM Categoriallamadas c"),
    @NamedQuery(name = "Categoriallamadas.findByIdCategoriaLlamadas", query = "SELECT c FROM Categoriallamadas c WHERE c.idCategoriaLlamadas = :idCategoriaLlamadas"),
    @NamedQuery(name = "Categoriallamadas.findByTipoLlamada", query = "SELECT c FROM Categoriallamadas c WHERE c.tipoLlamada = :tipoLlamada"),
    @NamedQuery(name = "Categoriallamadas.findByCosteMinuto", query = "SELECT c FROM Categoriallamadas c WHERE c.costeMinuto = :costeMinuto"),
    @NamedQuery(name = "Categoriallamadas.findByCosteEstablecimiento", query = "SELECT c FROM Categoriallamadas c WHERE c.costeEstablecimiento = :costeEstablecimiento"),
    @NamedQuery(name = "Categoriallamadas.findByBorrado", query = "SELECT c FROM Categoriallamadas c WHERE c.borrado = :borrado")})
public class Categoriallamadas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCategoriaLlamadas")
    private Integer idCategoriaLlamadas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "tipoLlamada")
    private String tipoLlamada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costeMinuto")
    private double costeMinuto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costeEstablecimiento")
    private double costeEstablecimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "borrado")
    private boolean borrado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoriaLlamadasidCategoriaLlamadas")
    private Collection<Lineafija> lineafijaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoriaLlamadasidCategoriaLlamadas")
    private Collection<Llamada> llamadaCollection;

    public Categoriallamadas() {
    }

    public Categoriallamadas(Integer idCategoriaLlamadas) {
        this.idCategoriaLlamadas = idCategoriaLlamadas;
    }

    public Categoriallamadas(Integer idCategoriaLlamadas, String tipoLlamada, double costeMinuto, double costeEstablecimiento, boolean borrado) {
        this.idCategoriaLlamadas = idCategoriaLlamadas;
        this.tipoLlamada = tipoLlamada;
        this.costeMinuto = costeMinuto;
        this.costeEstablecimiento = costeEstablecimiento;
        this.borrado = borrado;
    }

    public Integer getIdCategoriaLlamadas() {
        return idCategoriaLlamadas;
    }

    public void setIdCategoriaLlamadas(Integer idCategoriaLlamadas) {
        this.idCategoriaLlamadas = idCategoriaLlamadas;
    }

    public String getTipoLlamada() {
        return tipoLlamada;
    }

    public void setTipoLlamada(String tipoLlamada) {
        this.tipoLlamada = tipoLlamada;
    }

    public double getCosteMinuto() {
        return costeMinuto;
    }

    public void setCosteMinuto(double costeMinuto) {
        this.costeMinuto = costeMinuto;
    }

    public double getCosteEstablecimiento() {
        return costeEstablecimiento;
    }

    public void setCosteEstablecimiento(double costeEstablecimiento) {
        this.costeEstablecimiento = costeEstablecimiento;
    }

    public boolean getBorrado() {
        return borrado;
    }

    public void setBorrado(boolean borrado) {
        this.borrado = borrado;
    }

    @XmlTransient
    public Collection<Lineafija> getLineafijaCollection() {
        return lineafijaCollection;
    }

    public void setLineafijaCollection(Collection<Lineafija> lineafijaCollection) {
        this.lineafijaCollection = lineafijaCollection;
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
        hash += (idCategoriaLlamadas != null ? idCategoriaLlamadas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoriallamadas)) {
            return false;
        }
        Categoriallamadas other = (Categoriallamadas) object;
        if ((this.idCategoriaLlamadas == null && other.idCategoriaLlamadas != null) || (this.idCategoriaLlamadas != null && !this.idCategoriaLlamadas.equals(other.idCategoriaLlamadas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Categoriallamadas[ idCategoriaLlamadas=" + idCategoriaLlamadas + " ]";
    }
    
}
