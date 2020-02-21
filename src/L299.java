import java.util.ArrayList;

public class L299 {
    public static String getHint(String secret, String guess) {
        int n = secret.length();
        ArrayList SecretList = new ArrayList();
        ArrayList GuessList = new ArrayList();
        for (int i = 0; i < n; i++) {
            SecretList.add(Integer.parseInt(secret.substring(i, i + 1)));
            GuessList.add(Integer.parseInt(guess.substring(i, i + 1)));
        }

        int A = 0;
        int B = 0;
        for (int i = 0; i < n; i++) {
            if (SecretList.get(i) == GuessList.get(i)) {
                SecretList.set(i, "A");
                GuessList.set(i,"gA");
                A++;
            }
        }


        for (int i = 0; i < n; i++){
            int j = 0;
            while (j<n) {
                if (SecretList.get(i) == GuessList.get(j)){
                    SecretList.set(i, "B");
                    GuessList.set(j,"gB");
                    B++;
                    break;
                }
                j++;
            }

        }
        System.out.println(SecretList);
        System.out.println(GuessList);
        return A+"A"+B+"B";


    }

    public static void main(String[] args) {
        String s = "1123";
        String g = "0111";
        System.out.println(getHint(s, g));

    }
}
