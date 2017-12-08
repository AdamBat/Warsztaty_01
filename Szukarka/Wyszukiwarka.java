package Szukarka;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Wyszukiwarka {

	public static void main(String[] args) {
		popular();
		mostPopular();
		writingToFile(mostPopular());

	}

	static List<String> popular() {
		Connection connect = Jsoup.connect("http://www.skynews.com");
		List<String> words = new ArrayList<>();
		try {
			FileWriter writer = new FileWriter("popular_words.txt");
			Document document = connect.get();
			Elements links = document.select("h3");
			for (Element elem : links) {
				String line = elem.text().replaceAll("\\W+", " ");
				String[] array = line.split(" ");
				for (String word : array) {
					if (word.length() > 3) {
						words.add(word);
						writer.write(word + "\n");
					}
				}
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return words;
	}

	static List<String> mostPopular() {
		Path path = Paths.get("popular_words.txt");
		List<String> words = new ArrayList<>();
		try {
			Scanner sc = new Scanner(path.toFile());
			while (sc.hasNextLine()) {
				String word = sc.nextLine();
				words.add(word);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		List<String> mostPopular = new ArrayList<>();
		List<String> bin = new ArrayList<>();
		Collections.sort(words);

		while (mostPopular.size() < 10) {
			String most = words.get(0);
			int count = 1;
			int mostCount = 1;
			String previous = words.get(0);

			for (int i = 1; i < words.size(); i++) {
				if (words.get(i).equals(previous)) {
					count++;
				} else {
					if (count > mostCount) {
						most = words.get(i - 1);
						mostCount = count;
					}
					previous = words.get(i - 1);
					count = 1;
				}
			}
			mostPopular.add(most);
			for (String word : words) {
				if (word.equals(most)) {
					bin.add(word);
				}
			}
			words.removeAll(bin);

		}
		return mostPopular;
	}

	static void writingToFile(List<String> list) {
		FileWriter writer;
		try {
			writer = new FileWriter("most_popular_words.txt");
			for (String word : list) {
				writer.write(word + "\n");
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

//
// Warsztat: Wyszukiwarka najpopularniejszych słów
//
// Zaimportuj do projektu bibliotekę jsoup, możesz ją pobrać z adresu:
// https://jsoup.org/download.
// Wyszukaj w popularnych serwisach internetowych nagłówków artykułów, a
// następnie zapisz pojedyncze słowa w nich występujące do pliku o nazwie
// popular_words.txt. Przykład pobrania tytułów z tagu html span z atrybutem
// class o wartości title
//
// Connection connect = Jsoup.connect("http://www.onet.pl/");
// try {
// Document document = connect.get();
// Elements links = document.select("span.title");
// for (Element elem : links) {
// System.out.println(elem.text());
// }
// } catch (IOException e) {
// e.printStackTrace();
// }
//
// Wywołaj pobieranie dla wybranych serwisów internetowych.
// Wczytaj utworzony plik popular_words.txt i na jego podstawie utwórz plik
// most_popular_words.txt, który zawierać będzie 10 najbardziej popularnych
// słów.
// Utwórz tablicę elementów wykluczonych np. i, lub , ewentualnie pomiń
// wszystkie elementy 3-znakowe.
