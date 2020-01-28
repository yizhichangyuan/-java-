import java.util.Arrays;

public class ex29 {
    public static int rank(int key, int[] a)
    {
        int lo = 0;
        int hi = a.length - 1;
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            //找到该元素位置索引后，向左搜索，返回该键值的最小索引
            if(key == a[mid])
            {
                while(a[mid] == key && mid >= 0)
                    mid--;
                return ++mid;
            }
            else if(key < a[mid])
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        return -1;
    }

    public static int count(int key, int[] a) {
        int index = rank(key, a);
        int p = index;
        //找到最小索引后，再向右搜索
        if (index != -1) {
            while (a[index] == key && index < a.length) {
                index++;
            }
            index--;
            return index - p + 1;
        } else
            return 0;
    }

    public static void main(String[] args) {
        int[] a = {1,3,2,3,3,3,4,5};
        int key = 6;
        Arrays.sort(a);
        System.out.println(rank(key,a));
        System.out.println(count(key,a));
    }
}
