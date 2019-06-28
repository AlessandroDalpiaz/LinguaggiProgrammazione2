/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


/**
 *
 * @author Alessandro
 */
public class CompitoLuglio2018 extends Application {
    public static final int MAX_SIZE=5;
    ArrayList<Figura> figure = new ArrayList();
    int dimAttuale=-1;
    
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane root =new BorderPane();
        final VBox colonna=new VBox();
        VBox funzioni = new VBox();
        final GridPane griglia_bottoni= new GridPane();
        final GridPane griglia_figura=new GridPane();
        
        for (int i = 0; i < 5; i++) {
            figure.add(new Figura());
        }
        colonna.getChildren().addAll(figure);
        
        griglia_bottoni.add(new Button("Add"),0,0);
        griglia_bottoni.add(new Button("Remove Bottom"),1,0);
        griglia_bottoni.add(new Button("Remove Top"),0,1);
        griglia_bottoni.add(new Button("Print Stack"),1,1);
        
        //griglia_figura.add(new Figura(Color.TRANSPARENT),1,0);
        griglia_figura.add(new Button("Circle"),0,1);
        griglia_figura.add(new Button("Triangle"),1,1);
        griglia_figura.add(new Button("Hexagon"),2,1);
        griglia_figura.add(new Figura(), 1, 0);
        
