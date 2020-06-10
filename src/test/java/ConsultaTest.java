import com.mysql.cj.protocol.Resultset;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;

//@RunWith (investigar si es necesario)
@RunWith(JUnit4ClassRunner.class)
//@RunWith(MockitoJUnitRunner.class)
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
    public void testPost() {
        //hacer un metodo que construya una persona
        guardarPersona();

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
    public void updateTest() {

    }

    @Test
    public void deleteTest() {
        guardarPersona();
        traerPersona();
        assertNull(buildPersona().getDni(), traerPersona().getDni());
    }

    private Persona buildPersona(){
        Persona persona1 = new Persona();
        persona1.setDni("42416954");
        persona1.setNombre("Franco Tobias Martinez");
        persona1.setEdad("20");
        persona1.setTelefono("1530870938");
        persona1.setDireccion("Monasterio 848");
        persona1.setEmail("francomartinez@gmail.com");
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
        Persona personaTest = new Persona();
        PreparedStatement ps;
        ResultSet rs = null;
        try {

                Connection con = Conexion.obtenerCon();
                String SELECT = "SELECT * FROM personas WHERE dni = ?";

                ps = con.prepareStatement(SELECT);
                ps.setString(1, buildPersona().getDni());
                rs = ps.executeQuery();
            if (rs.next()) {
                personaTest.setDni(rs.getString("Dni"));
                personaTest.setNombre(rs.getString("Nombre"));
                personaTest.setEdad(rs.getString("Edad"));
                personaTest.setTelefono(rs.getString("Telefono"));
                personaTest.setDireccion(rs.getString("Direccion"));
                personaTest.setEmail(rs.getString("Email"));
            }

            } catch (Exception e) {
                System.out.println("Error:" + e.getMessage());
            }
            return personaTest;
        }
}
