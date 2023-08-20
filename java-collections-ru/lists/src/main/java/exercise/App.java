package exercise;

import java.util.ArrayList;
import java.util.List;

// BEGIN
public class App {
    public static boolean scrabble(String letters, String word) {
        // Преобразуем строку набора символов в список символов
        List<Character> letterList = new ArrayList<>();
        for (char ch : letters.toCharArray()) {
            letterList.add(Character.toLowerCase(ch));
        }

        // Преобразуем слово в список символов
        List<Character> wordList = new ArrayList<>();
        for (char ch : word.toCharArray()) {
            wordList.add(Character.toLowerCase(ch));
        }

        // Проверяем, можно ли из набора символов составить слово
        for (char ch : wordList) {
            if (!letterList.contains(ch)) {
                return false;
            }
            letterList.remove(Character.valueOf(ch));
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(scrabble("rkqodlw", "world")); // true
        System.out.println(scrabble("ajv", "java")); // false
        System.out.println(scrabble("avjafff", "JaVa")); // true
        System.out.println(scrabble("", "hexlet")); // false
    }
}
//END
