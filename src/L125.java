public class L125 {
    public static boolean isPalindrome(String s) {
        if (s.length() == 0 || s == null || s.length() == 1) return true;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ascii = s.charAt(i);
            if ((ascii > 96 && ascii < 123) || (ascii > 47 && ascii < 58))
                sb.append(ascii);
            if ((ascii > 64 && ascii < 91))
                sb.append((char) (ascii + 32));
        }
        for (int j = 0; j < sb.length() / 2; j++) {
            if (sb.charAt(j) != sb.charAt(sb.length() - 1 - j))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "A man, a plan, a canal: Panama";
        isPalindrome(a);
    }
}
