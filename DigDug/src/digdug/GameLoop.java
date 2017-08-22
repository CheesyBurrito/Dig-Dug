/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digdug;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

/**
 *
 * @author willi
 */
public class GameLoop extends AnimationTimer {
    
    int width = 512;
    int height = 480;
    
    int xPosHero = 0;
    int yPosHero = 0;
    
    int heroHeight = 25;
    int heroWidth = 25;
    
    
    private Group root;
    
    private GraphicsContext gContext;
    private WritableImage image = new WritableImage(width, height);
    private PixelWriter pixelWriter = image.getPixelWriter();
    private ImageView imageView = new ImageView(image);
    
    
    public GameLoop(GraphicsContext gContext, Group root){
        this.gContext = gContext;
        this.root = root;
    }

    @Override
    public void handle(long now) {
        //First Inputs
        userInputs();
        
        //Second Logic
        
        
        //Third Render
        
        /*
        Order of Rendering:
        1- Background
        2- Enemies and Hero
        3- Gameboard
        */
        
        renderBackground();
        renderHero();
        
    }
    
    public void userInputs(){
        root.setOnKeyPressed(e ->{
            System.out.println(yPosHero);
            switch(e.getCode()){
                case UP: {
                    yPosHero -= 1;
                    
                    if(yPosHero < 0){
                        yPosHero = 0;
                    }
                }
                
                case DOWN:{
                    yPosHero += 1;
                    
                    if(yPosHero > height - heroHeight){
                        yPosHero = height - heroHeight;
                    }
                }
                
                case LEFT: {
                    xPosHero -= 1;
                    
                    if(xPosHero < 0){
                        xPosHero = 0;
                    }
                
                }
                
                case RIGHT: {
                    xPosHero += 1;
                    
                    if(xPosHero > width - heroWidth){
                        xPosHero = width - heroWidth;
                    }
                }
            }
        });
    }
    
    public void renderBackground(){
        for(int i = 0; i < width; i++){
            for(int k = 0; k < height; k++){
                
                if(k <= 100 || i > 400){
                    pixelWriter.setColor(i, k, Color.BLACK);
                }
                else if(k >= 100 && k < 200){
                    pixelWriter.setColor(i, k, Color.BURLYWOOD);
                }
                else if(k >= 200 && k < 300){
                    pixelWriter.setColor(i, k, Color.CORAL);
                }
                else if(k >= 300 && k < 400){
                    pixelWriter.setColor(i, k, Color.CHOCOLATE);
                }
                else if(k >= 400 && k < 500){
                    pixelWriter.setColor(i, k, Color.ORANGERED);
                }
                else{
                    pixelWriter.setColor(i, k, Color.RED);
                }
            }
            
        }
    }
    
    public void renderHero(){
        //Render Hat
        
        //Height of hat
        for(int i = 0; i < 7; i++){
            //Width of Hat
            for(int k = 0; k < 12; k++){
                if(i == 0 && k > 4 && k < 8){
                    pixelWriter.setColor(xPosHero + k, yPosHero + i, Color.WHITE);
                }
                
                if(i == 1 && k > 2 && k < 8){
                    pixelWriter.setColor(xPosHero + k, yPosHero + i, Color.WHITE);
                }
                
                if(i == 2 && k > 1 && k < 10){
                    pixelWriter.setColor(xPosHero + k, yPosHero + i, Color.WHITE);
                }
                
            }
        }
    }
    
    public void renderHeroLeftFrameOne(){
        
    }
    
    public void renderHeroLeftFrameTwo(){
        
    }
    
    
    public ImageView getImageView() {
        return imageView;
    }
    
    
}
