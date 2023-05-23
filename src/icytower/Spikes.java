package icytower;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import java.util.Random;
import javafx.scene.media.AudioClip;


public class Spikes extends Pane {
    static final int SPIKE_SIZE = 100;
    Random random = new Random(); 
    int dx = 2;
    //AudioClip hit = new AudioClip("https://drive.google.com/uc?id=15bTs9Wjj6HU9xkIHqoNX4yMYbXVdZlfp");

    private int posY = -1000;
    private int posX = random.nextInt(0, GameVariables.width - SPIKE_SIZE);
    ImageView spikes = new ImageView(new Image("file:/home/basmala/NetBeansProjects/Icy Tower/src/Images/spikes.png"));
    boolean touched = false;
    Spikes(){
        
        getChildren().add(spikes);
        spikes.setFitWidth(SPIKE_SIZE);
        spikes.setFitHeight(SPIKE_SIZE);
        spikes.setX(posX);
        spikes.setY(posY);
        
    
    
    
    }
     //to check if the player touched the spike or no
    void checkCollision(Player player) {
        if (player.iv.getBoundsInParent().intersects(spikes.getBoundsInParent()) ) {
            posX = random.nextInt(0, GameVariables.width - SPIKE_SIZE);
            spikes.setX(posX);
            posY = -200;
            spikes.setY(posY);
            GameVariables.heartNum -- ;
            //hit.play();
        }else if(this.posY > GameVariables.height){
            posX = random.nextInt(0, GameVariables.width - SPIKE_SIZE);
            spikes.setX(posX);
            posY = -200;
            spikes.setY(posY);
        
        
}
    }
    void update(){
        posY += 2;
        spikes.setY(posY);
        
        
        //move across screen
        if(posX >= GameVariables.width - SPIKE_SIZE){
            dx = -4;
        
        
        
        
        }else if(posX <= 0){
            dx = 4;
        
        
        }
        
        
        posX += dx;
        spikes.setX(posX);
        
        spikes.setRotate(posX);
    }   
    
}