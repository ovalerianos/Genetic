package mx.robot;

public class Maze {
	
	private final int maze[][];
	
	private int startPosition[] = {-1,-1};
	
	public Maze(int maze[][]) {
		this.maze=maze;
	}
	
	public int[] getStartPosition(){
		//Check if we have already found start position
		if(this.startPosition[0]!=-1 && this.startPosition[1]!=1){
			
			return this.startPosition;
			
		}
		//Default return value
		int startPosition[] = {0,0};
		//Loop over rows
		for (int rowIndex = 0; rowIndex < this.maze.length; rowIndex++) {
			//Loop over columns
			for (int colIndex = 0; colIndex < this.maze.length; colIndex++) {
				//2 is type for start position
				if(this.maze[rowIndex][colIndex] == 2){
					this.startPosition = new int[]{colIndex,rowIndex};
					return new int[]{colIndex,rowIndex};
				}
				
			}	
			
		}
		
		
		return startPosition;
	}
	
	public int getPositionValue(int x, int y){
		
		return 0;
	}
	 
	
	

}
