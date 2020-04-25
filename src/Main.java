
import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

import static jdk.internal.net.http.common.Utils.close;

public class Main{
    public static void main(String[] args) throws SQLException {
        //Establecer Conexion con BD
        conexion con = new conexion();
           System.out.println(conexion.obtener_con());

        Scanner entradaEscaner = new Scanner (System.in);
        int opciones;

        if (conexion.obtener_con() != null){

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
                            System.out.println(agregar_personas.guardar());
                            break;
                        case 2:
                            System.out.println("Eligio Buscar Datos.\n");
                            Consulta buscar_personas = new Consulta();
                            System.out.println(buscar_personas.buscar());
                            break;
                        case 3:
                            System.out.println("Eligio Modificar Datos.\n");
                            Consulta modificar_personas = new Consulta();
                            System.out.println(modificar_personas.modificar());
                            break;
                        case 4: System.out.println("Eligio Borrar Datos");
                                Consulta borrar_personas = new Consulta();
                                System.out.println(borrar_personas.borrar());
                    }
                } while (opciones != 0);
        return;
        }
    }
}



