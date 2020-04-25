import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class conexion {
    private static Connection con = null;

    public static Connection obtener_con (){
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registro_personas", "root", "");
            if(con != null){
                System.out.println("Conexion Exitosa!");
            } else {
                System.out.println("Conxeion Fallida");
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
        return con;
    }
    public static void cerrar() throws SQLException {
        if (con != null) {
            con.close();
        }
    }
}
