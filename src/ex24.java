public class ex24{
    public static int Euclid(int p, int q)
    {
        System.out.println("p = "+ p + " q = " + q);
        if (p % q == 0)
            return q;
        else
            return Euclid(q, p % q);
    }

    public static void main(String[] args) {
        System.out.println(Euclid(1111111,1234567));
    }
}
