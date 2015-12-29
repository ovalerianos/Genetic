package mx.robot;

import mx.chapter2.Individual;
import mx.chapter2.Population;

public class RobotController {

	public static int maxGenerations = 1000;

	public static void main(String[] args) {
		/**
		 * 0 = Empty 1 = Wall 2 = Starting position 3 = Route 4 = Goal position
		 */
		Maze maze = new Maze(new int[][] { 
				{ 0, 0, 0, 0, 1, 0, 1, 3, 2 }, 
				{ 1, 0, 1, 1, 1, 0, 1, 3, 1 },
				{ 1, 0, 0, 1, 3, 3, 3, 3, 1 }, 
				{ 3, 3, 3, 1, 3, 1, 1, 0, 1 }, 
				{ 3, 1, 3, 3, 3, 1, 1, 0, 0 },
				{ 3, 3, 1, 1, 1, 1, 0, 1, 1 }, 
				{ 1, 3, 0, 1, 3, 3, 3, 3, 3 }, 
				{ 0, 3, 1, 1, 3, 1, 0, 1, 3 },
				{ 1, 3, 3, 3, 3, 1, 1, 1, 4 } 
				});
		
		// Create genetic algorithm
		GeneticAlgorithm ga = new GeneticAlgorithm(200, 0.05,0.9, 2, 10);
		Population population = ga.initPopulation(128);

		// Evaluate population
		ga.evalPopulation(population, maze);
		
		int generation = 1;
		// Start evolution loop
		
		while(ga.isTerminationConditionMet(generation,maxGenerations) == false){
			
			// Print fittest individual from population
			Individual fittest = population.getFittest(0);
			System.out.println("G" + generation + " Best solution (" + fittest.getFitness() + "): " + fittest.toString());
			
			//Apply crossover
			population = ga.crossoverPopulation(population);
			
			population = ga.crossoverPopulation(population);
			
//			SaveFile.writeFile("fileGa_"+SaveFile.getFileCount(), SaveFile.toLstIndividuals(population.getIndividuals()));
			
			
			//Apply mutattion
			population = ga.mutatePopulation(population);
			
//			SaveFile.writeFile("fileGa_"+SaveFile.getFileCount(), SaveFile.toLstIndividuals(population.getIndividuals()));
			
			//Evaluate population
			ga.evalPopulation(population,maze);
			
			//Increment the current generation
			generation++;
			
		}
			System.out.println("Stopped after " + maxGenerations + "generations.");
			Individual fittest = population.getFittest(0);
			System.out.println("Best solution (" + fittest.getFitness() + "): " + fittest.toString());
			
			int[] chromosome = fittest.getChromosome();
			Robot robot = new Robot(chromosome, maze, 100);
			System.out.println(robot.printSensorActions());
			robot.runFinal();
			
			System.out.println(robot.printRoute());
			
			System.out.println(robot.getLstDirection());

	}

	/**
	 * We'll implement the genetic algorithm pseudocode from chapter 2 here....
	 */
}
