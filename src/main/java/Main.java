import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        //Establecer Conexion con BD
        Conexion con = new Conexion();
        System.out.println(Conexion.obtenerCon());

        Scanner entradaEscaner = new Scanner (System.in);
        int opciones;
        if (Conexion.obtenerCon() != null){
            do{
                System.out.println("Elija la opcion que desee\n" +
                    "0- Cerrar.\n" +
                    "1- Agregar Datos.\n" +
                    "2- Buscar Datos.\n" +
                    "3- Modificar Datos.\n" +
                    "4- Borrar Datos");

                opciones = entradaEscaner.nextInt();

                switch (opciones) {
                    default:
                        System.out.println("Ingrese una opcion valida \n");
                        break;
                    case 0:
                        System.out.println("Adios, Usame pronto.\n");
                        break;
                    case 1:
                        System.out.println("Eligio Agregar datos.\n");
                        Consulta agregar_personas = new Consulta();
                        System.out.println(agregar_personas.post());
                        break;
                    case 2:
                        System.out.println("Eligio Buscar Datos.\n");
                        Consulta buscar_personas = new Consulta();
                        System.out.println(buscar_personas.lookup());
                        break;
                    case 3:
                        System.out.println("Eligio Modificar Datos.\n");
                        Consulta modificar_personas = new Consulta();
                        System.out.println(modificar_personas.update());
                        break;
                    case 4: System.out.println("Eligio Borrar Datos");
                        Consulta borrar_personas = new Consulta();
                        System.out.println(borrar_personas.delete());
                }
        } while (opciones != 0);
        return;
        }
    }
}
