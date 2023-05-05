import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Eleventh {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line1 = br.readLine(), line2 = br.readLine();
        String[] line11 = line1.split(" "), line22 = line2.split(" ");
        int x1 = Integer.parseInt(line11[1]);
        double y1 = Double.parseDouble(line11[2]);
        int x2 = Integer.parseInt(line22[1]);
        double y2 = Double.parseDouble(line22[2]);
        System.out.printf("VALOR A PAGAR: R$ %.2f", x1 * y1 + x2 * y2);
    }
}
