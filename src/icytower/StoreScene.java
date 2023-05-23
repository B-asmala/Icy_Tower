package icytower;

import static icytower.GameVariables.score;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class StoreScene extends AnchorPane {
    
    ButtonStyle buyButton1 = new ButtonStyle("Owned","src/kenvector_future.ttf","-fx-text-fill: green; -fx-background-color: transparent; -fx-background-image: url('buttonLong_grey_pressed.png');","-fx-text-fill: green; -fx-background-color: transparent; -fx-background-image: url('buttonLong_grey.png');");
    ButtonStyle buyButton2 = new ButtonStyle("2 $","src/kenvector_future.ttf"," -fx-text-fill: green; -fx-background-color: transparent; -fx-background-image: url('buttonLong_grey_pressed.png');","-fx-text-fill: green; -fx-background-color: transparent; -fx-background-image: url('buttonLong_grey.png');");
    ButtonStyle buyButton3 = new ButtonStyle("3 $","src/kenvector_future.ttf"," -fx-text-fill: green; -fx-background-color: transparent; -fx-background-image: url('buttonLong_grey_pressed.png');","-fx-text-fill: green; -fx-background-color: transparent; -fx-background-image: url('buttonLong_grey.png');");
    ButtonStyle selectButton1 = new ButtonStyle("Select","src/kenvector_future.ttf","-fx-background-color: transparent; -fx-background-image: url('buttonLong_grey_pressed.png');","-fx-background-color: transparent; -fx-background-image: url('buttonLong_grey.png');");
    ButtonStyle selectButton2 = new ButtonStyle("Select","src/kenvector_future.ttf","-fx-background-color: transparent; -fx-background-image: url('buttonLong_grey_pressed.png');","-fx-background-color: transparent; -fx-background-image: url('buttonLong_grey.png');");
    ButtonStyle selectButton3 = new ButtonStyle("Select","src/kenvector_future.ttf","-fx-background-color: transparent; -fx-background-image: url('buttonLong_grey_pressed.png');","-fx-background-color: transparent; -fx-background-image: url('buttonLong_grey.png');");
//    ButtonStyle backButton = new ButtonStyle("back","src/kenvector_future.ttf", "-fx-background-color: transparent; -fx-background-image: url('yellow_sliderLeft.png');","-fx-background-color: transparent; -fx-background-image: url('yellow_sliderLeft.png');");
    static Text character;
    static Text coins;
    static String [] characters = {"Bor3y",  "Shokria", "Shawkat"};
    static Boolean [] Bought = {true, false, false};
    ButtonStyle home;
    
    
    

    
    private final static int BUTTONS_START_X = 220; 
    private final static int BUTTONS_START_Y = 366;
    
    private final static int IMAGE_START_X = 166; 
    private final static int IMAGE_START_Y = 130; 
    
    public StoreScene() {
        creatBackground();
        createCharcter();
        createButtons();   
        character = new Text("Selected character : " + characters[GameVariables.selectedCharacter]);
        character.setFill(Color.WHITE);
        character.setFont(Font.font(40));
        character.setX(200);
        character.setY(100);
        
        
        coins = new Text("Coins : " + Integer.toString(GameVariables.coinCount));
        coins.setFill(Color.GOLD);
        coins.setFont(Font.font(30));
        coins.setX(800);
        coins.setY(50);
                
        
        getChildren().add(coins);
        getChildren().add(character);
        
        home = new ButtonStyle("Home","src/kenvector_future.ttf","-fx-background-color: transparent; -fx-background-image: url('yellow_button03.png');","-fx-background-color: transparent; -fx-background-image: url('yellow_button02.png');");
        home.setLayoutX(15);
        home.setLayoutY(15); 
        getChildren().add(home);
        
    }
    
    private void creatBackground() {
        
        Image backgroundImage = new Image("file:/home/basmala/NetBeansProjects/Icy Tower/src/Images/background.jpeg",1000,1000,false,true); 
        BackgroundImage background = new BackgroundImage(backgroundImage,
            BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
        setBackground(new Background(background));
    }    
    
    private void createButtons() {

//        Backbutton(); 
        BuyButton1();
        BuyButton2();
        BuyButton3();
        SelectButton1();
        SelectButton2();
        SelectButton3();
    }
    
    private void createCharcter() {
        Character1();
        Character2();
        Character3();
    }
    

    
    private void BuyButton1() {
        buyButton1.setDisable(true); 
        buyButton1.setLayoutX(BUTTONS_START_X);
        buyButton1.setLayoutY(BUTTONS_START_Y);
        getChildren().add(buyButton1);
    }
    
    private void BuyButton2() {
        buyButton2.setLayoutX(BUTTONS_START_X + 360);
        buyButton2.setLayoutY(BUTTONS_START_Y);
        getChildren().add(buyButton2);
    }

    private void BuyButton3() {
        buyButton3.setLayoutX(BUTTONS_START_X + 180);
        buyButton3.setLayoutY(BUTTONS_START_Y + 420 );
        getChildren().add(buyButton3);
    }
    
    private void SelectButton1() {
        selectButton1.setLayoutX(BUTTONS_START_X);
        selectButton1.setLayoutY(BUTTONS_START_Y + 70 );
        getChildren().add(selectButton1);
    }
    
    private void SelectButton2() {
        selectButton2.setLayoutX(BUTTONS_START_X + 360 );
        selectButton2.setLayoutY(BUTTONS_START_Y + 70 );
        getChildren().add(selectButton2);
    }
    
    private void SelectButton3() {
        selectButton3.setLayoutX(BUTTONS_START_X + 180);
        selectButton3.setLayoutY(BUTTONS_START_Y + 480 );
        getChildren().add(selectButton3);
    }
    
    private void Character1() {
        Image image = new Image("file:/home/basmala/NetBeansProjects/Icy Tower/src/Images/Bor3y.jpeg");
        ImageView imageview = new ImageView(image);
        imageview.setX(IMAGE_START_X);
        imageview.setY(IMAGE_START_Y);
        imageview.setFitWidth(280);
        imageview.setFitHeight(400);
        getChildren().add(imageview);
    }
    
    private void Character2() {
        Image image = new Image("file:/home/basmala/NetBeansProjects/Icy Tower/src/Images/Shawkat.jpeg");
        ImageView imageview = new ImageView(image);
        imageview.setX(IMAGE_START_X + 360 );
        imageview.setY(IMAGE_START_Y);
        imageview.setFitWidth(280);
        imageview.setFitHeight(400);
        getChildren().add(imageview);
    }
    
    private void Character3() {
        Image image = new Image("file:/home/basmala/NetBeansProjects/Icy Tower/src/Images/Shokria.jpeg");
        ImageView imageview = new ImageView(image);
        imageview.setX(IMAGE_START_X + 180);
        imageview.setY(IMAGE_START_Y + 430 );
        imageview.setFitWidth(280);
        imageview.setFitHeight(400);
        getChildren().add(imageview);
    }
    
    
    
}