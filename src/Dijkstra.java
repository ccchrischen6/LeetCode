import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Dijkstra {
    PriorityQueue<Cell> minHeap;
    Set<String> visited = new HashSet<>();

    public int kthSmallest(int[][] matrix, int k) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        minHeap = new PriorityQueue<>((c1, c2) -> (c1.val - c2.val));

        helper(0,0,matrix);
        for (int i = 0; i < k - 1; i++) {
            Cell cur = minHeap.poll();
            int r = cur.r, c = cur.c;
            if (r+1 < rows) {
                helper(r+1,c,matrix);
            }
            if (c+1 < columns) {
                helper(r,c+1,matrix);
            }
        }
        return minHeap.peek().val;
    }

    private void helper(int r, int c, int[][] matrix){
        if(visited.add((new StringBuilder(r+"@" +c)).toString())){
            Cell cell = new Cell(r,c,matrix[r][c]);
            minHeap.offer(cell);
        }
    }

    static class Cell {
        int r;
        int c;
        int val;

        Cell(int r, int c, int val) {
            this.r = r;
            this.c = c;
            this.val = val;
        }
    }
}
