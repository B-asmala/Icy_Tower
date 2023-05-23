package icytower;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

/**
 *
 * @author basmala
 */
public class IcyTower extends Application {
//    ImageView background = new ImageView(new Image("file:/home/basmala/NetBeansProjects/Icy Tower/src/Images/background.png", 1000, 7000, false, false));
//    GameVariables gv;
//    Stairs stairs;
//    Player p1;
//
//    int backY = -6050;
//    Coin coin;
//    Meteor meteor;
//    Spikes spikes;
//    Boolean gameStarted = false;
    @Override
    public void start(Stage stage){
        //setup
//        p1 = new Player(0);
//        gv = new GameVariables();
//        coin = new Coin();
//        meteor = new Meteor();
//        spikes = new Spikes();
//        stairs = new Stairs();
//        Group root = new Group();
//        root.getChildren().add(background);
//        root.getChildren().add(stairs);
//        root.getChildren().add(p1);
//        root.getChildren().add(coin);
//        root.getChildren().add(meteor);
//        root.getChildren().add(spikes);
//        root.getChildren().add(gv);
        
        //AudioClip jumpSound = new AudioClip("https://drive.google.com/uc?id=1peQsmcDOkZ7GJaJ9fARSEQ7YawPR_GDG");
        
//        background.setTranslateY(backY);
        GameStage gs = new GameStage(); 
        gs.show();
//        Scene scene = new Scene(gp, 1000, 1000);
//        stage.setWidth(1000);
//        stage.setHeight(1000);
//        stage.setResizable(false);
//        stage.setTitle("Icy Tower");
//        //Image icon = new Image("file:/home/basmala/NetBeansProjects/Icy Tower/src/Images/Icon.png");
//        //stage.getIcons().add(icon);
//        stage.setScene(scene);
//        stage.show();
//        
//        
//        scene.setOnKeyPressed(event -> {
//            if(event.getCode() == KeyCode.RIGHT) p1.movingRight = true;
//            if(event.getCode() == KeyCode.LEFT)  p1.movingLeft = true;
//            if(event.getCode() == KeyCode.SPACE && p1.landed && p1.getLegY() > 50){
//                gameStarted = true;
//                p1.jumping = true;
//                p1.landed = false;
//                p1.velocityY = -p1.jumpHeight;
//                p1.iv.setY(p1.iv.getY() + p1.velocityY);
//                //jumpSound.play();
//            }
//            
//            
//            
//        });
//
//        scene.setOnKeyReleased(event -> {
//            //horizontal moving stop
//            if(event.getCode() == KeyCode.RIGHT || event.getCode() == KeyCode.LEFT){
//                p1.setSpeed();
//                p1.movingRight = false;
//                p1.movingLeft = false;
//                    
//            }
//        });
//
//
//
//        
//        
//        
//        
//        
//
//
//        Timeline gameLoop = new Timeline(new KeyFrame(Duration.millis(12), e -> {
//            
//            
//
//            
//            
//            gv.update();
//            p1.checkLanding(stairs.getLandingStair(p1));
//            if(gameStarted){ //start moving
//                spikes.update();
//                spikes.checkCollision(p1);
//               
//                meteor.checkCollision(p1);
//                meteor.update();
//                coin.checkCollision(p1);
//                coin.update();
//                backY += 1;
//                background.setTranslateY(backY);
//                stairs.update();
//            }
//            p1.update();
//            stairs.removeLastStair();
//            stairs.checkWinning(p1);
//            
//            //p1.checkDeath();
//
//            
//            
//        }));
//        
//        gameLoop.setCycleCount(Timeline.INDEFINITE);
//        gameLoop.play();
        
        
        //closes program when the window is closed
        stage.setOnCloseRequest((WindowEvent event) -> {
            Platform.exit();
            System.exit(0);
        });
        
        
        
        
        
        
         
        
    }
    
    

    public static void main(String[] args) {
        launch(args);
    }
    


    

    
   
}