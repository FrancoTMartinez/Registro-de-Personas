import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


//@RestController
//@RequestMapping("/registro_personas")

public class Consulta {

    private PreparedStatement ps;
    private ResultSet rs;
    private Connection con = null;
    private String entradaTeclado = "";
    private Scanner entradaEscaner = new Scanner (System.in);
    private static String INSERT = "INSERT INTO personas(Dni, Nombre, Edad, Telefono, Direccion, Email) VALUES (?,?,?,?,?,?)";
    private static String SELECT = "SELECT * FROM personas WHERE dni = ?";
    private static String UPDATE = "UPDATE personas SET dni=?, nombre=?, Edad=?, telefono=?, direccion=?, email=? WHERE dni=?";
    private static String DELETE = "DELETE FROM personas WHERE dni=?";

    Persona persona1 = new Persona();
    // @PostMapping (@RequestBody Usuario usuario)
    public Connection post(Persona persona1){
        // Guardar Datos
        try{
            //Establecer Main.Java.conexion
            con = Conexion.obtenerCon();
                        ps = con.prepareStatement(INSERT);

            System.out.println("Ingrese el DNI: ");
            entradaTeclado = entradaEscaner.nextLine ();
            persona1.setDni(entradaTeclado);
            ps.setString(1, persona1.getDni());
            System.out.println("El Dni ingresado es: " + entradaTeclado + " \n" + "Ingrese Nombre y Apellido: ");
            entradaTeclado = entradaEscaner.nextLine ();
            persona1.setNombre(entradaTeclado);
            ps.setString(2, persona1.getNombre());
            System.out.println("El Nombre ingresado es: " + entradaTeclado + " \n" + "Ingrese Edad: ");
            entradaTeclado = entradaEscaner.nextLine ();
            persona1.setEdad(entradaTeclado);
            ps.setString(3,persona1.getEdad());
            System.out.println("La Edad ingresada es: " + entradaTeclado + " \n" + "Ingrese Telefono");
            entradaTeclado = entradaEscaner.nextLine ();
            persona1.setTelefono(entradaTeclado);
            ps.setString(4,persona1.getTelefono());
            System.out.println("El Telefono ingresado es: " + entradaTeclado + " \n" + "Ingrese Direccion");
            entradaTeclado = entradaEscaner.nextLine ();
            persona1.setDireccion(entradaTeclado);
            ps.setString(5, persona1.getDireccion());
            System.out.println("La direccion ingresada es: " + entradaTeclado + " \n" + "Ingrese Email");
            entradaTeclado = entradaEscaner.nextLine();
            persona1.setEmail(entradaTeclado);
            ps.setString(6, persona1.getEmail());
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

    /*@GetMapping("/registro_personas")
    public List Persona persona1 search(){
    }*/
    // @GetMapping("/registro_personas/{dni}")
    //@RequestParam String dni
    public  Connection lookup (Persona persona1) {
        //Buscar Personas
        try {
            //Establecer Main.Java.conexion
            con = Conexion.obtenerCon();
            ps = con.prepareStatement(SELECT);
            System.out.println("Ingrese el DNI de la persona que desea buscar.");
            entradaTeclado = entradaEscaner.nextLine();
            persona1.setDni(entradaTeclado);
            ps.setString(1, persona1.getDni());
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


    // @PutMapping("/registro_personas/{dni}")
    //@RequestParam String dni,
    //@RequestBody Persona persona
    public Connection update(Persona persona1){
        //Modificar Personas
        try {
            //Establecer Main.Java.conexion
            con = Conexion.obtenerCon();
            ps = con.prepareStatement(UPDATE);

            System.out.println("Ingrese el DNI: ");
            entradaTeclado = entradaEscaner.nextLine ();
            persona1.setDni(entradaTeclado);
            ps.setString(1,persona1.getDni());
            System.out.println("El Dni ingresado es: " + entradaTeclado + " \n" + "Ingrese Nombre y Apellido: ");
            entradaTeclado = entradaEscaner.nextLine ();
            persona1.setNombre(entradaTeclado);
            ps.setString(2, persona1.getNombre());
            System.out.println("El Nombre ingresado es: " + entradaTeclado + " \n" + "Ingrese Edad: ");
            entradaTeclado = entradaEscaner.nextLine ();
            persona1.setEdad(entradaTeclado);
            ps.setString(3,persona1.getEdad());
            System.out.println("La Edad ingresada es: " + entradaTeclado + " \n" + "Ingrese Telefono");
            entradaTeclado = entradaEscaner.nextLine ();
            persona1.setTelefono(entradaTeclado);
            ps.setString(4,persona1.getTelefono());
            System.out.println("El Telefono ingresado es: " + entradaTeclado + " \n" + "Ingrese Direccion");
            entradaTeclado = entradaEscaner.nextLine ();
            persona1.setDireccion(entradaTeclado);
            ps.setString(5,persona1.getDireccion());
            System.out.println("La direccion ingresada es: " + entradaTeclado + " \n" + "Ingrese Email");
            entradaTeclado = entradaEscaner.nextLine();
            persona1.setEmail(entradaTeclado);
            ps.setString(6, persona1.getEmail());
            System.out.println("El Email ingresado es: " + entradaTeclado + " ");
            System.out.println("Ingrese el DNI nuevamente: ");
            entradaTeclado = entradaEscaner.nextLine ();
            persona1.setDni(entradaTeclado);
            ps.setString(7,persona1.getDni());

            int res = ps.executeUpdate();

            if(res > 0) {
                System.out.println("Datos modificados con exito!\n");
                System.out.println("--------------------------------------------------------------------");
            }else{
                System.out.println("Error al modificar");
                System.out.println("--------------------------------------------------------------------");
            }
        }catch(Exception e){
            System.out.println("Error:" + e);
            System.out.println("--------------------------------------------------------------------");
        }
        return con;
    }

    // @DeleteMapping("/registro_personas/{dni}")
    // @RequestParam (String dni)
    public Connection delete(Persona persona1){
        //Borrar Personas
        try{
            //Establecer Main.Java.conexion
            con = Conexion.obtenerCon();
            ps = con.prepareStatement(DELETE);

            System.out.println("Ingrese el DNI de la persona que desea borrar su informacion: ");
            entradaTeclado = entradaEscaner.nextLine ();
            persona1.setDni(entradaTeclado);
            ps.setString(1,persona1.getDni());

            int res = ps.executeUpdate();

            if (res >0){
                System.out.println("Datos borrados con exito!\n");
                System.out.println("--------------------------------------------------------------------");
            }else{
                System.out.println("Error al eliminar datos");
                System.out.println("--------------------------------------------------------------------");
            }
        }catch (Exception e){
            System.out.println("Error:" + e.getMessage());
            System.out.println("--------------------------------------------------------------------");
        }

        return con;
    }
}
