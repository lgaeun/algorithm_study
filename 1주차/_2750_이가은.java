package 정렬;
import java.util.Scanner;

public class _2750 {
	
	static void insertionSort(int size, int[] array) {
		int i, j, temp;
		
		for(i = 0; i < size; i++) {
			j = i;
			while( j > 0 && array[j-1] > array[j]) {
				temp = array[j-1];
				array[j-1] = array[j];
				array[j] = temp;
				j--;
			}
		}
		
		for(i = 0; i < size; i++)
			System.out.println(array[i]);
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] arr = new int [n];
		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		
		insertionSort(n, arr);
		
	}

}
