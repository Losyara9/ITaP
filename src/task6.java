import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        System.out.println("Exercise 1");
        System.out.println(hiddenAnagram("My world evolves in a beautiful space called Tesh.", "sworn love lived")); // ➞ "worldevolvesin"
        System.out.println(hiddenAnagram("An old west action hero actor", "Clint Eastwood")); // ➞ "noldwestactio"
        System.out.println(hiddenAnagram("Mr. Mojo Rising could be a song title", "Jim Morrison"));

        System.out.println("Exercise 2");
        System.out.println(collect("intercontinentalisationalism", 6));
        System.out.println(collect("strengths", 3));
        System.out.println(collect("pneumonoultramicroscopicsilicovolcanoconiosis", 15));

        System.out.println("Exercise 3");
        System.out.println(nicoCipher("myworldevolvesinhers", "tesh"));
        System.out.println(nicoCipher("andiloveherso", "tesha"));
        System.out.println(nicoCipher("mubashirhassan", "crazy"));
        System.out.println(nicoCipher("edabitisamazing", "matt"));
        System.out.println(nicoCipher("iloveher", "612345"));

        System.out.println("Exercise 4");
        System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, 3, 9, 4, 5, 15}, 45)));
        System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, 3, 9, 4, 15, 3, 5}, 45)));
        System.out.println(Arrays.toString(twoProduct(new int[]{1, 2, -1, 4, 5, 6, 10, 7}, 20)));

        System.out.println("Exercise 5");
        System.out.println(isExact(6));
        System.out.println(isExact(24));
        System.out.println(isExact(125));
        System.out.println(isExact(720));
        System.out.println(isExact(1024));
        System.out.println(isExact(40320));

        System.out.println("Exercise 6");
        System.out.println(fractions("0.(6)"));
        System.out.println(fractions("1.(1)"));
        System.out.println(fractions("3.(142857)"));
        System.out.println(fractions("0.19(2367)"));
        System.out.println(fractions("0.1097(3)"));

        System.out.println("Exercise 7");
        System.out.println(pilishString("33314444"));
        System.out.println(pilishString("TOP"));
        System.out.println(pilishString("X"));

        System.out.println("Exercise 8");
        System.out.println(generateNonconsecutive("3 + 5 * (2 - 6)")); // ➞ -17
        System.out.println(generateNonconsecutive("6 - 18 / (-1 + 4)")); // ➞ 0

        System.out.println("Exercise 9");
        System.out.println(isValid("aabbcd")); // ➞ "NO"
        System.out.println(isValid("aabbccddeefghi")); // ➞ "NO"
        System.out.println(isValid("abcdefghhgfedecba")); // ➞ "YES"

        System.out.println("Exercise 10");
        System.out.println(findLCS("abcd", "bd")); // ➞ "bd"
        System.out.println(findLCS("aggtab", "gxtxamb")); // ➞ "gtab"
    }

    // #1 exercise
    public static String hiddenAnagram(String sentence, String word) {
        word = word.toLowerCase().replaceAll("[^a-zA-Z]+", "");
        sentence = sentence.toLowerCase().replaceAll("[^a-zA-Z]+", "");

        // Создаем отсортированный массив символов для скрытой анаграммы
        char[] anagramChars = word.toCharArray();
        Arrays.sort(anagramChars);
        String sortedAnagram = new String(anagramChars);

        // Находим скрытую анаграмму в предложении
        for (int i = 0; i <= sentence.length() - word.length(); i++) {
            String subStr = sentence.substring(i, i + word.length());
            char[] subStrChars = subStr.toCharArray();
            Arrays.sort(subStrChars);
            String sortedSubStr = new String(subStrChars);

            if (sortedSubStr.equals(sortedAnagram)) {
                return subStr;
            }
        }

        return "notfound";
    }


    // #2 exercise
    public static String collect(String word, int n) {
        ArrayList<String> slices = new ArrayList<>();
        for (int i = 0; i <= word.length() - n; i = i + n) {
            slices.add(word.substring(i, i + n));
        }
        String[] result = slices.toArray(new String[0]);
        Arrays.sort(result); // Сортировка полученного массива
        return Arrays.toString(result);
    }

    // #3 exercise
    public static StringBuilder nicoCipher(String message, String key) {
        char[] keyLetters = key.toCharArray();
        Map<Character, LinkedList<Character>> cipher = new HashMap<>();
        StringBuilder res = new StringBuilder();
        StringBuilder messageBuilder = new StringBuilder(message);
        //добавляем пробелы к сообщению пока его длина не станет кратной длине ключа
        while (messageBuilder.length() % keyLetters.length != 0) {
            messageBuilder.append(" ");
        }
        message = messageBuilder.toString();
        //цикл для обработки каждой буквы ключа
        for (int i = 0; i < keyLetters.length; i++) {
            char keyLetter = keyLetters[i]; //получаем букву ключа
            LinkedList<Character> letters = new LinkedList<>(); //список для символов для каждой буквы ключа
            int j = i;
            //добавляем символы из сообщения в список с шагом, равный длине ключа
            do {
                letters.add(message.charAt(j));
                j += keyLetters.length;
            } while (j < message.length());
            cipher.put(keyLetter, letters); //добавляем список символов в словарь с ключом, равным текущей букве ключа
        }
        //определяем кол-во строк в итоговом сообщении через длину списка для первой буквы ключа
        int rowsCount = cipher.get(keyLetters[0]).size();
        Arrays.sort(keyLetters);
        int index = 0;
        //добавляем символы из списков в итоговый результат в порядке отсортированных букв ключа
        while (index < rowsCount) {
            for (char letter : keyLetters) {
                res.append(cipher.get(letter).get(index));
            }
            index++;
        }
        return res;
    }

    // #4 exercise
    public static int[] twoProduct(int[] arr, int n) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int num : arr) {
            if (n % num == 0 && map.containsKey(n / num)) {
                return new int[]{n / num, num};
            }
            map.put(num, 1);
        }

        return new int[]{};
    }

    // #5 exercise
    public static String isExact(int n) {
        return Arrays.toString(isExactFactorial(n, 1, 1));
    }

    public static Integer[] isExactFactorial(int n, int current, int index) {
        if (n == current) {
            return new Integer[]{current, index};
        } else if (n < current) {
            return new Integer[]{};
        } else {
            return isExactFactorial(n, current * (index + 1), index + 1);
        }
    }


    // #6 exercise
    public static String fractions(String decimal) {
        int integerPart = Integer.parseInt(decimal.split("\\.")[0]); // Получаем целую часть десятичной дроби
        String repeatingPart = decimal.split("\\.")[1].replaceAll("[()]", ""); // Получаем повторяющуюся часть без скобок

        int nonRepeatingLength = decimal.split("\\.")[1].indexOf('('); // Длина неповторяющейся части

        //вычисляем знаменатель дроби, возводим неповторяющуюся часть в 10 степень + повторяющуюся часть, вычитаем неповтор.
        int denominator = (int) Math.pow(10, nonRepeatingLength + repeatingPart.length()) - (int) Math.pow(10, nonRepeatingLength);
        //находим числитель (повторяющуюся часть в число)
        int numerator = Integer.parseInt(repeatingPart);
        //Если неповторяющаяся часть существует, добавляем к числителю соответствующее значение из десятичной дроби.
        if (nonRepeatingLength > 0) {
            numerator += Integer.parseInt(decimal.split("\\.")[1].substring(0, nonRepeatingLength));
        }

        int gcd = gcd(numerator, denominator);
        //делим числитель и знаменатель на НОД для упрощения дроби
        numerator /= gcd;
        denominator /= gcd;

        //Прибавляем целую часть, домноженную на знаменатель, к числителю.
        numerator += integerPart * denominator;

        return numerator + "/" + denominator;
    }

    // Находим НОД (наибольший общий делитель)
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    // #7 exercise
    public static StringBuilder pilishString(String str) {
        String PI = String.valueOf(Math.PI).replace(".", "");
        StringBuilder res = new StringBuilder();
        int pIndex = 0;
        int strIndex = 0;
        while (strIndex < str.length()) {
            int addition = PI.charAt(pIndex) - '0';
            if (strIndex + addition <= str.length()) {
                res.append(str, strIndex, strIndex + addition).append(" ");
            } else {
                StringBuilder lastPart = new StringBuilder(str.substring(strIndex));
                while (lastPart.length() < addition) {
                    lastPart.append(str.charAt(str.length() - 1));
                }
                res.append(lastPart);
            }
            strIndex += addition;
            pIndex++;
        }
        return res;
    }

    // #8 exercise
    public static String generateNonconsecutive(String str) {
        Pattern bracketsFinder = Pattern.compile("\\(.*\\)");
        Matcher bracketsMatcher = bracketsFinder.matcher(str);
        while (bracketsMatcher.find()) {
            String chander = bracketsMatcher.group(); // получаем содержимое скобок
            str = bracketsMatcher.replaceFirst(generateNonconsecutive(chander.substring(1, chander.length() - 1)));
        }
        Pattern multiplication = Pattern.compile("-?\\d* (\\*||/) -?\\d*");
        while (str.contains("/") || str.contains("*")) {
            Matcher multiplicationMatcher = multiplication.matcher(str);
            if (multiplicationMatcher.find()) {
                String[] expression = multiplicationMatcher.group().split(" ");
                if (expression[1].equals("*")) {
                    str = multiplicationMatcher.replaceFirst(String.valueOf(Integer.parseInt(expression[0]) * Integer.parseInt(expression[2])));
                } else {
                    if (expression[2].equals("0")) {
                        return "division by zero";
                    }
                    str = multiplicationMatcher.replaceFirst(String.valueOf(Integer.parseInt(expression[0]) / Integer.parseInt(expression[2])));
                }
            } else {
                break;
            }
        }
        Pattern sumOrSubtraction = Pattern.compile("-?\\d* (\\+||-) -?\\d*");

        while (str.contains("+") || str.contains("-")) {
            Matcher sumOrSubtrationMatcher = sumOrSubtraction.matcher(str);
            if (sumOrSubtrationMatcher.find()) {
                String[] expression = sumOrSubtrationMatcher.group().split(" ");
                if (expression[1].equals("+")) {
                    str = sumOrSubtrationMatcher.replaceFirst(String.valueOf(Integer.parseInt(expression[0]) + Integer.parseInt(expression[2])));
                } else {
                    str = sumOrSubtrationMatcher.replaceFirst(String.valueOf(Integer.parseInt(expression[0]) - Integer.parseInt(expression[2])));
                }
            } else {
                break;
            }

        }
        return str;
    }

    // #9 exercise

    public static String isValid(String str) {
        HashMap<Character, Integer> frequencies = new HashMap<Character, Integer>();

        for (char ch : str.toCharArray()) {
            frequencies.put(ch, frequencies.getOrDefault(ch, 0) + 1);
        }

        HashMap<Integer, Integer> frequencyCounts = new HashMap<Integer, Integer>();
        for (int count : frequencies.values()) {
            frequencyCounts.put(count, frequencyCounts.getOrDefault(count, 0) + 1);
        }

        if (frequencyCounts.size() == 1) {
            return "YES";
        } else if (frequencyCounts.size() == 2) {
            int minFrequency = Integer.MAX_VALUE;
            int maxFrequency = Integer.MIN_VALUE;
            for (int count : frequencyCounts.keySet()) {
                minFrequency = Math.min(minFrequency, count);
                maxFrequency = Math.max(maxFrequency, count);
            }
            int minFrequencyCount = frequencyCounts.get(minFrequency);
            int maxFrequencyCount = frequencyCounts.get(maxFrequency);
            if ((minFrequencyCount == 1 && (minFrequency == 1 || minFrequency == maxFrequency + 1))
                    || (maxFrequencyCount == 1 && maxFrequency == minFrequency + 1)) {
                return "YES";
            }
        }

        return "NO";
    }

    // #10 exercise
    public static String findLCS(String s1, String s2) {
        int m = s1.length();  // Длина первой строки
        int n = s2.length();  // Длина второй строки

        int[][] dp = new int[m + 1][n + 1];  // Создаем массив для хранения значений LCS

        // Заполняем массив dp для каждой возможной комбинации подстрок s1 и s2
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;  // Начальное условие: LCS для пустых строк равно 0
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;  // Если символы равны, увеличиваем LCS на 1
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);  // Иначе, выбираем максимум из двух предыдущих значений
                }
            }
        }

        // Теперь, создаем массив для хранения LCS
        int len = dp[m][n];  // Длина наибольшей общей подпоследовательности
        char[] lcs = new char[len];  // Создаем массив символов для LCS

        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {  // Если символы совпадают
                lcs[len - 1] = s1.charAt(i - 1);  // Добавляем символ в LCS
                i--;
                j--;
                len--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;  // Если значение слева больше, двигаемся влево
            } else {
                j--;  // Иначе, двигаемся вверх
            }
        }

        return new String(lcs);  // Возвращаем наибольшую общую подпоследовательность в виде строки
    }

}
