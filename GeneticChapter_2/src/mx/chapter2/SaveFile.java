package mx.chapter2;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SaveFile {
	
	public static final String path="/home/ovalerianos/ga/";
	
	public static int fileCount=0;
	
	public static void writeFile(String nameFile,List<String> lines)throws Exception{
		Path file = Paths.get(path+nameFile);
		Files.write(file, lines, Charset.forName("UTF-8"));
	}
	
	public static int getFileCount() {
		fileCount++;
		return fileCount;
	}
	
	public static List<String> toLstIndividuals(Individual[] individuals){
		List<String> lstIndividuals = new ArrayList<String>();
		
		for (int i = 0; i < individuals.length; i++) {
			Individual individual = individuals[i];
			lstIndividuals.add(individual.toString());
			
		}
		
		return lstIndividuals;
	}
	
	

}
