package sortingAlgorithms;

public class SortAlgorithms {
	
	public static int[] mSort(int[] array){
		int N = array.length;

		if (N<=1){
			return array;
		}
		
		int middle = N/2;
		int [] lArray = new int [middle];
		int [] rArray = new int [N-middle];

		System.arraycopy(array,		 0, lArray, 0, middle);
		System.arraycopy(array, middle, rArray, 0, (N-middle));

		lArray = mSort(lArray);
		rArray = mSort(rArray);
		array = merge(array, lArray, rArray);
		return array;
	}

	private static int[] merge(int[] array, int[] lArray, int[] rArray) {
		int lIndex = 0;
		int rIndex = 0;
		for (int i = 0; i < array.length; i++){
			if((lIndex < lArray.length)&&(rIndex < rArray.length)){
				if (lArray[lIndex] < rArray[rIndex]){
					array[i] = lArray[lIndex];
					lIndex++;
				}
				else {
					array[i] = rArray[rIndex];
					rIndex++;
				}
			}
			else {
				if (lIndex < lArray.length){
					array[i] = lArray[lIndex];
					lIndex++;
				}
				else {
					array[i] = rArray[rIndex];
					rIndex++;

				}	
			}	
		}
		return array;
	}

	public static int[] bSort(int [] array) {
		int temp;
		boolean swap;
		do {
			swap = false;
			for (int i = 0; i < (array.length-1); i++) {
				if (array[i] > array[i + 1]) {
					temp = array[i + 1];
					array[i + 1] = array[i];
					array[i] = temp;
					swap = true;
				}
			}
		} while (swap);
		
		return array;
	}

	public static int[] iSort(int [] array){
		int temp;
		for (int i = 0; i < array.length; i++){
			temp = array[i];
			for (int j = (i-1); 0 <= j; j--){
				if (array[j] > temp){
					array[j+1] = array[j];
					if (j == 0){
						array[j]=temp;
					}
				} else {
					array[j+1] = temp;
					//j = 0;
					break;
				}
			}
		}
		return array;
	}

}
