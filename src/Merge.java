public class Merge {
    //归并排序(由上到下)
    private static Comparable[] anux;
    public static void merge(Comparable[] a, int lo, int mid, int hi)
    {
        int j = mid + 1;
        int i = lo;

        //将需要排序的数组部分元素拷贝到anux中
        for(int k = lo; k <= hi; k++)
        {
            anux[k] = a[k];
        }

        //将两个有序的数组归并到一个数组当中
        for(int k = lo; k <= hi; k++)
        {
            if(i > mid)
                a[k] = anux[j++] ;
            else if(j > hi) a[k] = anux[i++];
            else if(less(anux[j], anux[i])) a[k] = anux[j++];
            else  a[k] = anux[i++];
        }
    }

    private static boolean less(Comparable v, Comparable b)
    {
        return v.compareTo(b) < 0;
    }

    //提供给外部的函数
    public static void sort(Comparable[] a)
    {
        int lo = 0;
        int hi = a.length - 1;
        anux = new Comparable[a.length];
        sort(a, lo, hi);
    }

    //sort的重载函数，分治思想从上到下划分为两半，分别递归排序，然后整合到一个数组当中去
    private static void sort(Comparable[] a, int lo, int hi)
    {
        if(hi <= lo) return;
        int mid = (lo + hi) / 2;
        sort(a, lo, mid);
        sort(a, mid+1, hi);
        merge(a, lo, mid, hi);
    }

    private static boolean isSorted(Comparable[] a)
    {
        for(int i = 0; i < a.length - 1; i++)
        {
            if(less(a[i+1],a[i])) return false;
        }
        return true;
    }

    private static void show(Comparable[] a)
    {
        for(int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] a = {1,6,3,2,6,2,5,3,5};
        sort(a);
        System.out.println(isSorted(a));
        show(a);
    }
}
