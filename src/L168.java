public class L168 {
    public static String convertToTitle(int n) {
        String res = "";
        char ch;
        while (n != 0){
            ch = (char) ((n-1)%26 + 65);
            n = (n-1)/26;
            res = ch + res;
        }
        return res;
    }
public static void main(String[] args) {
    System.out.println(convertToTitle(702));
}
}
