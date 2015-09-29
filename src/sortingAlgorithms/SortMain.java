package sortingAlgorithms;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SortMain {

	public static Scanner myScanner = new Scanner(System.in);

	public static void main(String[] args) {
		boolean error = false;
		// Scanner sc = new Scanner(System.in);
		System.out.println("Hallo. Dies ist ein Programm zur Sortierung einer Reihe ganzzahliger Zahlen.");
		int myLength = input("Bitte geben Sie die Länge der Zahlenreihe ein!");
		/*
		 * do { error = false; System.out.println(
		 * "Bitte geben Sie ein, wie viele Zahlen die Reihe beinhalten soll.");
		 * try { inputLength = sc.nextInt(); } catch
		 * (java.util.InputMismatchException e) { error = true;
		 * System.out.println("Fehlerhafte Eingabe!"); } } while (error);
		 */

		int[] toBeSorted = new int[myLength];
		int[] sorted = new int[toBeSorted.length];
		int myInput = 0;
		do {
			myInput = input("Wollen Sie "
					+ "\n[1] Eigene Zahlen eingeben oder"
					+ "\n[2] Zufallsgenerierte Zahlen verwenden?");
			/*
			 * System.out.println("Wollen Sie " +
			 * "\n[1] Eigene Zahlen eingeben oder" +
			 * "\n[2] Zufallsgenerierte Zahlen verwenden?");
			 *
			 * do { try { error = false; myInput = sc.nextInt(); } catch
			 * (java.util.InputMismatchException e) { error = true;
			 * System.out.println("Fehlerhafte Eingabe!"); } } while (error);
			 */
			error = false;

			switch (myInput) {
				case 1:
					break;
				case 2:
					toBeSorted = genNumbs(toBeSorted.length);
					break;
				default:
					System.out.println("Fehlerhafte Eingabe!");
					error = true;

			}

		} while (error);

		System.out.println("unsortiert: " + Arrays.toString(toBeSorted));

		int myAlgorithm = 0;
		do {
			myAlgorithm = input("Bitte geben Sie ein, welchen Sortieralgorithmus Sie verwenden wollen:"
					+ "\n [1] Bubblesort"
					+ "\n [2] Insertsort"
					+ "\n [3] Mergesort");
			/*
			 * System.out.println(
			 * "Bitte geben Sie ein, welchen Sortieralgorithmus Sie verwenden wollen:"
			 * + "\n [1] Bubblesort" + "\n [2] Insertsort" + "\n [3] Mergesort"
			 * );
			 */
			error = false;
			switch (myAlgorithm) {
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
					error = true;
					break;
			}
		} while (error);

		System.out.println("\nsortiert:   " + Arrays.toString(sorted));
		// sc.close();

	}

	public static int[] genNumbs(int length) {
		Random rand = new Random();
		int[] array = new int[length];

		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(20) + 1;
			// System.out.print()
		}

		return array;
	}

	/**
	 * Scanner sc = new Scanner(System.in);
	 * sc.useDelimiter(System.getProperty("line.separator")); while
	 * (sc.hasNextInt()){ int i = sc.nextInt();
	 *
	 * //... do stuff with i ... }
	 */

	public static int input(String message) {
		int input = 0;
		boolean error = false;
		// Scanner sc = new Scanner(System.in);
		// System.out.println("");

		do {
			try {

				System.out.println(message);
				error = false;

				input = Integer.parseInt(myScanner.nextLine());

			} catch (NumberFormatException e) {
				error = true;
				System.out.println("Fehlerhafte Eingabe!");
			}
		} while (error);

		// sc.close();
		return input;
	}

}
