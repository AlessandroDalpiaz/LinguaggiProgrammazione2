

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
public class OperationBotton extends Button{

    Calcolatrice3 cc;
    EventHandler<MouseEvent> operation=new EventHandler<MouseEvent>() {
        
        @Override
        public void handle(MouseEvent t) {
            System.out.println(getId());
            System.out.println();
            //cc.Esegui(getId());
            cc.Add(getId());
            cc.SelSegno(getId());
        }
    };
    public OperationBotton(Calcolatrice3 c,String scritta,String Op) {
        cc=c;
        setText(scritta);
        setId(Op);
        addEventHandler(MouseEvent.MOUSE_CLICKED, operation);
    }
    void setOBWidth(double w) {
        this.setMaxWidth(w);
        this.setMinWidth(w);
    }
    void setOBHeight(double h) {
        this.setMaxHeight(h);
        this.setMinHeight(h);
    }
}
