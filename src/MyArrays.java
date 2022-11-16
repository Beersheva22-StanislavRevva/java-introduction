import java.util.Arrays;

public class MyArrays {

/**
 * 
 * @param array
 * @param number
 * @return new array added end a given number
 */
	
public static int[] addsNumber(int[] array, int number) {
	// use standart class Arrays, metod copyOf
	int[] newArray = Arrays.copyOf(array, array.length + 1);
	newArray[array.length] = number;
	return newArray;
}

/**
 * 
 * @param array
 * @param number
 * @return new array with no number at a given index in a given array
 * if index doesn't exist in a given array it returns the same array
 */

public static int[] removeNumber(int array[], int index) {
	//TODO
	// use standard class System, method arrayCopy
	
	int res[] = array;
	if (index > -1 && index < array.length) {
		res = new int[array.length - 1];
		System.arraycopy(array, 0, res, 0, index);
		System.arraycopy(array, index + 1, res, index, res.length - index);
	}
	
	return res;
}

/**
 * 
 * @param arraySorted - sorted array
 * @param number
 * @return new array with inserted number at an index for keeping array sorted
 */

public static int[] insertSorted(int arraySorted[], int number) {
	// use the method binarySearch of the standard class Arrays
	// use the method arraycopy of the standard class System
	int index = Arrays.binarySearch(arraySorted, number);
	if (index <0) {
		index = -(index + 1);
	}
	return insertAtIndex(arraySorted, number, index);
}

private static int[] insertAtIndex(int [] array, int number, int index) {
	int res[] = new int[array.length + 1];
	System.arraycopy(array, 0, res, 0, index);
	res[index] = number;
	System.arraycopy(array, index, res, index + 1, array.length - index);
	return res;
}

/**
 * 
 * @param arraySorted
 * @param number
 * @return index value if number exist, otherwise -1
 * O[N] - search number in unsorted array
 * O[LogN] - search number in sorted (binary search)
 */

public static int binarySearch(int arraySorted[], int number) {
	int left = 0;
	int right = arraySorted.length - 1;
	int middle = right / 2;
	while(left <= right && arraySorted[middle] != number) {
		if (number < arraySorted[middle]) {
			right = middle -1;
		} else {
			left = middle + 1;
		}
		middle = (left + right) / 2;
	}
	return left > right ? -1 : middle;
}

/**
 * 
 * @param arraySorted
 * @param number
 * @return index of left repeated number
 */

	public static int binarySearchRepeatedNumber(int arraySorted[], int number) {
		int left = 0;
		int right = (arraySorted.length);
		int middle = right / 2;
		while(left < right) {
			middle = (left + right) / 2;
			if (arraySorted[middle] < number) {
				left = middle + 1;
			} 
			else {
				right = middle;
			}
		}
		return left > right ? -1 : left;
	}
		
/**
 * 
 * @param arrayUnsorted
 * @return res = true if only one swap between two numbers is required for getting a sorted array
 */
	
	
	public static boolean isOneSwapForSorted (int arrayUnsorted[]) {
		
		int first = 0, second = 0;
	    int count = 0;
	    int[] newArray = Arrays.copyOf(arrayUnsorted, arrayUnsorted.length);
	    for (int i = 1; i < newArray.length; i++)
	    {
	        if (newArray[i] < newArray[i - 1])
	        {
	            count++;
	            if (first == 0) {
	                first = i;
	            }
	            else {
	                second = i;
	            }
	        }
	    }
	    if (count > 2) {
	        return false;
	    }
	    if (count == 0) {
	        return false;
	    }
	    if (count == 2) {
	        swap(newArray, first - 1, second);
	    }
	    else if (count == 1) {
	        swap(newArray, first - 1, first);
	    }
	    for (int i = 1; i < newArray.length; i++) {
	        if (newArray[i] < newArray[i-1])
	            return false;
	    }
	    return true;
			
	}
	
	
/**
* 
* @param newArray -given array
* @param i - index of 1st swapped element of array
* @param j - index of 2nd swapped element of array
* @return newArray - probably sorted array (array with swapped elements)
*/
	
	static public int[] swap(int []newArray, int i, int j)
	{
	    int temp = newArray[i];
	    newArray[i] = newArray[j];
	    newArray[j] = temp;
	    return newArray;
	}

/**
 * 
 * @param arrayUnsorted - unsorted array
 * @return arrayUnsorted - array sorted with bubble sort 
 */
	
	public static int [] bubbleSort(int arrayUnsorted []){
	boolean changes = false;
	while (changes == false) {
		changes = true;
    	for (int i = 0; i < (arrayUnsorted.length - 1); i++) {
    		if (arrayUnsorted[i] > arrayUnsorted[i+1]) {
    			MyArrays.moveGreaterRight(arrayUnsorted, i);
    			changes = false;
    		}
    	}
	}
	return arrayUnsorted;
	}
	
/**
 * 
 * @param arrayUnsorted
 * @param i
 * @return arrayUnsorted - array with swapped 2 adjacent elements
 */
	
	public static int [] moveGreaterRight (int arrayUnsorted [], int i) {
		int tmp = arrayUnsorted[i];
		arrayUnsorted[i] = arrayUnsorted[i+1];
		arrayUnsorted[i+1] = tmp;
			
	return arrayUnsorted;
	}
	
/**
 * 	
 * @param array of short positive numbers
 * @param sum
 * @return true if array contains 2 numbers, sum of which equals a given sum
 */

	public static boolean isSum2(short array[], short sum) {
		int i = 0, j = array.length - 1;
		Arrays.sort(array);
		 while (i < j) {
			 int sumN = array[i] + array[j];
			 if (sumN == sum)
		            return true;
		        if (sumN < sum) i++; else j--;
		 }
		
		return false;
	}
	
}
