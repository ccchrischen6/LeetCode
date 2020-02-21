import javax.swing.table.TableRowSorter;
import java.util.Arrays;

public class L66 {
    public static int[] plusOne(int[] digits) {
        for (int i=digits.length-1; i>=0; i--){
            if (digits[i] < 9){
                digits[i]++;
                return digits;
            }else {
                digits[i] = 0;
            }
        }

        int[] digits2 = new int[digits.length+1];
        digits2[0] = 1;
        return digits2;
    }

    public static void main(String[] args) {
//        int[] a = new int[]{9,8,7,6,5,4,3,2,1,0};
//        System.out.println(Arrays.toString(plusOne(a)));
        long x = Long.parseLong("98765432100");
        if (x>Integer.MAX_VALUE)
            System.out.println(true);


    }
}
