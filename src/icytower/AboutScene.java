package icytower;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;

public class AboutScene extends AnchorPane {
 
    ButtonStyle home = new ButtonStyle("Home","src/kenvector_future.ttf","-fx-background-color: transparent; -fx-background-image: url('yellow_button03.png');","-fx-background-color: transparent; -fx-background-image: url('yellow_button02.png');");

    public AboutScene() {
        creatBackground();
        Homebutton();
    }
    
    private void Homebutton() {
        home.setLayoutX(405);
        home.setLayoutY(930);
        getChildren().add(home);
    }
    
    private void creatBackground() {
        
        Image backgroundImage = new Image("file:/home/basmala/NetBeansProjects/Icy Tower/src/Images/message.png",1000,1000,false,true); 
        BackgroundImage background = new BackgroundImage(backgroundImage,
            BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
        setBackground(new Background(background));
    }
    

}