package co.edu.uniquindio.parcia2.tallerbicicletas.controller;

import co.edu.uniquindio.parcia2.tallerbicicletas.MainApp;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class DashboardController {

    @FXML private Label lblTitulo;

    @FXML
    private void goCrearCliente() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    MainApp.class.getResource("/co/edu/uniquindio/parcia2/tallerbicicletas/view/CrearClienteView.fxml")
            );

            Scene scene = new Scene(loader.load(), 800, 560);

            Stage stage = (Stage) lblTitulo.getScene().getWindow();
            stage.setTitle("Clientes - Registro");
            stage.setScene(scene);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void salir() {
        Platform.exit();
    }
}
