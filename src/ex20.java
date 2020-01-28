public class ex20 {
    public static double ln(int N)
    {
        if(N == 1) return 0;
        return ln(N-1) + Math.log(N);
    }

    public static void main(String[] args) {
        System.out.println(ln(10));
    }
}
