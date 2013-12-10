/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cviko01;

/**
 *
 * @author Richard
 */
public class KolekciaUtvarov {
    
    private Utvar[] utvary;
    private int aktualny;
    
    public KolekciaUtvarov(int kapacita){
        utvary = new Utvar[kapacita];
        aktualny = 0;
    }
    
    public boolean pridaj(Utvar utvar) {
        for(int i = 0; i < utvary.length; i++){
            if(utvary[i] == null){
                utvary[i] = utvar;
                return true;
            }
        }
            return false;
    }
    
    public boolean vyber(Utvar utvar){
    for(int i = 0; i< utvary.length; i++){
        if(utvary[i] == utvar){
        utvary[i] = null;
        return true;
}
}
return false;
}

    public interface Podmienka {
        boolean jeSplnena(Utvar utvar);
    }

    public Utvar najdiDalsi(Podmienka podmienka) {
        for(int i = 0; i < utvary.length; i++){
        int index = (aktualny + i + 1) % utvary.length;
        if(utvary[index] != null && podmienka.jeSplnena(utvary[index])){
            aktualny = index;
            return utvary[aktualny];
}
}
return null;
}
}

