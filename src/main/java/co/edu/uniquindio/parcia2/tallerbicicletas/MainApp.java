package co.edu.uniquindio.parcia2.tallerbicicletas;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(
                MainApp.class.getResource("/co/edu/uniquindio/parcia2/tallerbicicletas/view/LoginView.fxml")
        );

        Scene scene = new Scene(loader.load(), 520, 360);

        stage.setTitle("Taller de Bicicletas");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
