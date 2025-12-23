import java.util.Scanner;

public class StackNama {
    private int stackSize;
    private String[] stackArr; // Menggunakan String untuk input nama
    private int top;

    // Constructor untuk inisialisasi stack
    public StackNama(int size) {
        this.stackSize = size;
        this.stackArr = new String[stackSize];
        this.top = -1; // Stack awalnya kosong
    }

    // 1. PUSH: Menambahkan data ke stack
    public void push(String data) throws Exception {
        if (this.isStackFull()) {
            throw new Exception("Gagal Push: Stack sudah penuh!");
        }
        stackArr[++top] = data;
        System.out.println("Push berhasil: " + data);
    }

    // 2. POP: Menghapus dan mengambil data teratas
    public String pop() throws Exception {
        if (this.isStackEmpty()) {
            throw new Exception("Gagal Pop: Stack kosong!");
        }
        String data = stackArr[top--];
        return data;
    }

    // 3. PEEK: Melihat data teratas tanpa menghapus
    public String peek() throws Exception {
        if (this.isStackEmpty()) {
            throw new Exception("Gagal Peek: Stack kosong!");
        }
        return stackArr[top];
    }

    // 4. Method mengecek apakah stack kosong
    public boolean isStackEmpty() {
        return (top == -1);
    }

    // 5. Method mengecek apakah stack penuh
    public boolean isStackFull() {
        return (top == stackSize - 1);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Membuat stack dengan kapasitas 6 (sesuai jumlah huruf K-E-V-I-N-A)
        StackNama st = new StackNama(6);

        try {
            System.out.println("--- PROGRAM INPUT STACK NAMA ---");
            
            // Contoh Input menggunakan Scanner
            for (int i = 0; i < 6; i++) {
                System.out.print("Masukkan huruf ke-" + (i + 1) + ": ");
                String huruf = input.nextLine();
                st.push(huruf);
            }

            System.out.println("\n--- COBA OPERASI STACK ---");
            System.out.println("Data teratas saat ini (Peek): " + st.peek());
            
            System.out.println("Mengambil data (Pop): " + st.pop());
            System.out.println("Data teratas sekarang setelah Pop: " + st.peek());
            
            System.out.println("Apakah stack penuh? " + st.isStackFull());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            input.close();
        }
    }
}
