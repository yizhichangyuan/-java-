import java.util.Scanner;

public class ex1206 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("s:");
        String s = scan.next();
        System.out.println("t:");
        String t = scan.next();
        if (s.length() == t.length() && s.concat(s).indexOf(t) >= 0)
            System.out.println(t + " is a circle rotation of " + s);
        else
            System.out.println(t + " is not a circle rotation of " + s);
    }
}
