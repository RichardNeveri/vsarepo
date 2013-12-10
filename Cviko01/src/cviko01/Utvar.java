/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cviko01;

import java.awt.Color;
import net.useobjects.draw.drawable.AbstractView;
import net.useobjects.draw.drawable.GroupView;
import net.useobjects.draw.drawable.RectangleView;
import net.useobjects.draw.drawable.TextView;
import net.useobjects.geom.Position;
import net.useobjects.mouse.MouseChangedAdapter;
import net.useobjects.mouse.MouseChangedEvent;
import net.useobjects.mouse.MouseChangedListener;

/**
 *
 * @author Richard
 */
public class Utvar extends AbstractView {
    
    private TextView suradnice;
    private RectangleView zvyraznenie;
    private boolean mysNadUtvarom;
    
    public Utvar(GroupView skupina, double posX, double posY){
          super(skupina, posX, posY, 0);      // 0 je natocenie 0 radianov
          RectangleView pozadie = new RectangleView(0,0, 100, 60, 0, Color.BLACK, true); // pozicia od stredu skupiny, sirka, vyska, natocenie, true je ze je plny
          
          add(pozadie);
          add( new RectangleView(0, 0, 100, 20, 0, Color.WHITE, true));
          add( suradnice = new TextView(poziciaAkoRetazec(), -40, 5, 0, Color.BLACK));
          
          zvyraznenie = new RectangleView(0, 0, 103, 63, 0, Color.RED, false);
          
          //add (zvyraznenie);
          
          mysNadUtvarom = true;
          
          pozadie.addMouseChangedListener(new SledovacUdalostiMysi());
    }
    
    private String poziciaAkoRetazec() {
        int x = getBaseGroup().getRoundedPositionX();
        int y = getBaseGroup().getRoundedPositionY();
        return String.format("x = %3d, y = %3d", x , y);
    }
    
    public boolean jeMysNadUtvarom() {
        return mysNadUtvarom;
    }
    
    public Position dajPoziciu() {
        return getBaseGroup().getPosition();
    }
    
    public void nastavPoziciu(Position pozicia) {
        getBaseGroup().setPosition(pozicia);
        suradnice.setText(poziciaAkoRetazec());
    }
    
    public void nastavAktivaciu(boolean aktivacia) {
        
        if (aktivacia) {
            add(zvyraznenie);
        }
        else {
            remove(zvyraznenie);
        }
    }
    
    private class SledovacUdalostiMysi extends MouseChangedAdapter {

        @Override
        public void onMouseEntered(MouseChangedEvent mce) {
           mysNadUtvarom = true;
        }

        @Override
        public void onMouseExited(MouseChangedEvent mce) {
           mysNadUtvarom = false;
        }

    }
}
