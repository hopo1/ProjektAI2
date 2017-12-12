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
public class PcHrac_3 extends PcHrac_2{
    
    public PcHrac_3(BalicekA bal, BalicekB balB) {
        super(bal, balB);
    }
    @Override
    public boolean[] aiFce(Hra h){
       // vypis();
    boolean[] b={false,false,false,false}; //jestli hral kartu , jestli hral svrska , jestli vyhral, jestli si liznul
    int karet=ruka.size();
    int karet2=-1;
    //obsah
    
    boolean[] hratelneKarty= hratelneKarty(h);
    int karta=vybratKartu(hratelneKarty, h);
    if(karta!=-1){
    karet2=hraj(karta,h.dalsiKarta);
    b[0]=true;
    }
    else if(h.dalsiKarta[2]==0){
        for(int i=0;i<karet;i++){
            if(ruka.get(i).getTyp()==5){
            karet2=hraj(i,h.dalsiKarta);
            h.dalsiKarta[0]=vyberBarvicku(ruka.size());
            b[0]=true;
            b[1]=true;
            i=karet;
            }
            }
        if(!b[0]){
        lizniSi(h.dalsiKarta);
        b[3]=true;
        }
    }
    b[2]=karet2==0;
    return b;   
    }

    private boolean[] hratelneKarty(Hra h) {        
        boolean[] in=new boolean[ruka.size()];
        for(int i=0;i<in.length;i++){
            in[i]=false;
                    }
        for(int i=0;i<ruka.size();i++){
            if(pravidla(ruka.get(i),h.dalsiKarta)&&(ruka.get(i).getTyp()!=5)){
                in[i]=true;
                
            }
        }
        
        return in;
    }

    private int vybratKartu(boolean[] hratelneKarty, Hra h) {
        int index=-1;
        int[][] karty=h.balB.zahraneK();
        int[]odpovedi= new int[hratelneKarty.length];
        //vytvori pole s poctem jiz zahranych karet co by se dali zahrat vcetne te co se ma zahrat
        for(int i=0;i<hratelneKarty.length;i++){
            //odhazovaci balicek polde barvy a typu
            if(hratelneKarty[i]){
            int barva=ruka.get(i).getBarva();
            int typ=ruka.get(i).getTyp();
            for(int y=0;y<karty.length;y++){
                //porovnani barev
             if(karty[y][0]==barva&&karty[y][1]!=5){
                 odpovedi[i]++;
             }
             //porovnani typu
             if(karty[y][1]==typ&&karty[y][1]!=5){
                 odpovedi[i]++;
             }
            }
            
             //ruka podle barvy a typu
             for(int y=0;y<ruka.size();y++){
                 if(ruka.get(y).getBarva()==barva&&ruka.get(y).getTyp()!=5){
                 odpovedi[i]++;
             }
             //porovnani typu
             if(ruka.get(y).getTyp()==typ&&ruka.get(y).getTyp()!=5){
                 odpovedi[i]++;
             }
            }
        }
            else{
                
                    odpovedi[i]=Integer.MAX_VALUE;
            }
        }
        
        int porovnavac=Integer.MAX_VALUE;
            for(int y=0;y<odpovedi.length;y++){
                if(odpovedi[y]<porovnavac){
                    porovnavac=odpovedi[y];
                    index=y;
                } 
                    }
        return index;
}
}   