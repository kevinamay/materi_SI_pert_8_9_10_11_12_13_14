public class StackNamaManual {
    private int stackSize;
    private String[] stackArr;
    private int top;

    public StackNamaManual(int size) {
        this.stackSize = size;
        this.stackArr = new String[stackSize];
        this.top = -1;
    }

    public void push(String data) throws Exception {
        if (this.isStackFull()) {
            throw new Exception("Stack Penuh!");
        }
        stackArr[++top] = data;
        System.out.println("Push: " + data);
    }

    public String pop() throws Exception {
        if (this.isStackEmpty()) {
            throw new Exception("Stack Kosong!");
        }
        return stackArr[top--];
    }

    public String peek() throws Exception {
        if (this.isStackEmpty()) {
            throw new Exception("Stack Kosong!");
        }
        return stackArr[top];
    }

    public boolean isStackEmpty() {
        return (top == -1);
    }

    public boolean isStackFull() {
        return (top == stackSize - 1);
    }

    public static void main(String[] args) {
        // Kapasitas 6 untuk nama K-E-V-I-N-A
        StackNamaManual st = new StackNamaManual(6);

        try {
            System.out.println("--- OPERASI PUSH (Manual) ---");
            // Data dimasukkan langsung satu per satu
            st.push("K");
            st.push("E");
            st.push("V");
            st.push("I");
            st.push("N");
            st.push("A");

            System.out.println("\n--- HASIL OPERASI ---");
            System.out.println("Data teratas (Peek): " + st.peek());
            
            System.out.println("Data yang dikeluarkan (Pop): " + st.pop());
            System.out.println("Data teratas sekarang: " + st.peek());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
