import java.util.regex.*;

public class WordFinder {

    public static void findWordsStartingWithLetter(String text, char startingLetter) {
        // Формируем регулярное выражение для поиска слов, начинающихся с указанной буквы
        String regex = "\\b" + startingLetter + "\\w*\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        // Ищем и выводим слова
        System.out.println("Слова, начинающиеся с буквы '" + startingLetter + "':");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    public static void main(String[] args) {
        // Пример использования
        String inputText = "hellow world.";
        char startingLetter = 'w'; // заданная буква

        findWordsStartingWithLetter(inputText, startingLetter);
    }
}
