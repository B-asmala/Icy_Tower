package icytower;

import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

public class Stairs extends VBox{
    
    int yPos = GameVariables.STAIRS_START;
    Stair stair, landingStair, checkingStair, lastStair;
    ImageView finishline = new ImageView(new Image("file:/home/basmala/NetBeansProjects/Icy Tower/src/Images/finishline.png", 1000, 100, false, false));
    Rectangle ground1 = new Rectangle();
    public Rectangle ground2 = new Rectangle();
    ArrayList<Stair> arr = new ArrayList<>();
    Stair ground = new Stair(); 
    Stairs(){
        super();
        super.getChildren().add(finishline);
        finishline.setTranslateY(GameVariables.stairSpacing);
        for(int i = 0; i < GameVariables.stairNum; i++){
            stair = new Stair();
            arr.add(stair);
            super.getChildren().add(stair);
            
        
        }
        //adding ground
        ground.setHeight(500);
        ground.setWidth(GameVariables.width + 100);
        ground.setTranslateX(-50);
        arr.add(ground);
        super.getChildren().add(ground);
        landingStair = ground;
        lastStair = ground;
        setSpacing(130);
        super.setTranslateY(yPos);
    
    
    
    }
    
    public void update(){
        super.setTranslateY(yPos);
        yPos += 2;

        
    
    }
    
    
    public void setLastStair(){
        lastStair = arr.get(arr.size() - 1);
        
    
    
    }
    
    public Stair getLandingStair(Player player){
        int i = 0;
           for( i = arr.size() - 1; i >= 0; i--){
               checkingStair = arr.get(i);
               if(checkingStair.getUpperBound() >= player.iv.getY() + player.playerHeight){
                   
                   landingStair = checkingStair;

               
               
               
               }else{
                   break;
               
               
               
               }
           
           GameVariables.score = GameVariables.stairNum - i;
           
           
           }

           return landingStair;


    }
    
    
    void removeLastStair(){
            setLastStair();

            if(lastStair.getUpperBound() > GameVariables.height && arr.size() > 1){
                
                arr.remove(lastStair);
                super.getChildren().remove(lastStair);
                lastStair = null;


            }
    
    
    }
        
        
        public Boolean Won(Player player){
            if(arr.indexOf(getLandingStair(player)) == 0){
                return true;
                
            
            
            }else{
                return false;
            
            
            }
        
        
        
        
        }
        

        
    
}
