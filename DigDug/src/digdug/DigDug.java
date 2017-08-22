/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digdug;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;

/**
 *
 * @author willi
 */
public class DigDug extends Application {
    
    int width = 512;
    int height = 480;
    
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        
        Canvas canvas = new Canvas();
        
        
        
       
        GameLoop gameLoop = new GameLoop(canvas.getGraphicsContext2D(), root);
        
        gameLoop.start();
        
        root.getChildren().add(gameLoop.getImageView());
        
        root.getChildren().add(canvas);
        
        Scene scene = new Scene(root, width, height);
        
        primaryStage.setTitle("Dig Dug");
        primaryStage.setScene(scene);
        primaryStage.show();
        root.requestFocus();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
