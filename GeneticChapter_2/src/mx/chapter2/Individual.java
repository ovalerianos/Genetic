package mx.chapter2;

public class Individual {
	
	private int[] chromosome;
	
	private double fitness = -1;
	
	public Individual(int[] chromosome) {
		this.chromosome=chromosome;
	}
	
	
	public Individual(int chromosomeLength) {
		
		this.chromosome = new int[chromosomeLength];
		
		for (int gene = 0; gene < chromosomeLength; gene++) {
			
			if(0.5 > Math.random()){
				setGene(gene, 1);
			}else{
				setGene(gene, 0);
			}
			
		}
		
		
	}
	
	public int[] getChromosome() {
		return chromosome;
	}
	
	public int getChromosomeLength(){
		
		return this.chromosome.length;
	}
	
	
	public void setGene(int offset, int gene){
		
		this.chromosome[offset]=gene;
		
	}
	
	public int getGene(int offset){
		
		return this.chromosome[offset];
	}
	
	public void setFitness(double fitness) {
		this.fitness = fitness;
	}
	
	public double getFitness() {
		return fitness;
	}
	
	public String toString(){
			String out = "";
			
			for (int gene = 0; gene < this.chromosome.length; gene++) {
				out += this.chromosome[gene];
			}
			
		return out;
	}
	
	

}
