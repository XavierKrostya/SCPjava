/*
 * Clase que contiene el main, el cual se encargará de ejecutar
 * el programa.
 * @author Luis Maturana, Mauricio Rivera, Carlo Ardila y Javier Ortiz
 */

//Bibliotecas y paquetes
package Clases;
public class TestMain {
    
    /**
     * Es el método main para correr el programa.
     * @param args 
     */
    public static void main(String[] args) {
        /*Variables que iniciales*/
        int fitness = -1, sizeElement = 36, elementQuantity = 200, iterations = 300, crossingCromosomes = 3, fitnessCount = 0;
        double mutationProb = 0.2;
        
        /*Se declara la mejor solucion*/
        int[] bestFitness = new int[sizeElement];
        
        /*Arreglos de identificador y costos, además de una matriz con las comunas con sus respectivos vecinos*/
        int[] ids = {2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,33,34,35,36,37,38};
        double[] prices = {1,2,1.2,1.5,3,2,1,1,3,4,3,3,2,2.5,1.5,2,2,3,2,2,3,2,3,3,1,2.5,2,3.5,3,1.5,2,2,3.5,2,2.5,1,5};
        int[][] comunes = {{2,3,4},{3,2,5,28},{4,25,26,28,2},{5,3,29,27},{6,7,9,27,24,15},{7,8,9,10,6,15},{8,7,10},{9,7,6},
            {10,8,7,15,33},{11,12,24,25,16,17},{12,15,11,13},{13,12,15,33,17},{14,17,16,37,34,31},{15,10,7,6,24,12,11,13,33},
            {16,34,14,17,11},{17,13,11,16,14,35,33},{18,30,20},{19,22,21,30},{20,18,30,21},{21,20,30,19},{22,19,23},{23,22},
            {24,28,26,11,15,6},{25,11,24,26,4},{26,24,28,4,25},{27,5,29,28,6},{28,26,24,27,29,3,4},{29,5,3,28,27},{30,19,21,20,18,36,34},
            {31,35,14,34,38},{33,10,15,13,17,35},{34,30,36,38,37,14,16},{35,33,17,31},{36,38,34,30},{37,34,14},{38,31,34,36}};
        
        AG program = new AG(fitness,sizeElement,mutationProb,elementQuantity,iterations,crossingCromosomes,fitnessCount,bestFitness,ids,prices,comunes);
    }
}
