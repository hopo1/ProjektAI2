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
public class Hra {
    public ArrayList<Hrac> hraci=new ArrayList<>();
    public int f;
    private int hracC;
    public int[] dalsiKarta=new int[3];
    public BalicekB balB=new BalicekB();
    public BalicekA balA=new BalicekA(balB);
    public String druhAkce="Liznout";
    public Svrsek svrsek=new Svrsek();
    
    public Hra(int pocet){
        for(int i=0;i<pocet;i++){
            Hrac h=new Hrac(balA,balB);
            hraci.add(h);
        }
        balB.pridej(balA.lizniSi(true));
        dalsiKarta[0]=balB.posledni().getBarva();
        dalsiKarta[1]=balB.posledni().getTyp();
        dalsiKarta[2]=0;
    }
    public void dalsihrac(){
        hracC+=1;
        if(getHracC()==hraci.size())hracC=0;
    }

    /**
     * @return the hracC
     */
    public int getHracC() {
        return hracC;
    }
}