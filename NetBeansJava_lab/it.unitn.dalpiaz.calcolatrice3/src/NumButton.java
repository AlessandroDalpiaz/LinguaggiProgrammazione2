

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alessandro
 */
public class NumButton extends Button{
    Calcolatrice3 cc;
    NumButton(){
        
    }
    final public EventHandler<MouseEvent> bClick=new EventHandler<MouseEvent>() {
        
        @Override
        public void handle(MouseEvent t) {
            System.out.println(getId());
            System.out.println();
            //cc.Esegui(getId());
            if(getId()=="="){
                cc.calcola();
            }else{
               cc.Add(getId()); 
            }
            
        }
    };
    
    		
    NumButton(Calcolatrice3 c,String Scritta,String Num){
        cc=c;
        setText(Scritta);
        setId(Num);
        addEventFilter(MouseEvent.MOUSE_CLICKED, bClick);
    }
}
