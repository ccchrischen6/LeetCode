public class L190 {
    public static int reverseBits(int n) {
        String str = Integer.toBinaryString(n);
        str.replaceAll("0", "2");
        str.replaceAll("1", "0");
        str.replaceAll("2", "1");
        return Integer.parseInt(str);
    }

    public static void main(String[] args) {
        int a = 2;
        System.out.println(reverseBits(a));
    }
}
