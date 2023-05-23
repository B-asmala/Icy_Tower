package icytower;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;



public class Main extends Application {
    /*
    If you intend to run this program on your machine note that
    - Paths of photos need to be changed
    - changing some variables like gravity or stage size may stop the game from working properly
    */
    
    static GameStage gs;
    @Override
    public void start(Stage primaryStage) {
        
        MainScene mainscene = new MainScene();
        StoreScene store = new StoreScene();
        AboutScene about = new AboutScene();
        
        
        Scene scene = new Scene(mainscene,1000,1000);
        primaryStage.setScene(scene);
        
        //  MainScene part  //
        
      mainscene.startButton.setOnAction( e-> {
            initGame();
            
      
      });  
        
        mainscene.storeButton.setOnAction( e-> {
            primaryStage.getScene().setRoot(store); });
        
        mainscene.aboutUsButton.setOnAction( e-> {
            primaryStage.getScene().setRoot(about); });  
        
        mainscene.exitButton.setOnAction( e-> {
            primaryStage.close(); });
        
        //  StoreScene part  //
        
        store.home.setOnAction( e-> {
            primaryStage.getScene().setRoot(mainscene); });
        
        store.buyButton2.setOnAction( e-> {
            if(GameVariables.coinCount >= 2 ){
                store.buyButton2.setDisable(true); 
                GameVariables.coinCount -= 2;
                StoreScene.Bought[1] = true;
            updateStore();
            }else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("You don't have enough coins!!");
            alert.showAndWait();
            
            
            
            }
        });
        
        store.buyButton3.setOnAction( e-> {
            if(GameVariables.coinCount >= 3 ){
                store.buyButton3.setDisable(true); 
                GameVariables.coinCount -= 3;
                System.out.println(GameVariables.coinCount);
                StoreScene.Bought[2] = true;
            updateStore();
            }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText("You don't have enough coins!!");
                alert.showAndWait();
            
            
            }
        });
        
                   
             
       
        
       store.selectButton1.setOnAction( e-> {
           
           GameVariables.selectedCharacter = 0;
           updateStore();
                        });
        
        store.selectButton2.setOnAction( e-> {
            if( StoreScene.Bought[1]){
            GameVariables.selectedCharacter = 2;
            updateStore();
            }    });
        
        store.selectButton3.setOnAction( e-> {
            if( StoreScene.Bought[2]){
            GameVariables.selectedCharacter = 1;
            updateStore();
            }  }); 
        
        //  About Us part  //
        
        about.home.setOnAction( e-> {
        primaryStage.getScene().setRoot(mainscene); });
        
        // TO SHOW ALERT BEFORE CLOSING //
        
        primaryStage.setOnCloseRequest(event -> {
            event.consume(); // Prevents the window from closing immediately

            // Show a confirmation dialog or perform any necessary actions
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Are you sure you want to exit?");
            alert.setContentText("All your progress will be lost.");

            if (alert.showAndWait().orElse(null) == javafx.scene.control.ButtonType.OK) {
                Stage window = (Stage) event.getSource();
                window.close(); // Close the window if confirmed
            }
            Platform.exit();
            System.exit(0);
        });
        
        primaryStage.setTitle("Icy Tower");
        primaryStage.getIcons().add(new Image("file:/home/basmala/NetBeansProjects/Icy Tower/src/Images/Icon.png"));
        primaryStage.setResizable(false);
        primaryStage.show();

    }
    
    private void initGame(){
        //initiallize the game stage
        GameVariables.score = 0;
        GameVariables.heartNum = 3;
        gs = new GameStage();
        gs.show();
    
    
    
    }
 
    public void updateStore(){
        StoreScene.character.setText("Selected character : " +  StoreScene.characters[GameVariables.selectedCharacter]);
        StoreScene.coins.setText("coins : " +  Integer.toString(GameVariables.coinCount));
    
    }
    
   
    public static void main(String[] args) {
        launch(args);
    }
    
}
