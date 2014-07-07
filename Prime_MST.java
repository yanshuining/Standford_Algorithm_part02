package assignment_01_03_MST;

import java.io.IOException;


public class Prime_MST {
	
	public static void mst(int[][] edge){
		
		
		
	}
	
	public static void SortEdge(int[][] edge){
		heap.heapSort(edge);
	}
	
	public static void main(String[] args) throws IOException{
		String filePath = "/Users/wenhuawang/Documents/Coursera/Algorithm_Standford_02_Jun2014/Assignment_01/edges.txt";
		
		int startLine = 2;
		int[][] edge = importData.importData(filePath, startLine);
		

		heap.heapSort(edge);
		for (int i=0; i<edge.length; i++){
			for (int j=0; j<edge[i].length; j++){
				System.out.print(edge[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	
	
}
