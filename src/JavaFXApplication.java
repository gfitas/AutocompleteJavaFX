import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by gfitas on 10/12/15.
 */
public class JavaFXApplication extends Application {
    @Override
    public void start (Stage primaryStage)throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Autocomplete");
        Scene scene = new Scene(root, 400, 65);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void launchIt() {
        launch();
    }
}
