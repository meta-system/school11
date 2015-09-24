package sortingAlgorithms;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SortMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean test = true;

		int[] toBeSorted = new int[20];
		int[] sorted = new int[toBeSorted.length];

		do {
			System.out.println("Wollen Sie "
					+ "\n[1] Eigene Zahlen eingeben oder"
					+ "\n[2] Zufallsgenerierte Zahlen verwenden?");

			switch (sc.nextInt()) {
				case 1:
					break;
				case 2:
					toBeSorted = genNumbs(toBeSorted.length);
					break;
				default:
					System.out.println("Fehlerhafte Eingabe!");
					test = false;
					break;
			}
		} while (!test);

		System.out.println("unsortiert: " + Arrays.toString(toBeSorted));

		do {

			System.out.println("Bitte geben Sie ein, welchen Sortieralgorithmus Sie verwenden wollen:"
					+ "\n [1] Bubblesort"
					+ "\n [2] Insertsort"
					+ "\n [3] Mergesort");
			test = true;
			switch (sc.nextInt()) {
				case 1:
					sorted = SortAlgorithms.bSort(toBeSorted);
					break;
				case 2:
					sorted = SortAlgorithms.iSort(toBeSorted);
					break;
				case 3:
					sorted = SortAlgorithms.mSort(toBeSorted);
					break;
				default:
					System.out.println("Fehlerhafte Eingabe!");
					test = false;
					break;
			}
		} while (!test);

		System.out.println("\nsortiert:   " + Arrays.toString(sorted));
		sc.close();

	}

	public static int[] genNumbs(int length) {
		Random rand = new Random();
		int[] array = new int[length];

		for (int i : array) {
			i = rand.nextInt(20) + 1;
		}

		return array;
	}
}
