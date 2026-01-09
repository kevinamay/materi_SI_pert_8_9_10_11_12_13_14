import java.util.Scanner;

public class SistemRumahSakit {
    // 1. Array 2 Dimensi (4 Lantai x 4 Kamar) untuk menyimpan jumlah pasien
    static int[][] kamar = new int[4][4];

    // Variabel Global untuk Stack (Manual)
    static String[] riwayatStack = new String[10]; // Kapasitas history 10 aktivitas terakhir
    static int top = -1; // Penanda posisi atas tumpukan

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;

        // 2. Do-While Loop (Agar program terus berjalan sampai user keluar)
        do {
            System.out.println("\n==========================================");
            System.out.println("   SISTEM MANAJEMEN KAMAR RUMAH SAKIT");
            System.out.println("==========================================");
            System.out.println("1. Reset Data Kamar (Nol-kan Semua)");
            System.out.println("2. Update Jumlah Pasien (Input)");
            System.out.println("3. Tampilkan Denah Kamar (Array 2D)");
            System.out.println("4. Urutkan Data Pasien (Sorting Manual)");
            System.out.println("5. Lihat Riwayat Aktivitas (Stack)");
            System.out.println("6. Keluar");
            System.out.print("Pilih Menu (1-6): ");
            pilihan = scanner.nextInt();

            // 3. Switch Case (Untuk pemilihan menu)
            switch (pilihan) {
                case 1:
                    resetKamar();
                    break;
                case 2:
                    updatePasien();
                    break;
                case 3:
                    tampilkanDenah();
                    break;
                case 4:
                    sortingPasien();
                    break;
                case 5:
                    tampilkanRiwayat();
                    break;
                case 6:
                    System.out.println("Program Selesai. Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 6);
    }

    // --- FITUR 1: Inisialisasi/Reset Array ---
    static void resetKamar() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                kamar[i][j] = 0;
            }
        }
        System.out.println("[SUKSES] Semua data kamar telah di-reset menjadi 0.");
        pushStack("Reset semua data kamar"); // Simpan ke Stack
    }

    // --- FITUR 2: Update Data & Percabangan ---
    static void updatePasien() {
        System.out.print("Masukkan Lantai (0-3): ");
        int lantai = scanner.nextInt();
        System.out.print("Masukkan Nomor Kamar (0-3): ");
        int noKamar = scanner.nextInt();

        // 4. Percabangan (Validasi Input)
        if (lantai < 0 || lantai > 3 || noKamar < 0 || noKamar > 3) {
            System.out.println("[ERROR] Lantai atau Nomor Kamar tidak valid!");
        } else {
            System.out.print("Masukkan Jumlah Pasien: ");
            int jumlah = scanner.nextInt();

            if (jumlah < 0) {
                System.out.println("[ERROR] Jumlah pasien tidak boleh negatif.");
            } else {
                kamar[lantai][noKamar] = jumlah;
                System.out.println("[SUKSES] Data berhasil disimpan.");
                
                // Masukkan ke Stack
                String log = "Update: Lantai " + lantai + " | Kamar " + noKamar + " | Jml Pasien: " + jumlah;
                pushStack(log);
            }
        }
    }

    // --- FITUR 3: Menampilkan Array 2D ---
    static void tampilkanDenah() {
        System.out.println("\n--- Denah Kamar (Matriks 4x4) ---");
        // 5. Perulangan Bersarang (Nested Loop)
        for (int i = 0; i < 4; i++) {
            System.out.print("Lantai " + i + ": | ");
            for (int j = 0; j < 4; j++) {
                System.out.print(kamar[i][j] + " | "); // Cetak isi array
            }
            System.out.println(); // Pindah baris
        }
    }

    // --- FITUR 4: Sorting Manual (Bubble Sort) ---
    static void sortingPasien() {
        // Pindahkan data Array 2D ke Array 1D terlebih dahulu
        int[] tempArray = new int[16];
        int k = 0;
        
        // Flattening (2D ke 1D)
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                // Kita hanya ambil kamar yang ada pasiennya untuk diurutkan
                if(kamar[i][j] > 0) {
                    tempArray[k] = kamar[i][j];
                    k++;
                }
            }
        }

        if (k == 0) {
            System.out.println("Belum ada data pasien untuk diurutkan.");
            return;
        }

        // 6. Algoritma Sorting Manual (Bubble Sort)
        // Mengurutkan dari Terkecil ke Terbesar (Ascending)
        for (int i = 0; i < k - 1; i++) {
            for (int j = 0; j < k - i - 1; j++) {
                if (tempArray[j] > tempArray[j + 1]) {
                    // Tukar posisi (Swap)
                    int temp = tempArray[j];
                    tempArray[j] = tempArray[j + 1];
                    tempArray[j + 1] = temp;
                }
            }
        }

        // Tampilkan hasil sorting
        System.out.println("\n--- Data Keterisian Kamar Terurut (Ascending) ---");
        for (int i = 0; i < k; i++) {
            System.out.print(tempArray[i] + " ");
        }
        System.out.println("\n-------------------------------------------------");
    }

    // --- FITUR 5: Stack Manual (Push & Display) ---
    
    // Fungsi Push (Menambah data ke tumpukan paling atas)
    static void pushStack(String aktivitas) {
        if (top >= riwayatStack.length - 1) {
            // Jika stack penuh, geser data (opsional, agar data lama tertimpa)
            for (int i = 0; i < riwayatStack.length - 1; i++) {
                riwayatStack[i] = riwayatStack[i+1];
            }
            top--; 
        }
        top++;
        riwayatStack[top] = aktivitas;
    }

    // 7. Menampilkan Stack (LIFO - Last In First Out)
    static void tampilkanRiwayat() {
        System.out.println("\n--- Riwayat Aktivitas Terakhir (Stack LIFO) ---");
        if (top == -1) {
            System.out.println("(Belum ada aktivitas)");
        } else {
            // Loop mundur dari top ke 0
            for (int i = top; i >= 0; i--) {
                System.out.println((top - i + 1) + ". " + riwayatStack[i]);
            }
        }
    }
}