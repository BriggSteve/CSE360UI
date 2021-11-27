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

    public ArrayList<Entry> loginInfo(){
        ArrayList<Entry> entries = new ArrayList<Entry>();
        try{
            FileInputStream fis = new FileInputStream(new File("./entrydata.ser"));
            ObjectInputStream ois = new ObjectInputStream(fis);

            Entry entry1 = (Entry)ois.readObject();
            while(true){
                Entry person = (Entry)ois.readObject();
                entries.add(person);
                break;
            }


            ois.close();
            fis.close();


        }catch(IOException ex){
            ex.printStackTrace();
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        catch (NullPointerException et){
            et.printStackTrace();
        }
        System.out.println(entries);
        return entries;
    }

    public LogIn() {
    }

    public void userLogIn(ActionEvent event) throws IOException {
        this.checkLogin();
    }

    private void checkLogin() throws IOException {

        Main m = new Main();
        if (this.username.getText().toString().equals("doctor") && this.password.getText().toString().equals("123")) {
            this.wrongLogIn.setText("Success!");
            m.changeScene("afterLogin.fxml");
        } else if (this.username.getText().toString().equals("nurse") && this.password.getText().toString().equals("123")) {
            this.wrongLogIn.setText("Success!");
            m.changeScene("afterLogin-nurse.fxml");
        } else if (this.username.getText().toString().equals("patient") && this.password.getText().toString().equals("123")) {
            this.wrongLogIn.setText("Success!");
            m.changeScene("AfterLoginPatient.fxml");
        } else if (this.username.getText().isEmpty() && this.password.getText().isEmpty()) {
            this.wrongLogIn.setText("Please enter your data.");
        } else {
            this.wrongLogIn.setText("Wrong username or password!");
        }

    }

}
