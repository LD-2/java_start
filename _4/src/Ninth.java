import java.util.Scanner;
//这个数距离上下最小值
public class Ninth {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            if(n==0)break;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int x = Math.min(i + 1, n - i);//距离上下的最小值
                    int y = Math.min(j + 1, n - j);//距离左右额最小值
                    int z = Math.min(x, y);
                    System.out.print(z + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
