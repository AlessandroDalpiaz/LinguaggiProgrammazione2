
import javafx.scene.layout.VBox;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alessandro
 */

public class Colonna extends VBox{
    Colonna(){
        for (int i = 0; i < 8; i++) {
            this.getChildren().add(new Cella());
        }
    }
    
}