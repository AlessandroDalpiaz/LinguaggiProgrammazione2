
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
public class MyCircle extends Figura{
    Circle circle = new Circle(50,50,50);
    /**
     * inizializzazione cerchio
     */
    public MyCircle() {
        circle.setFill(Color.YELLOW);
        circle.setStroke(Color.RED);
        getChildren().addAll(circle);
    }
    
}
