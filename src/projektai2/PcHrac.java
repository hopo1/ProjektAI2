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
public class PcHrac extends Hrac {
    
    public PcHrac(BalicekA bal, BalicekB balB) {
        super(bal, balB);
    }
    // vraci true/false podle prepisu pro svrska
    @Override
    public boolean[] aiFce(Hra h){
        boolean[] b={false,false,false,false}; //jestli hral kartu , jestli hral svrska , jestli vyhral, jestli si liznul
        int karet=ruka.size();
        int karet2=-1;
        for(int i=0;i<karet;i++){
            karet2=hraj(i,h.dalsiKarta);
            if(karet!=karet2){
                b[0]=true;
                b[1]=h.dalsiKarta[1]==5;
                i=karet;
            }
        }
        b[2]=karet2==0;
        if(!b[0]){
        lizniSi(h.dalsiKarta);
        b[3]=true;
        }
        
        return b;
    }
}
