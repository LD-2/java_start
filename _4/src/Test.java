import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args){
         //数组的定义
//        int[] a;
        //数组的初始化 java中数组初始化为赋初值 都是0 或者 null  而C++随机值
//        a=new int[10];

        //定义输出
//        int[] b=new int[10];
//        char[] a=new char[10];
//        double[] a=new double[10];
//        float[] a=new float[10];
//        String[] a=new String[10]; //null

        //java中的数组就和普通变量一样 又可以重新赋值
//        int[] x={1,2,3};//定义一个数组并初始化赋初值1 2 3
//        System.out.println(x[0]);
//        x=new int[10];//x重新赋初值了
//        System.out.println(x[0]);

        //java中数组不赋初值是不可以使用的  不赋值就是空指针  和普通变量一样不赋值不可以用
//        int[] b;
//        System.out.println(b);

        //数组长度确定不变长就数组就可以   否则用arrylist
        //用数组求斐波拉契数列  这里和循环的思想有差错
//        Scanner sc=new Scanner(System.in);
//        int n=sc.nextInt();
//        int[] f=new int[n+1];
//        f[0]=0;f[1]=1;
//        for(int i=2;i<=n;i++){
//            int t=f[i-1]+f[i-2];
//            f[i]=t;
//        }
//        System.out.println(f[n]);

        //char本质上存的是整数
//        char[] a=new char[2];
//        System.out.println((int)a[0]);

        //java中没有指针的概念
//        Scanner sc=new Scanner(System.in);
//        int n=sc.nextInt();
//        int[] a=new int[n];
//        for(int i=0;i<n;i++)a[i]=sc.nextInt();
//        for (int i=n-1;i>=0;i--)System.out.printf("%d ",a[i]);

        //非冒泡的排序  此处用的选择排序 比较好理解
//        Scanner sc=new Scanner(System.in);
//        int n=sc.nextInt();
//        int[] a=new int[n];
//        for(int i=0;i<n;i++){
//            a[i]=sc.nextInt();
//        }
//        for(int i=0;i<n-1;i++){
//            for(int j=i+1;j<n;j++){
//                if(a[i]>a[j]){
//                    int t=a[i];
//                    a[i]=a[j];
//                    a[j]=t;
//                }
//            }
//        }
//        for(int i=0;i<n;i++){
//           System.out.print(a[i]+" ");
//        }

        //多维数组 数组的数组  数组中的元素是数组
        //数组有多维数组 一维 二维 三维 ......  定义和初始化 都是一样的
        //数组 多维数组 在java中都是一种数据类型
//        int[][] a=new int[3][4];
//        int[][] b={
//                {1,2},
//                {5,6},
//                {3}
//        };
//        System.out.println(b[2][0]);
////        System.out.println(b[2][1]);// 这里之所以不可以是因为 二维数组b 在元素三中定义的是一个元素个数未1的一维数组
//        System.out.println(b.length);
//        for (int i=0; i<b.length; i++){
//            System.out.println(b[i].length);
//        }

        //数组中一些常用的API
        //对象类型的整数 Integer
//        Scanner sc=new Scanner(System.in);
//        int n=sc.nextInt();
//        Integer[] a=new Integer[n];
//        for(int i=0;i<n;i++)
//            a[i]=sc.nextInt();
//        //排序若想逆序 则需要传入对象
//        Arrays.sort(a,(x,y)->{
////            return x-y;
//            return y-x;
//        });
//        System.out.println(Arrays.toString(a));//数组转字符串

//        Scanner sc=new Scanner(System.in);
//        Integer[][] a={
//                {6,2,5},
//                {1,2},
//                {7,5,4}
//        };
//        for(int i=0;i<a.length;i++){
//            Arrays.sort(a[i],(x,y)->{
//                return y-x;
//            });
//        }
//        Arrays.sort(a,(x,y)->{
//            return y[0]-x[0];
//        });
//        System.out.println(Arrays.deepToString(a));

        //填充
//        int[] a = new int[10];
//        Arrays.fill(a,3);
//        System.out.println(Arrays.toString(a));
    }
}
