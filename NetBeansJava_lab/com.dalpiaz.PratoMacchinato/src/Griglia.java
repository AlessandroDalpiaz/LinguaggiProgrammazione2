

import java.awt.Rectangle;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alessandro
 */
public class Griglia extends GridPane { final int NCOL = 8; final int NROW = 8;
    ColumnConstraints cc1 = new ColumnConstraints();
    RowConstraints rc1 = new RowConstraints();
    
    Griglia() {
        this.setWidth(2000);
        this.setHeight(100);
        cc1.setPercentWidth(100./ NCOL);
        getColumnConstraints().addAll(cc1, cc1, cc1);
        rc1.setPercentHeight(100./ NROW);
        getRowConstraints().addAll(rc1, rc1, rc1);
        ini();
    }
    void ini(){
        this.add(new Text("0, 0"), 0, 0);
        this.add(new Text("0, 1"), 0, 1);
        this.add(new Text("1, 1"), 1, 1);
       // Rectangle r = new Rectangle(80,30);
        //this.add(r, 1, 2);
        this.add(new Text("1, 3"), 1, 3);
        this.add(new Text("2,3"), 2, 3);
        this.add(new Text("4, 0"), 4, 0);
        this.add(new Text("4,2"), 4, 2); 
    }
 }