        for (int i = 0; i < 4; i++) {
            System.out.println(griglia_figura.getChildren().get(i));
        }
        /**
         * evento aggiungi in fondo
         */
        griglia_bottoni.getChildren().get(0).setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>(){

            @Override
            public void handle(javafx.scene.input.MouseEvent t) {
                System.out.println("ADD");
                if (dimAttuale==(MAX_SIZE)) {
                    System.err.println("ERRORE COLONNA PIENA");
                }else if (figure.isEmpty() || dimAttuale<5) {
                    
                    System.out.println("    dim attualee---" +dimAttuale);
                    Figura f= ((Figura)griglia_figura.getChildren().get(MAX_SIZE-2));
                    if ((f instanceof  Figura)) {
                        System.out.println(f);
                        if(f instanceof  MyCircle){
                            griglia_figura.getChildren().remove(3);
                            griglia_figura.add(new MyCircle(), 1, 0);
                            System.out.println(f);
                            dimAttuale++;
                            System.out.println(" tolgo ---" +figure.get(MAX_SIZE-1-dimAttuale) + "indice "+ (MAX_SIZE-dimAttuale));
                            figure.remove(figure.get(MAX_SIZE-1-dimAttuale));
                            
                            figure.add(f);
                        }else if(f instanceof  MyExagon){
                            griglia_figura.getChildren().remove(3);
                            griglia_figura.add(new MyExagon(), 1, 0);
                            System.out.println(f);
                            dimAttuale++;
                            System.out.println(" tolgo ---" +figure.get(MAX_SIZE-1-dimAttuale) + "indice "+ (MAX_SIZE-dimAttuale));
                            figure.remove(figure.get(MAX_SIZE-1-dimAttuale));
                            figure.add(f);
                        }else if (f instanceof  MyTriangle) {
                            griglia_figura.getChildren().remove(3);
                            griglia_figura.add(new MyTriangle(), 1, 0);
                            System.out.println(f);
                            dimAttuale++;
                            System.out.println(" tolgo ---" +figure.get(MAX_SIZE-1-dimAttuale) + "indice "+ (MAX_SIZE-dimAttuale));
                            figure.remove(figure.get(MAX_SIZE-1-dimAttuale));
                            figure.add(f);
                        }else if (f instanceof  Figura) {
                            griglia_figura.getChildren().remove(3);
                            griglia_figura.add(new Figura(), 1, 0);
                        }
                    }else{
                        System.err.println("NESSUN OGGETTO SELEZIONATO");
                        griglia_figura.getChildren().remove(3);
                        griglia_figura.add(new Figura(), 1, 0);    
                    }
                    
                    colonna.getChildren().clear();
                    colonna.getChildren().addAll(figure);
                    System.out.println(figure.size());
                    for (int i = 0; i < figure.size(); i++) {
                        System.out.println(figure.get(i));
                    }
                    System.out.println("-----");
                    for (int i = 0; i < griglia_figura.getChildren().size(); i++) {
                        System.out.println(griglia_figura.getChildren().get(i));
                    }
                    
                }
            }
        
        });
        /**
         * evento rimuovi in fondo
         */
        griglia_bottoni.getChildren().get(1).setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>(){

            @Override
            public void handle(javafx.scene.input.MouseEvent t) {
                if ((dimAttuale==-1)) {
                    System.err.println("ERRORE BOTTOM VUOTO");
                }else{
                    System.out.println(dimAttuale);
                    figure.remove(figure.get(MAX_SIZE-1));
                    //figure.add(new Figura());
                    
                    dimAttuale--;
                    ArrayList<Figura> tmp=new ArrayList();
                    tmp.add(new Figura());
                    for (int i = 0; i < figure.size(); i++) {
                        tmp.add(figure.get(i));
                    }
                    figure=tmp;
                    
                    colonna.getChildren().clear();
                    colonna.getChildren().addAll(figure);
                    System.out.println(figure.size());  
                }
                for (int i = 0; i < figure.size(); i++) {
                    System.out.println(figure.get(i));
                }
            }
        
        });
        /**
         * Evento rimuovi in cima
         */
        griglia_bottoni.getChildren().get(2).setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>(){

            @Override
            public void handle(javafx.scene.input.MouseEvent t) {
                boolean fatto=false;
                int index=0;
                System.out.println("REMOVE TOP");
                if ((dimAttuale==-1)) {
                    System.err.println("ERRORE COLONNA VUOTA");
                }else{
                    while(!fatto){
                        if(figure.get(index) instanceof  MyCircle){
                            figure.remove(figure.get(index));
                            fatto=true;
                        }else if(figure.get(index) instanceof  MyExagon){
                            figure.remove(figure.get(index));
                            
                            fatto=true;
                        }else if (figure.get(index) instanceof  MyTriangle) {
                            figure.remove(figure.get(index));
                            
                            fatto=true;
                        }else{
                            index++;
                            System.out.println(index);
                        }
                    }
                   dimAttuale--;
                    ArrayList<Figura> tmp=new ArrayList();
                    tmp.add(new Figura());
                    for (int i = 0; i < figure.size(); i++) {
                        tmp.add(figure.get(i));
                    }
                    figure=tmp;
                    
                    colonna.getChildren().clear();
                    colonna.getChildren().addAll(figure);
                    System.out.println(figure.size());
                    for (int i = 0; i < figure.size(); i++) {
                        System.out.println(figure.get(i));
                    }
                }
            }
        
        });
        /**
         * evento stampa nomi delle figure all'interno dello stack
         */
        griglia_bottoni.getChildren().get(3).setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>(){

            @Override
            public void handle(javafx.scene.input.MouseEvent t) {
                System.out.println("PRINT STACK");
                System.out.print("Elementi: ");
                for (int i = 0; i < figure.size(); i++) {
                    if (figure.get(i) instanceof MyCircle) {
                        System.out.print("Circle,");
                    }else if (figure.get(i) instanceof MyTriangle) {
                        System.out.print("Triangle,");
                    }else if (figure.get(i) instanceof MyExagon) {
                        System.out.print("Exagon,");
                    }else {
                        System.out.print("null,");
                    }
                }
                System.out.println("");
            }
        
        });
        /**
         * Evento crea cerchio
         */
        griglia_figura.getChildren().get(0).setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>(){

            @Override
            public void handle(javafx.scene.input.MouseEvent t) {
                System.out.println("CERCHIO");
                griglia_figura.getChildren().get(0).setDisable(true);
                griglia_figura.getChildren().get(1).setDisable(false);
                griglia_figura.getChildren().get(2).setDisable(false);
                griglia_figura.getChildren().remove(3);
                griglia_figura.add(new MyCircle(), 1, 0);
                
            }
        });
        /**
         * Evento crea triangolo
         */
        griglia_figura.getChildren().get(1).setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>(){

            @Override
            public void handle(javafx.scene.input.MouseEvent t) {
                System.out.println("TRIANGOLO");
                griglia_figura.getChildren().get(1).setDisable(true);
                griglia_figura.getChildren().get(0).setDisable(false);
                griglia_figura.getChildren().get(2).setDisable(false);
                griglia_figura.getChildren().remove(3);
                griglia_figura.add(new MyTriangle(), 1, 0);
                
                
                for (int i = 0; i < griglia_figura.getChildren().size(); i++) {
                    System.out.println(griglia_figura.getChildren().get(i));
                }
            }
        });
        /**
         * Evento crea esagono
         */
        griglia_figura.getChildren().get(2).setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>(){

            @Override
            public void handle(javafx.scene.input.MouseEvent t) {
                System.out.println("ESAGONO");
                griglia_figura.getChildren().get(2).setDisable(true);
                griglia_figura.getChildren().get(0).setDisable(false);
                griglia_figura.getChildren().get(1).setDisable(false);
                griglia_figura.getChildren().remove(3);
                griglia_figura.add(new MyExagon(), 1,0);
            }
        });
        funzioni.getChildren().addAll(griglia_bottoni,griglia_figura);
        root.setCenter(funzioni);
        root.setAlignment(funzioni, Pos.CENTER_LEFT);
        root.setLeft(colonna);
        Scene scene = new Scene(root, 525, 525);
        
        primaryStage.setTitle("Figure geometriche");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
