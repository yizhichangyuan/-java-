import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ex2322 {
    //三切分法快速排序，是为了规避当一个数组中有大量重复元素时，快速排序仍然将这些重复元素继续分组
    public static void sort(Comparable[] a)
    {
        List<Object> list = Arrays.asList(a);
        //打乱数组的原因是防止切分总是使一方数组为空（如数组是9，8，7，6，5，4，3，2，1）这样本身就是正序或者逆序的数组，
        // 这样复杂度就到了N ^ 2，打乱数组可以避免这个问题
//        Collections.shuffle(list);
        int lo = 0;
        int hi = a.length - 1;
        sort(a, lo, hi);
    }

    private static void sort(Comparable[] a, int lo, int hi)
    {
        if(lo >= hi) return;
        int p = lo, q = hi, i = lo, j = hi;
        Comparable v = a[lo];
        while(i < j)
        {   //三切分法，一个指针p维持[lo,p-1]的元素都是等于基准元素v
            //一个指针gt维持[q + 1, hi]的元素都是等于基准元素v
            //一个指针i维持扫描区域，其中[p,i - 1]的元素都小于a[lo],[j, q]的元素都大于a[lo]
            int cmp = a[i].compareTo(v);
            if (cmp == 0)
            {
                exch(a, i++, p++);
            }

            else if(cmp < 0)
                i++;
            else
                exch(a, i, j);

            int cmp2 = a[j].compareTo(v);
            if(cmp2 == 0)
                exch(a, j--, q--);
            else if(cmp2 > 0)
                j--;
            else
                exch(a, i, j);
        }
        sort(a, p, i - 1);
        sort(a, j + 1, q);
        add(a, lo, p, q, hi, i, j);
    }

    private static void add(Comparable[] a, int lo, int p, int q, int hi, int i, int j)
    {
        for(int z = p - 1; z >= lo; z--)
            for(int k = z; k < i - 1; k++)
                exch(a, k,k+1);
        for(int z = q + 1; z <= hi; z++)
            for(int k = z; k > j + 1 ; k--)
                exch(a, k,k-1);
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
        Integer[] a = {3,1,2,6,3,5,5};
        sort(a);
        show(a);
        System.out.println(isSorted(a));
    }

}
