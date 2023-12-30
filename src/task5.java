import javax.management.StringValueExp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.*;

public class Main {

    // #1 exercise
    public static boolean sameLetterPattern(String first, String second) {
        for (int i = 0; i < first.length(); i++) {
            for (int j = 0; j < second.length(); j++) {
                if ((first.charAt(i) == first.charAt(i + 1)) == (second.charAt(j) == second.charAt(j + 1))) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    // #2 exercise
    public static String spiderVsFly(String spider, String fly) { // task 2
        String letters = "ABCDEFGH";
        StringBuilder path = new StringBuilder();
        int angle = Math.abs(letters.indexOf(spider.charAt(0)) - letters.indexOf(fly.charAt(0)));
        if(angle >= 5) {
            angle = 4 - angle % 4;
        }
        if (angle == 0) { // по прямой
            if (spider.charAt(1) > fly.charAt(1)){
                for (int i = Integer.parseInt(spider.substring(1)); i >= Integer.parseInt(fly.substring(1)); i--) {
                    path.append(spider.charAt(0)).append(i).append("-");
                }
            }
            else {
                for (int i = Integer.parseInt(spider.substring(1)); i <= Integer.parseInt(fly.substring(1)); i++) {
                    path.append(spider.charAt(0)).append(i).append("-");
                }
            }
        }
        else if(angle == 1 || angle == 2) { // по дуге
            if (Integer.parseInt(spider.substring(1)) > Integer.parseInt(fly.substring(1))) { // идем до нужной дуги
                for (int i = Integer.parseInt(spider.substring(1)); i >= Integer.parseInt(fly.substring(1)); i--) {
                    path.append(spider.charAt(0)).append(i).append("-");
                }
            } else {
                String[] reverse = spiderVsFly(fly, spider).split("-");
                path = new StringBuilder();
                for (int i = reverse.length-1; i >= 0; i--) {
                    path.append(reverse[i]).append("-");
                }
                path = new StringBuilder(path.substring(0, path.length() - 1));
                return path.toString();
            }
            int currNum = Integer.parseInt(fly.substring(1));
            String returnPath = "BAHGFEDC";
            if (Math.abs(letters.indexOf(spider.charAt(0)) - letters.indexOf(fly.charAt(0))) <
                    Math.abs(returnPath.indexOf(spider.charAt(0)) - returnPath.indexOf(fly.charAt(0)))) {
                for (int i = letters.indexOf(spider.charAt(0)) + 1; i <= letters.indexOf(fly.charAt(0)); i++) {
                    path.append(letters.charAt(i)).append(currNum).append("-");
                }
            } else {
                for (int i = returnPath.indexOf(spider.charAt(0)) + 1; i <= returnPath.indexOf(fly.charAt(0)); i++) {
                    path.append(returnPath.charAt(i)).append(currNum).append("-");
                }
            }
        }
        else { // через центр
            for (int i = Integer.parseInt(spider.substring(1)); i >= 0; i--) { // вместо а0 ставим букву паука и 0
                path.append(spider.charAt(0)).append(i).append("-");
            }
            for (int i = 1; i <= Integer.parseInt(fly.substring(1)); i++) {
                path.append(fly.charAt(0)).append(i).append("-");
            }
        }
        path = new StringBuilder(path.substring(0, path.length() - 1));
        if (!path.toString().endsWith(fly)) {
            path.append("-").append(fly);
        }
        return path.toString();
    }

    // #3 exercise
    public static int digitsCount(long number) {
        if (number < 10) {
            return 1;
        } else {
            return 1 + digitsCount(number / 10);
        }
    }


    // #4 exercise
    public static int totalPoints(String[] guesses, String word) {
        int points = 0;
        char[] scrambled = word.toCharArray();
        Arrays.sort(scrambled); // сортируем буквы в скремблированном слове
        for (String guess : guesses) {
            if (guess.length() < 3 || guess.length() > 6) {
                continue; // игнорируем слова неподходящей длины
            }
            char[] letters = guess.toCharArray();
            Arrays.sort(letters);// сортируем буквы в угаданном слове
            boolean isPossible = true;
            for (char letter : letters) {
                int index = Arrays.binarySearch(scrambled, letter);
                if (index < 0) {
                    isPossible = false;
                    break;
                } // если буква не найдена, то слово нельзя составить
                else {
                    scrambled[index] = '_'; // помечаем использованную букву
                }
            }

            if (isPossible) {
                switch (guess.length()) {
                    case 3:
                        points += 1;
                        break;
                    case 4:
                        points += 2;
                        break;
                    case 5:
                        points += 3;
                        break;
                    case 6:
                        points += 54; // бонус за расшифровку слова
                        break;

                }
            }
            scrambled = word.toCharArray(); // восстанавливаем скремблированное слово
            Arrays.sort(scrambled); // сортируем буквы в скремблированном слове
        }
        return points;
    }


    // #5 exercise
    public static String sumsUp(int[] nums) {
        ArrayList<Integer[]> pairsIndexes = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) { // находятся индексы с элементами дающими 8
            int num1 = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int num2 = nums[j];
                if (num1 + num2 == 8 && i != j) {
                    pairsIndexes.add(new Integer[]{i, j});
                }
            }
        }
        for (int i = 0; i < pairsIndexes.size(); i++) { // сортировка индексов по возрастанию разности
            Integer[] min = pairsIndexes.get(i);
            int minId = i;
            for (int j = i; j < pairsIndexes.size(); j++) {
                if (pairsIndexes.get(j)[1] - pairsIndexes.get(j)[0] < min[1] - min[0]) {
                    min = pairsIndexes.get(j);
                    minId = j;
                }
            }
            Integer[] temp = pairsIndexes.get(i);
            pairsIndexes.set(i, min);
            pairsIndexes.set(minId, temp);
        }
        int[][] res = new int[pairsIndexes.size()][2];
        for (int i = 0; i < res.length; i++) { // заполнение массива итоговыми числами по их индексам
            res[i][0] = nums[pairsIndexes.get(i)[0]];
            res[i][1] = nums[pairsIndexes.get(i)[1]];
        }
        return Arrays.deepToString(res);
    }

    // #6 exercise

    public static String takeDownAverage(String[] perc){
        float sum = 0;
        for (String num: perc) {
            sum+= Integer.parseInt(num.substring(0, num.length()-1));
        }

        return String.valueOf((int)(((sum/perc.length) - 5) * (perc.length + 1)) - sum) + "%";

    }

    // #7 exercise
    public static String caesarCipher(String comm, String str, int shift) {

        StringBuilder result = new StringBuilder();

        if (comm.equals("encode")) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == ' ' || str.charAt(i) == '!' || str.charAt(i) == '?' || str.charAt(i) == '.' || str.charAt(i) == ',') {
                    result.append(str.charAt(i));
                    continue;
                }
                char newChar = (char) (str.charAt(i) + shift);
                result.append(String.valueOf(newChar).toUpperCase());
            }
        } else if (comm.equals("decode")) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == ' ' || str.charAt(i) == '!' || str.charAt(i) == '?' || str.charAt(i) == '.' || str.charAt(i) == ',') {
                    result.append(str.charAt(i));
                    continue;
                }
                char newChar = (char) (str.charAt(i) - shift);
                result.append(String.valueOf(newChar).toUpperCase());
            }
        }
        return result.toString();
    }


    // #8 exercise
    public static int setSetup(int n, int k) {
        if (n - k == 1) {
            int res = 1;
            for (int i = 2; i <= n; i++) {
                res *= i;
            }
            return res;
        }
        return setSetup(n - 1, k) * n / (n - k);
    }


    // #9 exercise
    public static String timeDifference(String cityA, String timestamp, String cityB) {

    // Создаем объекты для работы с датой и временем
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy HH:mm", Locale.US);
    LocalDateTime dateTimeA = LocalDateTime.parse(timestamp, formatter);

    // Создаем карту городов и их смещений по Гринвичу
    Map<String, Integer> cities = new HashMap<>();
    cities.put("Los Angeles",-8);
    cities.put("New York",-5);
    cities.put("Caracas",-4);
    cities.put("Buenos Aires",-3);
    cities.put("London",0);
    cities.put("Rome",1);
    cities.put("Moscow",3);
    cities.put("Tehran", (int) 3.5);
    cities.put("New Delhi",(int) 5.5);
    cities.put("Beijing",8);
    cities.put("Canberra",10);

    // Получаем смещение времени для каждого города
    int offsetA = cities.get(cityA);
    int offsetB = cities.get(cityB);

    // Вычисляем разницу во времени между городами
    int difference = offsetB - offsetA;

    // Добавляем разницу к времени в cityA и форматируем результат
    LocalDateTime dateTimeB = dateTimeA.plusHours(difference);
    DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-M-d HH:mm");
    return dateTimeB.format(outputFormatter);
    }


    // #10 exercise
    public static boolean isNew(int num) { // task 10
        int[] nums = new int[String.valueOf(num).length()];
        int num2 = num;
        for (int i = 0; num2 >= 1 ; i++) {
            nums[i] = (num2 % 10);
            num2 /= 10;
        }
        Arrays.sort(nums);
        StringBuilder compareNum = new StringBuilder(); // минимальное число с которым нужно сравнить исходное
        for (int i = 0; i < nums.length; i++) {
            compareNum.append(nums[i]);
        }
        if (compareNum.toString().startsWith("0")) {
            compareNum = new StringBuilder(compareNum.toString().replaceFirst("\\b\\d{2}", // замена незначимого 0 и числа после него
                    String.valueOf(compareNum.charAt(1) + String.valueOf(compareNum.charAt(0)))));
        }
        return num <= Integer.parseInt(compareNum.toString());
    }

    public static void main(String[] args) {
        System.out.println("#1 exercise");
        System.out.println(sameLetterPattern("ABAB", "CDCD"));
        System.out.println(sameLetterPattern("ABCBA", "BCDCB"));
        System.out.println(sameLetterPattern("FFGG", "CDCD"));
        System.out.println(sameLetterPattern("FFFF", "ABCD"));

        System.out.println("#2 exercise");
        System.out.println("Примеры");
        System.out.println(spiderVsFly("H3", "E2"));
        System.out.println(spiderVsFly("A4", "B2"));
        System.out.println(spiderVsFly("A4", "C2"));

        System.out.println("#3 exercise");
        System.out.println(digitsCount(4666));
        System.out.println(digitsCount(544));
        System.out.println(digitsCount(121317));
        System.out.println(digitsCount(0));
        System.out.println(digitsCount(12345));
        System.out.println(digitsCount(1289396587326L));

        System.out.println("#4 exercise");
        System.out.println(totalPoints(new String[]{"cat", "create", "sat"}, "caster"));
        System.out.println(totalPoints(new String[]{"trance", "recant", "sat"}, "recant"));
        System.out.println(totalPoints(new String[]{"dote", "dotes", "toes", "set", "dot", "dots", "sted"}, "tossed"));

        System.out.println("#5 exercise");
        System.out.println(sumsUp(new int[]{1, 2, 3, 4, 5}));
        System.out.println(sumsUp(new int[]{1, 2, 3, 7, 9}));
        System.out.println(sumsUp(new int[]{1, 6, 5, 4, 8, 2, 3, 7}));

        System.out.println("#6 exercise");
        System.out.println(takeDownAverage(new String[]{"95%", "83%", "90%", "87%", "88%", "93%"}));
        System.out.println(takeDownAverage(new String[]{"10%"}));
        System.out.println(takeDownAverage(new String[]{"53%", "79%"}));

        System.out.println("#7 exercise");
        System.out.println(caesarCipher("encode", "hello world", 3));
        System.out.println(caesarCipher("decode", "EPQSWX PEWX XEWO!", 4));

        System.out.println("#8 exercise");
        System.out.println(setSetup(5, 3));
        System.out.println(setSetup(7, 3));

        System.out.println("#9 exercise");
        System.out.println(timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra"));
        System.out.println(timeDifference("London", "July 31, 1983 23:01", "Rome"));
        System.out.println(timeDifference("New York", "December 31, 1970 13:40", "Beijing"));

        System.out.println("#10 exercise");
        System.out.println(isNew(3));
        System.out.println(isNew(30));
        System.out.println(isNew(321));
        System.out.println(isNew(123));
    }
}
