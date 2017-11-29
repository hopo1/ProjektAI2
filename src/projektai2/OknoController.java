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
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import static projektai2.PrvniController.i2;



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
    private int pocetHracu;
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
    private ListView l;
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
    private final int[] vypis=new int[2];
    private boolean prvni=false;
    private void proVypis(){
        if(prvni){
        System.out.print(h.getHracC()+" ");}
        else{
            prvni=true;
        }
        int[] vypis2=vypis.clone();
        vypis[0]=h.balB.posledni().getBarva();
        vypis[1]=h.balB.posledni().getTyp();
        if(vypis[0]!=vypis2[0]||vypis[1]!=vypis2[1]){
        System.out.println(h.balB.posledni().toString());
        }
        else{
            System.out.println("Liznul si");
        }
    }
    private void priprav(boolean b){
        proVypis();
        if(!b){
            odh.getChildren().clear();
        }
        h.dalsihrac();
        if(h.hraci.get(h.getHracC()).getClass()==Hrac.class){
        cisloH.setText(String.valueOf(h.getHracC()));
        //posledni karta
        odh.getChildren().add(0, h.balB.posledni().getImgv());
        //ruka
        int velikostRuky=h.hraci.get(h.getHracC()).sizeRuka();
        rukaPole.getItems().clear();
        for(int x=0;x<velikostRuky;x++){
            ImageView imgV=h.hraci.get(h.getHracC()).ruka.get(x).getImgv();
            rukaPole.getItems().add(imgV);
        }
        rukaPole.refresh();
        kartyHracu(); //pocty karet ostatnich hracu
        liznout.setText(druhAkce());
        {
    }
        }
        else{
           boolean[] x=h.hraci.get(h.getHracC()).aiFce(h);
           if(x[2]){
               vyhra();
           }
               else{
           if(x[1]){
               odh.getChildren().clear();
               ImageView imgVa=h.svrsek.obrazky.get(h.dalsiKarta[0]);
               imgVa.setFitWidth(30);
               imgVa.setFitHeight(30);
               odh.getChildren().add(imgVa);
               
           }
           priprav(x[1]||x[3]);   
        }
           }
    }
    private String druhAkce(){
        int typ=h.dalsiKarta[2];
        if(typ==1)return "Stat";
        return "Liznout";
    }
    
    private void svrsek() {
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
    private final ObservableList<VBox> list = FXCollections.observableArrayList();
    private final Image imgK=new Image("File:Rub.jpg");
    private final ImageView imgKV=new ImageView(imgK);

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("---------------------------------\nNova hra");
        pocetHracu=i2.length;
        h=new Hra(i2);
        for(int qw=0;qw<(pocetHracu-1);qw++){
            list.add(poleProtihrac());
        }
        l.setId("l");
        rukaPole.setId("rukaPole");
        priprav(false);
        dolBalicek();
    }  
    private void dolBalicek(){ 
        imgKV.setFitHeight(100);
        imgKV.setPreserveRatio(true);
        proKartu.getChildren().add(imgKV);
        
    }

    private void vyhra() {
        vypisVyhry();
        proVypis();
        cele.getChildren().clear();
        Label vyhra=new Label();
        Image img=new Image("File:vyhra.jpg");
        ImageView imgv=new ImageView(img);
        double sirka=cele.getWidth();
        double vyska=cele.getHeight();
        imgv.setFitHeight(vyska);
        imgv.setFitWidth(sirka);
        vyhra.setText("Vyhral hrac "+h.getHracC());
        System.out.println("Vyhral hrac " + h.getHracC()+" "+ h.hraci.get(h.getHracC()).getClass());
        cele.getChildren().addAll(imgv,vyhra);
//        try {
//            System.out.wait(10000);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(OknoController.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
    }
    private void kartyHracu(){
        int hraje=h.getHracC();
        for(int a=1;a<pocetHracu;a++){
            int hrac=hraje+a;
            if(hrac>pocetHracu-1){
                hrac-=pocetHracu;
            }
            Label lab=new Label();
            lab.setId("pro");
            Label lab2=new Label();
            lab2.setId("pro");
            lab2.setText("Hrac c.: "+String.valueOf(hrac));
            lab.setText("Karet:"+h.hraci.get(hrac).toString()); 
            list.get(list.size()-a).getChildren().remove(1);
            list.get(list.size()-a).getChildren().remove(1);
            list.get(list.size()-a).getChildren().addAll(lab2,lab);
        }
        
        protihrac.getChildren().clear();
        protihrac.getChildren().addAll(list);
    }
    private final Image protihracI=new Image("File:Protihrac.png");
    

    private VBox poleProtihrac() {
        VBox v=new VBox();
        Label labl=new Label();
        Label lab2=new Label();
        v.setPrefHeight(50);
        ImageView protihracV=new ImageView(protihracI);
        protihracV.setFitHeight(20);
        protihracV.setPreserveRatio(true);
        v.getChildren().add(protihracV);
        v.getChildren().addAll(labl,lab2);
        v.setAlignment(Pos.CENTER);
        return v;
    }

    private void vypisVyhry() {
        Class s=h.hraci.get(h.getHracC()).getClass();
        if(s==Hrac.class){
            ProjektAI2.vyhry[0]+=1;
        }
        if(s==PcHrac.class){
            ProjektAI2.vyhry[1]+=1;
        }
        if(s==PcHrac_2.class){
            ProjektAI2.vyhry[2]+=1;
        }
         }
    

   
    
}
