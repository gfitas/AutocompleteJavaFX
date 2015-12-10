
import AutocompleteJavaFX.AutocompleteJavaFX;
import AutocompleteJavaFX.Action;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.control.TextField;
import javafx.scene.control.ContextMenu;
/**
 * Created by gfitas on 10/12/15.
 */
public class Controller implements Initializable{
    @FXML
    private ContextMenu contextMenu;
    @FXML
    private TextField textField;

    private AutocompleteJavaFX autocompleteJavaFX;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.autocompleteJavaFX = new AutocompleteJavaFX(this.textField,this.contextMenu);
        this.autocompleteJavaFX.setAction(new Action() {
            @Override
            public List<? extends Object> methodCalledWhenSomthingIsTyped(String search){
                UrlGetSymbol urlGetSymbol = new UrlGetSymbol(search);
                return urlGetSymbol.startRequest();
            }
            @Override
            public void methodCalledWhenSomthingIsSelected(Object object){
                toDoSomethingWhenUserSelectAnItem();
            }
        });
    }
    private void toDoSomethingWhenUserSelectAnItem(){

    }
}
