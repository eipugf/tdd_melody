package eugene.game.gui;

import eugene.game.Game;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Eugene
 */
public class MainFormController implements Initializable {
    @FXML
    private RadioButton buttonVar1;
    
    @FXML
    private RadioButton buttonVar2;
    
    @FXML
    private RadioButton buttonVar3;
    
    @FXML
    private RadioButton buttonVar4;
    
    @FXML
    private TextArea text;
    
    @FXML
    Button playButton;
    
    @FXML
    Button nextStap;
    
    private Game game = new Game();
    
    private void setVariants(String[] variants){
        this.buttonVar1.setText(variants[0].replace(".wav",""));
        this.buttonVar2.setText(variants[1].replace(".wav",""));
        this.buttonVar3.setText(variants[2].replace(".wav",""));
        this.buttonVar4.setText(variants[3].replace(".wav",""));
    }
    
    
    ToggleGroup group = new ToggleGroup();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        game.loadSoudStore("soud-store");
        this.buttonVar1.setToggleGroup(group);
        this.buttonVar2.setToggleGroup(group);
        this.buttonVar3.setToggleGroup(group);
        this.buttonVar4.setToggleGroup(group);
        this.setVariants(game.getVariants());
        updateText();
    }    
    
    @FXML
    private void actionMakeStap(){
        if(!game.isStarted())
            return;
        if (this.buttonVar1.isSelected()) {
            game.makeStap(this.buttonVar1.getText());
            this.setVariants(game.getVariants());
        } else if (this.buttonVar2.isSelected()) {
            game.makeStap(this.buttonVar2.getText());
            this.setVariants(game.getVariants());
        } else if (this.buttonVar3.isSelected()) {
            game.makeStap(this.buttonVar3.getText());
            this.setVariants(game.getVariants());
        } else if (this.buttonVar4.isSelected()) {
            game.makeStap(this.buttonVar4.getText());
            this.setVariants(game.getVariants());
        }
        updateText();
    }
    
    @FXML
    private void actionPlay(){
        if(!game.isStarted())
            return;
        game.playSound();
        updateText();
    }
    
    private void updateText(){
        this.text.setText(game.getStringResult());
    }
}
