//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package sample;
import java.io.*;
import java.util.ArrayList;
import java.util.zip.InflaterOutputStream;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class LogIn {
    @FXML
    private Button button;
    @FXML
    private Label wrongLogIn;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    public static ArrayList<Entry> loginInfo(){
        try{
            FileInputStream fis = new FileInputStream(new File("entrydata.ser"));
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList club = (ArrayList<Entry>)ois.readObject();
            return club;
        }
        catch(IOException e){
            e.printStackTrace();
        }
        catch(ClassNotFoundException et){
            et.printStackTrace();
        }
        return null;

    }


    public void userLogIn(ActionEvent event) throws IOException {
        this.checkLogin();
    }

    private void checkLogin() throws IOException {

        Main m = new Main();

        if(this.username.getText().toString().equals(loginInfo().get(0).name)){
            this.wrongLogIn.setText("Success!");
            m.changeScene("afterLogin.fxml");
        }
//        }
//        if (this.username.getText().toString().equals("doctor") && this.password.getText().toString().equals("123")) {
//            this.wrongLogIn.setText("Success!");
//            m.changeScene("afterLogin.fxml");
//        } else if (this.username.getText().toString().equals("nurse") && this.password.getText().toString().equals("123")) {
//            this.wrongLogIn.setText("Success!");
//            m.changeScene("afterLogin-nurse.fxml");
//        } else if (this.username.getText().toString().equals("patient") && this.password.getText().toString().equals("123")) {
//            this.wrongLogIn.setText("Success!");
//            m.changeScene("AfterLoginPatient.fxml");
//        } else if (this.username.getText().isEmpty() && this.password.getText().isEmpty()) {
//            this.wrongLogIn.setText("Please enter your data.");
//        } else {
//            this.wrongLogIn.setText("Wrong username or password!");
//        }

    }

}
