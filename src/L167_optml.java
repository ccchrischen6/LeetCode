public class L167_optml {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        if (numbers.length <= 1 || numbers == null || target < numbers[0]
                || target > numbers[numbers.length - 1] * 2) return null;

        int start = 0;
        int end = numbers.length-1;
        while (start != end){
            if (numbers[start] + numbers[end] > target) end--;
            else if (numbers[start] + numbers[end] < target) start++;
            else break;
        }
        result[0] = start+1;
        result[1] = end+1;
        return result;
    }
}
