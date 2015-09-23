package sortingAlgorithms;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Bubblesort {

	public static int[] toBeSorted = new int[20];

	public static void main(String[] args) {
		genNumbs();	//das füllt den Array toBeSorted mit zufälligen Zahlen aus
		Scanner sc = new Scanner(System.in);
		boolean test = true;
		System.out.println("unsortiert: " + Arrays.toString(toBeSorted));
		do {
			System.out.println("Bitte geben Sie ein, welchen Sortieralgorithmus Sie verwenden wollen:"

			+ "\n [1] Bubblesort"
			+ "\n [2] Insertsort"
			+ "\n [3] Mergesort");

			switch (sc.nextInt()){
				case 1: bSort(); break;
				case 2: iSort(); break;
				case 3: mSort(toBeSorted); break;
				default: System.out.println("Fehlerhafte Eingabe!");
					test = false;
					break;
			}
		} while (!test);
		
		
		mSort(toBeSorted);
		System.out.println("\nsortiert:   " + Arrays.toString(toBeSorted));
		sc.close();

	}

	public static void genNumbs(){
		Random rand = new Random();
		for(int i = 0; i < toBeSorted.length; i++){
			toBeSorted[i] = rand.nextInt(20) + 1;
		}

	}
	public static void mSort(int [] array){
		int N = array.length;


		if (N<=1){
			return;
		}
		int middle = N/2;
		int [] lArray = new int [middle];
		int [] rArray = new int [N-middle];

		System.arraycopy(array, 0, lArray, 0, middle);
		System.arraycopy(array, middle, rArray, 0, (N-middle));

		mSort(lArray);
		mSort(rArray);
		merge(array, lArray, rArray);

	}

	public static void merge(int[] array, int [] lArray, int [] rArray) {
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
	}

	public static void bSort() {
		int temp = 0;
		boolean swap = false;
		do {
			swap = false;
			for (int i = 0; i < (toBeSorted.length-1); i++){
				if (toBeSorted[i]>toBeSorted[i+1]){
					temp = toBeSorted[i+1];
					toBeSorted[i+1]=toBeSorted[i];
					toBeSorted[i]= temp;
					swap = true;
				}
			}
		} while (swap == true);
	}

	public static int iSort(){
		int trys = 0;
		int temp = 0;
		for (int i = 0; i < toBeSorted.length; i++){
			trys++;
			temp = toBeSorted[i];
			for (int j = (i-1); 0 <= j; j--){
				trys++;
				if (toBeSorted[j] > temp){
					trys++;
					toBeSorted[j+1] = toBeSorted[j];
					if (j == 0){
						toBeSorted[j]=temp;
					}
				} else {
					toBeSorted[j+1] = temp;
					//j = 0;
					break;
				}
			}
		}
		return trys;
	}
}
