package src;
import java.util.Scanner;

public class ex9 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        String s = "";
        for(int i = a; i > 0;){
            s = (i % 2) + s;
            i = i / 2;
        }
        System.out.print(s);
    }
}
