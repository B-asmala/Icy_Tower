package icytower;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import java.util.Random;
import javafx.scene.media.AudioClip;


public class Meteor extends Pane {
    static final int METEOR_WIDTH = 60;
    static final int METEOR_HEIGHT = 120;
    Random random = new Random(); 
    private int posY = -4000;
    //AudioClip hit = new AudioClip("https://drive.google.com/uc?id=15bTs9Wjj6HU9xkIHqoNX4yMYbXVdZlfp");
    // make the meteor comes from the space randomly
    private int posX = random.nextInt(0, GameVariables.width - METEOR_WIDTH);
    ImageView meteor = new ImageView(new Image("file:/home/basmala/NetBeansProjects/Icy Tower/src/Images/meteors.png"));
    boolean touched = false;
    Meteor(){
        
        getChildren().add(meteor);
        //the size of meteor
        meteor.setFitWidth(METEOR_WIDTH);
        meteor.setFitHeight(METEOR_HEIGHT);
        meteor.setX(posX);
        meteor.setY(posY);
        
    
    
    
    }
    
    //to check if the player touched the meteor or not
    void checkCollision(Player player) {
        if (player.iv.getBoundsInParent().intersects(meteor.getBoundsInParent()) ) {//collided
//if the condition is true the meteor will disappear and one of the hearts will disappear 
            posX = random.nextInt(0, GameVariables.width - METEOR_WIDTH);
            meteor.setX(posX);
            posY = -500;
            meteor.setY(posY);
            //the player will lose heart
            GameVariables.heartNum -- ;
           // hit.play();
        }else if(this.posY > GameVariables.height){
//  if the meteor out of frame it will disappear
            posX = random.nextInt(0, GameVariables.width - METEOR_WIDTH);
            meteor.setX(posX);
            //out of the scene 
            posY = -500;
            meteor.setY(posY);
        
        
        
        }
}


    void update(){
        posY += 6;
        meteor.setY(posY);
    }
    
    
    
}