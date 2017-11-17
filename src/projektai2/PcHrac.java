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
    // vraci false kdyz uspesne zahraje kartu jinak true
    @Override
    public boolean aiFce(){
        
        return true;
    }
}
