/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektai2;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
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
    private Label protihrac1;
    @FXML
    private Label protihrac2;
    @FXML
    private Label protihrac3;
    @FXML
    private Label protihrac4;
    @FXML
    private HBox protihrac;
    @FXML
    private void hraj() {
        if(svrsekVyber){ 
        int vyber=rukaPole.getSelectionModel().getSelectedIndex();
        if(vyber!=-1){
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
        if(!b){
            odh.getChildren().clear();
        }
        odh.getChildren().add(0, h.balB.posledni().getImgv());
        //ruka
        int velikostRuky=h.hraci.get(h.getHracC()).sizeRuka();
        rukaPole.getItems().clear();
        for(int x=0;x<velikostRuky;x++){
            rukaPole.getItems().add(h.hraci.get(h.getHracC()).ruka.get(x).getImgv());
        }
        rukaPole.refresh();
        //pocty karet ostatnich hracu
        kartyHracu();
        //liznout.setText(h.druhAkce);   nevim co to sakra je ale mozna to ma neco delat
    }
    @FXML
    private ListView l;
    private boolean svrsek() {
        l.getItems().clear();
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
        if(vyber!=-1){
        h.dalsiKarta[0]=vyber;
        odh.getChildren().clear();
        odh.getChildren().add(h.svrsek.obrazky.get(vyber));
        svrsekVyber=true;
        priprav(true);
           }
    }
    private Hra h;
    private ObservableList<Label> list = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        h=new Hra(i);
        
        /*for(int a=0;a<(5-i);a++){
            protihrac.getChildren().remove(0);
        }*/
        for(int b=0;b<i;b++){
            Label lab=new Label();
            list.add(lab);
        }
        priprav(false);
    }    

    @FXML VBox cele;
    private void vyhra() {
        cele.getChildren().clear();
        Label vyhra=new Label();
        Image img=new Image("File:vyhra.jpg");
        ImageView imgv=new ImageView(img);
        double sirka=cele.getWidth();
        double vyska=cele.getHeight();
        imgv.setFitHeight(vyska);
        imgv.setFitWidth(sirka);
        vyhra.setText("Vyhral hrac "+h.getHracC());
        /*int scale=2;
        imgv.setScaleY(scale);
        imgv.setScaleX(scale);*/
        
        cele.getChildren().addAll(imgv,vyhra);
    }
    private void kartyHracu(){
        int hraje=h.getHracC();
        for(int a=1;a<i;a++){
            int hrac=hraje+a;
            if(hrac>i-1){
                hrac-=i;
            }
            String s=h.hraci.get(hrac).toString();
            int x=a-1;
            list.get(list.size()-a-1).setText(s);
        }
        
        protihrac.getChildren().clear();
        protihrac.getChildren().addAll(list);
    }
    

   
    
}
