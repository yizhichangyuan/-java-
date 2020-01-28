import java.util.Arrays;

public class ex15 {
    public static int[] histogram(int[] a, int M)
    {
//        Arrays.sort(a);
//        int[] b = new int[M];
//        for(int i = 0; i < M; i++)
//        {
//            int cnt = 0;
//            if (i < a[0] | i > a[a.length - 1])
//            {
//                b[i] = 0;
//                continue;
//            }
//            for(int j = 0; j < a.length; j++)
//            {
//                if(i == a[j])
//                    cnt += 1;
//                if(a[j] > i)
//                {
//                    b[i] = cnt;
//                    break;
//                }
//            }
//        }
//        return b;
        int[] result = new int[M];
        for(int i = 0; i < a.length; i++)
            if(a[i] >= 0 && a[i] < M)
                result[a[i]]++;
         return result;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,2,4,5};
        int M = 5;
        System.out.println(Arrays.toString(histogram(a,M)));
    }
}
