import com.mysql.cj.protocol.Resultset;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

//@RunWith (investigar si es necesario)
//@RunWith(JUnit4ClassRunner.class)
@RunWith(MockitoJUnitRunner.class)
public class ConsultaTest{
    @Mock
    private Conexion conexion;

    private Consulta consulta;
    private Consulta dni;

    @Before
    public void buildConsulta(){
        consulta = new Consulta();
        //TODO mockear conexion a la base (si la anotacion @Mock no funciona)
    }

    @Test
    public void testGuardar() {
        //hacer un metodo que construya una persona
        buildPersona();
        Connection con = consulta.post(buildPersona());
        // Connection con = consulta.lookup(buildUsuario().getDni());
        // buscar dentro de Connection un metodo que traiga lo que se guardo
        // hacer un select a la base
        traerPersona();


        assertEquals(traerPersona().getDni(), buildPersona().getDni());
        assertEquals(traerPersona().getNombre(), buildPersona().getNombre());
        assertEquals(traerPersona().getEdad(), buildPersona().getEdad());
        assertEquals(traerPersona().getTelefono(), buildPersona().getTelefono());
        assertEquals(traerPersona().getDireccion(), buildPersona().getDireccion());
        assertEquals(traerPersona().getEmail(), buildPersona().getEmail());
    }

    @Test
    public void testLookup() {
        //primero guardar un usuario en la base con el metodo
        guardarPersona();

        //testear el select
        traerPersona();

        assertEquals(traerPersona().getDni(), buildPersona().getDni());
        assertEquals(traerPersona().getNombre(), buildPersona().getNombre());
        assertEquals(traerPersona().getEdad(), buildPersona().getEdad());
        assertEquals(traerPersona().getTelefono(), buildPersona().getTelefono());
        assertEquals(traerPersona().getDireccion(), buildPersona().getDireccion());
        assertEquals(traerPersona().getEmail(), buildPersona().getEmail());
    }

    @Test
    public void modificar() {
    }

    @Test
    public void borrar() {
    }

    private Persona buildPersona(){
        Persona persona1 = new Persona();
        persona1.setDni("123");
        persona1.setNombre("Franco Tobias Martinez");
        persona1.setEdad("20");
        persona1.setTelefono("1530870938");
        persona1.setDireccion("Monasterio 848");
        persona1.setEdad("francomartinez@gmail.com");
        return persona1;
    }

    private void guardarPersona() { // en BD
        PreparedStatement ps;
        Resultset rs;
        Persona persona1 = new Persona();
        Connection con = Conexion.obtenerCon();
        String INSERT = "INSERT INTO personas(Dni, Nombre, Edad, Telefono, Direccion, Email) VALUES (?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(INSERT);

            ps.setString(1, buildPersona().getDni());
            ps.setString(2, buildPersona().getNombre());
            ps.setString(3, buildPersona().getEdad());
            ps.setString(4, buildPersona().getTelefono());
            ps.setString(5, buildPersona().getDireccion());
            ps.setString(6, buildPersona().getEmail());
            int res = ps.executeUpdate();

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private Persona traerPersona(){ //desde BD
        Persona persona1 = new Persona();
        try {
                PreparedStatement ps;
                ResultSet rs;
                String SELECT = "SELECT * FROM personas WHERE dni = ?";
                //Establecer Main.Java.conexion
                Connection con = Conexion.obtenerCon();
                ps = con.prepareStatement(SELECT);
                ps.setString(1, buildPersona().getDni());
                rs = ps.executeQuery();

                rs.getString("Dni");
                rs.getString("Nombre");
                rs.getInt("Edad");
                rs.getString("Telefono");
                rs.getString("Direccion");
                rs.getString("Email");

            } catch (Exception e) {
                System.out.println("Error:" + e.getMessage());
            }
            return persona1;
        }
}
