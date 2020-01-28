public class ex14 {
    public static int lg(int n)
    {
        for(int i = 1;;i++)
        {
            n = n / 2;
            if (n == 1)
                return i;
        }
    }

    public static void main(String[] args){
        int n = 1025;
        System.out.print(lg(n));
    }
}

