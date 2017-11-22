/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektai2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import javafx.scene.image.Image;

/**
 *
 * @author david_5i3asud
 */
public class BalicekA {
    private ArrayList<Karta> bal=new ArrayList<>();
    private String path="Karty_seznam.txt";
    private String slozka="Karty_prsi";
    private BalicekB balB;
    public BalicekA(BalicekB balB){
        this.balB=balB;
        nacti();
        michej();
    }
    
    private void nacti(){
        int i=0;
        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String s;
        while (((s = br.readLine()) != null)){  /*pro vsechny radky*/
            i++;
            String[] split=s.split(" ");
            int a=Integer.parseInt(split[0]);
            int b=Integer.parseInt(split[1]);
            String pathI;
                pathI = "file:"+slozka+File.separatorChar+"image_part_"+String.format("%03d", i)+".jpg";
            Image img=new Image(pathI);
            Karta k=new Karta(b,a,img);
            bal.add(k);
        }
        }
catch (Exception e)
{
        System.err.println("Chyba při četení ze souboru.3");
}
    }
    private void michej(){
        Random r=new Random();
        bal.forEach((k) -> {
            k.setPoradi(r.nextInt());
        });
      Collections.sort(bal,new Comparator<Karta>()
        {
            @Override
            public int compare(Karta k1,Karta k2){
                return Integer.valueOf(k1.getPoradi()).compareTo(k2.getPoradi());
                        
            }  
    });
    }
    private void otoc() {
        ArrayList<Karta> odhBal= balB.proMichni();
        bal.addAll(odhBal);
        System.out.println("Otaceni");
        michej();
    }
    public final Karta lizniSi(Boolean a){
        if(bal.isEmpty()){
            otoc();
        }
        if(bal.isEmpty()){
            return null;
        }
        Karta k=bal.get(0);
        if(a){
        bal.remove(0);}
        return k;
    }
}
