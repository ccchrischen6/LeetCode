public class L70_f {
    public static int climbStairs(int n) {
        int a = 1;
        int b = 1;
        int temp;
        for (int i=1; i<=n; i++){
            temp = b;
            b += a;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        for (int i=1; i<10; i++)
            System.out.println(climbStairs(i));
    }
}
