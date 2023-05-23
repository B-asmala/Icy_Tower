package icytower;

import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Button;


public class MainScene extends AnchorPane {
    
    Button startButton1 = new Button();
    ButtonStyle startButton = new ButtonStyle("Start","src/kenvector_future.ttf","-fx-background-color: transparent; -fx-background-image: url('yellow_button03.png');","-fx-background-color: transparent; -fx-background-image: url('yellow_button02.png');");
    ButtonStyle storeButton = new ButtonStyle("Store","src/Images/kenvector_future.ttf","-fx-background-color: transparent; -fx-background-image: url('yellow_button03.png');","-fx-background-color: transparent; -fx-background-image: url('yellow_button02.png');");
    ButtonStyle aboutUsButton = new ButtonStyle("About Us","src/Images/kenvector_future.ttf","-fx-background-color: transparent; -fx-background-image: url('yellow_button03.png');","-fx-background-color: transparent; -fx-background-image: url('yellow_button02.png');");
    ButtonStyle exitButton = new ButtonStyle("Exit","src/kenvector_future.ttf","-fx-background-color: transparent; -fx-background-image: url('yellow_button03.png');","-fx-background-color: transparent; -fx-background-image: url('yellow_button02.png');");
    
    //THE STRAT OF THE FIRST BUTTON
    private final static int STARTPAGE_BUTTONS_START_X = 65; 
    private final static int STARTPAGE_BUTTONS_START_Y = 700;
    
    //TO MAKE THE FOUR BUTTON LISTED ONE UNDER ANATHOR
    List<ButtonStyle> StartPageButtons; 
    
    public MainScene() {
        StartPageButtons = new ArrayList<>(); 
        createButtons();
        createBackground();
    }
    
    private void addStartPageButton(ButtonStyle button) {
        button.setLayoutX(STARTPAGE_BUTTONS_START_X);
        button.setLayoutY(STARTPAGE_BUTTONS_START_Y + StartPageButtons.size()*70);
        StartPageButtons.add(button);
       getChildren().add(button);
    }
    
    private void createButtons(){
        createStartButton();
        createStoreButton();
        createAboutUsButton();
        createExitButton();
    }

    private void createStartButton(){
        addStartPageButton(startButton);
        
    }
    
    private void createStoreButton(){
        addStartPageButton(storeButton);
    }
    
    private void createAboutUsButton(){
        addStartPageButton(aboutUsButton);
    }
    private void createExitButton(){
        addStartPageButton(exitButton);
    }
    
   private void createBackground() {
        Image backgroundImage = new Image("file:/home/basmala/NetBeansProjects/Icy Tower/src/Images/backgroundwith.jpeg",1000,1000,false,true); 
        BackgroundImage background = new BackgroundImage(backgroundImage,
            BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
        setBackground(new Background(background));
    }
}
