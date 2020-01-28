public class OrderedArray<Key extends Comparable<Key>> {
    private int n;
    private Key[] a;
    public OrderedArray(int capacity)
    {
        a = (Key[]) (new Comparable[capacity]);
        n = 0;
    }

    public void insert(Key key)
    {
        a[n] = key;
        for(int i = n; i > 0 && less(a[i], a[i - 1]); i--)
        {
            exch(a, i, i - 1);
        }
        n++;
    }

    private boolean less(Key a, Key b)
    {
        return a.compareTo(b) < 0;
    }

    private void exch(Key[] a, int i , int j)
    {
        Key temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public Key deleteMax()
    {
        return a[--n];
    }

    public boolean isEmpty()
    {
        return n == 0;
    }

    public static void main(String[] args) {
        OrderedArray<Integer> a = new OrderedArray<Integer>(10);
        a.insert(10);
        a.insert(14);
        a.insert(13);
        a.insert(9);
        while(!a.isEmpty())
            System.out.println(a.deleteMax() + " ");
    }
}
