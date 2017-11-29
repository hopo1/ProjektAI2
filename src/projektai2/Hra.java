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
    private int hracC=-1;
    public int[] dalsiKarta=new int[3];
    public BalicekB balB=new BalicekB();
    public BalicekA balA=new BalicekA(balB);
    public Svrsek svrsek=new Svrsek();
    
    public Hra(int[] i2){
        vytvorHrace(i2);
//        for(int i=0;i<i2.length;i++){
//            Hrac h=new Hrac(balA,balB);
//            hraci.add(h);
//        }
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

    private void vytvorHrace(int[] i2) {
        for(int i=0;i<i2.length;i++){
            switch(i2[i]){
                case 0 :
                    Hrac hr=new Hrac(balA,balB);
                    hraci.add(hr);
                    break;
                case 1:
                    PcHrac pcHr=new PcHrac(balA,balB);
                    hraci.add(pcHr);
                    break;
                case 2:
                    PcHrac_2 pcHr2= new PcHrac_2(balA,balB);
                    hraci.add(pcHr2);
                    break;
                case 3:
                    PcHrac_3 pcHr3= new PcHrac_3(balA,balB);
                    hraci.add(pcHr3);
            }
            
        }
    }
}