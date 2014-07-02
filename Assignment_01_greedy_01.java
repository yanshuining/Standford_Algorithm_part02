package greedy_01;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class greedy_01 {

	@SuppressWarnings("resource")
	public static int[][] readLines(String filename) throws IOException{
		FileReader fileReader = new FileReader(filename);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		Scanner dataIn=null;
		dataIn = new Scanner(bufferedReader);
		String InputLine;
		
		List<List<Integer>> arrayOut = new ArrayList<List<Integer>>();
		
		int skipLine = 0;
		while(dataIn.hasNextLine()){
			InputLine = dataIn.nextLine();
			if (skipLine>=1){
				String[] InArray = InputLine.split(" ");
				List<Integer> rowOut = new ArrayList<Integer>();
				
				for (int i=0; i<InArray.length; i++){
					rowOut.add(Integer.parseInt(InArray[i]));
				}
				arrayOut.add(rowOut);
			}
			skipLine++;
		}

		bufferedReader.close();
		
		int[][] data = new int[arrayOut.size()][arrayOut.get(0).size()];
		for (int i=0; i<arrayOut.size(); i++){			
			for (int j=0; j<arrayOut.get(i).size();j++){
				data[i][j]=arrayOut.get(i).get(j);
			}
		}
		
		return  data;
	}
	
	public static int qs_partition(int[][] inarray, int left, int right){
		int pivot = inarray.length/2;
		//swap pivot and rightmost element
		int[] temp = inarray[pivot];
		inarray[pivot]=inarray[right];
		inarray[right]=temp;
		
		int storeIndex = left;
		for (int i=left; i<=right-1; i++){
			if (inarray[i][0]-inarray[i][1] > (temp[0]-temp[1]))
			{
				int[] tmp = inarray[i];
				inarray[i]=inarray[storeIndex];
				inarray[storeIndex]=tmp;
				storeIndex++;
			}
			else if(inarray[i][0]-inarray[i][1] == (temp[0]-temp[1]))
			{
				if (inarray[i][0] >
				temp[0]){
					int[] tmp = inarray[i];
					inarray[i]=inarray[storeIndex];
					inarray[storeIndex]=tmp;
					storeIndex++;
				}
			}
		}
		//swap inarray[storeIndex] and inarray[right]
		temp = inarray[right];
		inarray[right] = inarray[storeIndex];
		inarray[storeIndex]=temp;
		
		return storeIndex;
	}
	
	public static void quickSort(int[][] weight_length, int left, int right){
		if (left<right){
			int p = qs_partition(weight_length, left, right);
			quickSort(weight_length, left, p-1);
			quickSort(weight_length, p+1, right);
		}
	}
	
	
	
	public static void main (String[] args) throws IOException{
		String filename = "C:/Users/Wenhua/Google Drive/Coursera-STD-algorithm2/assignment1/jobs.txt";
		int[][] file = readLines(filename);
		int length=file.length;

		int completionTime = 0;
		int weightSum=0;
		
		System.out.println("************");
		quickSort(file, 0, file.length-1);
		/*int index=0;
		for (int i=0; i<length; i++){
			System.out.print(index+" ");
			for (int j=0; j<file[i].length; j++){
				System.out.print(file[i][j]+" ");
			}

			completionTime+=file[i][1];
			weightSum = weightSum+file[i][0]*completionTime;
			
			System.out.print(file[i][0]-file[i][1]);
			System.out.print(" "+completionTime);
			System.out.print(" "+weightSum);
			System.out.println();
			index++;
		}*/
		

		for (int i=0; i<length; i++){
			completionTime+=file[i][1];
			weightSum = weightSum+file[i][0]*completionTime;			
		}
		System.out.println("weightSum="+weightSum);
	}
}
