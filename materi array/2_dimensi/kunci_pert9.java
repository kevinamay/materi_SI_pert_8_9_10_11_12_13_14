import java.util.Scanner;

public class kunci_pert9 {

    public static void main(String[] args) {
        // Deklarasi array 2 dimensi utama
        double[][] data = new double[10][2]; // 10 baris, 2 kolom (double)
        int[][] nilai = new int[10][2];      // 10 baris, 2 kolom (int)

        int jumdata = 0; // Menghitung jumlah baris data yang terisi
        int pilihan;
        Scanner scan = new Scanner(System.in);

        do {
            // Tampilan Menu
            System.out.println("===== Menu Sederhana Array 2D =====");
            System.out.println("1. Input Data (Nilai dan Data)");
            System.out.println("2. Tampilkan Data (Nilai dan Data)");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu (1/2/3): ");

            if (scan.hasNextInt()) {
                pilihan = scan.nextInt();
                scan.nextLine(); // Membersihkan buffer newline
            } else {
                System.out.println("Input tidak valid. Harap masukkan angka.");
                scan.nextLine(); // Membersihkan input yang salah
                pilihan = 0;
                continue;
            }

            // Pemrosesan Pilihan menggunakan Switch-Case
            switch (pilihan) {
                case 1:
                    // 1. Input Data
                    System.out.println("--- Pilihan: Input Data ---");
                    if (jumdata < data.length) {
                        int i = jumdata; // Indeks baris saat ini

                        System.out.println("Memasukkan data pada Indeks Baris ke-" + i);

                        // Input Data (double) menggunakan perulangan for
                        for (int j = 0; j < 2; j++) {
                            System.out.print("Masukkan Data " + (j + 1) + " (double) = ");
                            data[i][j] = scan.nextDouble();
                        }

                        // Input Nilai (int) menggunakan perulangan for
                        for (int j = 0; j < 2; j++) {
                            System.out.print("Masukkan Nilai " + (j + 1) + " (int) = ");
                            nilai[i][j] = scan.nextInt();
                        }

                        scan.nextLine(); // Membersihkan buffer
                        jumdata++;
                        System.out.println("Data berhasil dimasukkan pada baris ke-" + (i) + ".");
                    } else {
                        System.out.println("Penyimpanan data sudah penuh (Maksimal " + data.length + " baris).");
                    }
                    break;

                case 2:
                    // 2. Tampilkan Data (Menggunakan println yang lebih sederhana/natural)
                    System.out.println("--- Pilihan: Tampilkan Data ---");
                    if (jumdata == 0) {
                        System.out.println("Belum ada data yang tersimpan.");
                    } else {
                        System.out.println("Total " + jumdata + " baris data tersimpan:");
                        System.out.println("==========================================");
                        
                        for (int i = 0; i < jumdata; i++) {
                             System.out.println("Data Baris ke-" + i + ":");
                             // Menampilkan Data Double
                             System.out.println("  Data Double: " + data[i][0] + " dan " + data[i][1]);
                             // Menampilkan Nilai Int
                             System.out.println("  Nilai Int  : " + nilai[i][0] + " dan " + nilai[i][1]);
                             System.out.println("------------------------------------------");
                        }
                    }
                    break;

                case 3:
                    // 3. Keluar
                    System.out.println("\nTerima kasih! Program Selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih 1, 2, atau 3.");
            }
        } while (pilihan != 3); 
        
        scan.close();
    }
}