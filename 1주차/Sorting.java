package week1;
import java.util.*;

public class Sorting {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int array[] = new int[num];
		
		for(int i=0; i<num ; i++) {
			array[i]=sc.nextInt();
		}	
		
		int arr[]=quicksort(array,0,num-1);
		
		for(int i=0; i<num ; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static void swap(int a, int b, int[] arr) {
		int temp=arr[b];
		arr[b]=arr[a];
		arr[a]=temp;
	}
	
	public static int sort(int[] arr, int left, int right) {
		int low=left;
		int high=right+1;
		int pivot=arr[left];
		
		do {
			do{
				low++;
			}while(low<=right&&arr[low]<pivot);
		
			do {
				high--;
			}while(high>=left&&arr[high]>pivot);
		
			if (low<high) {
				swap(low,high,arr);
			}
		}while(low<high);
		
		swap(left,high,arr);
		
		return high;
	}
	
	public static int[] quicksort(int[] arr, int left, int right) {
		if(left<right) {
			int p=sort(arr,left,right);
			quicksort(arr,left,p-1);
			quicksort(arr,p+1,right);
		}
		return arr;
	}
	
}

