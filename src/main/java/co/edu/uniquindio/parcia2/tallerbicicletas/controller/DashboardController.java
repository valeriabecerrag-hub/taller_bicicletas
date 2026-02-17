package co.edu.uniquindio.parcia2.tallerbicicletas.controller;

import co.edu.uniquindio.parcia2.tallerbicicletas.app.MainApp;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DashboardController {

    @FXML
    private void goCrearCliente(ActionEvent event) {
        cambiarVista(event,
                "/co/edu/uniquindio/parcia2/tallerbicicletas/view/CrearClienteView.fxml",
                "Clientes - Registro",
                800, 560
        );
    }

    @FXML
    private void goRegistrarBicicleta(ActionEvent event) {
        cambiarVista(event,
                "/co/edu/uniquindio/parcia2/tallerbicicletas/view/RegistrarBicicletaView.fxml",
                "Bicicletas - Registro",
                820, 600
        );
    }

    @FXML
    private void goRegistrarMecanico(ActionEvent event) {
        cambiarVista(event,
                "/co/edu/uniquindio/parcia2/tallerbicicletas/view/RegistrarMecanicoView.fxml",
                "Mecánicos - Registro",
                800, 560
        );
    }

    private void cambiarVista(ActionEvent event, String fxml, String title, int w, int h) {
        try {
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource(fxml));
            Scene scene = new Scene(loader.load(), w, h);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle(title);
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
