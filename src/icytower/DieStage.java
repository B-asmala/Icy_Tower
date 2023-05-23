package icytower;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class DieStage extends Stage{
        Image backgroundImage = new Image("file:/home/basmala/NetBeansProjects/Icy Tower/src/Images/gameOver.gif",1000,1000,false,true); 
        DieStage(){
            ButtonStyle home = new ButtonStyle("Home","src/kenvector_future.ttf","-fx-background-color: transparent; -fx-background-image: url('yellow_button03.png');","-fx-background-color: transparent; -fx-background-image: url('yellow_button02.png');");
            home.setLayoutX(405);
            home.setLayoutY(650);   
            home.setOnAction( e-> {
                close(); 
            
            });
            
            
            BackgroundImage background = new BackgroundImage(backgroundImage,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

            Pane root = new Pane();
            root.setBackground(new Background(background));
            root.getChildren().add(home);
            Scene scene = new Scene(root, 1000, 1000);

            setTitle("Game Over!");
            setScene(scene);
            setResizable(false);
            getIcons().add(new Image("file:/home/basmala/NetBeansProjects/Icy Tower/src/Images/Icon.png"));
        }
}
