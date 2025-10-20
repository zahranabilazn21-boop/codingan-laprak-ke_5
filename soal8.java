public class soal8 {
    public static void main(String[] args) {
        int[][] angka = {
            {2, 4, 6},
            {1, 3, 5},
            {7, 9, 11}
        };

        int jumlah = 0; 

        System.out.println("Isi Matriks:");
        for (int i = 0; i < angka.length; i++) { 
            for (int j = 0; j < angka[i].length; j++) {
                System.out.print(angka[i][j] + " "); 
                jumlah += angka[i][j]; 
            }
            System.out.println(); 
        }

        System.out.println("\nJumlah semua elemen = " + jumlah);
    }
}

