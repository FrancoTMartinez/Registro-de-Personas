

//import Consulta.consulta;

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
        //Hacer Consultas

        Scanner entradaEscaner = new Scanner (System.in);
        int opciones;

        do {
            System.out.println("Elija la opcion que desee\n" +
                                "0- Cerrar.\n" +
                                "1- Agregar Datos.\n" +
                                "2- Eliminar Datos.\n"); //en prepracion
            opciones = entradaEscaner.nextInt();

            switch (opciones) {
                //hacer do while opciones !=0
                default:
                    System.out.println("Ingrese una opcion valida \n");
                    break;
                case 0 :
                    System.out.println("Adios, Usame pronto.\n");
                    break;
                case 1:
                    System.out.println("Eligio Agregar datos.\n");
                    Consulta consul = new Consulta();
                    System.out.println(consul.guardar());
                    break;
                case 2:
                    System.out.println("Eligio Modificar datos.\n");
                    break;


            }
        }while(opciones != 0);
    }

}

