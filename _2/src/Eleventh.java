import java.util.Scanner;

public class Eleventh {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int h1=sc.nextInt(),m1=sc.nextInt(),h2=sc.nextInt(),m2=sc.nextInt();
        int hour,minute;
        if(h1==h2){
            hour=24;
            if(m1>m2){
                hour-=1;
                minute=60-m1+m2;
            }
            else if(m1<m2){
                hour=0;
                minute=m2-m1;
            }
            else {
                hour=24;
                minute=0;
            }

        }
        else if(h1>h2){
            hour=24-h1+h2;
            if(m1>m2){
                hour-=1;
                minute=60-m1+m2;
            }
            else minute=m2-m1;
//            22:40 2:30 2:10
        }
        else{
            hour=h2-h1;
            if(m1>m2){
                hour-=1;
                minute=60-m1+m2;
            }
            else minute=m2-m1;
//            16:30  18:20
        }
        System.out.printf("O JOGO DUROU %d HORA(S) E %d MINUTO(S)\n",hour,minute);
    }
}
