package assignment_01_03_MST;

public class heap {

	final static int heap_col_no = 2;

	public static int right(int[][] a, int heap_size, int i) {
		if (2 * i + 1 <= heap_size) {
			return 2 * i + 1;
		} else {
			return i;
		}
	}

	public static int left(int[][] a, int heap_size, int i) {
		if (2 * i + 2 <= heap_size) {
			return 2 * i + 2;
		} else {
			return i;
		}
	}

	public static int parent(int[][] a, int i) {
		if (i / 2 >= 0) {
			return i / 2;
		} else {
			return i;
		}
	}

	public static void heapify(int[][] a, int heap_size, int i) {
		int left = left(a, heap_size, i);
		int right = right(a, heap_size, i);
		
		int largest = i;
		if (a[largest][heap_col_no]>=a[left][heap_col_no]){
			largest = left;
		}
		
		if(a[largest][heap_col_no]>=a[right][heap_col_no]){
			largest=right;
		}
		
		
		if (largest!=i){
			int[] temp = a[largest];
			a[largest]=a[i];
			a[i]=temp;
			heapify(a, heap_size, largest);
		}
	}
	
	public static void buildHeap(int[][] a){
		int heap_size = a.length;
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
		int[][] a = {{1,2,5},{6,3,9},{4,2,7},{3,6,10},{2,4,7}};
		/*buildHeap(a);
		for (int i=0; i<a.length; i++){
			for (int j=0; j<a[i].length; j++)
				System.out.print(a[i][j]+",");
			System.out.println();
		}
		System.out.println();*/
		heapSort(a);
		for (int i=0; i<a.length; i++){
			for (int j=0; j<a[i].length; j++)
				System.out.print(a[i][j]+",");
			System.out.println();
		}
		System.out.println();
	}
}
