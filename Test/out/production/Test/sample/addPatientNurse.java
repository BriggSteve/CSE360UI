package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class addPatientNurse {
    public void userLogOut(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("patientListNurse.fxml");

    }
    @FXML
    private TextField name;
    @FXML
    private TextField entryUserName;
    @FXML
    private TextField entryPassword;
    @FXML
    private TextField entryAppointment;
    @FXML
    private TextField startingMeds;
    @FXML
    protected void onClear() {
        name.setText("");
        entryUserName.setText("");
        entryPassword.setText("");
        entryAppointment.setText("");
        startingMeds.setText("");

    }

    @FXML
    protected void printTextFile(){
        try (BufferedWriter writeOut = new BufferedWriter(new FileWriter("patients.txt", true))){
            writeOut.write("Name: ");
            writeOut.write(name.getText());
            writeOut.write("\nUsername: ");
            writeOut.write(entryUserName.getText());
            writeOut.write("\nPassword: ");
            writeOut.write(entryPassword.getText());
            writeOut.write("\nAppointment: ");
            writeOut.write(entryAppointment.getText());
            writeOut.write("\nMeds: ");
            writeOut.write(startingMeds.getText());

        }catch (IOException e){
            e.printStackTrace();
        }

    }

}
