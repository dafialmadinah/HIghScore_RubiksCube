
import java.util.Scanner;

class HighScoreRubiksCube {
    private String[] pemain;
    private double[] waktu;
    private int jumlahPemain;

    public HighScoreRubiksCube(int jumlah) {
        pemain = new String[jumlah];
        waktu = new double[jumlah];
        jumlahPemain = 0;
    }

    public void tambahPemain(String nama, double waktuPenyelesaian) {
        if (jumlahPemain < pemain.length) {
            pemain[jumlahPemain] = nama;
            waktu[jumlahPemain] = waktuPenyelesaian;
            jumlahPemain++;
        } else {
            System.out.println("Kapasitas penuh, tidak bisa menambahkan pemain lagi.");
        }
    }

    public void bubbleSort() {
        for (int i = 0; i < jumlahPemain - 1; i++) {
            for (int j = 0; j < jumlahPemain - i - 1; j++) {
                if (waktu[j] > waktu[j + 1]) {
                    double tempWaktu = waktu[j];
                    waktu[j] = waktu[j + 1];
                    waktu[j + 1] = tempWaktu;

                    String tempNama = pemain[j];
                    pemain[j] = pemain[j + 1];
                    pemain[j + 1] = tempNama;
                }
            }
        }
    }

    public void insertionSort() {
        for (int i = 1; i < jumlahPemain; i++) {
            double kunci = waktu[i];
            String kunciNama = pemain[i];
            int j = i - 1;

            while (j >= 0 && waktu[j] > kunci) {
                waktu[j + 1] = waktu[j];
                pemain[j + 1] = pemain[j];
                j = j - 1;
            }
            waktu[j + 1] = kunci;
            pemain[j + 1] = kunciNama;
        }
    }

    public void tampilkanSkor() {
        System.out.println("Skor Terbaik:");
        for (int i = 0; i < jumlahPemain; i++) {
            System.out.printf("%d. %s - %.2f detik\n", i + 1, pemain[i], waktu[i]);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan jumlah pemain yang ingin ditambahkan: ");
        int jumlah = input.nextInt();
        input.nextLine(); 

        HighScoreRubiksCube papanSkor = new HighScoreRubiksCube(jumlah);

        for (int i = 0; i < jumlah; i++) {
            System.out.print("Masukkan nama pemain: ");
            String nama = input.nextLine();
            System.out.print("Masukkan waktu penyelesaian (dalam detik): ");
            double waktuPenyelesaian = input.nextDouble();
            input.nextLine();
            papanSkor.tambahPemain(nama, waktuPenyelesaian);
        }

        System.out.println("\nPilih metode sorting:");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Insertion Sort");
        int pilihan = input.nextInt();

        if (pilihan == 1) {
            papanSkor.bubbleSort();
        } else if (pilihan == 2) {
            papanSkor.insertionSort();
        } else {
            System.out.println("Pilihan tidak valid.");
            return;
        }

        papanSkor.tampilkanSkor();
    }
}
