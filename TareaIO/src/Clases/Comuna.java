/*
 * Clase comuna, en la cual poseerá todos los atributos y métodos
 * asociados a esta.
 */
package Clases;

public class Comuna {
    private int id;                 //Identificador de comuna.
    private String nombre;          //Nombre de la comuna.
    private double costo;           //Costo de colocar la antena en comuna.
    private double probabilidad;    //probailidad asignada
    private int[] idVecinos;        //identificadores de vecinos cercanos
    
    /**
     * Constructo de Comuna
     * @param id int
     * @param nombre String
     * @param costo double
     */
    public Comuna(int id, String nombre, double costo, int[]idVecinos) {
        this.id = id;
        this.nombre = nombre;
        this.costo = costo;
        this.probabilidad = 0;
        this.llenarVecinos(idVecinos);
    }
    
    //Getters y setters correspondientes
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getProbabilidad() {
        return probabilidad;
    }

    public void setProbabilidad(double probabilidad) {
        this.probabilidad = probabilidad;
    }
    
    private int cantidadVecinosDisponibles(int[] idParametro){
        int contador = 0;
        for(int i = 0; i < idParametro.length; i++){
            if(idParametro[i] != 0){
                contador++;
            }
        }
        return contador;
    }
    
    private void llenarVecinos(int[] idParametro){
        idVecinos = new int[cantidadVecinosDisponibles(idParametro)];
        int j = 0;
        for(int i = 0; i < idParametro.length; i++){
            if(idParametro[i] != 0){
                idVecinos[j] = idParametro[i];
                j++;
            }
        }
    }
    
    public void mostrarVecinos(){
        System.out.print("Vecinos son: ");
        for(int i = 0; i < idVecinos.length; i++){
            System.out.print(idVecinos[i]+" ");
        }
        System.out.println("");
    }
}
