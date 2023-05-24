package icytower;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import java.util.Random;
import javafx.scene.media.AudioClip;


public class Coin extends Pane {
    static final int COIN_SIZE = 60;
    Random random = new Random(); 

    private int posY = -500;
    private int posX = random.nextInt(0, GameVariables.width - COIN_SIZE);
    ImageView coin = new ImageView(new Image("file:/home/basmala/NetBeansProjects/Icy Tower/src/Images/coin.png"));
    //AudioClip coinSound = new AudioClip("https://drive.google.com/uc?id=1zYXD9E-ABbeSBto8YxpmGCUhwbbbUxje");
    boolean touched = false;
    Coin(){
        
        getChildren().add(coin);
        coin.setFitWidth(COIN_SIZE);
        coin.setFitHeight(COIN_SIZE);
        coin.setX(posX);
        coin.setY(posY);
        
    
    
    
    }
     //to check if the player touched the meteor or no
    void checkCollision(Player player) {
        if (player.iv.getBoundsInParent().intersects(coin.getBoundsInParent()) ) {
            posX = random.nextInt(0, GameVariables.width - COIN_SIZE);
            coin.setX(posX);
            posY = -500;
            coin.setY(posY);
            //if the player touch the coin he will gain money 
            GameVariables.coinCount++;
           // coinSound.play();
        }else if(this.posY > GameVariables.height){
            //  if the meteor out of frame it will disappear
            posX = random.nextInt(0, GameVariables.width - COIN_SIZE);
            coin.setX(posX);
            posY = -500;
            coin.setY(posY);
        
        
        
        }
}

    void update(){
        posY += 2;
        coin.setY(posY);
    }
    
    
    
}