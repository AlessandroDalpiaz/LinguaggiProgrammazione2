/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication7;

import java.awt.Font;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javax.swing.event.HyperlinkEvent;
//import javafx.scene.text.*;

/**
 *
 * @author Alessandro
 */
public class JavaFXApplication7 extends Application {
    
    @Override
    public void start(Stage primaryStage) throws InterruptedException {
        Text t2=new Text(0, 20, "Ping !\nPongPing !");
        t2.setTextAlignment(TextAlignment.LEFT);
        t2.setFill(Paint.valueOf("RED"));
        //t2.setFont(new Font(20));
        Group g2 = new Group(t2);
        Scene scene2 = new Scene(g2);
        scene2.setFill(Paint.valueOf("YELLOW"));
        Stage stage2 = new Stage();
        stage2.setTitle("Titolo della finestra 2");
        stage2.setScene(scene2);
        stage2.sizeToScene();
        stage2.setX(100);
        stage2.setY(80);
        stage2.show();
        
        
        Stage stage1 = new Stage();
        Text t =new Text(50,100,"The quick brown fox jumps over\n" + " the lazy dog");
        t.setTextAlignment(TextAlignment.CENTER);
        t.setWrappingWidth(50);
        t.setFill(Paint.valueOf("BLUE"));
        Group g = new Group(t);
        Scene scene = new Scene(g);
        stage1.setTitle("Titolo della finestra 1");
        stage1.setScene(scene);
        // set stage dimension
        stage1.setWidth(399);
        stage1.setHeight(399);
        // set stage position
        stage1.setX(100);
        stage1.setY(80);
        // make stage visible 
        stage1.show();
        stage2.centerOnScreen();
        
        Stage stage3 =new Stage();
        Circle cerchio= new Circle(50,50,50);
        cerchio.setFill(Color.GREEN);
        cerchio.setCenterX(200);
        cerchio.setCenterY(100);
        Group g3 =new Group(cerchio);
        Scene scene3 =new Scene(g3);
        stage3.setScene(scene3);
        stage3.setMinHeight(400);
        stage3.setMinWidth(400);
        stage3.setX(1400);
        stage3.setY(200);
        stage3.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
