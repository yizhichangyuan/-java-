import java.util.Arrays;

public class MergeUp {
    //归并排序(由下到上)
    //不将anux声明为局部变量，是因为当多个程序同时调用时，出现混乱，因为只会有一个anux在内存中，解决办法每个调用者自己都各有一个anux
//    private static Comparable[] anux;

    public static void merge(Comparable[] a,Comparable[] anux, int lo, int mid, int hi)
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

    //sort的重载函数，分治思想分别递归排序最小的数组(2个元素)，然后依次向上进行排序(4,8...)，然后整合到一个数组当中
    public static void sort(Comparable[] a)
    {
        int N = a.length;
        Comparable[] anux = new Comparable[a.length];
        //从下到上进行排序，根据子数组大小进行两两归并
        for(int sz = 1; sz < N; sz = sz + sz)
        {
            for(int lo = 0; lo <= N - sz; lo += sz + sz)
            {
                merge(a, anux, lo, lo + sz - 1, Math.min(N - 1, lo + sz + sz - 1));
            }
            System.out.print("sz" + sz + Arrays.toString(a));
            System.out.println();
        }

        //Math.min主要是针对数组中最后部分的元素可能组成不了一个sz大小的子数组,当sz较小时，最后形成不了一个sz大小的数组将会在归并sz大小进行忽略，当sz较大时会进行归并这剩余的部分，min就是这个作用
        //lo <= N -sz是为了保证lo+sz-1<= N - 1;所以lo<= N - sz;
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
        Integer[] a = {1,6,3,2,7,9,8,4,5,10,0};
        sort(a);
        System.out.println(isSorted(a));
        show(a);
    }
}
