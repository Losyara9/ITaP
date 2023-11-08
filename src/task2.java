import java.util.Arrays;
import java.util.Random;

public class task2 {

    // #1 exercise
    public static boolean duplicateChars(String a) {
        a = a.toLowerCase();
        for (int i = 0; i < a.length() - 1; i++) {
            for (int j = i + 1; j < a.length(); j++) {
                if (a.charAt(i) == a.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }

    // #2 exercise
    public static String getInitials(String a) {
        String[] words = a.split(" ");
        String b = "";
        for (String word : words) {
            b += word.charAt(0);
        }
        return b;
    }

    // #3 exercise
    public static int deferenceEvenOdd(int nums[]) {
        int a = 0;
        int b = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                a += nums[i];
            }
            else {
                b += nums[i];
            }
        }
        if (a > b) {
            res = a - b;
        }
        else {
            res = b - a;
        }
        return res;
    }

    // #4 exercise
    public static boolean equalToAvg(int nums[]) {
        double a = 0;
        for (int i = 0; i < nums.length; i++) {
            a += nums[i];
        }
        for (int j = 0; j < nums.length; j++){
            if ((a / nums.length) == nums[j]){
                return true;
            }
        }
        return false;
    }

    // #5 exercise
    public static String indexMult(int[] nums) {
        for (int i = 0; i < nums.length; i = i + 1) {
            nums[i] = nums[i] * i;
            System.out.print(nums[i] + " ");
        }
        return " ";
    }

    // #6 exercise
    public static String reverse(String a) {
        String res = "";
        char[] count = a.toCharArray();
        for(int i = a.length() - 1; i > -1; i--) {
            res = res + count[i];
        }
        return res;
    }

    // #7 exercise
    public static int Tribonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        }

        int t0 = 0;
        int t1 = 0;
        int t2 = 1;
        int t3 = 0;

        for (int i = 4; i <= n; i++) {
            t3 = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = t3;
        }

        return t3;
    }

    // #8 exercise
    public static String pseudoHash(int length) {
        String characters = "0123456789abcdef";
        StringBuilder hash = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            hash.append(characters.charAt(index));
        }

        return hash.toString();
    }

    // #9 exercise
    public static String botHelper(String a) {
        int count = 0;
        String[] words = a.split(" ");
        for (int i = 0; i < words.length; i = i + 1) {
            if (words[i].equals("help")) {
                count++;
            }
        }
        if (count == 1) {
            return "Calling for a staff member";
        }
        else {
            return "Keep waiting";
        }
    }

    // #10 exercise
    public static boolean isAnagram(String str1, String str2) {
        // удаляем пробелы и приводим к нижнему регистру
        str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();

        if (str1.length() != str2.length()) {
            return false;
        }

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }

    public static void main(String[] args) {
        System.out.println(duplicateChars("Donald"));
        System.out.println(duplicateChars("orange"));

        System.out.println(getInitials("Ryan Gosling"));
        System.out.println(getInitials("Barack Obama"));

        int nums[] = {44, 32, 86, 19};
        System.out.println(deferenceEvenOdd(nums));
        int nums2[] = {22, 50, 16, 63, 31, 55};
        System.out.println(deferenceEvenOdd(nums2));

        int nums3[] = {1, 2, 3, 4, 5};
        System.out.println(equalToAvg(nums3));
        int nums4[] = {1, 2, 3, 4, 6};
        System.out.println(equalToAvg(nums4));

        int nums5[] = {1, 2, 3};
        System.out.println(indexMult(nums5));
        int nums6[] = {3, 3, -2, 408, 3, 31};
        System.out.println(indexMult(nums6));

        System.out.println(reverse("Hello World"));
        System.out.println(reverse("The quick brown fox."));

        System.out.println(Tribonacci(7));
        System.out.println(Tribonacci(11));

        System.out.println(pseudoHash(5));
        System.out.println(pseudoHash(10));
        System.out.println(pseudoHash(0));

        System.out.println(botHelper("Hello, I'm under water, please help me"));
        System.out.println(botHelper("Two pepperoni pizzas please"));

        System.out.println(isAnagram("listen", "silent"));
        System.out.println(isAnagram("eleven plus two", "twelve plus one"));
        System.out.println(isAnagram("hello", "world"));
    }
}
