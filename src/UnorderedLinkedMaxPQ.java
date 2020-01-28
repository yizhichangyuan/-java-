public class UnorderedLinkedMaxPQ<Item extends Comparable<Item>>
{
    private Node first = null;
    private Node last = null;

    private class Node
    {
        Item item;
        Node next;
    }

    public void insert(Item val)
    {
        Node oldLast = last;
        last = new Node();
        last.item = val;
        last.next = null;
        if(first == null)
            first = last;
        else
            oldLast.next = last;
    }

    public Item deleteMax()
    {
        Item max = first.item;
        Node y = first;
        for(Node x = first; x.next != null && x != null; x = x.next)
        {
            if(max.compareTo(x.next.item) < 0)
            {
                max = x.next.item;
                y = x;
            }
        }
        if(y.next != null)
            //针对链表有两个及两个以上的结点，删除结点
            y.next = y.next.next;
        else
            //针对只剩下一个结点
            first = null;
        return max;
    }

    public boolean isEmpty()
    {
        return first == null;
    }

    public void show()
    {
        for(Node x = first; x != null; x = x.next)
        {
            System.out.print(x.item + " ");
        }
    }
    public static void main(String[] args) {
        UnorderedLinkedMaxPQ<Integer> link = new UnorderedLinkedMaxPQ<Integer>();
        link.insert(10);
        link.insert(18);
        link.insert(14);
        link.insert(89);
        link.show();
        System.out.println();
        while(!link.isEmpty())
        {
            System.out.print(link.deleteMax() + " ");
        }
    }
}
