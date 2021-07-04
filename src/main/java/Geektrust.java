import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Geektrust {
    public static void main(String[] args) {
        Bank bank = new Bank();

        String filePath = args[0];
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                bank.handle(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
//
//        bank.handle("LOAN UON Shelly 15000 2 9");
//        bank.handle("PAYMENT UON Shelly 7000 12");
//        bank.handle("BALANCE UON Shelly 12");
    }
}
