public class OrderedLinkedMaxPQ<Item extends Comparable<Item>> {
    private Node first = null;

    private class Node
    {
        Item item;
        Node next;
    }
    private void sink(Node x)
    {//结点x的优先级下降，将结点向下传递
        while(x.next != null && x != null && less(x.item, x.next.item))
        {
            Item temp = x.item;
            x.item = x.next.item;
            x.next.item = temp;
            x = x.next;
        }
    }

    private boolean less(Item item1, Item item2)
    {
        return item1.compareTo(item2) < 0;
    }

    public void insert(Item key)
    {//从first进入链表，然后执行sink操作，插入到合适的位置
        Node oldFirst = first;
        first = new Node();
        first.item = key;
        first.next = oldFirst;
        sink(first);
    }

    public Item deleteMax()
    {
        Item key = first.item;
        first = first.next;
        return key;
    }

    private boolean isEmpty()
    {
        return first == null;
    }

    public void show()
    {
        Node x = first;
        while(x != null)
        {
            System.out.print(x.item + " ");
            x = x.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        OrderedLinkedMaxPQ<Integer> link = new OrderedLinkedMaxPQ<Integer>();
        link.insert(10);
        link.insert(7);
        link.insert(9);
        link.insert(4);
        link.insert(18);
        while(!link.isEmpty())
        {
            System.out.print(link.deleteMax() + " ");
        }
    }

}

