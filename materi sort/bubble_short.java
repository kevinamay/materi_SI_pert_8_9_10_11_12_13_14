import java.util.Scanner;
public class bubble_short {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        // Input jumlah data
        System.out.print("Masukkan jumlah data: ");
        int jlh_data = scan.nextInt();
        
        // Input nilai tiap data
        int[] data = new int[jlh_data];
        System.out.println();
        for (int a = 0; a < jlh_data; a++) {
            System.out.print("Masukkan data ke-" + (a + 1) + ": ");
            data[a] = scan.nextInt();
        }
        
        // Tampilkan data sebelum diurutkan
        System.out.println("\n--- Data sebelum diurutkan ---");
        for (int a = 0; a < jlh_data; a++) {
            System.out.print(data[a] + " ");
        }
        System.out.println("\n");
        
        // Proses Bubble Sort
        for (int a = 0; a < jlh_data - 1; a++) {
            System.out.println("\n--- Iterasi ke-" + (a + 1) + " ---");
            
            // Loop Perbandingan yang Dioptimalkan (hanya bandingkan elemen yang belum terurut)
            for (int b = 0; b < jlh_data - 1 - a; b++) {
                
                // Menampilkan status perbandingan
                System.out.print("Bandingkan " + data[b] + " dengan " + data[b + 1] + ": ");
                
                String pesan = "Tidak ada pertukaran";
                if (data[b] > data[b + 1]) {
                    // Proses pertukaran nilai data
                    pesan = "Data " + data[b] + " ditukar dengan data " + data[b + 1];
                    int temp = data[b];
                    data[b] = data[b + 1];
                    data[b + 1] = temp;
                }
                
                // Menampilkan Array setelah perbandingan dan pesan
                for (int c = 0; c < jlh_data; c++) {
                    System.out.print(data[c] + " ");
                }
                System.out.println("(" + pesan + ")");
            }
        }
        
        // Tampilkan data setelah diurutkan (DIPERBAIKI penempatannya)
        System.out.println("\n--- Data setelah diurutkan ---");
        for (int a = 0; a < jlh_data; a++) {
            System.out.print(data[a] + " ");
        }
        System.out.println();
    }
}