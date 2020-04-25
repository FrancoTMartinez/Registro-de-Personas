import java.sql.*;
import java.util.Scanner;

public class Consulta {

    public static Connection guardar(){


        String entradaTeclado = "";
        Scanner entradaEscaner = new Scanner (System.in);
        //Establecer conexion
        Connection con = null;
        String dni;
        String nombre;
        String apellido;
        String edad;
        String telefono;
        String direccion;
        String email;
        // Insertar Datos
            try{
                PreparedStatement ps;
                ResultSet rs;

                con = conexion.obtener_con();
                ps = con.prepareStatement("INSERT INTO personas(Dni, Nombre, Apellido, Edad, Telefono, Direccion, Email) VALUES (?,?,?,?,?,?,?)");
                System.out.println("Ingrese el DNI");
                entradaTeclado = entradaEscaner.nextLine ();
                dni = entradaTeclado;
                ps.setString(1,dni);
                System.out.println("El Dni ingresado es: " + entradaTeclado + " " );
                System.out.println("Ingrese Nombre");
                entradaTeclado = entradaEscaner.nextLine ();
                nombre = entradaTeclado;
                ps.setString(2, nombre);
                System.out.println("El Nombre ingresado es: " + entradaTeclado + " ");
                System.out.println("Ingrese Apellido");
                entradaTeclado = entradaEscaner.nextLine ();
                apellido = entradaTeclado;
                ps.setString(3, apellido);
                System.out.println("El Apellido ingresado es: " + entradaTeclado + " ");
                System.out.println("Ingrese Edad");
                entradaTeclado = entradaEscaner.nextLine ();
                edad = entradaTeclado;
                ps.setString(4,edad);
                System.out.println("La Edad ingresada es: " + entradaTeclado + " ");
                System.out.println("Ingrese Telefono");
                entradaTeclado = entradaEscaner.nextLine ();
                telefono = entradaTeclado;
                ps.setString(5,telefono);
                System.out.println("El Telefono ingresado es: " + entradaTeclado + " ");
                System.out.println("Ingrese el Direccion");
                entradaTeclado = entradaEscaner.nextLine ();
                direccion = entradaTeclado;
                ps.setString(6,direccion);
                System.out.println("La direccion ingresada es: " + entradaTeclado + " ");
                System.out.println("Ingrese Email");
                entradaTeclado = entradaEscaner.nextLine();
                email = entradaTeclado;
                ps.setString(7, email);
                System.out.println("El Email ingresado es: " + entradaTeclado + " ");
                int res = ps.executeUpdate();

                if(res > 0){
                    System.out.println("Datos guardados con exito!\n");
                }else {
                    System.out.println("No se pudo guaradar\n");
                }

            }catch (Exception e){
                System.out.println("Error: " + e);
            }
        return con;
    }

}

