/*
 * LeerArchivoTexto.java
 */
package leerarchivotexto;

import java.io.IOException;
import java.lang.IllegalStateException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Leer datos en un archivo de texto secuencial, ejemplo de uso de la clase 
 * Scanner. Ejemplo de uso de las librerias java.nio.file.
 * @author Ing. Ricardo Presilla.
 * @version 1.0.
 */
public class LeerArchivoTexto {
    private static Scanner entrada;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        abrirArchivo();
        leerRegistros();
        cerrarArchivo();
    }
    /* Método para abrir el archivo clientes.txt
    */
    public static void abrirArchivo(){
        try{
            entrada = new Scanner(Paths.get("clientes.txt"));
        }catch (IOException ioException){
            System.out.println("Error para leer el archivo. Terminando.");
            System.err.println("Error para leer el archivo. Terminando.");
            System.exit(1); // termina el programa
        }
    }
    // lee registro del archivo
    public static void leerRegistros(){
        System.out.printf("%-10s%-12s%-12s%10s%n", "Cuenta",
        "Primer nombre ", "Apellido paterno", "Saldo");
        try{
            while (entrada.hasNext()){ // mientras haya más qué leer           
            // muestra el contenido del registro
                System.out.printf("%-10d%-14s%-17s%10.2f%n", entrada.nextInt(),
                entrada.next(), entrada.next(), entrada.nextDouble());
            }
        }catch (NoSuchElementException elementException){
            System.err.println("El archivo no esta bien formado. Terminando.");
        }catch (IllegalStateException stateException){
            System.err.println("Error al leer del archivo. Terminando.");
        }
    } // fin del método leerRegistros

    /* Cierra el archivo*/
    public static void cerrarArchivo(){
        if (entrada != null)
            entrada.close();
    }
}
