package assignment_01_03_MST;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class importData {
	public static int[][] importData(String filePath, int startLine) throws IOException{
		
		FileReader fileReader = new FileReader(filePath);
		BufferedReader br = new BufferedReader(fileReader);
		Scanner dataIn = new Scanner(br);
		List<String[]> dataArray = new ArrayList<String[]>();
		
		int line = 0;
		while(dataIn.hasNext()){
			String theLine = dataIn.nextLine();
			if(line>=startLine){
				String[] arrayLine = theLine.split(" ");
				dataArray.add(arrayLine);
				
			}
			line++;
		}
		int[][] dataOut = new int[dataArray.size()][dataArray.get(0).length];
		for (int i=0; i<dataArray.size(); i++){
			for(int j=0; j<dataArray.get(i).length; j++){
				dataOut[i][j]=Integer.parseInt(dataArray.get(i)[j]);
			}
		}
		
		return dataOut;
	}
	
	
	
	public static void main(String[] args) throws IOException{
		String file = "/Users/wenhuawang/Documents/Coursera/Algorithm_Standford_02_Jun2014/Assignment_01/jobs.txt";
		int startLine = 1;
		int[][] out = importData(file, startLine);
		for (int i=0; i<out.length; i++){
			for (int j=0; j<out[i].length; j++){
				System.out.print(out[i][j]+" ");
			}
			System.out.println();
		}
	}
}
