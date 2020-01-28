public class Insertion {
    public static void sort(Comparable[] a)
    {
        int N = a.length;
        for(int i = 1; i < N; i++)
        {
            for(int j = i; j >= 1 && less(a[j],a[j-1]); j--)
            {
                exch(a, j, j-1);
            }
        }
    }

    private static boolean less(Comparable a, Comparable b)
    {
        return a.compareTo(b) < 0;
    }

    private static void exch(Comparable[] a, int i, int j)
    {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void show(Comparable[] a)
    {
        for(int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a)
    {
        for(int i = 1; i < a.length; i++)
            if(less(a[i],a[i-1]))
                return false;
        return true;
    }

    public static void main(String[] args) {
        Integer[] a = {1,4,2,8,4,3,6};
        sort(a);
        System.out.println(isSorted(a));
        show(a);
    }
}
