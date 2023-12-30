import java.util.regex.*;
public class NumberFinder {
    public static void main(String[] args) {
        String text = "Это текст с числами 456. Также здесь есть число 7890, 77.3 и 90,1.";

        Pattern pattern = Pattern.compile("\\d+((\\.|,)\\d+)?"); // Регулярное выражение для поиска чисел
        Matcher matcher = pattern.matcher(text);

        boolean found = false;
        while (matcher.find()) {
            System.out.println("Найдено число: " + matcher.group());
            found = true;
        }

        if (!found) {
            System.out.println("Чисел не найдено!");
        }
    }
}
