
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alessandro
 */
class Strada extends Terreno{ 
        Strada(){
            super.puoAvereMacchina=true;
            rett.setFill(Color.GRAY);
            
        }

    @Override
    void CreaMacchina() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
    }