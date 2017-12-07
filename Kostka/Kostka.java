package Kostka;

import java.util.Random;

public class Kostka {

	public static void main(String[] args) {
		try {
			dice("2D5+16");
		} catch (Exception e) {
			System.out.println("Zla formula rzutu kostka");
		}
	}

	static int[] typeOfDices = { 3, 4, 6, 8, 12, 20, 100 };

	static int dice(String code) {
		int type = getTypeOfDice(code);
		if (!checkingDice(type)) {
			System.out.println("Zly format kostki");
			return 0;
		}
		int nThrows = getThrows(code);
		int add = getAdd(code);
		int result = throwDice(type, nThrows) + add;
		System.out.println(result);
		return result;

	}

	static int throwDice(int typeOfDice, int nThrows) {
		int sum = 0;
		Random random = new Random();
		for (int i = 1; i <= nThrows; i++) {
			sum += random.nextInt(typeOfDice + 1);
		}
		return sum;
	}

	static boolean checkingDice(int type) {
		boolean ok = false;
		for (int i = 0; i < typeOfDices.length; i++) {
			if (type == typeOfDices[i]) {
				ok = true;
			}
		}
		return ok;
	}

	static int getTypeOfDice(String code) {
		int typeOfDice = 0;
		if (code.contains("+")) {
			typeOfDice = Integer.parseInt(code.substring(code.indexOf('D') + 1, code.indexOf('+')));
		} else if (code.contains("-")) {
			typeOfDice = Integer.parseInt(code.substring(code.indexOf('D') + 1, code.indexOf('-')));
		} else {
			typeOfDice = Integer.parseInt(code.substring(code.indexOf('D') + 1));
		}
		return typeOfDice;
	}

	static int getThrows(String code) {
		if (code.startsWith("D")) {
			return 1;
		}
		int noThrows = Integer.parseInt(code.substring(0, code.indexOf('D')));
		if (noThrows > 1) {
			return noThrows;
		} else {
			return 1;
		}
	}

	static int getAdd(String code) {
		int add = 0;
		if (code.contains("+")) {
			add = Integer.parseInt(code.substring(code.indexOf('+') + 1));
			return add;
		} else if (code.contains("-")) {
			add = Integer.parseInt(code.substring(code.indexOf('-') + 1));
			return add;
		} else {
			return 0;
		}
	}
}
