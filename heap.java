package assignment_01_03_MST;

public class heap {

	final static int heap_col_no = 2;

	public static int right(int[][] a, int i) {
		return 2 * i + 1;
	}

	public static int left(int[][] a, int i) {
		return 2 * i + 2;
	}

	public static int parent(int[][] a, int i) {
		if (i / 2 >= 0) {
			return i / 2;
		} else {
			return i;
		}
	}

	public static void heapify(int[][] a, int heap_size, int i) {
		int left = left(a, i);
		int right = right(a, i);
		
		int smallest = i;
		if (left <= heap_size && a[smallest][heap_col_no]>a[left][heap_col_no]){
			smallest = left;
		}
		
		if(right <= heap_size && a[smallest][heap_col_no]>a[right][heap_col_no]){
			smallest=right;
		}
		
		
		if (smallest!=i){
			int[] temp = a[smallest];
			a[smallest]=a[i];
			a[i]=temp;
			heapify(a, heap_size, smallest);
		}
	}
	
	public static void buildHeap(int[][] a){
		int heap_size = a.length-1;
		for (int i=a.length/2-1; i>=0; i--){
			heapify(a, heap_size, i);
		}
	}
	
	public static void heapSort(int[][] a){
		buildHeap(a);
		int heap_size=a.length-1;
		for (int i=a.length-1; i>=1; i--){

			int[] temp = a[0];
			a[0]=a[i];
			a[i]=temp;
			heap_size--;
	
			heapify(a, heap_size, 0);
			
		}
	}
	public static void main(String[] args){
		int[][] a = {{103, 221, 4},{152, 414, 1},{136, 259, 1},{103, 454, 1},{461, 462, 2},{45, 304, 3},{73, 380, 1}};
		
		heapSort(a);
		for (int i=0; i<a.length; i++){
			for (int j=0; j<a[i].length; j++)
				System.out.print(a[i][j]+",");
			System.out.println();
		}
		System.out.println();
		
	}
}
