import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


public class Usuario {

    private String dni;
    private String nombre;
    private String edad;
    private String telefono;
    private String direccion;
    private String email;

    public Usuario() {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Usuario{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad='" + edad + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Usuario usuario = (Usuario) object;
        return java.util.Objects.equals(dni, usuario.dni) &&
                java.util.Objects.equals(nombre, usuario.nombre) &&
                java.util.Objects.equals(edad, usuario.edad) &&
                java.util.Objects.equals(telefono, usuario.telefono) &&
                java.util.Objects.equals(direccion, usuario.direccion) &&
                java.util.Objects.equals(email, usuario.email);
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), dni, nombre, edad, telefono, direccion, email);
    }
}
