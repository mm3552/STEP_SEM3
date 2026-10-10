package java_fundamentals.assigment_problems;
public class Q5_BusiestBusRow {
    static int busiestRow(int[][] grid) {
        int bestRow = 0, bestTotal = -1;
        for (int r = 0; r < grid.length; r++) {
            int total = 0;
            for (int c = 0; c < grid[r].length; c++) total += grid[r][c];
            if (total > bestTotal) {
                bestTotal = total;
                bestRow = r;
            }
        }
        System.out.println("Row " + bestRow + ", Total " + bestTotal);
        return bestRow;
    }
    public static void main(String[] args) {
        int[][] grid = {{2, 0, 1}, {3, 3, 1}, {1, 1, 1}};
        busiestRow(grid);
    }
}