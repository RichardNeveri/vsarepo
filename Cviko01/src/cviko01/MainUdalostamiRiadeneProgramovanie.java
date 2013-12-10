/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cviko01;

import net.useobjects.draw.drawable.GroupView;
import net.useobjects.eventloop.EventLoop;
import net.useobjects.eventloop.MainActivity;
import net.useobjects.frame.MainWindow;

/**
 *
 * @author Richard
 */
public class MainUdalostamiRiadeneProgramovanie {
    
        public static void main(String[] args) {
            EventLoop.start(new MainActivity() {

                @Override
                public void onInit() {
                   MainWindow okno = new MainWindow("Udalostami riadene programovanie", 500, 400);
                   okno.setVisible(true);
                   
                   GroupView skupina = okno.getRootGroup();
                   
                   Kos kos = new Kos();
                   
                   Spravca spravca = new Spravca(okno, kos, 1000);
                   // Utvar utvar = new Utvar(skupina, 100, 100);
                }
            });
                
   
        }
}
