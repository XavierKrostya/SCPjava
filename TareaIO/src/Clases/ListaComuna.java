/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
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
            int[] idVecinos = new int[30];
            int i = 0;
            
            while((bfRead = bf.readLine()) != null){
                identificador = Integer.parseInt(bfRead);
                bfRead = bf.readLine();
                nombre = bfRead;
                bfRead = bf.readLine();
                costo = Double.parseDouble(bfRead);
                bfRead = bf.readLine();
                while(!bfRead.equals("end")){
                    idVecinos[i] = Integer.parseInt(bfRead);
                    bfRead = bf.readLine();
                    i++;
                }
                this.listaComuna.add(new Comuna(identificador,nombre,costo,idVecinos));
                i = 0;
                vaciarArregloIdentificador(idVecinos);
            }
            cargarProbabilidad();
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
            System.out.println("ID: "+actual.getId()+" Nombre: "+actual.getNombre()+" Costo: "+actual.getCosto()+" Probabilidad: "+actual.getProbabilidad());
            actual.mostrarVecinos();
        }
    }
    
    private void cargarProbabilidad(){
        int cantidadComunas = listaComuna.size();
        double probabilidadAsignada;
        
        for(int i = 0; i < cantidadComunas; i++){
            probabilidadAsignada = (double)(i+1)/cantidadComunas;
            listaComuna.get(i).setProbabilidad(probabilidadAsignada);
        }
    }
    
    public ArrayList<Comuna> entregarComunasSolicitadas(int[] comunasId){
        ArrayList<Comuna> comunasSolicitadas = new ArrayList<>();
        for(Comuna actual : listaComuna){
            for(int i = 0; i < comunasId.length; i++){
                if(comunasId[i] == actual.getId()){
                    comunasSolicitadas.add(actual);
                }
            }
        }
        return comunasSolicitadas;
    }
    
    public void vaciarArregloIdentificador(int[] arreglo){
        for(int i = 0; i < arreglo.length; i++){
            arreglo[i] = 0;
        }
    }
}
