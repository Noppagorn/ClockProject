package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Controller controller = new Controller();
        Parent root = (Parent) FXMLLoader.load(Main.class.getResource("sample.fxml"));
        primaryStage.setTitle("CLOCk");
        primaryStage.setScene(new Scene(root, 600, 500));
        primaryStage.setResizable(false);
        primaryStage.show();
        //controller.running();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
