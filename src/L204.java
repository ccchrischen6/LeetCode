public class L204 {
    public static int countPrimes(int n) {
        if (n <= 2) return 0;
        int memo = 0;
        for (int i=3; i<=n; i++){
            memo = memo + isPrime(i-1);
        }
        return memo;
    }

    public static int isPrime(int n){
        if (n<=3) return 1;
        if (n%2 == 0) return 0;
        if (n % 6 != 1 && n % 6 != 5)
            return 0;
        for (int i=5; i<=Math.sqrt(n); i+=6){
            if (n%i == 0 || n%(i+2) == 0) return 0;
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(1000000000));
    }
}
