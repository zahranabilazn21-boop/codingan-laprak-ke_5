public class soal4  {
    public static void main(String[] args) {
        int[] bilangan = new int[5];

        for (int i = 0; i < bilangan.length; i++) {
            bilangan[i] = i + 1;
        }

        System.out.println("Isi array:");
        for (int angka : bilangan) {
            System.out.println(angka);
        }
    }
}
