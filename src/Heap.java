public class Heap {
    //堆排序,注意第一个元素，即索引为0的元素因为其两个子节点索引是1，2，不符合
    // 二叉树树中定义第一个节点索引是1，父节点位置k，两个子节点位置分别为2 * k, 2 * k + 1的规则
    //为此想要符合子父节点的位置关系，始终以元素处于第几个位置考虑，例如索引为0的元素处在第一个元素，其子节点在第二个和三个元素，即索引为1，2，
    // 只在交换元素位置，判断两个元素大小，需要采用索引访问元素时，才转换为索引，也就是第个元素其索引位置就是i-1
    public static void sort(Comparable[] a)
    {
        int N = a.length;
        //第k个元素向前遍历，直到第1个元素结束
        for(int k = N / 2; k >= 1; k--)
        {
            sink(a, k, N);
        }
        while(N -1 >= 1)
        {
            exch(a, 1, N--);
            sink(a, 1, N);
        }
    }

    private static void exch(Comparable[] a, int i, int j)
    {
        //i,j为第i，第j个元素，所以转化为索引是i-1，j-1
        Comparable temp = a[i - 1];
        a[i - 1] = a[j - 1];
        a[j - 1] = temp;
    }

    private static void sink(Comparable[] a, int i , int N)
    {
        while(2*i + 1 <= N)
        {
            int j = 2 * i;
            if(less(a, 2*i, 2*i + 1)) j++;
            if(!less(a, i, j)) break;
            exch(a, i, j);
        }
    }

    private static boolean less(Comparable[] a, int i, int j)
    {
        return a[i - 1].compareTo(a[j - 1]) < 0;
    }

    public static void main(String[] args) {
        Integer[] a = {3,2,1,8,5,9,4,7,6};
        sort(a);
        for(int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + " ");
        }
    }

}
