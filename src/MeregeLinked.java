import src.Node;

public class MeregeLinked {
    //链表归并排序

    private static Node getMid(Node x)
    {
        //获取中间节点
        if(x == null)
            return null;

        //设置一个快指针，一个慢指针，当快指针移动到末尾，慢指针在链表的中间位置
       Node low = x;
        for(Node fast = x; fast.next != null && fast.next.next!=null; fast = fast.next.next)
        {
            low = low.next;
        }
        return low;
    }

    public static Node sort(Node x)
    {
        if(x == null || x .next == null)
            return x;

        //拆分链表
        Node mid = getMid(x);
        Node mid_1 = mid.next;
        mid.next = null;

        return merge(sort(x),sort(mid_1));
    }

    public static Node merge(Node x, Node y)
    {
        Node dummyHead = new Node(0);
        Node curr = dummyHead;
        while(x != null && y != null)
        {
            if(x.item <= y.item){
                curr.next = x;
                curr = curr.next;
                x = x.next;
            }
            else
            {
                curr.next = y;
                curr = curr.next;
                y = y.next;
            }
        }
        if(x == null)
            curr.next = y;
        else
            curr.next = x;
        return dummyHead.next;
    }

    private static boolean isSorted(Node head)
    {
        Node x = head;
        while(x != null && x.next != null)
        {
            int last = x.item;
            x = x.next;
            int curr = x.item;
            if(curr < last)
                return false;
        }
        return true;
    }

    private static void show(Node head)
    {
        for(Node x = head; x != null; x = x.next)
            System.out.print(x.item + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Node first = new Node(9);
        Node second = new Node(4);
        Node third = new Node(3);
        Node forth = new Node(10);
        Node sixth = new Node(5);
        Node seven = new Node(6);

        first.next = second;
        second.next = third;
        third.next = forth;
        forth.next = sixth;
        sixth.next = seven;


        Node newFirst = sort(first);
        System.out.println(isSorted(newFirst));
        show(newFirst);
    }

}
