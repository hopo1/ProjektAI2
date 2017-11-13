/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektai2;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import static projektai2.PrvniController.i;
import javafx.scene.control.Cell;



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
    private HBox protihrac;
    @FXML
    private VBox cele;
    @FXML
    private HBox rukaOkoli;
    @FXML
    private HBox proKartu;
    @FXML
    private Button liznout;
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
        odh.getChildren().remove(0);
        priprav(true);
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
        kartyHracu(); //pocty karet ostatnich hracu
        liznout.setText(druhAkce());
    }
    private String druhAkce(){
        int typ=h.dalsiKarta[2];
        if(typ==1)return "Stat";
        return "Liznout";
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
    private final ObservableList<Label> list = FXCollections.observableArrayList();
    private final Image imgK=new Image("File:Rub.jpg");
    private final ImageView imgKV=new ImageView(imgK);

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        h=new Hra(i);
        for(int qw=0;qw<i;qw++){
            Label lab=new Label();
            lab.setTextFill(Color.RED);
            lab.setFont(Font.font("Vardana", 40));
            list.add(lab);
        }
        priprav(false);  
    }  
    private void dolBalicek(){ //nedava spravnou velikost
        double ada=proKartu.getHeight();
        imgKV.setFitHeight(/*proKartu.getHeight()*/ada);
        imgKV.setPreserveRatio(true);
        proKartu.getChildren().add(imgKV);
    }

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
