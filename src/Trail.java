import java.util.*;

public class Trail {
    private void test() {
        int[] a = new int[]{1, 2};
        int[] b = new int[]{1, 3};
        int[] c = new int[]{1, 1};
        int[][] intervals = new int[][]{a, b, c};
        for (int[] e : intervals) {
            System.out.println(Arrays.toString(e));
        }

        System.out.println("-------------");
        Collections.sort(Arrays.asList(intervals), new IntervalComparator());
        for (int[] e : intervals) {
            System.out.println(Arrays.toString(e));
        }
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

    }

    private class IntervalComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            return Integer.compare(a[0], b[0]);
        }
    }


}

/*
 *   ctrl + shift + /    多行注释
 *   cmd + d             复制当前行到下一行
 *   cmd + d             删除当前行
 *
 *
 * */