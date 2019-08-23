/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ListaComuna {
    private ArrayList<Comuna> listaComuna;
    
    public ListaComuna(){
        this.listaComuna = new ArrayList<>();
    }
        
    public ListaComuna(String direccionArchivo){
        this.listaComuna = new ArrayList<>();
        try{
            BufferedReader bf = new BufferedReader(new FileReader(direccionArchivo));
            String bfRead;
            int identificador;
            String nombre;
            double costo;
            
            while((bfRead = bf.readLine()) != null){
                identificador = Integer.parseInt(bfRead);
                bfRead = bf.readLine();
                nombre = bfRead;
                bfRead = bf.readLine();
                costo = Double.parseDouble(bfRead);
                this.listaComuna.add(new Comuna(identificador,nombre,costo));
            }
        }
        catch(IOException e){
            System.err.println("¡No se encontró un archivo!");
        }
    }
    
    public ArrayList<Comuna> getListaComuna() {
        return listaComuna;
    }

    public void setListaComuna(ArrayList<Comuna> listaComuna) {
        this.listaComuna = listaComuna;
    }
    
    public void mostrarDatos(){
        for(Comuna actual : listaComuna){
            System.out.println("ID: "+actual.getId()+" Nombre: "+actual.getNombre()+" Costo: "+actual.getCosto());
        }
    }
}
