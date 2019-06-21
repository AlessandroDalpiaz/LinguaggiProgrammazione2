
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
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
public class Operation extends Button implements EventHandler<ActionEvent> {
    TextField tf=new TextField();
    Operation(String s,TextField tff){
        this.setText(s);
        tf=tff;
    }
    public String somma(String numeri){
        int sum=0;
       String Array[]= numeri.split("+");
        for (int i = 0; i < Array.length; i++) {
            sum+=Integer.parseInt(Array[i]);
        }
        return String.valueOf(sum);
    }
    @Override
    public void handle(ActionEvent t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println(this.getText());
        System.out.println(somma(tf.getText()));
        
}
}
