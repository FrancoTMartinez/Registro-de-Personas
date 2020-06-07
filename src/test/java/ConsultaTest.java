import com.mysql.cj.x.protobuf.MysqlxExpr;
import net.bytebuddy.agent.VirtualMachine;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.processor.ObjectColumnProcessor;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Connection;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

//@RunWith (investigar si es necesario)
//@RunWith(JUnit4ClassRunner.class)
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
    public void testGuardar() {
        //hacer un metodo que construya un usuario
        Connection con = consulta.post(buildUsuario());
        // Connection con = consulta.lookup(buildUsuario().getDni());
        // buscar dentro de Connection un metodo que traiga lo que se guardo
        // hacer un select a la base
        assertEquals(usuarioReturn.dni, buildUsuario().getDni());
        assertEquals(usuarioReturn.nombre, buildUsuario().getNombre());
    }

    @Test
    public void testLookup() {
        //primero guardar un usuario en la base con el metodo
        guardarUsuario();

        //testear el select
    }

    @Test
    public void modificar() {
    }

    @Test
    public void borrar() {
    }

    private Usuario buildUsuario(){
        Usuario usuario = new Usuario();
        usuario.setDni("123");
        return usuario;
    }

    private void guardarUsuario(){

    }
}