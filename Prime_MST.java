package assignment_01_03_MST;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


public class Prime_MST {
	
	public static int[] mst(int[][] edge){

		heap.buildHeap(edge);
		int heap_size = edge.length-1;
		
		int node_cnt = NodeMax(edge);
		
		//declare and initialize nodeCollection, initially, each node connect to itself
		int[] nodeCollection = new int[node_cnt];
		for (int i=0; i<nodeCollection.length; i++){
			nodeCollection[i]=i;
		}
		
		// in a mst, N nodes has N-1 edges
		int[] mst = new int[node_cnt-1];
		int edge_cnt = 0;
		
		while (edge_cnt<node_cnt-1){
			
			int[] minEdge = edge[0];
			int node_a = minEdge[0]-1;
			int node_b = minEdge[1]-1;
			
			if (!MergeNodes.connected(nodeCollection, node_a, node_b)){
				mst[edge_cnt]=edge[0][2];
				edge_cnt++;
				MergeNodes.nodeMerge(nodeCollection, node_a, node_b);
			}
			
			//swap edge[0] and edge[max], heap_size -1 and heapify the edge array again
			int[] temp = edge[0];
			edge[0]=edge[heap_size];
			edge[heap_size]=temp;
			heap_size--;
			heap.heapify(edge, heap_size, 0);
		}
		return mst;
		
	}
	
	public static int NodeMax(int[][] edge){
		//find the node count
		int nodeMax=0;
		for (int i=0; i<edge.length; i++){
			for (int j=0; j<=1; j++){
				if (edge[i][j]>=nodeMax){
					nodeMax=edge[i][j];
				}
			}
		}
		return nodeMax;
	}
	
	
	public static void main(String[] args) throws IOException{
		String filePath = "/Users/wenhuawang/Documents/Coursera/Algorithm_Standford_02_Jun2014/Assignment_01/edges.txt";
		
		int startLine = 1;
		int[][] edge = importData.importData(filePath, startLine);
		
		int[] tree = mst(edge);
		int edgeSum=0;
		System.out.println("mst:");
		for (int i=0; i<tree.length; i++){
			System.out.print(tree[i]+" ");
			edgeSum=edgeSum+tree[i];
		}
		System.out.println();
		System.out.println("edgeSum="+edgeSum);
	}
	
	
	
}
