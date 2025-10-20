import java.util.Scanner;

public class RotasiArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] data = {1, 2, 3, 4, 5, 6};

        System.out.print("Array awal: ");
        for (int angka : data) {
            System.out.print(angka + " ");
        }

        System.out.print("\nMasukkan jumlah langkah rotasi (k): ");
        int k = input.nextInt();

        // b. Melakukan rotasi ke kanan sebanyak k langkah tanpa membuat array baru
        int n = data.length;
        k = k % n; 

        // Membalik seluruh elemen array
        reverse(data, 0, n - 1);
        // Membalik k elemen pertama
        reverse(data, 0, k - 1);
        // Membalik sisa elemen
        reverse(data, k, n - 1);

        // c. Menampilkan hasil setelah rotasi
        System.out.print("Array setelah rotasi: ");
        for (int angka : data) {
            System.out.print(angka + " ");
        }

        input.close();
    }

    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
