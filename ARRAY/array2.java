package ARRAY;

import java.util.Scanner;
public class array2 {
    public static void main(String[] args) {
        // CONTOH 1
        // int []x;
        // System.out.println("cara 1");
        // x= new int [3];
        // x[0] = 20;
        // x[1] = 10;
        // x[2] = 30;
        // // System.out.println("Nilai x [0] : " + x[0]);
        // // System.out.println("Nilai x [1] : " + x[1]);
        // // System.out.println("Nilai x [2] : " + x[2]);
         
        // System.out.println("cara 2");
        // int [] y = new int [3];
        // y[0] = 20;
        // y[1] = 10;
        // y[2] = 30;
        // // System.out.println("Nilai x [0] : " + y[0]);
        // // System.out.println("Nilai x [1] : " + y[1]);
        // // System.out.println("Nilai x [2] : " + y[2]);
        
        // System.out.println("cara 3");
        // int [] z = {20,10,30};
        // System.out.println("Nilai x [0]"+z[0]+x[0]+y [0]);
        // System.out.println("Nilai x [0]"+z[1]+x[1]+y [1]);
        // System.out.println("Nilai x [0]"+z[2]+x[2]+y [2]);

    // CONTOH 2
    //     int [] angka = new int [100];
    //     int x = 1;
    //     for (int i=0; i<angka.length; i++){
    //         angka[i] = x;x ++;
    //     }
    //     int total = 0;
    //     for (int i=0; i<angka.length; i++){
    //         total += angka[i];
    //     }
    //     System.out.println(total);
    // }

    // CONTOH 3
        int [] DeretPositif = {0,10,20,30,40,60};

       for(int i=0;i<6;i++){
        System.out.println("index ke - "+i+": "+DeretPositif[i]);}
    // CONTOH 4
        // int [] DeretPositif = new int[5];
        // Scanner sc = new Scanner(System.in);
        // System.out.println("Mengisi nilai array");
        // for(int k=0;k<5;k++){
        // System.out.println("index ke - "+k+":");
        // DeretPositif[k]=sc.nextInt();}
        // System.out.println("Menampilkan nilai array");
        // for(int k=0;k<5;k++){
        // System.out.println("index ke - "+k+": "+DeretPositif[k]);
        // }
    }
}