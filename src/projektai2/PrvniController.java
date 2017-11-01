/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektai2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author david_5i3asud
 */
public class PrvniController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    public ChoiceBox menu;
    @FXML
        public void handle() {
        i=menu.getSelectionModel().getSelectedIndex()+2;
        try {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("Okno.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        stage.setTitle("Hra");
        stage.setScene(scene);
        stage.show();
        
    } catch (IOException e) {
        System.err.println("Nejde otevrit");
    }
        
}
    public static int i=0;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        menu.getItems().addAll("2", "3","4","5");
        menu.getSelectionModel().select(0);
    }    
    
}
