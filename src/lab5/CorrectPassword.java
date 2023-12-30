import java.util.regex.*;

public class CorrectPassword {
    public static void main(String[] args) {
        String text = "Xntzz08t9OAD";

        Pattern pattern = Pattern.compile("^[A-Za-z0-9]{8,16}$");
        Pattern symbolPattern = Pattern.compile("[^A-Za-z0-9]");
        Matcher matcher = pattern.matcher(text);
        Matcher symbolMatcher = symbolPattern.matcher(text);

        if (symbolMatcher.find()) {
            System.out.println("Пароль содержит недопустимые символы!");
        }

        while (matcher.find()) {
            System.out.println("Пароль надежный");
        }

        if (text.length() < 8) {
            System.out.println("Пароль слишком короткий!");
        } else if (text.length() > 16) {
            System.out.println("Пароль слишком длинный!");
        }
    }
}
