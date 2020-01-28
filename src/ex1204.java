import src.Counter;
import java.util.Arrays;
public class ex1204 {
    public static void main(String[] args) {
        String string1 = "hello";
        String string2 = string1;
        string1 = "world";
        System.out.println(string1);
        System.out.println(string2);
        Counter a = new Counter();
        Counter b = a;
        a.incresment();
        System.out.println(a.count);
        System.out.println(b.count);

        String s = "Hello World";
        s = s.toUpperCase();
        System.out.println(s);
        s = s.substring(6,11);
        System.out.println(s);
        System.out.println(s.length());
        System.out.println(s);
        String[] c = s.split("O");
        System.out.println(s);
        System.out.println(Arrays.toString(c));

    }
}
