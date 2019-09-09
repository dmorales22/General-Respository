public class lab4 {

    // Merge sort
    // This code is from geeksforgeeks.org/merge-sort/. Written by Rajat Mishra
    // This method is ran recursively 
    public static void mergeSort (int[] arr, int l, int r) {
		if (l < r) { 
			// Find the middle point 
			int m = (l + r) / 2; 
  
            // Sort first and second halves 
            mergeSort(arr, l, m); 
            mergeSort(arr , m + 1, r); 
  
            // Merge the sorted halves 
            mergeSort2(arr, l, m, r); 
        }
    }

    //This is the method that merges the array partitions. 
    public static void mergeSort2 (int[] arr, int l, int m, int r) {
		// Find sizes of two subarrays to be merged 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        /* Create temp arrays */
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
  
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i) 
			L[i] = arr[l + i]; 
        for (int j = 0; j < n2; ++j) 
            R[j] = arr[m + 1 + j]; 
  
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
  
        // Initial index of merged subarry array 
        int k = l; 
        while (i < n1 && j < n2) { 
            if (L[i] <= R[j]) { 
                arr[k] = L[i]; 
                i++; 
            } 
            else{ 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
        
    // Quick sort
    // This code is from geeksforgeeks.org/merge-sort/. Written by Rajat Mishra. 
    public static void quickSort(int[] arr, int low, int high) {
	
        if (low < high) { 
            /* pi is partitioning index, arr[pi] is now at right place */
            int pi = quickSortPartition(arr, low, high); 
  
            // Recursively sort elements before         int n = arr.length; 
			// partition and after partition
			quickSort(arr, low, pi - 1); 
			quickSort(arr, pi + 1, high); 
        }
    }

    //This is the second part to the quickSort method. Its function is to split the array up and sort the array. It is supposed to run
    //recursively in the quickSort method. 
    public static int quickSortPartition (int[] A, int low, int high) {
		int pivot = A[high];  //Selects pivot 
        int i = (low - 1); // index of smaller element 
        for (int j = low; j < high; j++) { 
            // If current element is smaller than or 
            // equal to pivot 
            if (A[j] <= pivot) {
                i++;
		
                // swap A[i] and arr[j] 
                int temp = A[i]; 
                A[i] = A[j]; 
                A[j] = temp; 
            }
        } 
  
        // swap arr[i+1] and arr[high] (or pivot) 
        int temp = A[i + 1]; 
        A[i + 1] = A[high]; 
        A[high] = temp; 
  
        return i + 1; 
    }
    
    //Insertion sort method
    //This code is from geeksforgeeks.org/insertion-sort/. Written by Rajat Mishra.
    public static void insertionSort (int[] arr) {// replace the name of this method by the name of your chosen algo
        int n = arr.length; 
        for (int i = 1; i < n; ++i) { 
            int key = arr[i]; 
            int j = i - 1; 
  
            /* Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
            while (j >= 0 && arr[j] > key) { 
				arr[j + 1] = arr[j]; 
                j = j - 1; 
            }
            arr[j + 1] = key; 
        }
    }
	
    // Proposed combination algorithm. The combination I chose was quick and insertion sort. It runs the first parts of quick sort, then
    // the insertionSort method is used to sort the partially sorted array.
    public static void quickInsertionSort (int[] arr, int high, int low) {
		//This will borrow the first part of the quick sort code.  
		if (low < high) { 
			/* pi is partitioning index, arr[pi] is now at right place */
			int pi = quickSortPartition(arr, low, high);
			
			//Leaves the array partially sorted. 
            quickSort(arr, low, pi - 1);
			}
			
			//the partially sorted array is then sorted by the insertionSort code. 
			insertionSort(arr); 
    }

    //Method to print arrays to validate functionality of the code. 
    public static void printArray (int[] A) {
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println(""); 
	}
    
    // Main method
	public static void main (String[] args) {
		//Test cases for arrays. 
	
		//int[]unsortedArray = {6, 2, 3, 4, 23, 5, 54, 69, 69, 231, 32, 0, 8, 7, 1, 9, 23, 45, 62};
		//int[]unsortedArray = {1, 3, 2};
		//int[]unsortedArray = {70, 65, 50, 1, 40, 41, 71, 84};
		//int[]unsortedArray = {1, 1, 3, 8, 8, 4, 1};  
		int[]unsortedArray = {9, 7, 6, 5, 4, 3, 2, 1};

		//creating array copies for sorting methods.
	
		int[] copy4mergeSort = unsortedArray;
		int[] copy4quickSort = unsortedArray;
		int[] copy4insertionSort = unsortedArray;
		int[] copy4quickInsertionSort = unsortedArray;

		//assigning array length to integer n, so it can be used in the following methods. 
		int n = unsortedArray.length;

	
		System.out.println("TESTING: Merge Sort");

		//using the Java function nanoTime to measure the time elasped when these methods execute and finish.
		//This is done in main since the methods are ran recursively, and would print out multiple times. 
		//The rest of main is similar to this.
	
		long startTime = System.nanoTime();
		mergeSort(copy4mergeSort, 0, n - 1);
		long stopTime = System.nanoTime();
		long elapsedTime = stopTime - startTime; 
		System.out.println("Time: " + elapsedTime); 
		printArray(copy4mergeSort);

		System.out.println("");

		//Quick sort setup 
		System.out.println("TESTING: Quick Sort");

		startTime = System.nanoTime();
		quickSort(copy4quickSort, 0, n - 1);
		stopTime = System.nanoTime(); 
		elapsedTime = stopTime - startTime;
		System.out.println("Time: " + elapsedTime); 
		printArray(copy4quickSort); 

		System.out.println(""); 
		
		//insertion sort setup
		startTime = System.nanoTime();
		System.out.println("TESTING: Insertion Sort");
		insertionSort(copy4insertionSort);
		stopTime = System.nanoTime();
		elapsedTime = stopTime - startTime;
		System.out.println("Time: " + elapsedTime); 
		printArray(copy4insertionSort);

		System.out.println(""); 
		
		//quick/insertion sort 
		startTime = System.nanoTime(); 
		System.out.println("TESTING: Quick and Insertion Sort");
		quickInsertionSort(copy4quickInsertionSort, 0, n - 1);
		stopTime = System.nanoTime();
		elapsedTime = stopTime - startTime;
		System.out.println("Time: " + elapsedTime); 
		printArray(copy4quickInsertionSort); 

	
    }
}
