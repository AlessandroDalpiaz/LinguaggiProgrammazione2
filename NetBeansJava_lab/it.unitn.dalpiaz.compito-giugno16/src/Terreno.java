
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
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
public abstract class Terreno extends StackPane{
    boolean puoAvereMacchina=false;
    Circle auto =new Circle(20,20,20); 
    Rectangle rett= new Rectangle(50, 50);
    EventHandler<MouseEvent> changeStatus;
        
    /**
     * costruttore di default
     */
    Terreno(){
        rett.setStroke(Color.WHITE);
        changeStatus= new EventHandler<MouseEvent>() {
        
           @Override
           public void handle(MouseEvent t){
               cambia();
           }
       };
        addEventHandler(MouseEvent.MOUSE_CLICKED, changeStatus);
    }
    /**
     * cambia lo stato del terreno;
     * aggiunge macchina se clicco il bottone add;
     * check l'esistenza della macchina
     */
    void cambia(){
        if (this instanceof Prato) {
            System.out.print(((Prato)this).cordX);
            System.out.println(((Prato)this).cordY);
            System.out.println("PRATO");
            ((Prato)this).city.add(new Strada(false,((Prato)this).city,((Prato)this).cordX,((Prato)this).cordY), ((Prato)this).cordX,((Prato)this).cordY);
        }else{
            System.out.print(((Strada)this).cordX);
            System.out.println(((Strada)this).cordY);
            System.out.println("STRADA");
            System.out.println(" ((Strada)this).haCliccato) "+((Strada)this).haCliccato);
            
            //aggiunge macchina se clicco il bottone add
            if (((Strada)this).haCliccato) {
                ((Strada)this).SetVisible();
                ((Strada)this).haCliccato=false;
            }
            ///check l'esistenza della macchina
            if(((Strada)this).visibile){
                System.out.println("errore: macchina presente");
            }else{
                ((Strada)this).city.add(new Prato(((Strada)this).city,((Strada)this).cordX,((Strada)this).cordY), ((Strada)this).cordX,((Strada)this).cordY);
            }
            
        }
    }
    /**
     * Creo la figura macchina solamente se sono nella casella Strada
     */
    abstract void  CreaMacchina();
}
