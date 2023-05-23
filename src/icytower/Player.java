package icytower;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Player extends Pane{
    
    //////attributes//////
    private final Image[] characterImages = new Image[11]; //storing character positions in an image array
    private final int positionX = 480; //initial position in x-direction
    private final int positionY = 755; //initial position in y-direction 
    public ImageView iv;
    public int index; 
    public final double gravity = 2, jumpHeight = 25;
    private double speed = 3;
    public boolean movingRight = false, movingLeft = false, space = false, landed = true, jumping = false;
    public double velocityY;
    public double playerHeight = 116, playerWidth = 88;
    

      //////methods//////

    Player(int characterCode){//a parametarized constructor takes the code of the chosen character
        switch (characterCode){
            case 1: //Shokria's code
                for(int i=0; i<11; i++){
                    characterImages[i] = new Image("file:/home/basmala/NetBeansProjects/Icy Tower/src/Images/charachters/shokria" + i + ".png", 88, 116, false, false);
                }
                break;
            case 2: //Shawkat's code
                for(int i=0; i<11; i++){
                    characterImages[i] = new Image("file:/home/basmala/NetBeansProjects/Icy Tower/src/Images/charachters/shawkat" + i + ".png", 88, 116, false, false);
                }
               break;
            default: //case 0 : Bora3y
                for(int i=0; i<11; i++){
                    characterImages[i] = new Image("file:/home/basmala/NetBeansProjects/Icy Tower/src/Images/charachters/bor3y" + i + ".png", 88, 116, false, false);
                }
                break;      
        }
        iv = new ImageView(characterImages[1]);
        getChildren().add(iv);
        
        //initializing the character position at the beginning of the game
        iv.setX(positionX);
        iv.setY(positionY);
    }
    
    //speed setter method
    public void setSpeed(){
        this.speed = 3;
    }
    
    //a method to update the player's position based on its state 
    public void update() {
        //Vertical movement------------
       
        //collision detection with ground
        if (landed) {           
            velocityY = 0;
            jumping = false;
            switchPositions(1);
        }else{
            //in air
            velocityY += gravity;
            iv.setY(iv.getY() + velocityY);
            
            if(movingRight){
                if(velocityY <= 0){
                    switchPositions(7); //jumping right
                }else{
                    switchPositions(9); //falling right
                }
            }else if(movingLeft){
                if(velocityY <= 0){
                    switchPositions(8); //jumping left
                }else{
                    switchPositions(10); //falling left
                }
            }else{
                switchPositions(6);
            }
        }
    
        //Horizontal movement------------
        //right direction movement
        double dx = 0;
        if (movingRight) {
            speed++;
            dx += speed;
            if(index == 2 || index == 1){
                switchPositions(5);
            }
            else if(index == 5){
                switchPositions(4);
            }
        }
        //left direction movement
        if (movingLeft) {
            speed++;
            dx -= speed;
            if(index == 4 ||  index == 1){
                switchPositions(5);
            }
            else if(index == 5){
                switchPositions(4);
            }
        }
        
        iv.setX(iv.getX() + dx);
        
        //detecting whether the player collided with walls or not
        if (iv.getX() < 0) {
            iv.setX(0);
        }
        if (iv.getX() > GameVariables.width - playerWidth) {
            iv.setX(GameVariables.width - playerWidth);
}
          
    } 
    //detecting whether the user has losed or not
    public Boolean isDead(){
        if(iv.getY() >= GameVariables.height || GameVariables.heartNum == 0){
            return true;
        }else{
            return false;
        }
    }
    
    //detecting the nearest stair the player can land on
    void checkLanding(Stair stair){
        if(stair.getUpperBound() >= (getLegY()) && velocityY + gravity >= stair.getUpperBound() - getLegY() && iv.getX() >= stair.getPosX() - playerWidth / 2 && iv.getX() + playerWidth <= stair.getPosX() + stair.getWidth() + playerWidth / 2) {
            landed = true;
            stair.changeColor();
            iv.setY(stair.getUpperBound() - playerHeight);
            
        }else{
            landed = false;
        }
    }
    
    //changing player's images to make the movement appears animated
    public void switchPositions(int index){
        this.index = index;
        iv.setImage(characterImages[index]);
    }

    //getting the current Y position of the lower left point of the player
    public int getLegY() {
        return (int) (iv.getY() + playerHeight);
    }
    
    //getting the landed state to check whether the character is standing on a stair or not
    public Boolean getLandingState(){
        return this.landed;
    }
    
}
