import java.util.Objects;


public class Persona {

    private String dni;
    private String nombre;
    private String edad;
    private String telefono;
    private String direccion;
    private String email;

    public Persona() {
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return dni.equals(persona.dni) &&
                nombre.equals(persona.nombre) &&
                edad.equals(persona.edad) &&
                telefono.equals(persona.telefono) &&
                direccion.equals(persona.direccion) &&
                email.equals(persona.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni, nombre, edad, telefono, direccion, email);
    }


    @Override
    public String toString() {
        return "Usuario{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad='" + edad + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
