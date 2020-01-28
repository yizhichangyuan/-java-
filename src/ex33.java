import java.util.Arrays;

public class ex33 {
    double[][] a;
    double[][] b;
    public ex33(double[][] a,double[][] b){
        this.a = a;
        this.b = b;
    }

    public static double dot(double[] x, double[] y){
        double result = .0;
        for(int i = 0; i < x.length; i++){
            result += x[i] * y[i];
        }
        return result;
    }

    public static double[][] mult(double[][] a, double[][] b){
        int M = a.length;
        int R = a[0].length;
        int N = b[0].length;
        double[][] result = new double[M][N];
        for(int i = 0; i < M; i++)
            for(int j = 0; j < N; j++)
                for(int k = 0; k < R; k++)
                result[i][j] = +a[i][k] * b[k][j];
        return result;
    }

    public static double[][] transpose(double[][] a){
        int M = a.length;
        int N = a[0].length;
        double[][] result = new double[N][M];
        for(int i = 0 ; i < N; i++)
            for(int j = 0; j < M; j++)
                result[i][j] = a[j][i];
        return result;
    }

    public static double[] mult(double[][] a, double[] b){
        int M = a.length;
        int N = a[0].length;
        double[] result = new double[M];
        for(int i = 0; i < M; i++)
            for(int j = 0; j < M; j++)
                for(int k = 0; k < N; j++)
                result[i] += a[i][j] * b[k];
        return result;
    }

    public static double[] mult(double[] y, double[][] a)
    {
        int M = a.length;
        int N = a[0].length;
        double[] result = new double[N];
        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++)
                for(int k = 0; k < N; k++)
                    result[i] += y[j] * a[j][k];
        return result;
    }

    public static void main(String[] args) {
        double[] a = {1,2,3};
        double[] b = {1,1,1};
        double[][] c = {{1,1,1},{1,1,1}};
        double[][] d = {{1,2},{3,4},{5,6}};
        System.out.println(dot(a,b));
        System.out.println(Arrays.deepToString(mult(d,c)));
    }
}
