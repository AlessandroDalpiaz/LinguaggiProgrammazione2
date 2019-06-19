/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Alessandro
 */
public class main extends Application {
    
    @Override
    public void start(Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Carica un'immagine");
        fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("JPG", "*.jpg"),
            new FileChooser.ExtensionFilter("PNG", "*.png")
         );
        String url = System.getProperty("user.home");
        File f=new File(url);
        fileChooser.setInitialDirectory(f); // bugged on MacOsX
        File file = fileChooser.showOpenDialog(stage);
        if (file == null) {
            System.out.println("No file chosen");
        System.exit(1);
        }
        
        Image image = new Image("file:" + file.getAbsolutePath(), 500, 500, true, true);
        ImageView iw = new ImageView(image);
        Group root = new Group(iw);
        Scene scene = new Scene(root, 500,500);
        stage.setTitle(file.getName());
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //launch(args);
        Application.launch(args);
    }
    
}
