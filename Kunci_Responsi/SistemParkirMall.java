import java.util.Scanner;

public class SistemParkirMall {
    // 1. Array 2 Dimensi: 3 Lantai x 5 Slot
    // Nilai 0 = Kosong, Nilai > 0 = ID Kendaraan
    static int[][] parkir = new int[3][5];

    // Variabel Global untuk Stack (Manual) - Kapasitas 10 Log
    static String[] logStack = new String[10];
    static int top = -1; // Penanda posisi atas tumpukan

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;

        // 2. Do-While Loop: Program berjalan terus sampai user pilih Exit
        do {
            System.out.println("\n===========================================");
            System.out.println("   SISTEM MANAJEMEN PARKIR MALL (SMART PARKING)");
            System.out.println("===========================================");
            System.out.println("1. Reset/Kosongkan Seluruh Parkiran");
            System.out.println("2. Input Kendaraan Masuk (Update)");
            System.out.println("3. Tampilkan Denah Parkir (Matriks 2D)");
            System.out.println("4. Urutkan ID Kendaraan (Sorting Manual)");
            System.out.println("5. Lihat Riwayat Masuk (Stack LIFO)");
            System.out.println("6. Keluar");
            System.out.print("Pilih Menu (1-6): ");
            pilihan = scanner.nextInt();

            // 3. Switch Case: Navigasi Menu
            switch (pilihan) {
                case 1:
                    resetParkiran();
                    break;
                case 2:
                    masukkanKendaraan();
                    break;
                case 3:
                    tampilkanDenah();
                    break;
                case 4:
                    sortingKendaraan();
                    break;
                case 5:
                    tampilkanRiwayat();
                    break;
                case 6:
                    System.out.println("Sistem dimatikan. Sampai Jumpa!");
                    break;
                default:
                    System.out.println("[ERROR] Pilihan tidak valid!");
            }
        } while (pilihan != 6);
    }

    // --- FITUR 1: Reset Array 2D ---
    static void resetParkiran() {
        // Nested Loop untuk mengisi semua slot dengan 0
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                parkir[i][j] = 0;
            }
        }
        System.out.println("[SUKSES] Seluruh area parkir telah dikosongkan.");
        pushStack("Reset Total Area Parkir");
    }

    // --- FITUR 2: Input Data (Percabangan & Validasi) ---
    static void masukkanKendaraan() {
        System.out.println("\n--- Input Kendaraan Masuk ---");
        System.out.print("Pilih Lantai (0-2): ");
        int lantai = scanner.nextInt();
        System.out.print("Pilih Nomor Slot (0-4): ");
        int slot = scanner.nextInt();

        // 4. Percabangan: Validasi Koordinat
        if (lantai < 0 || lantai > 2 || slot < 0 || slot > 4) {
            System.out.println("[ERROR] Lantai atau Slot tidak ditemukan!");
        } else {
            // Cek apakah slot sudah terisi?
            if (parkir[lantai][slot] != 0) {
                System.out.println("[GAGAL] Slot Lantai " + lantai + " No " + slot + " sudah terisi!");
            } else {
                System.out.print("Masukkan ID Kendaraan (Angka Unik): ");
                int idKendaraan = scanner.nextInt();

                // Validasi ID tidak boleh 0 atau negatif
                if (idKendaraan <= 0) {
                    System.out.println("[ERROR] ID Kendaraan harus angka positif!");
                } else {
                    parkir[lantai][slot] = idKendaraan;
                    System.out.println("[SUKSES] Kendaraan berhasil parkir.");
                    
                    // Simpan ke Stack
                    String log = "Masuk: ID " + idKendaraan + " di L-" + lantai + " S-" + slot;
                    pushStack(log);
                }
            }
        }
    }

    // --- FITUR 3: Tampilkan Array 2D (Visualisasi) ---
    static void tampilkanDenah() {
        System.out.println("\n--- Denah Area Parkir (3 Lantai x 5 Slot) ---");
        System.out.println("Keterangan: [ 0 ] = Kosong, [ ID ] = Terisi");
        
        // 5. Perulangan Bersarang
        for (int i = 0; i < 3; i++) {
            System.out.print("Lantai " + i + ": ");
            for (int j = 0; j < 5; j++) {
                // Tampilkan format rapi
                if (parkir[i][j] == 0) {
                    System.out.print("[   0   ] ");
                } else {
                    System.out.printf("[%7d] ", parkir[i][j]);
                }
            }
            System.out.println(); // Enter ganti baris lantai
        }
    }

    // --- FITUR 4: Sorting Manual (Bubble Sort) ---
    static void sortingKendaraan() {
        // Array sementara untuk menampung ID kendaraan (Max 15 slot)
        int[] tempArray = new int[15];
        int count = 0; // Menghitung jumlah kendaraan yang ada

        // Flattening: Pindah data dari 2D ke 1D (Hanya yang bukan 0)
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                if (parkir[i][j] != 0) {
                    tempArray[count] = parkir[i][j];
                    count++;
                }
            }
        }

        if (count == 0) {
            System.out.println("[INFO] Parkiran sedang kosong, tidak ada data untuk diurutkan.");
            return;
        }

        // 6. Algoritma Bubble Sort (Ascending / Kecil ke Besar)
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (tempArray[j] > tempArray[j + 1]) {
                    // Tukar Posisi (Swap)
                    int temp = tempArray[j];
                    tempArray[j] = tempArray[j + 1];
                    tempArray[j + 1] = temp;
                }
            }
        }

        // Tampilkan Hasil Sorting
        System.out.println("\n--- Daftar Kendaraan Berdasarkan ID (Terurut) ---");
        for (int i = 0; i < count; i++) {
            System.out.print(tempArray[i] + " -> ");
        }
        System.out.println("Selesai");
    }

    // --- FITUR 5: Stack Manual (Log Riwayat) ---
    static void pushStack(String aktivitas) {
        // Jika Stack Penuh, geser data lama (hapus yang paling tua)
        if (top >= logStack.length - 1) {
            for (int i = 0; i < logStack.length - 1; i++) {
                logStack[i] = logStack[i+1];
            }
            top--;
        }
        // Masukkan data baru
        top++;
        logStack[top] = aktivitas;
    }

    static void tampilkanRiwayat() {
        System.out.println("\n--- Riwayat Transaksi Terakhir (Stack LIFO) ---");
        if (top == -1) {
            System.out.println("(Belum ada kendaraan masuk)");
        } else {
            // Loop mundur dari Top ke 0
            for (int i = top; i >= 0; i--) {
                System.out.println((top - i + 1) + ". " + logStack[i]);
            }
        }
    }
}