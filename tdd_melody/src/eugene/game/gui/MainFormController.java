package eugene.game.gui;

import eugene.game.Game;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;

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
    private Button playButton;
    
    @FXML
    private Button nextStap;
    
    
    
    private Game game = new Game();
    
    
    @FXML
    private void actionMakeStap(){
        if (this.buttonVar1.isSelected()) {
            game.makeStap(this.buttonVar1.getText());
        } else if (this.buttonVar2.isSelected()) {
            game.makeStap(this.buttonVar2.getText());
        } else if (this.buttonVar3.isSelected()) {
            game.makeStap(this.buttonVar3.getText());
        } else if (this.buttonVar4.isSelected()) {
            game.makeStap(this.buttonVar4.getText());
        }
    }
    
    @FXML
    private void actionPlay(){
        game.playSound();
    }
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        game.loadSoudStore("soud-store");
    }    
    
}
