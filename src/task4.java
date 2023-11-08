import java.util.*;

public class task4 {
    // #1 exercise
    public static String nonRepeatable(String str) {
        if (str.length() <= 1) {
            return str;
        }
        // если в строке со 2 символа есть первый символ, вызываем рекурсивный метод
        if (str.substring(1).contains(str.substring(0, 1))) {
            return nonRepeatable(str.substring(1));
        }
        // иначе возвращаем первый символ строки + оставшуюся часть строки
        return str.substring(0, 1) + nonRepeatable(str.substring(1));
    }

    // #2 exercise

    public static List<String> generateBrackets(int n) {
        List<String> result = new ArrayList<>();
        generate(result, "", 0, 0, n);
        return result;
    }

    private static void generate(List<String> result, String current, int open, int close, int n) {
        // проверяем длину строки, n * 2 т.к. пары скобок
        if (current.length() == n * 2) {
            result.add(current);
            return;
        }
        // если открытых скобок меньше, добавляем (
        if (open < n) {
            generate(result, current + "(", open + 1, close, n);
        }
        // если закрытых скобок меньше, добавляем )
        if (close < open) {
            generate(result, current + ")", open, close + 1, n);
        }
    }

    // #3 exercise

    public static List<String> binarySystem(int n) {
        List<String> result = new ArrayList<>();
        generateBinaryCombinations(n, "", result);
        return result;
    }

    private static void generateBinaryCombinations(int n, String current, List<String> result) {
        // если n = 0, завершаем метод
        if (n == 0) {
            result.add(current);
        } else {
            // если пустая или первый символ не 0, записываем 0, счетчик уменьшаем
            if (current.isEmpty() || current.charAt(current.length() - 1) != '0') {
                generateBinaryCombinations(n - 1, current + '0', result);
            }
            // аналогично с едиинцей
            generateBinaryCombinations(n - 1, current + '1', result);
        }
    }

    // #4 exercise

    public static String alphabeticRow(String input) {
        if (input == null || input.length() == 0) {
            return "";
        }

        String longestRow = "";
        String currentRow = String.valueOf(input.charAt(0));

        // получаем текущий и предыдущий символ строки
        for (int i = 1; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            char previousChar = input.charAt(i - 1);
            // если разница 1 - алфавитный порядок, -1 - обратный алфавитный порядок
            if (currentChar - previousChar == 1 || previousChar - currentChar == 1) {
                currentRow += currentChar;
                // если разница не равно 1 или -1 проверяем на максимальную последовательность
            } else {
                if (currentRow.length() > longestRow.length()) {
                    longestRow = currentRow;
                }
                currentRow = String.valueOf(currentChar);
            }
        }

        if (currentRow.length() > longestRow.length()) {
            longestRow = currentRow;
        }

        return longestRow;
    }

    // #5 exercise

    public static Map<Character, Integer> countCharacters(String inputString) {
        // Создаем хеш-таблицу для хранения символов и их количества
        Map<Character, Integer> charCountMap = new HashMap<>();

        // Проходим по строке и подсчитываем количество каждого символа
        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);

