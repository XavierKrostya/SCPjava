/*
 * Clase comuna, en la cual poseerá todos los atributos y métodos
 * asociados a esta.
 */
package Clases;

public class Comuna {
    private int id;         //Identificador de comuna.
    private String nombre;  //Nombre de la comuna.
    private double costo;   //Costo de colocar la antena en comuna.
    
    /**
     * Constructo de Comuna
     * @param id int
     * @param nombre String
     * @param costo double
     */
    public Comuna(int id, String nombre, double costo) {
        this.id = id;
        this.nombre = nombre;
        this.costo = costo;
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
}
