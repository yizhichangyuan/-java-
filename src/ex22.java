import java.util.Arrays;
import java.util.Scanner;
public class ex22 {
    public static int count = 0;

    private static String StringUtils(String a, int count) {
        String result = "";
        for (int i = 0; i < count; i++)
            result += a;
        return result;
    }

    public static int BinarySearch(int key, int[] a, int lo, int hi, int depth) {
        int mid = (lo + hi) / 2;
        if (lo > hi) return -1;
//        String c = "    ";
//        System.out.println(StringUtils(c,depth) + lo + hi);
        if (key < a[mid]) return BinarySearch(key, a, lo, mid - 1, depth + 1);
        else if (key > a[mid]) return BinarySearch(key, a, mid + 1, hi, depth + 1);
        else return mid;
    }
    public static String getType(Object o)
    {
        return o.getClass().toString();
    }

    public static void main(String[] args) {
        int[] a = {4, 6, 3, 2, 7, 8, 9};
        int lo = 0;
        int hi = a.length - 1;
        Arrays.sort(a);
        Scanner scan = new Scanner(System.in);
        System.out.print("+ or -");
        String flag = scan.next();
        System.out.println(getType(flag));
        while (scan.hasNextInt()) {
            int key = scan.nextInt();
            if (flag.equals("+") && BinarySearch(key, a, lo, hi, 1) == -1)
                System.out.println("key" + key);

            if (flag.equals("-") && BinarySearch(key, a, lo, hi, 1) != -1)
                System.out.println("key" + key);
        }
    }
}


