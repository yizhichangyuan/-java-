package src;

public class practice {
    public static void main(String[] args) {
        // write your code here
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);
        if (a == b && b == c && a == c)
            System.out.println("equal");
        else
            System.out.println("not equal");
    }
}

