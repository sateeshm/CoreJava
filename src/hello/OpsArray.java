package hello;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class OpsArray {

	
	public static void main(String[] args) {
		int[] aArray = {23,21,12,34,12,11,12,232,23,45} ;  
		//quickSort(aArray);
		//printOdd(aArray);
		//moveEvenToFirst(aArray);
		//printUniqueAndDuplicate(aArray);
		//printFibnocciNumbers();
		//palindromeOrNot(aArray);
		//mergeSortRecursion(aArray);
		printDigit();
		
	}
	
	private static void sortArry(int[] theArray, int firstindex, int lastindex){
		//Arrays.sort(theArray);
		if (theArray ==null || theArray.length ==0) {
			return;
		}
		if (firstindex >= lastindex){
			return;
		}
		int p  = theArray[firstindex + (lastindex-firstindex)/2];
		int i = firstindex;
		int j = lastindex;
		while (i <= j) {
			if (theArray[i] < p){
				i++;
			} 
			if (theArray[j] > p ) {
				j--;
			}
			 
			if (i <=j){
				int temp;
				temp = theArray[i];
				theArray[i] = theArray[j];
				theArray[j] = temp;
				i++; j--;
			}
		}
		
		if (firstindex < j){
			sortArry(theArray, firstindex, j);
		}
		
		if (lastindex > i){
			sortArry(theArray,i, lastindex);
			
		}
	}
		
	private static void quickSort(int[] aArray){
		System.out.println("Array before:"+ Arrays.toString(aArray));
		int size = aArray.length-1;
		sortArry(aArray, 0, size);
		System.out.println("Array after:"+ Arrays.toString(aArray));
	}
	
	private static void printOdd(int[] aArray){
		System.out.println("print Odd");
		for (int i=0; i<=aArray.length-1; i++){
			if (aArray[i] % 2 != 0){
				System.out.println("Odd Numbers:" + aArray[i]);
			}
		}
		
	}
	
	private static void moveEvenToFirst(int[] aArray){
		System.out.println("Move Even to First");
		int i= 0; int j = 0;
			while(j <= aArray.length-1){
				if (aArray[j] % 2 == 0 ){
					int temp;
					temp = aArray[i];
					aArray[i] = aArray[j];
					aArray[j] = temp;
					i++;
				}
				j++;
			}	
		System.out.println("Array"+ Arrays.toString(aArray));
		
	}
	
	private static void printUniqueAndDuplicate(int[] aArray){
		System.out.println("printUniqueAndDuplicate");
		System.out.println("Array: "+Arrays.toString(aArray));
		int size = aArray.length;
		
		Integer[] ints = new Integer[size];
		int i = 0;
		for(int value : aArray){
			ints[i++] = Integer.valueOf(value);
		}
		
		
		for(Integer tups: ints){
			System.out.println("Occurences: "+tups+":"+Collections.frequency(Arrays.asList(ints), tups));
		
		}
		
		//Uniques
		Set<Integer> uniques = new TreeSet<Integer>();
		uniques.addAll(Arrays.asList(ints));
		
		System.out.println("Uniques:"+ uniques.toString());
		
	}
	
	private static void printFibnocciNumbers(){
		int i = 10;
		for (int k =1; k<=i; k++){
			System.out.println("Print the series: " + fibSeries(k));
		}
	}
	
	
	private static int fibSeries(int number){
		if (number == 1 || number == 2){
			return 1;
		}
		return fibSeries(number - 1) + fibSeries(number - 2);
		
//		int fib1 = 1; int fib2 = 1; int fibonocci = 1;
//		
//		for (int i = 3; i<=number; i++){
//			fibonocci = fib1+fib2;
//			fib1 = fib2;
//			fib2 = fibonocci;
//		}
//		return fibonocci;
	}
	
	private static void palindromeOrNot(int aArry[]){
		int aLength = aArry.length;
		for (int i=0; i<aLength; i++){
			System.out.println("Actual value: "+aArry[i]);
			if (reverse(aArry[i]) == aArry[i]){
				 System.out.println(aArry[i]+" - Palindrome");
			 } else {
				 System.out.println("Not Palindrome");
			 }
		}
	}
	
	private static int reverse(int rev){
		int reverseNum = 0;
		while (rev != 0){
			reverseNum = reverseNum *10;
			reverseNum = reverseNum + rev % 10;
			rev = rev / 10;
		}
		System.out.println("reverseNum : "+ reverseNum);
		return reverseNum;
	}
	
	private static void mergeSortRecursion(int aArry[]){
		int len = aArry.length;
		System.out.println("Array Before: "+Arrays.toString(aArry));
		sort(aArry,0,len);
		System.out.println("Array: After: "+Arrays.toString(aArry));
	}
	
	public static void sort(int[] a, int low, int high) 
		    {
		        int N = high - low;         
		        if (N <= 1) 
		            return; 
		        int mid = low + N/2; 
		        // recursively sort 
		        sort(a, low, mid); 
		        sort(a, mid, high); 
		        // merge two sorted subarrays
		        int[] temp = new int[N];
		        int i = low, j = mid;
		        for (int k = 0; k < N; k++) 
		        {
		            if (i == mid)  
		                temp[k] = a[j++];
		            else if (j == high) 
		                temp[k] = a[i++];
		            else if (a[j]<a[i]) 
		                temp[k] = a[j++];
		            else 
		                temp[k] = a[i++];
		        }    
		        for (int k = 0; k < N; k++) 
		            a[low + k] = temp[k];         
	    }
	
	private static void printDigit(){
		int k = 345879;
		System.out.println("Mod: "+ k%10);
		System.out.println("Div: "+ k/10);
	}
	
}


