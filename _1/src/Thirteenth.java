import java.io.*;

public class Thirteenth {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] words = bf.readLine().split(" ");
        double A = Double.parseDouble(words[0]), B = Double.parseDouble(words[1]), C = Double.parseDouble(words[2]);
        System.out.printf("TRIANGULO: %.3f\n", A * C / 2);
        System.out.printf("CIRCULO: %.3f\n", 3.14159 * C * C);
        System.out.printf("TRAPEZIO: %.3f\n", (A + B) * C / 2);
        System.out.printf("QUADRADO: %.3f\n", B * B);
        System.out.printf("RETANGULO: %.3f\n", A * B);
    }
}
