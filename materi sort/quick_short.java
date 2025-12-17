public class quick_short {
    static void quickSort(int z[], int low, int high) {
        // low adalah indeks bawah,high adalah indeks atas
        // dari bagian array yang akan diurutkan
        int i = low, j = high, h;
        int pivot = z [low];
        // pembagian
        do {
            while (z[i]<pivot)// Geser i ke kanan mencari elemen >= pivot
                i++;
            while (z[j]>pivot)// Geser j ke kiri mencari elemen <= pivot
                j--;
            if (i <= j) {
                h = z [i];
                z [i] = z [j];
                z [j] = h;// Pertukaran (Swap)
                i++;
                j--;
            }
        } while (i <= j);
        if (low < j)
            quickSort(z, low, j);// Urutkan sub-array KIRI
        if (i < high)
            quickSort(z, i, high);// Urutkan sub-array KANAN
    }
    public static void main(String[] args) {
        int tabInt[]= {9,4,2,7,10,1,5};
        int i, n=7;
        System.out.println("Data sebelum diurutkan:");
        for (i=0; i<n; i++)
            System.out.print(tabInt[i]+" ");
    
        System.out.print("\n");
        quickSort(tabInt, 0, n-1);
        System.out.println("Data setelah diurutkan:");
        for (i=0; i<n; i++)
            System.out.print(tabInt[i]+" ,");
    }
}

