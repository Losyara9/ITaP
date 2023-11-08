import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class task3 {
    // #1 exercise
    public static String replaceVovels(String str) {
        return str.replaceAll("[aeiouyAEIOUY]", "*");
    }

    // #2 exercise
    public static String stringTransform(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i + 1 < s.length() && s.charAt(i + 1) == c) {
                result.append("Double").append(Character.toUpperCase(s.charAt(i + 1)));
                i++;
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    // #3 exercise
    public static boolean doesBlockFit(int a, int b, int c, int w, int h) {
        int max = Math.max(Math.max(a, b), c);
        return (max <= w && Math.min(a, Math.min(b, c)) <= h) || (max <= h && Math.min(a, Math.min(b, c)) <= w);
    }

    // #4 exercise
    public static boolean numCheck(int a) {
        int sum = 0;
        int num = a;
        while (num > 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return (sum % 2 == a % 2);
    }

    // #5 exercise
    public static int countRoots(int a, int b, int c) {
        int d = b*b - 4 * a * c;
        int count;
        if (d > 0) {
            count = 2;
        }
        else if (d == 0) {
            count = 1;
        }
        else {
            count = 0;
        }
        return (count);
    }

    // #6 exercise

    public static String salesData(String[][] arr) {
        HashSet<String> shops = new HashSet<>();
        HashSet<String> items = new HashSet<>();
        for(int i = 0; i < arr.length; i++){
            for(int j = 1; j < arr[i].length; j++){
                shops.add(arr[i][j]);
            }
        }

        for(int a = 0; a < arr.length; a++){
            HashSet<String> soldIn = new HashSet<>();
            for(int b = 1; b < arr[a].length; b++){
                soldIn.add(arr[a][b]);
            }
            if (soldIn.equals(shops)) {
                items.add(arr[a][0]);
            }
        }
        return items.toString();
    }

    // #7 exercise
    public static boolean validSplit(String sentence) {
        String[] words = sentence.split(" ");
        if (words.length < 2) {
            return false;
        }
        for (int i = 1; i < words.length; i++) {
            if (words[i].charAt(0) != words[i-1].charAt(words[i-1].length()-1)) {
                return false;
            }
        }
        return true;
    }

    // #8 exercise
    public static boolean waveForm(int[] arr) {
        if (arr.length < 2) {
            return false;
        }
        boolean increasing = arr[1] > arr[0];
        for (int i = 2; i < arr.length; i++) {
            if ((increasing && arr[i] >= arr[i-1]) || (!increasing && arr[i] <= arr[i-1])) {
                return false;
            }
            increasing = !increasing;
        }
        return true;
    }

    // #9 exercise

    public static char commonVowel(String sentence) {
        sentence = sentence.toLowerCase();
        HashMap<Character, Integer> vowelMap = new HashMap<>();
        vowelMap.put('a', 0);
        vowelMap.put('e', 0);
        vowelMap.put('i', 0);
        vowelMap.put('o', 0);
        vowelMap.put('u', 0);

        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            if (vowelMap.containsKey(c)) {
                int count = vowelMap.get(c);
                vowelMap.put(c, count + 1);
            }
        }

        char mostCommonVowel = ' ';
        int maxCount = 0;

        for (char vowel : vowelMap.keySet()) {
            int count = vowelMap.get(vowel);
            if (count > maxCount) {
                mostCommonVowel = vowel;
                maxCount = count;
            }
        }
        return mostCommonVowel;
    }


    // #10 exercise
    public static String dataScience(int[][] arr) {
        int sum = 0;
        int j = 0;
        int a = 0;
        for (int k = 0; k < arr.length; k++) {
            for (int i = 0; i < arr[k].length; i++) {
                sum += arr[i][k];
                j++;
            }
            arr[k][a] = sum / arr[k].length;
            a++;
            sum = 0;
        }
        return Arrays.deepToString(arr);
    }


    public static void main(String[] args) {
        System.out.println("#1 exercise");
        System.out.println(replaceVovels("apple"));
        System.out.println(replaceVovels("Even if you did this task not by yourself, you have to understand every single line of code"));

        System.out.println("#2 exercise");
        System.out.println(stringTransform("hello"));
        System.out.println(stringTransform("bookkeeper"));

        System.out.println("#3 exercise");
        System.out.println(doesBlockFit(1, 3, 5, 4, 5));
        System.out.println(doesBlockFit(1, 8, 1, 1, 1));
        System.out.println(doesBlockFit(1, 2, 2, 1, 1));

        System.out.println("#4 exercise");
        System.out.println(numCheck(243));
        System.out.println(numCheck(52));

        System.out.println("#5 exercise");
        System.out.println(countRoots(1, -3, 2));
        System.out.println(countRoots(2, 5, 2));
        System.out.println(countRoots(1, -6, 9));

        System.out.println("#6 exercise");
        System.out.println(salesData(new String[][] {
                {"Apple", "Shop1", "Shop2", "Shop3", "Shop4"},
                {"Banana", "Shop2", "Shop3", "Shop4"},
                {"Orange", "Shop1", "Shop3", "Shop4"},
                {"Pear", "Shop2", "Shop4"}
        }));
        System.out.println(salesData(new String[][] {
                {"Fridge", "Shop2", "Shop3"},
                {"Microwave", "Shop1", "Shop2", "Shop3", "Shop4"},
                {"Laptop", "Shop3", "Shop4"},
                {"Phone", "Shop1", "Shop2", "Shop3", "Shop4"}
        }));


        System.out.println("#7 exercise");
        System.out.println(validSplit("apple eagle egg goat"));
        System.out.println(validSplit("cat dog goose fish") );

        System.out.println("#8 exercise");
        System.out.println(waveForm(new int[] {3, 1, 4, 2, 7, 5}));
        System.out.println(waveForm(new int[] {1, 2, 3, 4, 5}));
        System.out.println(waveForm(new int[] {1, 2, -6, 10, 3}));

        System.out.println("#9 exercise");
        System.out.println(commonVowel("Hello world"));
        System.out.println(commonVowel("Actions speak louder than words."));

        System.out.println("#10 exercise");
        System.out.println(dataScience(new int[][] {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {5, 5, 5, 5, 5},
                {7, 4, 3, 14, 2},
                {1, 0, 11, 10, 1}
        }));
        System.out.println(dataScience(new int[][] {
                {6, 4, 19, 0, 0},
                {81, 25, 3, 1, 17},
                {48, 12, 60, 32, 14},
                {91, 47, 16, 65, 217},
                {5, 73, 0, 4, 21}
        }));
    }
}
