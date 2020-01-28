import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Quick3Way {
    //三切分法快速排序，是为了规避当一个数组中有大量重复元素时，快速排序仍然将这些重复元素继续分组
    public static void sort(Comparable[] a)
    {
        List<Object> list = Arrays.asList(a);
        //打乱数组的原因是防止切分总是使一方数组为空（如数组是9，8，7，6，5，4，3，2，1）这样本身就是正序或者逆序的数组，
        // 这样复杂度就到了N ^ 2，打乱数组可以避免这个问题
        Collections.shuffle(list);
        int lo = 0;
        int hi = a.length - 1;
        sort(a, lo, hi);
    }

    private static void sort(Comparable[] a, int lo, int hi)
    {
        if(lo >= hi) return;
        int lt = lo, i = lo, gt = hi;
        Comparable v = a[lo];
        while(i <= gt)
        {   //三切分法，一个指针lt维持[lo,lt-1]的元素都是小于基准元素v
            //一个指针gt维持[gt + 1, hi]的元素都是大于基准元素v
            //一个指针i维持扫描区域，其中[lt, i - 1]中的元素都是等于基准元素，[i, gt]中的元素都是带扫描的元素
            int cmp = a[i].compareTo(v);
             if(cmp < 0) exch(a,i++,lt++);
            else if(cmp > 0) exch(a, i, gt--);
            else i++;
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
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

    private static boolean isSorted(Comparable[] a)
    {
        for(int i = 1; i < a.length; i++)
        {
            if(less(a[i], a[i-1]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] a = {3,1,56,3,2,9};
        sort(a);
        show(a);
        System.out.println(isSorted(a));
    }

}
