package sortingAlgorithms;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SortMain {

    public static int[] toBeSorted = new int[20];
    public static int[] sorted = new int[toBeSorted.length];

    public static void main(String[] args) {
        genNumbs();	//das füllt den Array toBeSorted mit zufälligen Zahlen aus
        Scanner sc = new Scanner(System.in);
       // SortAlgorithms sAlgs = new SortAlgorithms();
        boolean test = true;

        System.out.println("unsortiert: " + Arrays.toString(toBeSorted));

        do {
            System.out.println("Bitte geben Sie ein, welchen Sortieralgorithmus Sie verwenden wollen:"
                    + "\n [1] Bubblesort"
                    + "\n [2] Insertsort"
                    + "\n [3] Mergesort");

            switch (sc.nextInt()){
                case 1: sorted = SortAlgorithms.bSort(toBeSorted); break;
                case 2: sorted = SortAlgorithms.iSort(toBeSorted); break;
                case 3: sorted = SortAlgorithms.mSort(toBeSorted); break;
                default: System.out.println("Fehlerhafte Eingabe!");
                    test = false;
                    break;
            }
        } while (!test);

        System.out.println("\nsortiert:   " + Arrays.toString(sorted));
        sc.close();

    }

    public static void genNumbs(){
        Random rand = new Random();
        for(int i = 0; i < toBeSorted.length; i++){
            toBeSorted[i] = rand.nextInt(20) + 1;
        }

    }

}
