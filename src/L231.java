public class L231 {
    public static boolean isPowerOfTwo(int n) {
        double result = Math.log10(n) / Math.log10(2);
        if (result%1 == 0) return true;
        else return false;
    }

    public static void main(String[] args) {
        for(int i=1; i<20; i++)
            System.out.println(i + "th " + isPowerOfTwo(i));
    }
}
