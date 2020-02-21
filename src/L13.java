class L13 {
    public int romanToInt(String s) {
        char[] charArray = s.toCharArray();
        int[] nums = new int[charArray.length];
        for (int j=0; j<nums.length; j++){
            if (charArray[j] == 'I') nums[j] = 1;
            if (charArray[j] == 'V') nums[j] = 5;
            if (charArray[j] == 'X') nums[j] = 10;
            if (charArray[j] == 'L') nums[j] = 50;
            if (charArray[j] == 'C') nums[j] = 100;
            if (charArray[j] == 'D') nums[j] = 500;
            if (charArray[j] == 'M') nums[j] = 1000;
        }

        int sum = nums[nums.length-1];
        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i] < nums[i+1]){
                sum -= nums[i];
            } else {
                sum += nums[i];
            }
        }
        return sum;
    }
}