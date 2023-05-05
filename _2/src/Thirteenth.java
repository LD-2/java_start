import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Thirteenth {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        double salary = Double.parseDouble(bf.readLine());
        double taxes=0.0;
        if(salary>=0&&salary<=2000.00){
            taxes+=0;
        }
        else if(salary<=3000.00){
            taxes=(salary-2000)*0.08;
        }
        else if(salary<=4500.00){
            taxes=(salary-3000)*0.18+1000*0.08;
        }
        else{
            taxes=(salary-4500)*0.28+1000*0.08+1500*0.18;
        }
        if(taxes==0){
            System.out.println("Isento");
        }
        else {
            System.out.printf("R$ %.2f",taxes);
        }
    }
}
