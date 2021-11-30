package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;


public class nurseList implements Initializable{
    ArrayList<String> names = new ArrayList<>( // EDIT THIS list to include patient names
            Arrays.asList("Martin Prince", "Lauren Gregson")
    );
    @FXML
    private TextField searchBar;

    @FXML
    private ListView<String> listView;

    public void search(ActionEvent event) {
        listView.getItems().clear();
        listView.getItems().addAll(searchList(searchBar.getText(),names));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listView.getItems().addAll(names);
    }

    public void userLogOut(ActionEvent event) throws IOException{
        Main m = new Main();
        m.changeScene("afterLogin.fxml");

    }
    public void addNurse(ActionEvent event) throws  IOException{
        Main m = new Main();
        m.changeScene("addNurseDoctor.fxml");
    }
    private List<String> searchList(String searchWords, List<String> listOfStrings) {

        List<String> searchWordsArray = Arrays.asList(searchWords.trim().split(" "));

        return listOfStrings.stream().filter(input -> {
            return searchWordsArray.stream().allMatch(word ->
                    input.toLowerCase().contains(word.toLowerCase()));
        }).collect(Collectors.toList());
    }
}
