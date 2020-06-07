import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static Connection con = null;

    public static Connection obtenerCon (){
        try {
            if(con == null){
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registro_personas", "root", "");
                return con;
            } else {
                return con;
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return con;
    }
    public static void cerrar() throws SQLException {
        if (con != null) {
            con.close();
        }
    }
}