            // Если символ уже встречался, увеличиваем его счетчик на 1
            if (charCountMap.containsKey(c)) {
                int count = charCountMap.get(c);
                charCountMap.put(c, count + 1);
            } else {
                // Если символ встречается впервые, добавляем его в хеш-таблицу
                charCountMap.put(c, 1);
            }
        }

        return charCountMap;
    }

    public static String sortCharactersByCount(String inputString) {
        // Получаем Map с количеством символов
        Map<Character, Integer> charCountMap = countCharacters(inputString);

        // Преобразуем Map в List для сортировки
        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(charCountMap.entrySet());

        // Сортировка при помощи метода compare
        Collections.sort(entryList, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        // Записываем символы и их количество в выходную строку
        StringBuilder outputString = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : entryList) {
            outputString.append(entry.getKey());
            outputString.append(entry.getValue());
        }

        return outputString.toString();
    }


    // #6 exercise

    public static int convertToNum(String input) {
        // Создаем HashMap соответствия слов и чисел от 1 до 1000
        HashMap<String, Integer> wordsToNumbers = new HashMap<>();
        wordsToNumbers.put("one", 1);
        wordsToNumbers.put("two", 2);
        wordsToNumbers.put("three", 3);
        wordsToNumbers.put("four", 4);
        wordsToNumbers.put("five", 5);
        wordsToNumbers.put("six", 6);
        wordsToNumbers.put("seven", 7);
        wordsToNumbers.put("eight", 8);
        wordsToNumbers.put("nine", 9);
        wordsToNumbers.put("ten", 10);
        wordsToNumbers.put("eleven", 11);
        wordsToNumbers.put("twelve", 12);
        wordsToNumbers.put("thirteen", 13);
        wordsToNumbers.put("fourteen", 14);
        wordsToNumbers.put("fifteen", 15);
        wordsToNumbers.put("sixteen", 16);
        wordsToNumbers.put("seventeen", 17);
        wordsToNumbers.put("eighteen", 18);
        wordsToNumbers.put("nineteen", 19);
        wordsToNumbers.put("twenty", 20);
        wordsToNumbers.put("thirty", 30);
        wordsToNumbers.put("forty", 40);
        wordsToNumbers.put("fifty", 50);
        wordsToNumbers.put("sixty", 60);
        wordsToNumbers.put("seventy", 70);
        wordsToNumbers.put("eighty", 80);
        wordsToNumbers.put("ninety", 90);
        wordsToNumbers.put("hundred", 100);

        String[] words = input.split(" ");
        int result = 0;
        int currentNumber = 0;

        for (String word : words) {
            int num = wordsToNumbers.get(word);
            if (num == 100) {
                currentNumber *= num;
            } else if (num < 100) {
                currentNumber += num;
            } else {
                currentNumber *= num;
                result += currentNumber;
                currentNumber = 0;
            }
        }

        // Добавляем последнее число к результату
        result += currentNumber;

        return result;
    }

    // #7 exercise

    public static String uniqueSubstring(String input) {
        int maxLength = 0;
        String result = "";
        int start = 0;
        // множество всех уникальных символов
        HashSet<Character> uniqueCharacters = new HashSet<>();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (!uniqueCharacters.contains(currentChar)) {
                uniqueCharacters.add(currentChar);
                if (uniqueCharacters.size() > maxLength) {
                    maxLength = uniqueCharacters.size();
                    result = input.substring(start, i + 1);
                }
                // если уже содержит текущий символ очищаем и обновляем переменную start
            } else {
                uniqueCharacters.clear();
                start = i;
                uniqueCharacters.add(currentChar);
            }
        }
        return result;
    }

    // #8 exercise

    public static int shortestWay(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Создаем дополнительную матрицу для хранения минимальных сумм путей
        int[][] dp = new int[m][n];

        // Инициализируем первую ячейку в dp суммой первой ячейки в grid
        dp[0][0] = grid[0][0];

        // Инициализируем первую строку в dp
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }

        // Инициализируем первый столбец в dp
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        // Заполняем dp матрицу, находя минимальные суммы путей
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }

        // Возвращаем результат, который будет наименьшей суммой пути до правого нижнего угла
        return dp[m-1][n-1];
    }

    // #9 exercise

    public static String numericOrder(String input) {
        String[] words = input.split(" "); // Разбиваем строку на слова
        // создаем пустой массив для заполнения итоговой строки
        List<String> orderedWords = new ArrayList<>(Collections.nCopies(words.length, ""));

        // проходимся по каждому слову массива
        for (String word : words) {
            // проходимся по символам каждого слова
            for (char c : word.toCharArray()) {
                // проверяем содержит ли слово цифру
                if (Character.isDigit(c)) {
                    int position = Character.getNumericValue(c);
                    // заменяем соответствующий элемент массива словом без цифры
                    if (position > 0 && position <= words.length) {
                        orderedWords.set(position - 1, word.replaceAll("[0-9]", ""));
                    }
                }
            }
        }

        orderedWords.removeAll(Collections.singleton("")); // Удаляем пустые элементы
        return String.join(" ", orderedWords);
    }

    // #10 exercise

    public static int switchNums(int num1, int num2) {
        Integer[] numsToReplace = new Integer[String.valueOf(num1).length()];
        int[] switchNumbers = new int[String.valueOf(num2).length()];

        for (int i = 0; i < numsToReplace.length; i++) { // заполнение массива цифрами числа num1
            numsToReplace[i] = num1 % 10;
            num1/=10;
        }
        Arrays.sort(numsToReplace, Collections.reverseOrder()); // сортировка в обратном порядке
        for (int i = 0; i < switchNumbers.length; i++) {
            switchNumbers[i] = num2 % 10;
            num2/=10;
        }
        int changeIndex = 0;
        for (int i = switchNumbers.length - 1; i >= 0; i--) { // идем в обратном порядке чтобы не переворачивать массив num2
            if (numsToReplace[changeIndex] > switchNumbers[i]) {
                switchNumbers[i] = numsToReplace[changeIndex];
                changeIndex++;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int num: switchNumbers) {
            res.append(num);
        }
        return Integer.parseInt(res.reverse().toString()); // реверсим тк идем динамически
    }


    public static void main(String[] args) {
        System.out.println("#1 exercise");
        System.out.println(nonRepeatable("abracadabra"));
        System.out.println(nonRepeatable("paparazzi"));

        System.out.println("#2 exercise");
        System.out.println(generateBrackets(1));
        System.out.println(generateBrackets(2));
        System.out.println(generateBrackets(3));

        System.out.println("#3 exercise");
        System.out.println(binarySystem(3));
        System.out.println(binarySystem(4));

        System.out.println("#4 exercise");
        System.out.println(alphabeticRow("abcdjuwx"));
        System.out.println(alphabeticRow("klmabzyxw"));

        System.out.println("#5 exercise");
        System.out.println(sortCharactersByCount("aaabbcdd"));
        System.out.println(sortCharactersByCount("vvvvaajaaaaa"));

        System.out.println("#6 exercise");
        System.out.println(convertToNum("eight"));
        System.out.println(convertToNum("five hundred sixty seven"));
        System.out.println(convertToNum("thirty one"));

        System.out.println("#7 exercise");
        System.out.println(uniqueSubstring("123412324"));
        System.out.println(uniqueSubstring("111111"));
        System.out.println(uniqueSubstring("77897898"));

        System.out.println("#8 exercise");
        System.out.println(shortestWay(new int[][] {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
        System.out.println(shortestWay(new int[][] {{2, 7, 3}, {1, 4, 8}, {4, 5, 9}}));

        System.out.println("#9 exercise");
        System.out.println(numericOrder("t3o the5m 1One all6 r4ule ri2ng"));
        System.out.println(numericOrder("re6sponsibility Wit1h gr5eat power3 4comes g2reat"));

        System.out.println("#10 exercise");
        System.out.println(switchNums(519, 723));
        System.out.println(switchNums(491, 3912));
        System.out.println(switchNums(6274, 71259));

    }
}
