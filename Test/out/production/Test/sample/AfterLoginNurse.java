package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class AfterLoginNurse {

    @FXML
    private Button logout;

    public void viewPatients(ActionEvent event) throws IOException{
        Main m = new Main();
        m.changeScene("patientListNurse.fxml");
    }

    public void userLogOut(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("sample.fxml");

    }

    public void doctorList(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("doctorListNurse.fxml");
    }

    public void nurseList(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("nurseListNurse.fxml");
    }

}
