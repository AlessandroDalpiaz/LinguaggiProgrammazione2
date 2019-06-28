
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alessandro
 */
public class MyTriangle extends Figura{
    Polygon triangle = new Polygon(50,0,100,100,0,100);
    /**
     * inizializzazione triangolo
     */
    public MyTriangle() {
        triangle.setFill(Color.YELLOW);
        triangle.setStroke(Color.RED);
        getChildren().addAll(triangle);
        
    }
    
}
