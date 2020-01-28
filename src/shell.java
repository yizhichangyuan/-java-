public class shell {
    public static void sort(Comparable[] a)
    {
        //希尔排序，分为gap组，对每个gap插入排序
        int gap = 0;
        while(gap < a.length / 3)
        {
            gap = gap * 3 + 1;
        }

       while(gap >= 1) {
           //选择相应的gap后，各组的second元素都是从gap元素开始，gap前面的元素是每组的首元素
           for (int j = gap; j < a.length; j++)
               for(int k = j; k - gap > 0 && less(a[k], a[k - gap]); k -= gap)
                   exch(a, k, k - gap);
           gap = gap / 3;
       }
   }
//        for(int gap = a.length / 2; gap > 0; gap /= 2)
//        {
//            for(int j = gap; j < a.length; j++)
//                for(int k = j; k - gap > 0 && less(a[k],a[k-gap]); k -= gap)
//                    exch(a,k,k-gap);
//        }
//    }

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
        {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    private static boolean isSorted(Comparable[] a)
    {
        for(int i = 1; i < a.length; i++)
            if(less(a[i],a[i-1]))
                return false;
        return true;
    }

    public static void main(String[] args) {
        Integer[] a = {1,6,44,23,4,6,3};
        sort(a);
        show(a);
        isSorted(a);
    }
}
