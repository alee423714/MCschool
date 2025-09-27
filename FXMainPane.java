package lab;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * @author ralexander
 */
public class FXMainPane extends VBox {

    // Declare all the GUI components and the DataManager
    private Button helloButton, howdyButton, chineseButton, clearButton, exitButton;
    private Label feedbackLabel;
    private TextField inputTextField;
    private HBox topHBox, bottomHBox;
    private DataManager dataManager;

    /**
     * The constructor sets up the entire GUI.
     */
    public FXMainPane() {
        // Instantiate the components
        helloButton = new Button("Hello");
        howdyButton = new Button("Howdy");
        chineseButton = new Button("Chinese");
        clearButton = new Button("Clear");
        exitButton = new Button("Exit");
        feedbackLabel = new Label("Feedback:");
        inputTextField = new TextField();
        topHBox = new HBox();
        bottomHBox = new HBox();
        
        // Instantiate the DataManager
        dataManager = new DataManager();

        // Set alignment and margins for the HBoxes and their contents
        topHBox.setAlignment(Pos.CENTER);
        bottomHBox.setAlignment(Pos.CENTER);
        HBox.setMargin(feedbackLabel, new Insets(10));
        HBox.setMargin(inputTextField, new Insets(10));
        HBox.setMargin(helloButton, new Insets(10));
        HBox.setMargin(howdyButton, new Insets(10));
        HBox.setMargin(chineseButton, new Insets(10));
        HBox.setMargin(clearButton, new Insets(10));
        HBox.setMargin(exitButton, new Insets(10));
        
        // Add components to their respective HBoxes
        topHBox.getChildren().addAll(feedbackLabel, inputTextField);
        bottomHBox.getChildren().addAll(helloButton, howdyButton, chineseButton, clearButton, exitButton);
        
        // Add the HBoxes to this VBox pane
        this.getChildren().addAll(topHBox, bottomHBox);

        // Create the handler for button clicks
        ButtonHandler handler = new ButtonHandler();
        
        // Set the handler for each button
        helloButton.setOnAction(handler);
        howdyButton.setOnAction(handler);
        chineseButton.setOnAction(handler);
        clearButton.setOnAction(handler);
        exitButton.setOnAction(handler);
    }

    /**
     * Private inner class to handle button click events.
     */
    private class ButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            // Get the button that was clicked
            Object source = event.getTarget();
            
            // Use if-else-if to determine which button it was and act accordingly
            if (source == helloButton) {
                inputTextField.setText(dataManager.getHello());
            } else if (source == howdyButton) {
                inputTextField.setText(dataManager.getHowdy());
            } else if (source == chineseButton) {
                inputTextField.setText(dataManager.getChinese());
            } else if (source == clearButton) {
                inputTextField.setText("");
            } else if (source == exitButton) {
                Platform.exit();
                System.exit(0);
            }
        }
    }
}

