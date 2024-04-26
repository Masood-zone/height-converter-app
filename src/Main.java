import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Main.fxml"));
        Parent mainLayout = fxmlLoader.load();
        Scene scene = new Scene(mainLayout);

        stage.setTitle("Metric/US Height Converter");
        stage.setScene(scene);
        stage.show();
    }
}