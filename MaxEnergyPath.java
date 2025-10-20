public class MaxEnergyPath {
    public static void main(String[] args) {
        int[][] grid = {
            {5, 3, 2, 1},
            {1, 2, 10, 2},
            {4, 3, 1, 3},
            {2, 1, 2, 20}
        };

        int n = grid.length;
        int[][] dp = new int[n][n];
        int[][] path = new int[n][n]; // simpan arah asal: 0 = dari atas, 1 = dari kiri

        // Inisialisasi titik awal
        dp[0][0] = grid[0][0];

        // Isi baris pertama (cuma bisa dari kiri)
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
            path[0][j] = 1; // dari kiri
        }

        // Isi kolom pertama (cuma bisa dari atas)
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
            path[i][0] = 0; // dari atas
        }

        // Proses isi DP
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    dp[i][j] = grid[i][j] + dp[i - 1][j];
                    path[i][j] = 0; // dari atas
                } else {
                    dp[i][j] = grid[i][j] + dp[i][j - 1];
                    path[i][j] = 1; // dari kiri
                }
            }
        }

        // Rekonstruksi jalur terbaik dari (N-1, N-1)
        StringBuilder bestPath = new StringBuilder();
        int i = n - 1, j = n - 1;
        while (i > 0 || j > 0) {
            bestPath.insert(0, String.format("(%d,%d) -> ", i, j));
            if (path[i][j] == 0) i--;
            else j--;
        }
        bestPath.insert(0, "(0,0) -> ");

        // Output hasil
        System.out.println("Jalur terbaik: " + bestPath.substring(0, bestPath.length() - 4));
        System.out.println("Total Energi Maksimum: " + dp[n - 1][n-1]);
}
}