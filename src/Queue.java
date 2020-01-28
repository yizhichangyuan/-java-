package src;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
    private int N;
    private Node first;
    private Node last;

    private class Node {
        Item item;
        Node next;
    }


    public boolean isEmpty() {
        return N == 0;
    }


    public int size() {
        return N;
    }

    //从对尾入队
    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        N++;
        //如果入队队列中只有一个元素，first也应该指向这个元素
        if (N == 1)
            first = last;
        else
            //oldLast只有在进行过赋值才有Node的具体结构，也就是之前就要有last,入队后的元素个数要大于2，否则oldLast为null;
            oldLast.next = last;
//      if(oldLast != null)
//          oldLast.next = last;
    }

    //从队首出队
    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        N--;
        if (N == 0)
            last = null;
        return item;
    }

    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<Item> {
        private int i = N;
        private Node k = first;

        public boolean hasNext() {
            return i > 0;
        }

        public Item next() {
            Item item = k.item;
            k = k.next;
            i--;
            return item;
        }
    }

    public static void main(String[] args) {
        Queue<String> queue = new Queue<String>();
        System.out.println("please input string to enqueue");
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String str = scan.next();
            queue.enqueue(str);
            System.out.println("enqueue string " + str + " queue size " + queue.size());
        }

        //遍历
        for (String each : queue)
            System.out.print(each + " ");

        System.out.println();
        //出队
        while (!queue.isEmpty()) {
            String str1 = queue.dequeue();
            System.out.println("dequeue string " + str1 + " queue size " + queue.size());
        }
    }
}
