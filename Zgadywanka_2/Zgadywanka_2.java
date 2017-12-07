package Zgadywanka_2;

import java.util.Scanner;

public class Zgadywanka_2 {
	public static void main(String[] args) {
		System.out.println("Pomysl liczbe od 0 do 1000 a ja zgadne ja  w max 10 probach");
		Scanner sc = new Scanner(System.in);
		int result = sc.nextInt();
		int min = 0;
		int max = 1000;
		int noOfTries = 0;
		boolean win = false;
		while (noOfTries <= 10 && !win) {
			int guess = ((max - min) / 2) + min;
			System.out.println("Zgaduje liczbe " + guess);
			switch (menu()) {
			case 1:
				if (guess <= result) {
					System.out.println("Nie oszukuj");
					break;
				} else {
					System.out.println("za duzo");
					max = guess - 1;
					noOfTries++;
					break;
				}

			case 2:
				if (guess >= result) {
					System.out.println("Nie oszukuj");
					break;
				} else {
					System.out.println("Za malo");
					min = guess + 1;
					noOfTries++;
				}
				break;
			case 3:
				if (guess != result) {
					System.out.println("Nie oszukuj");
					break;
				} {
				System.out.println("Zgadles");
				win = true;
			}
				break;
			default:
				System.out.println("zla opcja");
			}
		}

	}

	static int menu() {
		System.out.println("1 - za duzo\n2 - za malo\n3 - zgadles");
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
}
