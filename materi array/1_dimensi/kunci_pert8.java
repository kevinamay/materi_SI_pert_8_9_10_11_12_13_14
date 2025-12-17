import java.util.Scanner;

public class kunci_pert8 {
    public static void main(String[] args) {
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
    }
}
