package icytower;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

public class ButtonStyle extends Button {
    
        public ButtonStyle(String BUTTON_PRESSED,String BUTTON_RELEASED) { // THE CONSTRCUTOR THAT IN CHARGE OF THE BUTTONS 
        setPrefWidth(39);
        setPrefHeight(31);
        setStyle(BUTTON_RELEASED);
        initializeButtonListeners(BUTTON_PRESSED,BUTTON_RELEASED);        
    }
    
    public ButtonStyle(String text,String FONT_PATH,String BUTTON_PRESSED,String BUTTON_RELEASED) { // THE CONSTRCUTOR THAT IN CHARGE OF THE BUTTONS 
        setText(text);
        setButtonFont(FONT_PATH);
        setPrefWidth(190);
        setPrefHeight(49);
        setStyle(BUTTON_RELEASED);
        initializeButtonListeners(BUTTON_PRESSED,BUTTON_RELEASED);        
    }
    
    private void setButtonFont(String FONT_PATH) {
       try{
        setFont(Font.loadFont(new FileInputStream(FONT_PATH), 20));
       }
       catch( FileNotFoundException ex ) {
        setFont(Font.font("Verdana", 23)); //if our uploaded FONT did not work this FONT "Verdana" will be used instead        
       }
    }
    
    private void setButtonPressed(String BUTTON_PRESSED) {
        setStyle(BUTTON_PRESSED);
        setPrefHeight(45);
        setLayoutY(getLayoutY() + 4); //THE PRESSED BUTTON IMAGE HEIGHT IS 4 PX SMALLER THAN THE RELEASED ONE
        
    }
    
    private void setButtonReleased(String BUTTON_RELEASED) {
        setStyle(BUTTON_RELEASED);
        setPrefHeight(49);
        setLayoutY(getLayoutY() - 4); // NOTE ABOVE ^^
        
    }
    
    private void initializeButtonListeners(String BUTTON_PRESSED,String BUTTON_RELEASED) {
        
        setOnMousePressed(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            if( event.getButton().equals(MouseButton.PRIMARY)) {
                setButtonPressed(BUTTON_PRESSED);
            }
        }
            
        });
        
        setOnMouseReleased(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            if( event.getButton().equals(MouseButton.PRIMARY)) {
                setButtonReleased(BUTTON_RELEASED);
            }
        }
            
        });
        
        setOnMouseEntered(new EventHandler<MouseEvent>() { // IT CREATE A DROP SHADOW EFFECT WHEN A MOUSRE ENTERED ON THE BUTTON
        @Override
        public void handle(MouseEvent event) {
            setEffect(new DropShadow());        
        }
            
        });
        
        setOnMouseExited(new EventHandler<MouseEvent>() { 
        @Override
        public void handle(MouseEvent event) {
            setEffect(null);        
        }
            
        });
    }
    
}
