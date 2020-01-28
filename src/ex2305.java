public class ex2305 {
    public static void sort(Comparable[] a)
    {
        int lt = 0, i = 0, gt = a.length - 1;
        Comparable v = a[0];
        while(i <= gt)
        {
            int cmp = a[i].compareTo(v);
            if(cmp < 0) exch(a,i++,lt++);
            else if(cmp > 0) exch(a, i, gt--);
            else i++;
        }
    }

    private static void exch(Comparable[] a, int i, int j)
    {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] a = {1,2,2,1,2,1,2};
        sort(a);
        for(int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + " ");
        }
    }

}
