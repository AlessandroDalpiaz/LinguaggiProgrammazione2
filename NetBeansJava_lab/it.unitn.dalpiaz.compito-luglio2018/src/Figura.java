

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alessandro
 */
public class Figura extends StackPane{
    Rectangle quadrato= new Rectangle(100,100);
    /**
     * inizializzazione figura (Background)
     */
    public Figura() {
        quadrato.setFill(Color.BLACK);
        quadrato.setStroke(Color.GREEN);
        quadrato.setStrokeWidth(5);
        getChildren().add(quadrato);
    }
    /**
     * inizializzazione figura (Background)
     * @param p scelta sfondo
     */
    public Figura(Color p) {
        quadrato.setFill(p);
        getChildren().add(quadrato);
    }
    
}
