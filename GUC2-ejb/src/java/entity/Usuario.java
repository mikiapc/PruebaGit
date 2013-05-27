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
import javax.persistence.JoinColumns;
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
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByNif", query = "SELECT u FROM Usuario u WHERE u.nif = :nif"),
    @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Usuario.findByApellidos", query = "SELECT u FROM Usuario u WHERE u.apellidos = :apellidos"),
    @NamedQuery(name = "Usuario.findByDireccion", query = "SELECT u FROM Usuario u WHERE u.direccion = :direccion"),
    @NamedQuery(name = "Usuario.findByTelefono", query = "SELECT u FROM Usuario u WHERE u.telefono = :telefono"),
    @NamedQuery(name = "Usuario.findByCorreoE", query = "SELECT u FROM Usuario u WHERE u.correoE = :correoE"),
    @NamedQuery(name = "Usuario.findByPublicable", query = "SELECT u FROM Usuario u WHERE u.publicable = :publicable"),
    @NamedQuery(name = "Usuario.findByRol", query = "SELECT u FROM Usuario u WHERE u.rol = :rol"),
    @NamedQuery(name = "Usuario.findByPassword", query = "SELECT u FROM Usuario u WHERE u.password = :password"),
    @NamedQuery(name = "Usuario.findByBorrado", query = "SELECT u FROM Usuario u WHERE u.borrado = :borrado")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "nif")
    private String nif;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "correo_e")
    private String correoE;
    @Basic(optional = false)
    @NotNull
    @Column(name = "publicable")
    private boolean publicable;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "rol")
    private String rol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "borrado")
    private boolean borrado;
    @OneToMany(mappedBy = "jefeservicio")
    private Collection<Usuario> usuarioCollection;
    @JoinColumn(name = "Jefe_servicio", referencedColumnName = "nif")
    @ManyToOne
    private Usuario jefeservicio;
    @JoinColumns({
        @JoinColumn(name = "Ayuntamiento_localidad", referencedColumnName = "localidad"),
        @JoinColumn(name = "Ayuntamiento_direccion", referencedColumnName = "direccion")})
    @ManyToOne
    private Ayuntamiento ayuntamiento;
    @OneToMany(mappedBy = "usuarionif")
    private Collection<Linea> lineaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarionif")
    private Collection<Solicitud> solicitudCollection;
    @OneToMany(mappedBy = "usuarionif")
    private Collection<Terminal> terminalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarionif")
    private Collection<Facturaoperador> facturaoperadorCollection;

    public Usuario() {
    }

    public Usuario(String nif) {
        this.nif = nif;
    }

    public Usuario(String nif, String nombre, String apellidos, String direccion, String telefono, String correoE, boolean publicable, String rol, String password, boolean borrado) {
        this.nif = nif;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correoE = correoE;
        this.publicable = publicable;
        this.rol = rol;
        this.password = password;
        this.borrado = borrado;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoE() {
        return correoE;
    }

    public void setCorreoE(String correoE) {
        this.correoE = correoE;
    }

    public boolean getPublicable() {
        return publicable;
    }

    public void setPublicable(boolean publicable) {
        this.publicable = publicable;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getBorrado() {
        return borrado;
    }

    public void setBorrado(boolean borrado) {
        this.borrado = borrado;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    public Usuario getJefeservicio() {
        return jefeservicio;
    }

    public void setJefeservicio(Usuario jefeservicio) {
        this.jefeservicio = jefeservicio;
    }

    public Ayuntamiento getAyuntamiento() {
        return ayuntamiento;
    }

    public void setAyuntamiento(Ayuntamiento ayuntamiento) {
        this.ayuntamiento = ayuntamiento;
    }

    @XmlTransient
    public Collection<Linea> getLineaCollection() {
        return lineaCollection;
    }

    public void setLineaCollection(Collection<Linea> lineaCollection) {
        this.lineaCollection = lineaCollection;
    }

    @XmlTransient
    public Collection<Solicitud> getSolicitudCollection() {
        return solicitudCollection;
    }

    public void setSolicitudCollection(Collection<Solicitud> solicitudCollection) {
        this.solicitudCollection = solicitudCollection;
    }

    @XmlTransient
    public Collection<Terminal> getTerminalCollection() {
        return terminalCollection;
    }

    public void setTerminalCollection(Collection<Terminal> terminalCollection) {
        this.terminalCollection = terminalCollection;
    }

    @XmlTransient
    public Collection<Facturaoperador> getFacturaoperadorCollection() {
        return facturaoperadorCollection;
    }

    public void setFacturaoperadorCollection(Collection<Facturaoperador> facturaoperadorCollection) {
        this.facturaoperadorCollection = facturaoperadorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nif != null ? nif.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.nif == null && other.nif != null) || (this.nif != null && !this.nif.equals(other.nif))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Usuario[ nif=" + nif + " ]";
    }
    
}
