package Zgadywanka;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		zgadujZgadula();
	}

	static void zgadujZgadula() {
		Random random = new Random();
		int result = random.nextInt(101);

		boolean win = false;
		System.out.println("Zgadnij liczbe od 1 do 100");
		while (!win) {

			Scanner sc = new Scanner(System.in);
			if (sc.hasNextInt()) {
				int number = sc.nextInt();
				if (number > result) {
					System.out.println("za duza");
				} else if (number < result) {
					System.out.println("za mala");
				} else {
					System.out.println("Gratulacje!!!!!!");
					win = true;
				}
			} else {
				System.out.println("To nie jest liczba,podaj jeszcze raz");

			}
		}
	}

}
