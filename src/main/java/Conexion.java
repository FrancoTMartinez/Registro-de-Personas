import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static Connection con = null;

    public static Connection obtenerCon (){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registro_personas", "root", "");
            if(con != null){

            } else {
                System.out.println("Conxeion Fallida");
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