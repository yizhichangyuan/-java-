import java.lang.reflect.UndeclaredThrowableException;

public class UnorderedArrayMaxPQ<Item extends Comparable<Item>> {
    private Item[] a;
    private int N;

    public UnorderedArrayMaxPQ(int capacity)
    {
        N = 0;
        a = (Item[])(new Comparable[capacity]);
    }

    public void insert(Item item)
    {
        a[N++] = item;
    }

    public Item deleteMax()
    {
        int max = N - 1;
        for(int i = N - 2; i >= 0; i--)
        {
           if(a[max].compareTo(a[i]) < 0 )
               max = i;
        }
        exch(N - 1, max);
        Item item = a[--N];
        a[N] = null;
        return item;
    }

    private void exch(int i, int j)
    {
        Item temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private boolean less(Item item1, Item item2)
    {
        return item1.compareTo(item2) < 0;
    }

    private boolean isEmpty()
    {
        return N == 0;
    }

    public static void main(String[] args) {
        UnorderedArrayMaxPQ<Integer> array = new UnorderedArrayMaxPQ<Integer>(10);
        array.insert(10);
        array.insert(4);
        array.insert(5);
        array.insert(18);
        array.insert(88);
        while(!array.isEmpty())
        {
            System.out.print(array.deleteMax() + " ");
        }
    }


}
