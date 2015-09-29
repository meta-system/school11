package sortingAlgorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SortMain {

	public static Scanner myScanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Hallo. Dies ist ein Programm zur Sortierung einer Reihe ganzzahliger Zahlen.");
		int[] toBeSorted = new int[20];
		int[] sorted = new int[20];
		boolean error = false;

		do {

			error = false;

			switch (input("Wollen Sie "
					+ "\n[1] Eigene Zahlen eingeben oder"
					+ "\n[2] Zufallsgenerierte Zahlen verwenden?")) {
				case 1:
					toBeSorted = readNumbs();
					break;
				case 2:
					toBeSorted = genNumbs(input("Bitte geben Sie die Länge der Zahlenreihe ein!"));
					break;
				default:
					System.out.println("Fehlerhafte Eingabe!");
					error = true;

			}

		} while (error);

		System.out.println("unsortiert: " + Arrays.toString(toBeSorted));

		do {

			error = false;
			switch (input("Bitte geben Sie ein, welchen Sortieralgorithmus Sie verwenden wollen:"
					+ "\n [1] Bubblesort"
					+ "\n [2] Insertsort"
					+ "\n [3] Mergesort")) {
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

		System.out.println("\nsortiert: " + Arrays.toString(sorted));
	}

	public static int[] genNumbs(int length) {
		Random rand = new Random();
		int[] array = new int[length];

		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(20) + 1;
		}

		return array;
	}

	public static int input(String message) {
		int input = 0;
		boolean error = false;

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

		return input;
	}

	public static int[] readNumbs() {
		System.out.println("Bitte geben Sie die zu sortierenden Zahlen, separiert durch ein Leerzeichen, ein.");
		System.out.println("Wenn Sie fertig sind, drücken Sie 'Enter'.");
		Queue<Integer> inputQ = new LinkedList<Integer>();

		Pattern delimiters = Pattern.compile(System.getProperty("line.separator") + "|\\s");
		myScanner.useDelimiter(delimiters);

		while (myScanner.hasNextInt()) {
			inputQ.add(myScanner.nextInt());

		}
		myScanner.nextLine();

		int[] input = new int[inputQ.size()];
		int i = 0;
		while (inputQ.peek() != null) {
			input[i] = inputQ.poll();
			i++;
		}
		return input;
	}

}
