
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

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
    /**
     * Array Figure
     */
    String classi[]={"MyRett","MyTriangle","MyHexagon","MyCircle"};
    Color colorArray[]={Color.BLUE,Color.GREEN,Color.RED,Color.VIOLET,Color.OLIVEDRAB,Color.BEIGE};
    /**
     * Costruttore
     * @param FiguraListener evento del click
     * @param tipo tipo figura
     * @param colorIndex scelta colore 0-4
     */
    Figura(int tipo,int colorIndex){
        //addEventFilter(MouseEvent.MOUSE_CLICKED,FiguraListener);
        setId(""+tipo+colorIndex);
        Shape tmp = null;
        
        //String packname="SlotMachine";//this.getClass().getPackage().getName();
        String className=classi[tipo];
        try {
            tmp=(Shape)(Class.forName(className).newInstance());
        } catch (ClassNotFoundException | InstantiationException| IllegalAccessException ex) {
            System.err.println("Impossibile istanziare la classe "+className);
        }
        System.out.println(colorArray[colorIndex]);
        tmp.setFill(colorArray[colorIndex]);
        setId(""+tipo+colorIndex);
        // ======== enclosing rectangle
        Rectangle rect= new Rectangle(130,130);
        rect.setFill(Color.WHITE);
        rect.setStrokeWidth(7);
        rect.setStroke(Color.BLACK);
        // ======== put things together
        getChildren().addAll(rect,tmp);
    }
    
}
