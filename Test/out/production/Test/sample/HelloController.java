package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.io.*;

public class HelloController {
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField cusID;
    @FXML
    private TextField address;
    @FXML
    private TextField phoneNum;
    @FXML
    private TextField savingsNumber;
    @FXML
    private TextField checkingNumber;




    @FXML
    protected void onClear() {
        firstName.setText("");
        lastName.setText("");
        cusID.setText("");
        address.setText("");
        phoneNum.setText("");
        savingsNumber.setText("");
        checkingNumber.setText("");
    }

    @FXML
    protected void printTextFile(){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt", true))){
            //rintWriter pw = new PrintWriter("output.txt");
            bw.write("First Name: ");
            bw.write(firstName.getText());
            bw.write("\nCustomer ID: ");
            bw.write(cusID.getText());
            bw.write("\nPhone Number: ");
            bw.write(phoneNum.getText());
            bw.write("\nAddress: ");
            bw.write(address.getText());
            bw.write("\nSavings Account Number: ");
            bw.write(savingsNumber.getText());
            bw.write("\nChecking Account Number: ");
            bw.write(checkingNumber.getText());
            bw.write("\n\n");
        }catch (IOException e){
            e.printStackTrace();
        }

    }


}