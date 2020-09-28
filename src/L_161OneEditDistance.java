/**
 * Created by Chris Chen
 */
public class L_161OneEditDistance {
    boolean action = false;
    public boolean isOneEditDistance(String s, String t) {
        int i = s.length();
        int j = t.length();
        if(i>j){
            return isOneEditDistance(t, s);
        }

        if(j-i>1){
            return false;
        }

        return helper(s, t, i-1, j-1);

    }

    private boolean helper(String s, String t, int i, int j){
        if(i == -1){
            return j == -1 && action || j == 0 && !action;
        }

        if(j == -1){
            return i == -1 && action || i == 0 && !action;
        }

        if(s.charAt(i) == t.charAt(j)){
            return helper(s, t, i-1, j-1);
        }
        else{
            if(action){
                return false;
            }

            action = true;
            return helper(s, t, i-1, j-1) || helper(s, t, i, j-1);
        }

    }
}
