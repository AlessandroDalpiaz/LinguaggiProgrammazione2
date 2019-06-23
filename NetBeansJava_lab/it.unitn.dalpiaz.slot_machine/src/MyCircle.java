
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
public class MyCircle extends Circle{
    /**
     * costruttore di default
     */
    public MyCircle() {
        /**
         * dimensione cerchio
         */
        super(35);
        /**
         * posizioni
         */
        setLayoutX(65);
        setLayoutY(65);
        /**
         * colore contorno
         */
        setStroke(Color.BLACK);
    }
    
}
