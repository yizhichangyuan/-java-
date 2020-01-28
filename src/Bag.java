import java.util.Iterator;
import java.util.Scanner;

public class Bag<Item> implements Iterable<Item> {
    private Node first;
    private int N;

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    private class Node{
        Item item;
        Node next;
    }

    public void add(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public Iterator<Item> iterator(){
        return new BagIterator();
    }

    private class BagIterator implements Iterator<Item>{
        private int i = N;
        private Node k = first;

        public boolean hasNext(){
            return i > 0;
        }

        public Item next(){
            Item item = k.item;
            k = k.next;
            i--;
            return item;
        }
    }


    public static void main(String[] args) {
        System.out.println("please input string to bag");
        Scanner scan = new Scanner(System.in);
        Bag<String> bag = new Bag<String>();
        while(scan.hasNext()){
            String str = scan.next();
            bag.add(str);
            System.out.println("add string " + str + " bag size " + bag.size());
        }

        for(String each: bag)
            System.out.print(each + " ");
    }

}
