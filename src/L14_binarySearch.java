public class L14_binarySearch {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs == null) return "";
        int minL = Integer.MAX_VALUE;
        for (String str : strs)
            minL = Math.min(str.length(), minL);

        int low = 1;
        int high = minL;
        int mid;
        while(low <= high){
            mid = (low + high)/2;
            if (isCommon(strs, mid))
                low = mid+1;
            else high = mid-1;
        }
        return strs[0].substring(0, (low+high)/2);
    }

    public static boolean isCommon(String[] strs, int len){
        for (int i=0; i<strs.length; i++){
            if (!strs[0].substring(0,len).equals(strs[i].substring(0,len)))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"BA", "BA", "BBA"};
        System.out.println(longestCommonPrefix(strs));
    }
}
