public class L58 {
    public static int lengthOfLastWord(String s) {
        int n = 0;
        for (int i=s.length()-1; i>=0; i--){
            if (n==0 && s.charAt(i) == ' ') continue;
            else if (s.charAt(i) != ' ') n++;
            else break;
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("a fdsf  "));
    }
}
