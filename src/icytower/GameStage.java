package icytower;


import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.media.AudioClip;
import javafx.util.Duration;


public class GameStage extends Stage{
    //declare variables
    private ImageView background = new ImageView(new Image("file:/home/basmala/NetBeansProjects/Icy Tower/src/Images/background.png", 1000, 7000, false, false));
    private GameVariables gv;
    private Stairs stairs;
    private Player p1;
    Boolean paused = false;
    private int backY;
    private Coin coin;
    private Meteor meteor;
    private Spikes spikes;
    private Boolean gameStarted;
    private DieStage ds;
    private AudioClip jumpSound;
    private FinishStage fs;
    
    GameStage(){
        //setup
        super();
        Group root = new Group();
        backY = -6050;
        gameStarted = false;
        p1 = new Player(GameVariables.selectedCharacter);
        gv = new GameVariables();
        coin = new Coin();
        meteor = new Meteor();
        spikes = new Spikes();
        stairs = new Stairs();
        root.getChildren().add(background);
        root.getChildren().add(stairs);
        root.getChildren().add(p1);
        root.getChildren().add(coin);
        root.getChildren().add(meteor);
        root.getChildren().add(spikes);
        root.getChildren().add(gv);
        background.setTranslateY(backY);
        Scene scene = new Scene(root, 1000, 1000);
        setScene(scene);
        setWidth(1000);
        setHeight(1000);
        setResizable(false);
        setTitle("Icy Tower");
        Image icon = new Image("file:/home/basmala/NetBeansProjects/Icy Tower/src/Images/Icon.png");
        getIcons().add(icon);
        jumpSound = new AudioClip("https://drive.google.com/uc?id=1peQsmcDOkZ7GJaJ9fARSEQ7YawPR_GDG");
       
        
        ds = new DieStage();
        fs = new FinishStage();
        



        //game loop repeats every 12 milliseconds
        
        Timeline gameLoop = new Timeline(new KeyFrame(Duration.millis(12), e -> {
            
            //check if game is paused
            if(!paused){
            
                
                gv.update();
                if(gameStarted){ //game starts moving only after first jump
                    //handle player landing on stairs
                    p1.checkLanding(stairs.getLandingStair(p1));
                    
                    //handle spikes movement and collision with player
                    spikes.update();
                    spikes.checkCollision(p1);
                    
                    //handle meteor movement and collision with player
                    meteor.checkCollision(p1);
                    meteor.update();
                    
                    //handle coins movement and collision with player
                    coin.checkCollision(p1);
                    coin.update();
                    
                    //handle background movement
                    backY += 1;
                    background.setTranslateY(backY);
                    
                    //handle stairs update
                    stairs.update();
                    
                    //check if game ended (player lost or won)
                    checkGameEnd(p1);
                    checkWinning(p1);
                }
                
                //handle player movement
                p1.update();
                
                //remove last stair when it gets out of frame
                stairs.removeLastStair();
   
            

            }
            
        }));
        
        gameLoop.setCycleCount(Timeline.INDEFINITE);
        gameLoop.play();
        
        
        scene.setOnKeyPressed(event -> {

            if(event.getCode() == KeyCode.RIGHT) p1.movingRight = true;
            if(event.getCode() == KeyCode.LEFT)  p1.movingLeft = true;
            if(event.getCode() == KeyCode.SPACE && p1.landed && p1.getLegY() > 50){//only jump if player is landed and not out of frame
                gameStarted = true;
                p1.jumping = true;
                p1.landed = false;
                //initiallize the jump
                p1.velocityY = -p1.jumpHeight;
                p1.iv.setY(p1.iv.getY() + p1.velocityY);
                
                jumpSound.play();
            }
            if(event.getCode() == KeyCode.P){ //pause the game when you press p 
                
                    paused = true;
                
               }
                
                
            if(event.getCode() == KeyCode.S){//continue the game when you press s
                    paused = false;
                }
            
            
        });
        
        
        scene.setOnKeyReleased(event -> {
            //horizontal moving stop
            if(event.getCode() == KeyCode.RIGHT || event.getCode() == KeyCode.LEFT){
                p1.setSpeed();
                p1.movingRight = false;
                p1.movingLeft = false;
                    
            }
        });
    
        
        
        setOnCloseRequest((WindowEvent event) -> {
                paused = true;
        });

    
    }
    
    private void checkGameEnd(Player player){
        if(player.isDead()){
            System.out.println("i am dead");
            ds.show();
            hide();
            paused = true;

        
        
        }
    }
    private void checkWinning(Player player){
        if(stairs.Won(player)){
            System.out.println("I WIN");
            fs.show();
            hide();
            paused = true;
        
        
        
        
        }
    
    
    
    
    
   
    
    
    }
    
}
