package Clases;

import java.util.Random;

public class AG {
	
	int fitness;
	int sizeElement;
	double mutationProb;
	int elementQuantity;
	int iterations;
	int crossingCromosomes;
	int bestFitness[];
	int ids[];
	double prices[];
	int comunes[][];
	
	public AG(int fitness, int sizeElement, double mutationProb, int elementQuantity, int iterations,
			int crossingCromosomes, int[] bestFitness, int[] ids, double[] prices, int[][] comunes) {
		super();
		this.fitness = fitness;
		this.sizeElement = sizeElement;
		this.mutationProb = mutationProb;
		this.elementQuantity = elementQuantity;
		this.iterations = iterations;
		this.crossingCromosomes = crossingCromosomes;
		this.bestFitness = bestFitness;
		this.ids = ids;
		this.prices = prices;
		this.comunes = comunes;
	}
	
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
	
	public int[][] createPoblation() {
		int poblation[][] = new int[this.elementQuantity][this.sizeElement];
		
		for (int j = 0; j < this.elementQuantity; j++)
		{
			poblation[j] = new int[this.elementQuantity];
			poblation[j] = this.createElement(0, 1);
		}
		
		return poblation;
	}
	
	public int fitnessCalc(int[] element) {
		double fitness = 0;
		for (int j = 0; j < this.sizeElement; j++)
		{
			if(element[j] == 1) {
				fitness += this.prices[j];
			}
		}
		return (int) fitness;
	}

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

	public int[][] reproduction(int[][] poblation){
		int fitnessCount = 0;
		double totalFitness= 0;
		int [] fat = new int[poblation.length];
		double [][] data = new double [poblation.length][poblation[0].length]; 
		
		double [][]evaluatedPop = new double [poblation.length][poblation[0].length]; 
		
		for(int i = 0; i < poblation.length; i++ ) {
			evaluatedPop[i][0] = fitnessCalc(poblation[i]);
			evaluatedPop[i][i] = i;
		}
		for(int i = 0; i < evaluatedPop.length; i++ ) {
			fitnessCount += evaluatedPop[i][0];
			totalFitness = fitnessCount;
			fitnessCount = 0;

		}
		for(int i = 0; i < evaluatedPop.length; i++ ) {
			data[0][i] = evaluatedPop[i][0] / totalFitness ;
			fitnessCount += data[0][i];
			data[1][i] = fitnessCount;
		}
		int random = (int) Math.random();
		for(int i = 0; i < evaluatedPop.length; i++ ) {
			if(random < data[1][i]) {
				fat = poblation[i];
			}
		}
		this.iterations = (poblation.length/2);
		int [][]result;
		while(this.iterations != 0)
		{
			random = (int) Math.random()*poblation.length - 1;
			result = this.crossover(fat, poblation[random]);
			fat = result[0];
			poblation[random] = result[1];
			this.iterations -=1;
		}
		bestFitnessPoblation(poblation, this.bestFitness);
		return poblation;
		
	}
        
        public int[][] mutation (int[][] poblation) {
            
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

	public int [] bestFitnessPoblation(int[][] poblation, int[] bestFitness2) {
		System.out.print(bestFitness2);
		for(int i = 0; i < poblation.length - this.crossingCromosomes; i++ ) {
			if (elementValidate(poblation[i]) == true)
			{
				if((this.fitnessCalc(poblation[i]) < bestFitness2[0])) {
					bestFitness2[0] = this.fitnessCalc(poblation[i]);
					bestFitness2[0] =  poblation[i][0];
				}
			}	
		}
		return bestFitness2;
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

	
			
}
	