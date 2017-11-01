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
public class Hrac {
    private BalicekA bal;
    private BalicekB balB;
    public ArrayList<Karta> ruka=new ArrayList<>();
    public Hrac(BalicekA bal,BalicekB balB){
        this.bal=bal;
        this.balB=balB;
        for(int i=0;i<5;i++){
            lizniSi();
        }
    }
    public int sizeRuka(){
        return ruka.size();
    }
    public int hraj(int vyber,int[] dalsiKarta){
        System.out.println("hraj");
            if(pravidla(ruka.get(vyber),dalsiKarta)){
            zahraj(vyber,dalsiKarta);
            
            }
        return pocetKaret();
    
    }
    /**
     * Hrac si lizne kartu a da si ji do ruky
     * @param dalsiKarta
     */
    public void lizniSi(int[] dalsiKarta){
        switch(dalsiKarta[2]){
            case 0:
                lizniSi();
                break;
            case 1:
                dalsiKarta[0]=balB.posledni().getBarva();
                break;
            default:
                for(int i=0;i<dalsiKarta[2];i++){
                    lizniSi();
                }
                dalsiKarta[0]=balB.posledni().getBarva();
    }
         dalsiKarta[2]=0;
    }
    public final void lizniSi(){
        Karta k;
        k =  bal.lizniSi(true);
        ruka.add(k);
    }
    private void specEfekt(Karta karta,int[] dalsiKarta){
        dalsiKarta[1]=karta.getTyp();
        switch (dalsiKarta[1]) {
            case 0: //sedmicka
                if(dalsiKarta[2]==2)dalsiKarta[2]+=2;
                else dalsiKarta[2]=2;
                dalsiKarta[0]=-1;
                break;
            case 7: //eso 
                dalsiKarta[2]=1;
                dalsiKarta[0]=-1;
                break;
            default: //vsechny karty
                dalsiKarta[2]=0;
                dalsiKarta[0]=karta.getBarva();
                break;
        }
    }

    /**
     * Hrac zahraje kartu s indexem i ze sve ruky
     * @param i pozice karty na ruce
     * @param odhBalicek odhayovaci balicek
     */
    private void zahraj(int i,int[] dalsiKarta){
        specEfekt(ruka.get(i),dalsiKarta);
        balB.pridej(ruka.get(i));
        ruka.remove(i);
    }
    private boolean pravidla(Karta k,int[] dalsiKarta){
        boolean b=false;
        b=((k.getBarva()==dalsiKarta[0])||(k.getTyp()==dalsiKarta[1]));
        
        //pro svrska
        if(k.getTyp()==5 &&dalsiKarta[2]==0){
            b=true;
        }
        return b;
    
    }
    private int pocetKaret(){
        return ruka.size();
    }
    
}
