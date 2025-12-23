package ARRAY;
import java.util.Scanner;
public class dimensi2 {
    public static void main(String[] args) {
//      System.out.println("Cara Pertama");
//      int [] [] ax;
//      ax = new int [3] [3];
//         ax [0] [0] = 1;
//         ax [0] [1] = 2;
//         ax [0] [2] = 3;
//         ax [1] [0] = 4;
//         ax [1] [1] = 5;
//         ax [1] [2] = 6;
//         ax [2] [0] = 7;
//         ax [2] [1] = 8;
//         ax [2] [2] = 9;
//     System.out.println("Nilai ax [0] :" + ax [0] [0]);
//     System.out.println("Nilai ax [0] :" + ax [0] [1]);
//     System.out.println("Nilai ax [0] :" + ax [0] [2]);
//     System.out.println("Nilai ax [1] :" + ax [1] [0]);
//     System.out.println("Nilai ax [1] :" + ax [1] [1]);
//     System.out.println("Nilai ax [1] :" + ax [1] [2]);
//     System.out.println("Nilai ax [2] :" + ax [2] [0]);
//     System.out.println("Nilai ax [2] :" + ax [2] [1]);
//     System.out.println("Nilai ax [2] :" + ax [2] [2]);
//  System.out.println("------------------------");
//     // Cara Kedua
//     System.out.println("Cara Kedua");
//     int [][] ay = {{1,2,3,4},{4,5,6,7},{7,8,9,10}};
//     System.out.println("Nilai ay [0] :" + ay [0] [0]);
//     System.out.println("Nilai ay [0] :" + ay [0] [1]);
//     System.out.println("Nilai ay [0] :" + ay [0] [2]);
//     System.out.println("Nilai ay [1] :" + ay [1] [0]);
//     System.out.println("Nilai ay [1] :" + ay [1] [1]);
//     System.out.println("Nilai ay [1] :" + ay [1] [2]);
//     System.out.println("Nilai ay [2] :" + ay [2] [0]);
//     System.out.println("Nilai ay [2] :" + ay [2] [1]);
//     System.out.println("Nilai ay [2] :" + ay [2] [2]);
//     }
// }
// String [] [] laptop = {
//     {"toshiba","5.000.000"},
//     {"acer","4.000.000"},
//     {"asus","4.000.000"},
//     {"Lenovo","1.500.000"}

// };
// for (int i=0; i<laptop.length; i++){
//     System.out.println("merk laptop : " + laptop [i] [0]);
//     System.out.println("harga laptop : " + laptop [i] [1]);
//     System.out.println("---------------------");
//     }
// }
double [] data = new double [10];
int [] nilai = new int [10];
int i , jumdata;
String str;
char jawab ;
Scanner scan = new Scanner (System.in);
jumdata =0;
for(i=0; i<data.length; i++){
    System.out.print("Masukkan bilangan =" );
    data [i] = scan.nextDouble();
    scan.nextLine();
if (i < data.length -2){
    System.out.print("Tambah Y/T = ");
    str = scan.nextLine();
    jawab = str.charAt(0);
    if (jawab == 'T' || jawab == 't'){
        jumdata = i +1;
    }
}
}
for (i=0; i<jumdata; i++){
    System.out.println("indeks ke - " + i + " menyimpan data " + data [i]);
    }
}
}
