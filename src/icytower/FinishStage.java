package icytower;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FinishStage extends Stage{
    
    private static final int width = 1000; //GameVariables.width
    private static final int height = 1000; //GameVariables.height
    private static final int initX = width / 2;
    private static final int initY = height / 2;
    private static double dx = 2.5;
    private static double dy = 1.5;
    private static int rotationAngle = 15;
    Image backgroundImage = new Image("file:/home/basmala/NetBeansProjects/Icy Tower/src/Images/space_backgroundreal.gif",1000,1000,false,true); 
    Image image1;
    
    public FinishStage(){
        Pane root = new Pane();
        //setting home button style;
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

        
        root.setBackground(new Background(background));
        root.getChildren().add(home);
        Scene scene = new Scene(root, 1000, 1000);
        //setting label style
        Label label = new Label("Congratulations!");
        label.setLayoutX(200);
        label.setLayoutY(500);
        label.setStyle("-fx-text-fill: gold;"+
           "-fx-font-family: Cursive;"+
           "-fx-font-weight: bold;"+
           "-fx-font-size: 80;");
        root.getChildren().add(label);
        
        //setting player position
        switch (GameVariables.selectedCharacter) {
            case 0:
                image1 = new Image("file:/home/basmala/NetBeansProjects/Icy Tower/src/Images/charachters/bor3y0.png");
                break;
            case 1:
                image1 = new Image("file:/home/basmala/NetBeansProjects/Icy Tower/src/Images/charachters/shokria0.png");
                break;
            case 2:
                image1 = new Image("file:/home/basmala/NetBeansProjects/Icy Tower/src/Images/charachters/shawkat0.png");
                break;
            default:
                break;
        }
        ImageView iv = new ImageView(image1);
        iv.setTranslateX(initX);
        iv.setTranslateY(initY);
        iv.setFitHeight(200);
        iv.setFitWidth(160);
        root.getChildren().add(iv);
        setScene(scene);
//        //setting star1 to the pane
        Image image2 = new Image("file:/home/basmala/NetBeansProjects/Icy Tower/src/Images/star1.png");
        ImageView iv2 = new ImageView(image2);
        iv2.setTranslateX(initX + 20);
        iv2.setTranslateY(initY);
        root.getChildren().add(iv2);
        
        //setting star2 to the pane
        Image image3 = new Image("file:/home/basmala/NetBeansProjects/Icy Tower/src/Images/star2.png");
        ImageView iv3 = new ImageView(image3);
        iv3.setTranslateX(initX + 40);
        iv3.setTranslateY(initY - 30);
        root.getChildren().add(iv3);
        
        //setting star3 to the pane
        Image image4 = new Image("file:/home/basmala/NetBeansProjects/Icy Tower/src/Images/star3.png");
        ImageView iv4 = new ImageView(image4);
        iv4.setTranslateX(initX + 60);
        iv4.setTranslateY(initY - 50);
        root.getChildren().add(iv4);
        
        //creating a Timeline animation to update the positions
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(5), event -> {
            //updating player's position
            iv.setTranslateX(iv.getTranslateX() + dx);
            iv.setTranslateY(iv.getTranslateY() + dy);

            //checking for collisions with the window boundaries
            if (iv.getTranslateX() <= 0 || iv.getTranslateX() >= width - 88) { // 44 --> p1.playerWidth
                dx *= -1;
                iv.setRotate(iv.getRotate() + rotationAngle);
            }
            if (iv.getTranslateY() <= 0  || iv.getTranslateY() >= height - 116) { // 58 --> p1.playerHeight
                dy *= -1;
                iv.setRotate(iv.getRotate() - rotationAngle);
            }
            
            //updating star1's position
            iv2.setTranslateX(iv.getTranslateX() + -dx*20);
            iv2.setTranslateY(iv.getTranslateY() + -dy*20);
            
            //updating star2's position
            iv3.setTranslateX(iv.getTranslateX() + -dx*40);
            iv3.setTranslateY(iv.getTranslateY() + -dy*30);
            
            //updating star3's position
            iv4.setTranslateX(iv.getTranslateX() + -dx*50);
            iv4.setTranslateY(iv.getTranslateY() + -dy*50);
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        
    }
}