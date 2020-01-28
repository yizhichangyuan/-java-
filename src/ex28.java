import java.util.Arrays;
import java.util.ArrayList;
public class ex28 {
    public static int binarySearch(int key, int[] a, int lo, int hi)
    {
        int mid = (lo + hi) / 2;
        if (key < a[mid]) return binarySearch(key,a,lo,mid-1);
        else if(key > a[mid]) return binarySearch(key,a,mid+1, hi);
        else return mid;
    }

    public static void main(String[] args)
    {
        int[] whiteList = {2,4,5,3,5,3,5,5,5};
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(whiteList);
        list.add(whiteList[0]);
        for(int i = 1; i < whiteList.length; i++){
            if(whiteList[i] != whiteList[i-1])
                list.add(whiteList[i]);
        }
        whiteList = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
            whiteList[i] = list.get(i);
        System.out.println(Arrays.toString(whiteList));
    }
}
