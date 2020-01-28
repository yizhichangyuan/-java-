import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Quick {
    //快速排序
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
        int j = particition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static int particition(Comparable[] a, int lo, int hi)
    {
        //指定第一个元素为比较的基准
        Comparable v = a[lo];
        int i = lo;
        int j = hi + 1;
        while(true)
        {
            //从左侧开始搜寻，寻找第一个大于等于基准的元素
            while(less(a[++i],v)) if(i == hi) break;
            //从右侧开始搜寻，寻找第一个小于等于基准的元素
            while(less(v,a[--j])) if(j == lo) break;
            //当两个指针相遇，就应该结束，此时i，j已经进入对方扫描过的区域，此时弹出的i，j已经是对方扫描过的区域，再交换就会打回原形
            if(i >= j) break;
            //交换i指向的大元素以及j指向的小元素
            exch(a, i, j);
        }
        //i，j会弹出，说明此时i指向的是大于基准的元素，j指向小于基准的元素
        exch(a, lo, j);
        return j;

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
