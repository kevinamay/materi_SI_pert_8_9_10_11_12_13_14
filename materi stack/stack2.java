public class stack2 {                         // Class stack (struktur data Stack / LIFO)

    private int stackSize;                  // Menyimpan kapasitas maksimum stack
    private int[] stackArr;                 // Array untuk menyimpan elemen stack
    private int top;                        // Penanda elemen teratas stack

    // Constructor untuk inisialisasi stack
    public stack2(int size) {                
        this.stackSize = size;              // Menentukan ukuran stack
        this.stackArr = new int[stackSize]; // Membuat array sesuai ukuran stack
        this.top = -1;                      // Top = -1 artinya stack masih kosong
    }

    // Method untuk menambahkan data ke stack (PUSH)
    public void push(int entry) throws Exception { 
        if (this.isStackFull()) {            // Cek apakah stack sudah penuh
            throw new Exception("Stack is already full. can not add elements"); // Jika penuh, error
        }
        System.out.println("Adding: " + entry); // Menampilkan data yang ditambahkan
        this.stackArr[++top] = entry;        // Naikkan top lalu simpan data ke stack
    }

    // Method untuk menghapus dan mengambil data teratas (POP)
    public int pop() throws Exception {      
        if (this.isStackEmpty()) {           // Cek apakah stack kosong
            throw new Exception("Stack is empty. can not remove elements"); // Jika kosong, error
        }
        int entry = this.stackArr[top--];    // Ambil data teratas lalu turunkan top
        System.out.println("Removed entry: " + entry); // Tampilkan data yang dihapus
        return entry;                        // Kembalikan nilai yang di-pop
    }

    // Method untuk melihat data teratas tanpa menghapus
    public int peek(){                      
        return stackArr[top];               // Mengembalikan elemen teratas stack
    }

    // Method untuk mengecek apakah stack kosong
    public boolean isStackEmpty() {          
        return (top == -1);                 // True jika top = -1
    }

    // Method untuk mengecek apakah stack penuh
    public boolean isStackFull() {           
        return (top == stackSize - 1);      // True jika top mencapai batas array
    }

    // Method utama (main) untuk menjalankan program
    public static void main(String[] args) { 
        stack stack = new stack(5);          // Membuat stack dengan kapasitas 5

        try {
            stack.push(4);                   // Menambahkan angka 4 ke stack
            stack.push(8);                   // Menambahkan angka 8
            stack.push(3);                   // Menambahkan angka 3
            stack.push(89);                  // Menambahkan angka 89
            stack.pop();                     // Menghapus elemen teratas (89)
            stack.push(23);                  // Menambahkan angka 23
            stack.push(15);                  // Menambahkan angka 15 (stack penuh)
            stack.push(7);                   // Error karena stack sudah penuh
        } catch (Exception e) {
            System.out.println(e.getMessage()); // Menampilkan pesan error
        }

        try {
            stack.pop();                     // Menghapus elemen teratas
            stack.pop();                     // Menghapus elemen teratas
            stack.pop();                     // Menghapus elemen teratas
            stack.pop();                     // Menghapus elemen teratas
            stack.pop();                     // Menghapus elemen terakhir
            stack.pop();                     // Error karena stack kosong
        } catch (Exception e) {
            System.out.println(e.getMessage()); // Menampilkan pesan error
        }
    }
}

