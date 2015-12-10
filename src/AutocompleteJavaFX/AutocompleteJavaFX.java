package AutocompleteJavaFX;

/**
 * Created by gfitas on 09/12/15.
 */
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Side;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

import java.util.List;

/**
 * Created by gfitas on 04/12/15.
 */
public class AutocompleteJavaFX {
    private TextField textField;
    private ContextMenu contextMenu;
    private ActionToDo action;
    public AutocompleteJavaFX(TextField textSearch,ContextMenu textSearchContextMenu){
        this.textField = textSearch;
        this.contextMenu = textSearchContextMenu;
        textSearch.setContextMenu(textSearchContextMenu);
    }
    public void setAction(ActionToDo action) {
        this.action = action;
        this.textField.setContextMenu(contextMenu);
        this.textField.textProperty().addListener((observable, oldValue, newValue) -> {
            this.keyPressed();
        });
    }
    private void keyPressed(){
        Thread thread = new Thread(){
            @Override
            public void run(){
                List<? extends Object> listOfObj = action.methodCalledWhenSomthingIsTyped(textField.getText());
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        contextMenu.getItems().clear();
                        for( final Object Obj : listOfObj) {
                            MenuItem menuItem = new MenuItem(Obj.toString());
                            contextMenu.getItems().add(menuItem);
                            menuItem.setOnAction(new EventHandler<ActionEvent>() {
                                public void handle(ActionEvent t) {
                                    textField.setText(Obj.toString());
                                    action.methodCalledWhenSomthingIsSelected(Obj);
                                }
                            });
                        }
                        textField.getContextMenu().show(textField, Side.BOTTOM, 0, 0);
                    }
                });
            }
        };
        thread.start();
    }
}
