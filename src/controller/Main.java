package controller;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.project.observer.ProjectManager;
import view.general.MainScreenController;
 
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        try {
            ProjectManager manager = new ProjectManager();
            
            FXMLLoader loader = new FXMLLoader();
            MainScreenController controller = new MainScreenController();
            loader.setController(controller);
            controller.setProjectManager(manager);
            Parent root = loader.load(getClass().getResource("../view/general/main_screen.fxml")); 
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Octavia Melody Writer");
            primaryStage.setOnCloseRequest((e)->{System.exit(0);});
            primaryStage.show();
        } catch (IOException e) {
            System.out.println(String.format("Сценарий построения интерфейса повреждён, или отсутствует. Сообщение ошибки:\n%s", e.getMessage()));
            e.printStackTrace();
        }
    }
}
