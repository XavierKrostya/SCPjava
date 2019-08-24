package Clases;
import java.util.Random;


public class AG {
	
	int fitness;            //Fitness inicial
	int sizeElement;        //cantidad de vecinos que tiene el elemento
	double mutationProb;    //probabilidad de mutacion
	int elementQuantity;    //numero del elemento
	int iterations;         //cantidad de iteracciones
	int crossingCromosomes; //cantidad de cromosomas por cruzar
	int fitnessCount = 0;   //contador para el fitness
	int bestFitness[];      //vector que contendr� el mejor Fitness
	int ids[];          //vector que contiene los identificadores de las comunas
	int prices[];       //vector que contiene los costos de cada comuna
	int comunes[][];    //matriz que contiene la poblacion inicial del problema
	
        /**
         * Constructor para la clase AG; se guardar�n todos los datos
         * ingresados por parametro.
         * @param fitness int
         * @param sizeElement int   
         * @param mutationProb double
         * @param elementQuantity int
         * @param iterations int
         * @param crossingCromosomes int
         * @param fitnessCount int
         * @param bestFitness int[]
         * @param ids int[]
         * @param prices int[]
         * @param comunes int[][]
         */
	public AG(int fitness, int sizeElement, double mutationProb, int elementQuantity, int iterations,
			int crossingCromosomes, int fitnessCount, int[] bestFitness, int[] ids, int[] prices, int[][] comunes) {
		super();
		this.fitness = fitness;
		this.sizeElement = sizeElement;
		this.mutationProb = mutationProb;
		this.elementQuantity = elementQuantity;
		this.iterations = iterations;
		this.crossingCromosomes = crossingCromosomes;
		this.fitnessCount = fitnessCount;
		this.bestFitness = bestFitness;
		this.ids = ids;
		this.prices = prices;
		this.comunes = comunes;
	}
	
        /**
         * M�todo para crear un elemento en un vector
         * @param min int
         * @param max int
         * @return int[]
         */
	public int[] createElement(int min, int max) {
		int element[] = new int[this.sizeElement];
		
		for (int i = 0; i < this.sizeElement; i++)
		{
			element[i] = (int)(Math.random()*max + min);
		}
		
		if(!elementValidate(element))
		{
			while(!elementValidate(element))
			{
				for (int j = 0; j < this.sizeElement; j++)
				{
					element[j] = (int)(Math.random()*max + min);
				}
			}	
		}
		return element;
	}
	
        /**
         * Crear la poblacion y guardarla en una matriz
         * @return int[][]
         */
	private int[][] createPoblation() {
		int poblation[][] = new int[this.elementQuantity][this.sizeElement];
		
		for (int j = 0; j < this.elementQuantity; j++)
		{
			poblation[j] = new int[this.elementQuantity];
			poblation[j] = this.createElement(0, 1);
		}
		
		return poblation;
	}
	
        /**
         * Calcular el fitness de un elemento entregado por par�metro.
         * @param element int[]
         * @return double
         */
	private double fitnessCalc(int[] element) {
		double fitness = 0;
		for (int j = 0; j < this.sizeElement; j++)
		{
			if(element[j] == 1) {
				fitness += this.prices[j];
			}
		}
		return fitness;
	}
        
        /**
         * Validar un elemento entregado por par�metro.
         * @param element int[]
         * @return boolean
         */
	private boolean elementValidate(int[] element) {
		int count = 0;
		int [] validate = new int[sizeElement];
		
		for (int j = 0; j < this.sizeElement; j++)
		{
			validate[j] = 0;
		}
		for (int i = 0; i < this.sizeElement; i++)
		{
			if(element[i] == 1)
			{
				for (int k = 0; k < this.comunes[i].length; k++)
				{
					if(k > 31) {
						validate[k - 3] = 1;
					}
					if(k <= 31) {
						validate[k - 2] = 1;
					}
				}
			}
		}
		for (int j = 0; j < this.sizeElement; j++)
		{
			if(validate[j] != 0) {
				count++;
			}
		}
		if(count == element.length) {
			return true;
		}
		return false;
	}
	
        /**
         * Permite realizar el cruzamiento de dos elementos padres, y retornar�
         * los hijos resultantes
         * @param elementF int[]
         * @param elementM int[]
         * @return int[][]
         */
	private int[][] crossover(int[] elementF, int[] elementM) {
		
		int breakpoint = (int) Math.random()*(elementF.length-1) + 1;
		
		int [] childA = new int [elementF.length];
		int [] childB = new int [elementF.length];
		
		
	    for (int i = breakpoint; i < elementF.length; i++) {
	        int temp = elementF[i];
	        childA[i] = elementM[i];
	        childB[i] = temp;
	    }
		
		int[][] childs = new int[2][elementF.length];
		childs[0] = childA;
		childs[1] = childB;
		return childs;
		
	}
        
        /*
        private int[] seachTheBestFitnessPoblation(int[][] poblation, int[] bestFitness){
            for (int i = 0; i < sizeElement; i++){
                if(elementValidate(poblation[i])){
                    if((fitnessCalc(poblation[i])) < bestFitness[0]){
                        bestFitness = bestFitness[calcularFitness(poblation[i])][poblation[i]];
                    }
                }
            }
            return bestFitness;
        }
        */
        
        /**
         * Permite mutar la poblacion.
         * @param poblation int[][]
         * @return int[][]
         */
        private int[][] mutation (int[][] poblation) {
            
                double random = 0;
                int point = 0;
                int value = 0;
                Random randomBoolean = new Random();
                        
                for (int i = 0; i < sizeElement; i++) {
                    random = Math.random();
                    
                    if (random <= mutationProb) {
                        random = ((Math.random() * (sizeElement - 1)) + 1);
                        point = (int)random;
                        value = randomBoolean.nextInt(1);
                        
                        while (value == poblation[i][point]) {
                            value = randomBoolean.nextInt(1);
                        }
                        poblation[i][point] = value;
                    }
                }
                return poblation;
        }


	public int getFitness() {
		return fitness;
	}
	public void setFitness(int fitness) {
		this.fitness = fitness;
	}
	public int getSizeElement() {
		return sizeElement;
	}
	public void setSizeElement(int sizeElement) {
		this.sizeElement = sizeElement;
	}
	public double getMutationProb() {
		return mutationProb;
	}
	public void setMutationProb(double mutationProb) {
		this.mutationProb = mutationProb;
	}
	public int getElementQuantity() {
		return elementQuantity;
	}
	public void setElementQuantity(int elementQuantity) {
		this.elementQuantity = elementQuantity;
	}
	public int getIterations() {
		return iterations;
	}
	public void setIterations(int iterations) {
		this.iterations = iterations;
	}
	public int getCrossingCromosomes() {
		return crossingCromosomes;
	}
	public void setCrossingCromosomes(int crossingCromosomes) {
		this.crossingCromosomes = crossingCromosomes;
	}
	public int getFitnessCount() {
		return fitnessCount;
	}
	public void setFitnessCount(int fitnessCount) {
		this.fitnessCount = fitnessCount;
	}	
	
			
}
	