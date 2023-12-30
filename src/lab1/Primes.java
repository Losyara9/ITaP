public class Primes {
    public static boolean isPrime(int n) {
        if(n < 2) return false;
        for(int i = 2; i <= n / 2; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main (String[] args) {
        int n;
        for(n = 2; n < 100; n++) {
            System.out.println(isPrime(n) + " " + n);
        }

    }
}
