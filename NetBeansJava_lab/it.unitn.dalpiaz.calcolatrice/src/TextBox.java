
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alessandro
 */
public class TextBox extends TextField implements EventHandler<ActionEvent> {
    TextBox(){
        addEventFilter(ActionEvent.ACTION, this);
        this.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                System.out.println((event.toString()));
            }
        });
    }
    
    @Override
    public void handle(ActionEvent t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println(this.getText());
        
        
}
    
}
