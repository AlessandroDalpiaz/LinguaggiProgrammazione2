
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
public class MyTriangle extends Polygon{

    public MyTriangle() {
        super(25.0,0.0,0.0,70.0,70.0,70.0);
        setLayoutX(30);
        setLayoutY(30);
        setStroke(Color.BLACK);
    }
    
}
