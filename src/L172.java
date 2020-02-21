public class L172 {
    public int trailingZeroes(int n) {
        return n/5;
    }
    public static void main(String[] args) {
        long mul = 1;
        for (int i=1; i<31; i++){
            mul *= i;
            System.out.println(i + ": " + mul);
        }
    }
}
