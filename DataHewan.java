public class DataHewan {
    public static void main(String[] args) {
        // a. Membuat array String berisi 5 nama hewan
        String[] hewan = {"Kucing", "Kelinci", "Burung", "Ikan", "Kuda"};

        // b. Menggunakan for loop untuk mencetak semua nama hewan
        System.out.println("Daftar Nama Hewan di Kebun Binatang Bu Yuyun:");
        for (int i = 0; i < hewan.length; i++) {
            // c. Menampilkan hasil sesuai urutan penyimpanan
            System.out.println((i + 1) + ". " + hewan[i]);
        }
    }
}
