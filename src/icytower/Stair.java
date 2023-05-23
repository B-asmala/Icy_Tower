package icytower;


import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.Random;





public class Stair extends Rectangle{
   

    private int posX, width;
    Random random = new Random();




    public Stair() {
        super();
        posX =  random.nextInt(0, 400);
        width = random.nextInt(400,GameVariables.width - posX);
        this.setTranslateX(posX);
        this.setWidth(width);
        this.setHeight(GameVariables.stairHeight);
        this.setArcHeight(20);
        this.setArcWidth(20);
        this.setStroke(Color.TRANSPARENT);
        this.setStrokeWidth(5);
        this.setFill(Color.rgb(150, 150, 170));
       



        

    }
    //change after landing

    int getUpperBound(){
        return (int) localToScene(getBoundsInLocal()).getMinY();
    
    
    }

    public int getPosX() {
        return posX;
    }



    

    
    public void changeColor(){

            this.setStroke(Color.VIOLET);
            this.setFill(Color.rgb(50, 50, 50));
        
        
        
    
    
    }
}

    
    



