import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Consulta {
    private String dni;
    private String nombre;
    private String edad;
    private String telefono;
    private String direccion;
    private String email;
    private PreparedStatement ps;
    private ResultSet rs;
    private Connection con = null;
    private String entradaTeclado = "";
    private Scanner entradaEscaner = new Scanner (System.in);
    private static String INSERT = "INSERT INTO personas(Dni, Nombre, Edad, Telefono, ) VADireccion, EmailLUES (?,?,?,?,?,?)";
    private static String SELECT = "SELECT * FROM personas WHERE dni = ?";
    private static String UPDATE = "UPDATE personas SET dni=?, nombre=?, Edad=?, telefono=?, direccion=?, email=? WHERE dni=?";
    private static String DELETE = "DELETE FROM personas WHERE dni=?";


    public Connection guardar(){
        // Guardar Datos
        try{
            //Establecer Main.Java.conexion
            con = Conexion.obtenerCon();
            ps = con.prepareStatement(INSERT);

            System.out.println("Ingrese el DNI: ");
            entradaTeclado = entradaEscaner.nextLine ();
            dni = entradaTeclado;
            ps.setString(1,dni);
            System.out.println("El Dni ingresado es: " + entradaTeclado + " \n" + "Ingrese Nombre y Apellido: ");
            entradaTeclado = entradaEscaner.nextLine ();
            nombre = entradaTeclado;
            ps.setString(2, nombre);
            System.out.println("El Nombre ingresado es: " + entradaTeclado + " \n" + "Ingrese Edad: ");
            entradaTeclado = entradaEscaner.nextLine ();
            edad = entradaTeclado;
            ps.setString(3,edad);
            System.out.println("La Edad ingresada es: " + entradaTeclado + " \n" + "Ingrese Telefono");
            entradaTeclado = entradaEscaner.nextLine ();
            telefono = entradaTeclado;
            ps.setString(4,telefono);
            System.out.println("El Telefono ingresado es: " + entradaTeclado + " \n" + "Ingrese Direccion");
            entradaTeclado = entradaEscaner.nextLine ();
            direccion = entradaTeclado;
            ps.setString(5,direccion);
            System.out.println("La direccion ingresada es: " + entradaTeclado + " \n" + "Ingrese Email");
            entradaTeclado = entradaEscaner.nextLine();
            email = entradaTeclado;
            ps.setString(6, email);
            System.out.println("El Email ingresado es: " + entradaTeclado + " ");
            int res = ps.executeUpdate();

            if(res > 0){
                System.out.println("Datos guardados con exito!\n");
                System.out.println("--------------------------------------------------------------------");
            }else {
                System.out.println("No se pudo guaradar\n");
                System.out.println("--------------------------------------------------------------------");
            }

        }catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }
        return con;
    }
    public  Connection buscar() {
        //Buscar Personas
        try {
            //Establecer Main.Java.conexion
            con = Conexion.obtenerCon();
            ps = con.prepareStatement(SELECT);
            System.out.println("Ingrese el DNI de la persona que desea buscar.");
            entradaTeclado = entradaEscaner.nextLine();
            dni = entradaTeclado;
            ps.setString(1, dni);
            rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("El Dni ingresado es: " + rs.getString("Dni"));
                System.out.println("Nombre y Appellido: " + rs.getString("Nombre"));
                System.out.println("Edad: " + rs.getInt("Edad"));
                System.out.println("Telefono: " + rs.getString("Telefono"));
                System.out.println("Direccion: " + rs.getString("Direccion"));
                System.out.println("Email: " + rs.getString("Email"));
                System.out.println("--------------------------------------------------------------------");
            } else {
                System.out.println("No se encontraron datos.");
                System.out.println("--------------------------------------------------------------------");
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return con;
    }
    public Connection modificar(){
        //Modificar Personas
        try {
            //Establecer Main.Java.conexion
            con = Conexion.obtenerCon();
            ps = con.prepareStatement(UPDATE);

            System.out.println("Ingrese el DNI: ");
            entradaTeclado = entradaEscaner.nextLine ();
            dni = entradaTeclado;
            ps.setString(1,dni);
            System.out.println("El Dni ingresado es: " + entradaTeclado + " \n" + "Ingrese Nombre y Apellido: ");
            entradaTeclado = entradaEscaner.nextLine ();
            nombre = entradaTeclado;
            ps.setString(2, nombre);
            System.out.println("El Nombre ingresado es: " + entradaTeclado + " \n" + "Ingrese Edad: ");
            entradaTeclado = entradaEscaner.nextLine ();
            edad = entradaTeclado;
            ps.setString(3,edad);
            System.out.println("La Edad ingresada es: " + entradaTeclado + " \n" + "Ingrese Telefono");
            entradaTeclado = entradaEscaner.nextLine ();
            telefono = entradaTeclado;
            ps.setString(4,telefono);
            System.out.println("El Telefono ingresado es: " + entradaTeclado + " \n" + "Ingrese Direccion");
            entradaTeclado = entradaEscaner.nextLine ();
            direccion = entradaTeclado;
            ps.setString(5,direccion);
            System.out.println("La direccion ingresada es: " + entradaTeclado + " \n" + "Ingrese Email");
            entradaTeclado = entradaEscaner.nextLine();
            email = entradaTeclado;
            ps.setString(6, email);
            System.out.println("El Email ingresado es: " + entradaTeclado + " ");
            System.out.println("Ingrese el DNI nuevamente: ");
            entradaTeclado = entradaEscaner.nextLine ();
            dni = entradaTeclado;
            ps.setString(7,dni);

            int res = ps.executeUpdate();

            if(res > 0) {
                System.out.println("Datos modificados con exito!\n");
                System.out.println("--------------------------------------------------------------------");
            }else{
                System.out.println("Error al modificar");
            }
        }catch(Exception e){
            System.out.println("Error:" + e);
            System.out.println("--------------------------------------------------------------------");
        }
        return con;
    }
    public Connection borrar(){
        //Borrar Personas
        try{
            //Establecer Main.Java.conexion
            con = Conexion.obtenerCon();
            ps = con.prepareStatement(DELETE);

            System.out.println("Ingrese el DNI de la persona que desea borrar su informacion: ");
            entradaTeclado = entradaEscaner.nextLine ();
            dni = entradaTeclado;
            ps.setString(1,dni);

            int res = ps.executeUpdate();

            if (res >0){
                System.out.println("Datos borrados con exito!\n");
                System.out.println("--------------------------------------------------------------------");
            }else{
                System.out.println("Error al eliminar datos");
            }
        }catch (Exception e){
            System.out.println("Error:" + e.getMessage());
            System.out.println("--------------------------------------------------------------------");
        }

        return con;
    }
}
