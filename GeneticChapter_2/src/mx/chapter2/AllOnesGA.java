package mx.chapter2;

public class AllOnesGA {

	public static void main(String[] args) throws Exception{
		
		//Creacion de GA Object
		GeneticAlgorithm ga=new GeneticAlgorithm(100, 0.01, 0.95, 10);
		
		//Inicia population
		Population population = ga.initPopulation(50);
		
		SaveFile.writeFile("fileGa_"+SaveFile.getFileCount(), SaveFile.toLstIndividuals(population.getIndividuals()));
		
		
		ga.evalPopulation(population);
		
		int generation = 1;
		
		while(ga.isTerminationConditionMet(population) == false){
			
			//print fittest individual from population
			System.out.println("Best solution "+ population.getFittest(0).toString());
			
			//Apply crossover
			population = ga.crossoverPopulation(population);
			
			SaveFile.writeFile("fileGa_"+SaveFile.getFileCount(), SaveFile.toLstIndividuals(population.getIndividuals()));
			
			
			//Apply mutattion
			population = ga.mutatePopulation(population);
			
			SaveFile.writeFile("fileGa_"+SaveFile.getFileCount(), SaveFile.toLstIndividuals(population.getIndividuals()));
			
			//Evaluate population
			ga.evalPopulation(population);
			
			//Increment the current generation
			generation++;
			
		}
		
		System.out.println("Found solution in "+generation+" generations");
		System.out.println("Best solution: "+population.getFittest(0).toString());

	}

}
