/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektai2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import static projektai2.PrvniController.i;


/**
 * FXML Controller class
 *
 * @author david_5i3asud
 */
public class OknoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private boolean svrsekVyber=true;
    @FXML
    private ListView rukaPole;
    @FXML
    private Label cisloH;
    @FXML
    private HBox odh;
    @FXML
    private Button liznout;
    @FXML
    private void hraj() {
        if(svrsekVyber){
        System.out.println("Ahoj hraj");
        int vyber=rukaPole.getSelectionModel().getSelectedIndex();
        int karet=h.hraci.get(h.getHracC()).hraj(vyber, h.dalsiKarta);
        if(karet==0){
            vyhra();
        }
        else if(karet!=rukaPole.getItems().size()){
            if(h.balB.posledni().getTyp()==5){
                svrsek();
                
            }
            else{
            priprav(false);
        }
        }
        }
    }
    @FXML
    private void handleLiznout(){
        if(svrsekVyber){
        h.hraci.get(h.getHracC()).lizniSi(h.dalsiKarta);
        
        priprav(false);
    }
    }
    private void priprav(boolean b){
        h.dalsihrac();
        cisloH.setText(String.valueOf(h.getHracC()));
        //posledni karta
        if(b){
            odh.getChildren().remove(0);
        }
        else{
        odh.getChildren().clear();
        }
        odh.getChildren().add(0, h.balB.posledni().getImgv());
        //ruka
        int velikostRuky=h.hraci.get(h.getHracC()).sizeRuka();
        rukaPole.getItems().clear();
        for(int x=0;x<velikostRuky;x++){
            rukaPole.getItems().add(h.hraci.get(h.getHracC()).ruka.get(x).getImgv());
        }
        rukaPole.layout();
        rukaPole.refresh();
        //funkcni tlacitko
        liznout.setText(h.druhAkce);
    }
    @FXML
    private ListView l;
    private boolean svrsek() {
        for(int i=0;i<4;i++){
            ImageView imgv=h.svrsek.obrazky.get(i);
            int rozmer=30;
            imgv.setFitHeight(rozmer);
            imgv.setFitWidth(rozmer);
        l.getItems().add(imgv);
        }
        l.refresh();
        odh.getChildren().add(l);
        svrsekVyber=false;
        
        return true;
    }
    @FXML
    private void vyberSvrsek(){
        int vyber=l.getSelectionModel().getSelectedIndex();
        l.getItems().clear();
        h.dalsiKarta[0]=vyber;
        odh.getChildren().clear();
        odh.getChildren().add(h.svrsek.obrazky.get(vyber));
        svrsekVyber=true;
        priprav(true);
        
    }
    private Hra h;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        h=new Hra(i);
        priprav(false);
    }    

    @FXML VBox cele;
    private void vyhra() {
        cele.getChildren().clear();
        Label vyhra=new Label();
        vyhra.setText("Vyhral hrac "+h.getHracC());
        cele.getChildren().add(vyhra);
    }

   
    
}
