import java.util.Iterator;
import java.util.Scanner;
public class Linked<Item> implements Iterable<Item>{
    private int N;
    private Node first;

    private class Node
    {
        Node next;
        Item item;
    }

    public int size()
    {
        return N;
    }

    //想链表头部添加结点
    public void add(Item item)
    {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    private class IteratorLinked implements Iterator<Item>
    {
        private int i = N;
        private Node x = first;

        public boolean hasNext()
        {
            return i > 0;
        }

        public Item next()
        {
            Item item = x.item;
            i--;
            x = x.next;
            return item;
        }
    }

    public Iterator<Item> iterator()
    {
        return new IteratorLinked();
    }

    //删除链表的第k个元素
    public void delete(int k)
    {
        if(k > N)
            System.out.println("Linked doesn't exixt this element");
        else
        {
            int i = 1;
            for(Node x = first; x != null; x = x.next)
            {
                if(k == 1)
                {
                    x = x.next;
                    break;
                }
                else if (i == k - 1)
                {
                    x.next = x.next.next;
                    N--;
                    break;
                }
                i++;
            }
        }
    }

    //接受一个链表和一个字符串作为参数，如果链表中的某个结点的item的值为key，则返回true
    public static boolean find(Linked link,String key)
    {
        for(Object each:link)
            if (each.equals(key))
                return true;
        return false;
    }

    //接收一个整型k作为参数并删除该节点的后续结点
    public void removeAfter(int k)
    {
        int i = 0;
        for(Node y = first; y != null; y = y.next)
        {
            i++;
            if(k == 1) {
                y.next = null;
                N = 0;
            }
            else if(i == k - 1)
            {
                y.next = null;
                N = k - 1;
            }

        }
    }

    //接收两个链表节点作为参数，将第二个节点插入链表并使之成为第一个结点的后续结点

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Linked<String> link = new Linked<String>();
        while(scan.hasNext())
        {
            String str = scan.next();
            link.add(str);
        }
        System.out.println("please input a string to find: ");

        //查找值是否存在于链表中
        String findString = "b";
        System.out.println(Linked.find(link,findString));

        //删除第k个结点及后续所有结点
        System.out.println("删除第k个结点及后续所有结点");
        int k = 3;
        link.removeAfter(k);
        for(String each:link)
            System.out.println(each);
    }
}
