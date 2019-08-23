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
        File archivoComunas = new File("C:\\Users\\Usuario\\Desktop\\gitHub\\SCPjava\\TareaIO\\src\\Archivo\\Comunas.txt");
        String ruta = archivoComunas.getAbsolutePath();     //Ruta del archivo
     
        
        ListaComuna listaComunas = new ListaComuna(ruta);   //Se crea la lista de comunas y se cargan los datos
        listaComunas.mostrarDatos();
        
        
        
        /*
        //crear SECTOR1
        int[] comunasSolicitadasSector1 = {2,3,4,5};
        Sector sector1 = new Sector(listaComunas.entregarComunasSolicitadas(comunasSolicitadasSector1));
        
        //crear SECTOR2
        int[] comunasSolicitadasSector2 = {6,7,8,9,10};
        Sector sector2 = new Sector(listaComunas.entregarComunasSolicitadas(comunasSolicitadasSector2));
        
        //crear SECTOR3
        int[] comunasSolicitadasSector3 = {11,12,13,14,15,16,17};
        Sector sector3 = new Sector(listaComunas.entregarComunasSolicitadas(comunasSolicitadasSector3));
        
        //crear SECTOR4
        int[] comunasSolicitadasSector4 = {18,19,20,21,22,23};
        Sector sector4 = new Sector(listaComunas.entregarComunasSolicitadas(comunasSolicitadasSector4));
        
        //crear SECTOR5
        int[] comunasSolicitadasSector5 = {24,25,26,27,28,29};
        Sector sector5 = new Sector(listaComunas.entregarComunasSolicitadas(comunasSolicitadasSector5));
        
        //crear SECTOR6
        int[] comunasSolicitadasSector6 = {30,31,32,33,34,35,36,37,38};
        Sector sector6 = new Sector(listaComunas.entregarComunasSolicitadas(comunasSolicitadasSector6));
        */
    }
}
