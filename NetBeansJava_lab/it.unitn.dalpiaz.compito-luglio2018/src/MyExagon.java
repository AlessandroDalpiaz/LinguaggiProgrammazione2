
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.color;
import static javafx.scene.paint.Color.color;
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
public class MyExagon extends Figura{
    Polygon exagon= new Polygon(33,0,66,0,100,50,66,100,33,100,0,50);
    /**
     * inizializzazione esagono
     */
    public MyExagon() {
        exagon.setFill(Color.YELLOW);
        exagon.setStroke(Color.RED);
        this.getChildren().addAll(exagon);
    }
        
}
