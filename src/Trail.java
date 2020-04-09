import javax.swing.tree.TreeNode;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class Trail {
    /**
     *[3,1,2,4]
     */
    public static void main(String[] args) throws IOException {
        backspaceCompare("bxj##tw"
                ,"bxo#j##tw");


    }

    public static boolean backspaceCompare(String S, String T) {
        if(S==null && T==null) return true;
        int i = S.length()-1;
        int j = T.length()-1;
        int ci = 0;
        int cj = 0;
        while(i>=0 && j>=0){
            //process S
            while(S.charAt(i) == '#'){
                i--;
                ci++;
            }
            i -= ci;
            ci = 0;

            //process T
            while(T.charAt(j) == '#'){
                j--;
                cj++;
            }
            j -= cj;
            cj = 0;

            if(i>=0 && j>=0 && S.charAt(i) != T.charAt(j)) return false;
            i--;
            j--;
        }
        System.out.println(i + " " + j);
        while(i >= 0 && S.charAt(i) == '#') i--;
        while(j >= 0 && S.charAt(j) == '#') j--;

        if(i<=0 && j<=0) return true;
        return i==j;

    }
}
