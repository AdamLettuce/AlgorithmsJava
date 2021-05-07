package sorting.quick;

import java.util.stream.Collectors;
import java.util.*;
import java.util.Arrays;

public class Quick_v2 {
	public static void main(String[] args) {
		System.out.println("Hello!");
		System.out.println("We will sort an array for you using the Merge-Sort algorithm :)");
		System.out.println("Before starting to sort we have the following data: ");
		int[] data = new int[]{7,6,5,4,3,2,1,0};
		printArray(data);
		quickSort(data);
		System.out.println("After sorting we have the following data: ");
		printArray(data);

	}

	public static void quickSort(int[] A) {
		shuffle(A);
		quickSort(A,0,A.length-1);
	} 

	private static void quickSort(int[] A, int lo, int hi) {
		if(hi<=lo) return;
		int j=partition(A,lo,hi);
		quickSort(A, lo, j-1);
		quickSort(A, j+1, hi);
	}

	private static int partition(int[] a, int lo, int hi) {
		int i = lo;
		int j = hi+1;
		int v = a[lo];
		while(true) {
			while(a[++i]<v) {
				if(i==hi) {
					break;
				}
			}
			while(v<a[--j]) {
				if(j==lo) {
					break;
				}
			}
			if(i>=j) {
				break;
			}
			int tmp = a[i];
			a[i] = a[j];
			a[j] = tmp;
		}
		int tmp = a[lo];
		a[lo] = a[j];
		a[j] = tmp;
		return j;
	}

	private static void shuffle(int[] A) {
		int shuffledElementsCount = 0;
		boolean [] toShuffle = new boolean[A.length];
		for (int i=0; i<toShuffle.length; ++i) {
			toShuffle[i] = true;
		}

		Random random = new Random(59);
		
		while(shuffledElementsCount<A.length) {
			shuffledElementsCount = 0;	

			int r1 = Math.abs(random.nextInt())%A.length;
			while(toShuffle[r1]) {
				r1 = Math.abs(random.nextInt())%A.length;
				toShuffle[r1] = false;
			}

			int r2 = r1;
			while(r1==r2 || toShuffle[r2]) {
				r2 = Math.abs(random.nextInt())%A.length;
				toShuffle[r2] = false;
			}

			//replace
			int tmp = A[r1];
			A[r1] = A[r2];
			A[r2] = tmp; 

			//count shuffled elements
			for (int i=0; i<toShuffle.length; ++i) {
				if(toShuffle[i]==false) {
					++shuffledElementsCount;
				}
			}
		}
				
	}

	private static void printArray(int[] A) {
		for (int i=0; i<A.length-1; ++i) {
			System.out.print(A[i]+", ");
		}
		System.out.println(A[A.length-1]);
	}
}