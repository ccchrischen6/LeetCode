import java.util.Arrays;
import java.util.List;

public class L118 {
    public static void  generate(int numRows) {
        int[][] pascalTri = new int[numRows][];
        for (int i=0; i<numRows; i++){
            pascalTri[i] = new int[i+1];
            pascalTri[i][0] = 1;
            pascalTri[i][i] = 1;
            for (int j=1; j<i; j++){
                pascalTri[i][j] = pascalTri[i-1][j-1] + pascalTri[i-1][j];
            }
            System.out.println(Arrays.toString(pascalTri[i]));
        }
    }

    public static void main(String[] args) {
        generate(5);
    }
}
