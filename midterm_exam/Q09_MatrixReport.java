public class Q09_MatrixReport {
    public static void main(String[] args) {
        int[][] data = {
            {5, 8, 2},
            {9, 4, 7},
            {3, 6, 10}
        };
        System.out.println("第 1 列總和：" + rowSum(data, 0));
        System.out.println("第 2 欄總和：" + columnSum(data, 1));
        System.out.println("大於等於 7 的個數：" + countAtLeast(data, 7));
        System.out.println("總和最大的列索引：" + findRowWithLargestTotal(data));
    }

    public static int rowSum(int[][] data, int row) {
        if (row < 0 || row >= data.length) return -1;
        int sum = 0;
        for (int v : data[row]) sum += v;
        return sum;
    }

    public static int columnSum(int[][] data, int column) {
        if (column < 0 || column >= data[0].length) return -1;
        int sum = 0;
        for (int[] row : data) {
            if (column < row.length) sum += row[column];
        }
        return sum;
    }

    public static int countAtLeast(int[][] data, int target) {
        int count = 0;
        for (int[] row : data) {
            for (int v : row) {
                if (v >= target) count++;
            }
        }
        return count;
    }

    public static int findRowWithLargestTotal(int[][] data) {
        int maxSum = Integer.MIN_VALUE;
        int bestRow = -1;
        for (int i = 0; i < data.length; i++) {
            int sum = rowSum(data, i);
            if (sum > maxSum) {
                maxSum = sum;
                bestRow = i;
            }
        }
        return bestRow;
    }
}