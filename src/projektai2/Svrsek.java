/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektai2;

import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author david_5i3asud
 */
public class Svrsek {
    private final Image listy=new Image("File:Svrsek\\listy.jpg");
    private final Image srdce=new Image("File:Svrsek\\srdce.jpg");
    private final Image kule=new Image("File:Svrsek\\kule.jpg");
    private final Image zaludy= new Image("File:Svrsek\\zaludy.jpg");
    private final ImageView srd=new ImageView(srdce);
    private final ImageView list=new ImageView(listy);
    private final ImageView kul=new ImageView(kule);
    private final ImageView zal=new ImageView(zaludy);
    public ArrayList<ImageView> obrazky=new ArrayList<>();
    public Svrsek(){
        obrazky.add(srd);
        obrazky.add(kul);
        obrazky.add(list);
        obrazky.add(zal);
    }
}
