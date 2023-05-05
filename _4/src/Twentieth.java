//import java.util.Scanner;
//
//public class Twentieth {
//    public static void main(String[] args){
//        Scanner sc=new Scanner(System.in);
//        int n=sc.nextInt(),m=sc.nextInt();
//        int cnt=0,a=0,b=0;
//        int[][] arr=new int[n][m];
//        String[] str={"r","d","l","u"};int s=0;;
//        int[] aa={0,1,0,-1},bb={1,0,-1,0};
//        //0 1     1 0     0 -1      -1 0
//        for(int i=0;i<n;i++){
//            for(int j=0;j<m;j++){
//                arr[a][b]=++cnt;
//                while (true) {
//                    switch (str[s]) {
//                        case "r":
//                            a += aa[0];
//                            b += bb[0];
//                        case "d":
//                            a += aa[1];
//                            b += bb[1];
//                        case "l":
//                            a += aa[2];
//                            b += bb[2];
//                        case "u":
//                            a += aa[3];
//                            b += bb[3];
//                    }
//                    if (a < n && b < m && a >= 0 && b >= 0 && arr[a][b] == 0||cnt==n*m) break;
//                    else s = (s + 1) % 4;
//                }
//            }
//        }
//        for (int i=0;i<n;i++) {
//            for (int j = 0; j < m; j++)
//                System.out.print(arr[i][j] + " ");
//            System.out.println();
//        }
//    }
//}
import java.util.Scanner;

public class Twentieth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] res = new int[n][m];
        int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
        int x = 0, y = 0, d = 1;
        for (int i = 1; i <= n * m; i ++ ) {
            res[x][y] = i;
            int a = x + dx[d], b = y + dy[d];
            if (a < 0 || a >= n || b < 0 || b >= m || res[a][b] > 0) {
                d = (d + 1) % 4;
                a = x + dx[d];
                b = y + dy[d];
            }
            x = a;
            y = b;
        }

        for (int[] row: res) {
            for (int val: row) {
                System.out.printf("%d ", val);
            }
            System.out.println();
        }
    }
}