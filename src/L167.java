import java.util.HashMap;
import java.util.Map;

public class L167 {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length == 0 || numbers == null || target < numbers[0]
                || target > numbers[numbers.length - 1] * 2) return null;
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap();

        int end = numbers.length;
        for (int i = 0; i < end; i++) {
            map.put(numbers[i], i);
        }


        for (int k = 0; k < end; k++) {
            if (map.containsKey(target - numbers[k]) && map.get(target - numbers[k]) != k) {
                result[0] = k + 1;
                result[1] = map.get(target - numbers[k]) + 1;
                break;
            }

        }
        return result;
    }
}
