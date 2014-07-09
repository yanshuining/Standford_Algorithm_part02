package assignment_01_03_MST;

public class MergeNodes {
	public static int nodeRoot(int[] nodes, int i){
		
		int parent = nodes[i];
		while (parent != i){
			i=parent;
			parent=nodes[i];
		}
		
		return i;
	}
	
	public static boolean connected(int[] nodes, int a, int b){
		if (a==b)
			return true;
		if (nodeRoot(nodes,a)==nodeRoot(nodes, b)){
			return true;
		}
		else{
			return false;
		}
	}
	
	
	public static int rootLevel(int[] nodes, int i){
		int parent = nodes[i];
		int level = 0;
		while (parent!=i){
			i=parent;
			parent=nodes[i];
			level++;
		}
		return level;
	}
	
	public static void nodeMerge(int[] nodes, int a, int b){
		
		int root_a = nodeRoot(nodes, a);
		int root_b = nodeRoot(nodes, b);
		
		if (rootLevel(nodes, a)>rootLevel(nodes, b)){
			nodes[root_b]=root_a;
		}
		else{
			nodes[root_a]=root_b;
		}
	}
	
	public static void main(String[] args){
		int[] nodes = {0,1,2,3,4,5};
		
		nodeMerge(nodes, 1, 2);
		for (int i=0; i<nodes.length; i++){
			System.out.print(nodes[i]+" ");
		}
		System.out.println();
		nodeMerge(nodes, 0, 3);
		for (int i=0; i<nodes.length; i++){
			System.out.print(nodes[i]+" ");
		}
		System.out.println();
		nodeMerge(nodes, 1, 4);
		for (int i=0; i<nodes.length; i++){
			System.out.print(nodes[i]+" ");
		}
		System.out.println();
		nodeMerge(nodes, 3, 4);
		for (int i=0; i<nodes.length; i++){
			System.out.print(nodes[i]+" ");
		}
		System.out.println();
		nodeMerge(nodes, 2, 5);
		for (int i=0; i<nodes.length; i++){
			System.out.print(nodes[i]+" ");
		}
		System.out.println();
		
		System.out.println("node_0 and node_1 is connected?"+connected(nodes,0,1));
	}
}
