import java.io.*;

//import java.util.Scanner;
//
//public class Ninth {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int seconds = sc.nextInt();
//        int hours = seconds / 3600;
//        seconds %= 3600;
//        int minutes = seconds / 60;
//        seconds %= 60;
//        System.out.println(hours + ":" + minutes + ":" + seconds);
//    }
//}
public class Ninth {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int seconds = Integer.parseInt(bf.readLine());
        int hours = seconds / 3600;
        seconds %= 3600;
        int minutes = seconds / 60;
        seconds %= 60;
        bw.write(hours + ":" + minutes + ":" + seconds);
        bw.flush();
    }
}