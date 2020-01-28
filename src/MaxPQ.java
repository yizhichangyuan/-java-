public class MaxPQ<Key extends Comparable<Key>> {
    //二叉堆
    private int N = 0;//表明数组已存储元素个数
    private Key[] a;//元素放在a[1] ... a[N+1],a[0]不放置元素
    public MaxPQ(int capacity)
    {
        a = (Key[])(new Comparable[capacity + 1]);
    }

    //某一个k结点的优先级增大，执行上浮操作
    private void swim(int k)
    {
        while(k / 2 >= 1 && less(k / 2, k))
        {
            //与父节点（位置k/2)比较，如果确实大于父节点，与父节点交换位置
            exch(k / 2, k);
            k = k / 2;
        }
    }

    //某一个结点的优先级减小，执行下沉操作
    private void sink(int k)
    {
        while(2 * k + 1 <= N)
        {
            //如果确实小于最大的子节点，就与最大子节点的位置对调
            int j = 2 * k;
            //找出最大子节点位置
            if(less(2*k, 2*k + 1)) j++;
            //判断是否需要再次下沉
            if(!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    public void insert(Key key)
    {
        //插入结点，现将该值放置在末尾，在执行上浮操作到合适位置
        a[++N] = key;
        swim(N);
    }

    public Key deleteMax()
    {
        //删除最大结点，将末尾的结点放置到最大结点位置，再执行下沉操作，重塑该树
        Key item = a[1];
        a[1] = a[N--];
        a[N+1] = null;
        sink(1);
        return item;
    }

    private boolean less(int i, int j)
    {
        return a[i].compareTo(a[j]) < 0;
    }

    private void exch(int i, int j)
    {
        Key temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public boolean isEmpty()
    {
        return N == 0;
    }

    public static void main(String[] args) {
        MaxPQ<Integer> maxPQ = new MaxPQ<Integer>(10);
        maxPQ.insert(10);
        maxPQ.insert(1);
        maxPQ.insert(18);
        maxPQ.insert(18);
        maxPQ.insert(7);
        maxPQ.insert(4);
        while(!maxPQ.isEmpty())
        {
            System.out.print(maxPQ.deleteMax() + " ");
        }
    }
}
