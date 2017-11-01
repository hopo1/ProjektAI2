/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektai2;

import java.util.ArrayList;

/**
 *
 * @author david_5i3asud
 */
public class BalicekB {
    private ArrayList<Karta> balB=new ArrayList<>();
    public Karta posledni(){
        return balB.get(balB.size()-1);
    }
    public ArrayList<Karta> proMichni(){
        int a=balB.size()-1;
        ArrayList<Karta> d=new ArrayList<>();
        for(int i=0;i<a;i++){
            Karta k=balB.get(0);
            balB.remove(0);
            d.add(k);
        }
        return d;
    }
    public void pridej(Karta k){
        balB.add(k);
    }
}
