import java.util.Scanner;

//java的循环判断 只能写bool型 不能写别的数据类型 C++可以
public class Test {
    public static void main(String[] args) {
        //java的循环判断 只能写bool型 不能写别的数据类型 C++可以
//        int a=1;
//        while (a){}
//        int i=0;
//        while (i<10){
//            System.out.println(i);
//            i++;
//        }

//        int i=1,sum=0;
//        while(i<=100){
//            sum+=i*i*i;
//            i++;
//        }
//        System.out.println(sum);

        //利用循环的思想求斐波拉且数列
//        Scanner sc=new Scanner(System.in);
//        int n=sc.nextInt(),i=0,a=1,b=1;
//        while(i<n-1){
//            int c=a+b;
//            a=b;
//            b=c;
//            i++;
//        }
//        System.out.println(a);

//        Scanner sc=new Scanner(System.in);
//        int i=0;
//        do{
//            System.out.println(i);
//        }while (i!=0);

        //java中的for循环和C++中的一样
//        Scanner sc=new Scanner(System.in);
//        int n=sc.nextInt(),a=1,b=1;
//        for(int i=1;i<n;i++){
//            int c=a+b;
//            a=b;
//            b=c;
//        }
//        System.out.println(a);

//        Scanner sc=new Scanner(System.in);
//        int sum=0;
//        for(int i=1,j=10;i<j;i++,j--){
//            sum+=i*j;
//        }
//        System.out.println(sum);

        //break语句
//        Scanner sc=new Scanner(System.in);
//        int n=sc.nextInt();
//        boolean isP=true;
//        for(int i=2;i<=n/i;i++){
//            if(n%i==0){
//                isP=false;
//                break;
//            }
//        }
//        if(isP)System.out.println("Yes");
//        else System.out.println("No");

//        Scanner sc=new Scanner(System.in);
//        int sum=0;
//        for(int i=1;i<=100;i++){
//            if(i%2==1)continue;
//            sum+=i;
//        }
//        System.out.println(sum);

        //双层循环输出1-100 不一样的感觉
//        for(int i=1,k=1;i<=10;i++){
//            for(int j=1;j<=10;j++,k++){
//                System.out.printf("%-4d",k);
//            }
//            System.out.println();
//        }

//        for(int i=2;i<=100;i++){
//            boolean isPrime=true;
//            for(int j=2;j<=i/j  ;j++){
//                if(i%j==0) {
//                    isPrime = false;
//                    break;
//                }
//            }
//            if(isPrime){
//                System.out.println(i);
//            }
//        }


    }
}
