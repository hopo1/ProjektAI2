/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektai2;

/**
 *
 * @author david_5i3asud
 */
public class PcHrac_2 extends Hrac {
    public PcHrac_2(BalicekA bal, BalicekB balB) {
        super(bal, balB);
    
}
@Override
    public boolean[] aiFce(Hra h){
       // vypis();
        boolean[] b={false,false,false,false}; //jestli hral kartu , jestli hral svrska , jestli vyhral, jestli si liznul
        int karet=ruka.size();
        int karet2=-1;
        boolean mamSvrska=false;
        int poziceSvrska=-1;
        for(int i=0;i<karet;i++){
            if(ruka.get(i).getTyp()!=5){
            karet2=hraj(i,h.dalsiKarta);
            if(karet!=karet2){
                b[0]=true;
                i=karet;
            }
            }
            else{
                mamSvrska=true;
                poziceSvrska=i;
            }
        }
        if(!b[0]&&mamSvrska){
            int hratB=vyberBarvicku(karet2);
            karet2=hraj(poziceSvrska,h.dalsiKarta);
            h.dalsiKarta[0]=hratB;
            b[1]=true;
        }
        
        b[2]=karet2==0;
        if(!b[0]){
        lizniSi(h.dalsiKarta);
        b[3]=true;
        }
        
        return b;
    }
    int vyberBarvicku(int karet2){
        int[] barvicky={0,0,0,0};
            for(int i=0;i<karet2;i++){
                if(ruka.get(i).getTyp()!=5){
                barvicky[ruka.get(i).getBarva()]+=1;
            }
            }
            int porovnat=-1;
            int hratB=0;
            for(int x=0;x<barvicky.length;x++){
                if(porovnat<barvicky[x]){
                    porovnat=barvicky[x];
                    hratB=x;
                }
            }
            return hratB;
    }
    
}
