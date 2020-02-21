
public class L1232 {
    public boolean checkStraightLine(int[][] coordinates) {
        int n = coordinates.length;
        if (n == 2) return true;
        if (n <= 1) return false;
        double slope = (double) (coordinates[0][1] - coordinates[1][1]) / (coordinates[0][0] - coordinates[1][0]);
        double interaction = coordinates[0][1] - slope * coordinates[0][0];

        for (int i = 2; i < n; i++) {
            if (coordinates[i][1] != coordinates[i][0] * slope + interaction)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        double i = (double) (2-1)/3;
        int j = 1;
        System.out.println(i*3==j);
        System.out.println(i);
        System.out.println(j);
    }
}

