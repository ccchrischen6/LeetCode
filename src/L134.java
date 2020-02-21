public class L134 {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int start = 0;
        int tank = 0;
        for (int i=0; i<gas.length; i++){
            sum += gas[i] - cost[i];
        }
        if (sum < 0){
            return -1;
        }
        else {
            for (int i=0; i<gas.length; i++){
                tank += gas[i] - cost[i];
                if (tank<0){
                    tank = 0;
                    start = i + 1;
                }
            }
            return start;
        }
    }

    public static void main(String[] args) {
        int[] gas  = new int[]{3,1,1};
        int[] cost  = new int[]{1,2,2};
        System.out.println(canCompleteCircuit(gas, cost));
    }
}
