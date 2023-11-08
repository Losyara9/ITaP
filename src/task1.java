
public class task1 {

    // #1 exercise
    public static double convert(double a) {
        return (a * 3.785);
    }

    // #2 exercise
    public static int fitCalc(int a, int b) {
        return (a * b);
    }

    // #3 exercise
    public static int containers(int a, int b, int c) {
        return (a*20 + b*50 + c *100);
    }

    // #4 exercise
    public static String triangleType(int x, int y, int z) {
        String result;
        if ((x + y < z) | (x + z < y) | (z + y < x)){
            result = "not a triangle";
        }

        else if ((x == y) & (y == z)) {
            result = "isosceles";
        }
        else if ((x == y) | (y == z) | (x == z)) {
            result = "equilateral";
        }

        else{
            return "different-sided";
        }

        return result;
    }

    // #5 exercise
    public static int ternayEvalution(int a, int b) {
        return a > b ? a : b;
    }

    // #6 exercise
    public static int howManyItems(int n, double w, double h) {
        double result = ((n / 2) / (w * h));
        int res = (int) result;
        return res;
    }

    // #7 exercise
    public static int factorial(int a) {
        int res = 1;
        int x = a;
        while (x != 1) {
            res = res * x;
            x--;
        }
        return res;
    }

    // #8 exercise
    public static int gcd(int a, int b) {
        int res = 1;
        for (int i = 1; i <= a && i <= b; i++) {
            if (a % i == 0 && b % i == 0) {
                res = i;
            }
        }
        return res;
    }

    // #9 exercise
    public static int ticketSaler(int a, int b) {
        double res = a * (b-(b*0.28));
        int result = (int) res;
        return result;
    }

    // #10 exercise
    public static int tabels(int a, int b) {
        int totalDesks = (int) Math.ceil(a / 2.0);
        int desksNeeded = totalDesks - b;
        if (desksNeeded < 0) {
            return 0;
        } else {
            return desksNeeded;
        }
    }


    public static void main(String[] args) {
        System.out.println(convert(5));
        System.out.println(convert(3));
        System.out.println(convert(8));

        System.out.println(fitCalc(15, 1));
        System.out.println(fitCalc(24, 2));
        System.out.println(fitCalc(41, 3));

        System.out.println(containers(3, 4, 2));
        System.out.println(containers(5, 0, 2));
        System.out.println(containers(4, 1, 4));

        System.out.println(triangleType(5, 5, 5));
        System.out.println(triangleType(5, 4, 5));
        System.out.println(triangleType(3, 4, 5));
        System.out.println(triangleType(5, 1, 1));

        System.out.println(ternayEvalution(8, 4));
        System.out.println(ternayEvalution(1, 11));
        System.out.println(ternayEvalution(5, 9));

        System.out.println(howManyItems(22, 1.4, 2));
        System.out.println(howManyItems(45, 1.8, 1.9));
        System.out.println(howManyItems(100, 2, 2));

        System.out.println(factorial(3));
        System.out.println(factorial(5));
        System.out.println(factorial(7));

        System.out.println(gcd(48, 18));
        System.out.println(gcd(52, 8));
        System.out.println(gcd(259, 28));

        System.out.println(ticketSaler(70, 1500));
        System.out.println(ticketSaler(24, 950));
        System.out.println(ticketSaler(53, 1250));

        System.out.println(tabels(5, 2));
        System.out.println(tabels(31, 20));
        System.out.println(tabels(123, 58));
    }
}