package Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Lotto {

	public static void main(String[] args) {
		List<Integer> coupon = getNumbers();
		List<Integer> draw = numbersDraw();
		System.out.println(results(coupon, draw));
	}

	static List<Integer> getNumbers() {
		List<Integer> numbers = new ArrayList<>();
		System.out.println("Podawaj kolejno swoje liczby i zatwierdzaj enterem");
		while (numbers.size() < 6) {
			Scanner sc = new Scanner(System.in);
			if (sc.hasNextInt()) {
				int guess = sc.nextInt();
				if (numbers.contains(guess)) {
					System.out.println("to juz bylo");
				} else if (guess < 1 || guess > 49) {
					System.out.println("out of bounds");
				} else {
					numbers.add(guess);
				}
			} else {
				System.out.println("To ma byc numer");
			}
		}
		Collections.sort(numbers);
		System.out.println("Twoje numery to " + numbers.toString());
		return numbers;

	}

	static List<Integer> numbersDraw() {
		List<Integer> draw = new ArrayList<>();
		Random random = new Random();
		for (int i = 1; i < 7; i++) {
			draw.add(random.nextInt(48) + 1);

		}
		System.out.println("Wylosowane numery to" + draw.toString());
		return draw;
	}

	static String results(List<Integer> guesses, List<Integer> draw) {
		int noOfGuesses = 0;
		for (Integer guess : guesses) {
			for (Integer result : draw) {
				if (guess == result)
					noOfGuesses++;
			}
		}
		if (noOfGuesses >= 3) {
			return "Brawo trafiles " + noOfGuesses + " liczby";
		} else {
			return "Zyczymy szczescia nastepnym razem";
		}
	}
}
