/*
 * Clase que contiene el main, el cual se encargará de ejecutar
 * el programa.
 * @author Luis Maturana, Mauricio Rivera, Carlo Ardila y Javier Ortiz
 */

//Bibliotecas y paquetes
package Clases;
import java.io.File;

public class TestMain {
    
    /**
     * Es el método main para correr el programa.
     * @param args 
     */
    public static void main(String[] args) {
        //Se crea el archivo que contiene las comunas, si es necesario, se deberá cambiar la ruta
        File archivoComunas = new File("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\TareaIO\\src\\Archivo\\Comunas.txt");
        String ruta = archivoComunas.getAbsolutePath();     //Ruta del archivo
        ListaComuna listaComunas = new ListaComuna(ruta);   //Se crea la lista de comunas y se cargan los datos
        listaComunas.mostrarDatos();
    }
}
