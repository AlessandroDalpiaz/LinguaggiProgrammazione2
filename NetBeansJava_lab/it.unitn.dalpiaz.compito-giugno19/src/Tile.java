
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alessandro
 */
public class Tile extends StackPane{
    int numero;
    Label lbl_number=new Label();
    boolean cliccato=false;
    Tile(){
        addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent t) {
                
                gtlt();
            }
            
        });
    }
    /**
     * Metodo greather than and less than. Serve per modificare il numero all'interno della label
     */
    void gtlt(){
        cliccato=true;
        if (this instanceof SquareTile) {
            numero--;
            if (numero==-1) {
                numero=9;
            }
        }else{
            numero++;
            if (numero==10) {
                numero=0;
            }
        }
        
        lbl_number.setText(String.valueOf(numero));
    }
    
        
}
