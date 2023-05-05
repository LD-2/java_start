import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fifteenth {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String name = bf.readLine();
        double basic_salary = Double.parseDouble(bf.readLine());
        double sale = Double.parseDouble(bf.readLine());
        System.out.printf("TOTAL = R$ %.2f", basic_salary + 0.15 * sale);
    }
}
