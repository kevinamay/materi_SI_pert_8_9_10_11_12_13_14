package ARRAY;
import java.util.Scanner;
public class Array {

    public static void main(String[] args) {
    //    CONTOH 1
    //    int [] DeretPositif = new int[5];
    //    DeretPositif [0] =0;
    //    DeretPositif [1] =10;
    //    DeretPositif [2] =20;
    //    DeretPositif [3] =30;
    //    DeretPositif [4] =40;
    //    System.out.println("index ke - 0 :"+DeretPositif[0]);
    //    System.out.println("index ke - 1 :"+DeretPositif[1]);
    //    System.out.println("index ke - 2 :"+DeretPositif[2]);
    //    System.out.println("index ke - 3 :"+DeretPositif[3]);
    //    System.out.println("index ke - 4 :"+DeretPositif[4]);

    //CONTOH 2
    // int [] DeretPositif = {0,10,20,30,40};
    //    for(int i=0;i<5;i++){
    // System.out.println("index ke - "+i+": "+DeretPositif[i]);}

    //CONTOH 3
//        int [] nilai = {80,90,30,55,65};
//        int [] DeretPositif = {0,10,20,30,40};
//        for(int k=0;k<5;k++){
//        System.out.println("index ke - "+k+": "+DeretPositif[k]);
//        System.out.println("npm ke - "+k+": "+nilai[k]);

//CONTOH 4
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
        
// CONTOH 5
        int [] nilai =new int[5];
        int [] npm =new int[5];
        Scanner sc = new Scanner(System.in);
        System.out.println("Mengisi nilai array");
        for(int k=0;k<5;k++){
        System.out.println("nilai ke - "+k+":");
        nilai[k]=sc.nextInt();
        System.out.println("npm ke - "+k+":");
        npm[k]=sc.nextInt();}
        System.out.println("Menampilkan nilai array");
        for(int k=0;k<5;k++){
        System.out.println("nilai ke - "+k+": "+nilai[k]);
        System.out.println("npm ke - "+k+": "+npm[k]);
        }

        // CONTOH 6
        // int [] angka = new int[100];
        // int x = 1;
        // Scanner sc = new Scanner(System.in);
        // System.out.println("Mengisi nilai array");
        // for(int k=0;k<angka.length;k++){angka[k]=x; x++;}
        // int total=0;
        // System.out.println("Menampilkan nilai array");
        // for(int k=0;k<angka.length;k++){total+=angka[k];}
        // System.out.println(total);
    }
}