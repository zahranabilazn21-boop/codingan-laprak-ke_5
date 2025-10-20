import java.util.*;

public class RobotPathMaxEnerg {
    
    public static void main(String[] args) {
        int[][] grid = {
            {5, 3, 2, 1},
            {1, 2, 10, 2},
            {4, 3, 1, 3},
            {2, 1, 2, 20}
        };
        
        findMaxEnergyPath(grid);
    }
    
    public static void findMaxEnergyPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        // Array untuk menyimpan energi maksimum
        int[][] dp = new int[n][m];
        
        // Array untuk melacak jalur
        char[][] path = new char[n][m]; // 'U' = dari atas, 'L' = dari kiri
        
        // Inisialisasi titik start
        dp[0][0] = grid[0][0];
        path[0][0] = 'S'; // Start
        
        // Isi baris pertama (hanya bisa dari kiri)
        for (int j = 1; j < m; j++) {
            dp[0][j] = dp[0][j-1] + grid[0][j];
            path[0][j] = 'L'; // Dari kiri
        }
        
        // Isi kolom pertama (hanya bisa dari atas)
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
            path[i][0] = 'U'; // Dari atas
        }
        
        // Isi sisa grid menggunakan dynamic programming
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (dp[i-1][j] > dp[i][j-1]) {
                    // Lebih menguntungkan dari atas
                    dp[i][j] = grid[i][j] + dp[i-1][j];
                    path[i][j] = 'U'; // Dari atas
                } else {
                    // Lebih menguntungkan dari kiri
                    dp[i][j] = grid[i][j] + dp[i][j-1];
                    path[i][j] = 'L'; // Dari kiri
                }
            }
        }
        
        // Dapatkan jalur terbaik dengan backtracking
        List<String> bestPath = getBestPath(path, grid);
        
        // Output hasil
        System.out.println("Jalur terbaik: " + String.join(" + ", bestPath));
        System.out.println("Total Energi Maksimum: " + dp[n-1][m-1]);
        
        // Optional: Tampilkan grid dp untuk verifikasi
        System.out.println("\nGrid Energi Maksimum (dp):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
    }
    
    private static List<String> getBestPath(char[][] path, int[][] grid) {
        List<String> result = new ArrayList<>();
        int i = path.length - 1;
        int j = path[0].length - 1;
        
        // Stack untuk menyimpan jalur dalam urutan terbalik
        Stack<String> stack = new Stack<>();
        stack.push("(" + i + "," + j + ")");
        
        // Backtrack dari akhir ke awal
        while (i > 0 || j > 0) {
            if (path[i][j] == 'U') {
                i--; // Bergerak ke atas
            } else if (path[i][j] == 'L') {
                j--; // Bergerak ke kiri
            }
            stack.push("(" + i + "," + j + ")");
        }
        
        // Pindahkan dari stack ke list untuk urutan yang benar
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        
        return result;
    }
}
