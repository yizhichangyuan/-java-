import java.util.Scanner;

public class ex1207 {
    public static String swap(String a){
        int N = a.length();
        if (N == 1)
           return a;
        String s1 = a.substring(0,N/2);
        String s2 = a.substring(N/2,N);
        return swap(s2) + swap(s1);
    }

    public static void main(String[] args) {
        System.out.print("input a String:");
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        System.out.println("颠倒顺序后的String:" + swap(a));
    }

}
