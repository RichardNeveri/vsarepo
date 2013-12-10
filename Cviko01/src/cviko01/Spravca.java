/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cviko01;

import net.useobjects.frame.MainWindow;
import net.useobjects.geom.Vector;
import net.useobjects.mouse.MouseChangedAdapter;
import net.useobjects.mouse.MouseChangedEvent;

/**
 *
 * @author Richard
 */
public class Spravca {
    
    private KolekciaUtvarov utvary;
    private Utvar aktivny;
    private boolean aktivnyTahany;
    private Vector offset;
    private MainWindow okno;
    private Kos kos;
    
    public Spravca(MainWindow okno, Kos kos, int maxPocetUtvarov) {
        utvary = new KolekciaUtvarov(maxPocetUtvarov);
        aktivny = null;
        aktivnyTahany = false;
        this.okno = okno;
        this.kos = kos;
        okno.addMouseChangedListener(new SledovacUdalostiMysiOkna());
    }
    
    //metoda ktora umozni prekryvanie
    
    private Utvar dalsiPodMysou() {
        return utvary.najdiDalsi(new KolekciaUtvarov.Podmienka() {

            @Override
            public boolean jeSplnena(Utvar utvar) {
                return utvar.jeMysNadUtvarom();
            }
        });
    }
    
    private class SledovacUdalostiMysiOkna extends MouseChangedAdapter {

        @Override
        public void onMouseClicked(MouseChangedEvent event) {
            super.onMouseClicked(event); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void onMousePressed(MouseChangedEvent event) {
            if( aktivny == null ){
                aktivny = new Utvar(okno.getRootGroup(), event.getX(), event.getY());
                utvary.pridaj(aktivny);
                aktivny.nastavAktivaciu(true);
            }
            aktivnyTahany = true;
            // doplnime kod
        }

        @Override
        public void onMouseReleased(MouseChangedEvent event) {
            super.onMouseReleased(event); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void onMouseDragged(MouseChangedEvent event) {
            if (aktivnyTahany == true) {
                
                aktivny.nastavPoziciu(event.getPosition());
            }
        }

        @Override
        public void onMouseMoved(MouseChangedEvent event) {
           if( aktivny != null && !aktivny.jeMysNadUtvarom()){
               aktivny.nastavAktivaciu(false);
               aktivny = null;
           }
           if( aktivny == null ) {
               aktivny = dalsiPodMysou();
               if ( aktivny != null ){
                   aktivny.nastavAktivaciu(true);
               }
           }
        }
        
    }
    
}
