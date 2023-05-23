
package icytower;

import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author basmala
 */
public class GameVariables extends VBox{
   public static final int width = 1000;
   public static final int height = 1000;
   public static final int stairSpacing = 130;
   public static final int stairHeight = 40;
   public static final int stairNum = 67;
   public static final int STAIRS_START = -11100; 
   public static int selectedCharacter = 0;
   public static int heartNum = 3;
   public static int score = 0;
   public static int coinCount = 5;
   private final Image[] heartImages = new Image[4];
   ImageView heart;
   HBox coins;
   ImageView coin = new ImageView(new Image("file:/home/basmala/NetBeansProjects/Icy Tower/src/Images/coin.png", 70, 70, false, false));
   Text coinText;
   Text scoreText;
   GameVariables(){
       //get heart images
       for(int i = 0; i <= 3; i++){
           heartImages[i] = new Image("file:/home/basmala/NetBeansProjects/Icy Tower/src/Images/" + i + "hearts.png", 231,70, false, false);
       
       
       }
       //initially
       heart = new ImageView(heartImages[3]);
       
       
       
       
       //coins
       coins = new HBox(10);
       coinText = new Text(Integer.toString(coinCount));
       coinText.setFill(Color.GOLD);
       coinText.setFont(Font.font(40));
       coinText.setTranslateY(5);
       coins.getChildren().addAll(coin, coinText);
       scoreText = new Text("Score : " +Integer.toString(score));
       scoreText.setFill(Color.WHITE);
       scoreText.setStroke(Color.BLACK);
       scoreText.setFont(Font.font(40));
       super.getChildren().addAll(heart,coins, scoreText);
   }
   
   
   public void update(){
       heart.setImage(heartImages[heartNum]);
       coinText.setText(Integer.toString(coinCount));
       scoreText.setText("Score : " +Integer.toString(score));
   
   
   }
   


   
   
    
}
