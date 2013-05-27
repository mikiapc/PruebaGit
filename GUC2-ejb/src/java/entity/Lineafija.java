/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Naoual Amasri
 */
@Entity
@Table(name = "lineafija")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lineafija.findAll", query = "SELECT l FROM Lineafija l"),
    @NamedQuery(name = "Lineafija.findByUbicacion", query = "SELECT l FROM Lineafija l WHERE l.ubicacion = :ubicacion"),
    @NamedQuery(name = "Lineafija.findByLineaidLinea", query = "SELECT l FROM Lineafija l WHERE l.lineaidLinea = :lineaidLinea")})
public class Lineafija implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ubicacion")
    private String ubicacion;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Linea_idLinea")
    private String lineaidLinea;
    @JoinColumn(name = "Linea_idLinea", referencedColumnName = "idLinea", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Linea linea;
    @JoinColumn(name = "CategoriaLlamadas_idCategoriaLlamadas", referencedColumnName = "idCategoriaLlamadas")
    @ManyToOne(optional = false)
    private Categoriallamadas categoriaLlamadasidCategoriaLlamadas;

    public Lineafija() {
    }

    public Lineafija(String lineaidLinea) {
        this.lineaidLinea = lineaidLinea;
    }

    public Lineafija(String lineaidLinea, String ubicacion) {
        this.lineaidLinea = lineaidLinea;
        this.ubicacion = ubicacion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getLineaidLinea() {
        return lineaidLinea;
    }

    public void setLineaidLinea(String lineaidLinea) {
        this.lineaidLinea = lineaidLinea;
    }

    public Linea getLinea() {
        return linea;
    }

    public void setLinea(Linea linea) {
        this.linea = linea;
    }

    public Categoriallamadas getCategoriaLlamadasidCategoriaLlamadas() {
        return categoriaLlamadasidCategoriaLlamadas;
    }

    public void setCategoriaLlamadasidCategoriaLlamadas(Categoriallamadas categoriaLlamadasidCategoriaLlamadas) {
        this.categoriaLlamadasidCategoriaLlamadas = categoriaLlamadasidCategoriaLlamadas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lineaidLinea != null ? lineaidLinea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lineafija)) {
            return false;
        }
        Lineafija other = (Lineafija) object;
        if ((this.lineaidLinea == null && other.lineaidLinea != null) || (this.lineaidLinea != null && !this.lineaidLinea.equals(other.lineaidLinea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Lineafija[ lineaidLinea=" + lineaidLinea + " ]";
    }
    
}
