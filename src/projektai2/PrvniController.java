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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
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
    private final String[] hraci={"Clovek"};
    @FXML
    private VBox vyber;
    @FXML
    private Button pridej;
    @FXML
    private Button odeber;
    @FXML
    private void handleOdeber(){
        int last=vyber.getChildren().size()-1;
        if(last>1){
        vyber.getChildren().remove(last);
        }
    }
    @FXML
    private void handlePridej(){
        int hracu=vyber.getChildren().size();
        if(hracu<5){
            vyber.getChildren().add(vyber());
        }
    }
    private ChoiceBox vyber(){
        ChoiceBox b=new ChoiceBox();
        b.getItems().addAll((Object[]) hraci);
        b.getSelectionModel().selectFirst();
        return b;
    }
    @FXML
        public void handle() {
        i=vyber.getChildren().size();
        i2=zjisti();
        try {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("Okno.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        stage.setTitle("Hra");
        stage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("Barvicky.css").toExternalForm());
        stage.show();
        
    } catch (IOException e) {
        System.err.println("Nejde otevrit");
    }
        
}
    public static int i;
    public static int[] i2;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for(int q=0;q<2;q++){
            vyber.getChildren().add(vyber());
        }
    }    

    private int[] zjisti() {
        int[] pole=new int[i];
        for(int q=0;q<i;q++){
            ChoiceBox b=(ChoiceBox) vyber.getChildren().get(q);
            pole[q]=b.getSelectionModel().getSelectedIndex();
        }
        return pole;
    }
    
}
