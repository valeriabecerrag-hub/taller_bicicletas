package co.edu.uniquindio.parcia2.tallerbicicletas.controller;

import co.edu.uniquindio.parcia2.tallerbicicletas.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class LoginController {

    @FXML private TextField txtUsuario;
    @FXML private PasswordField txtPassword;
    @FXML private Label lblMensaje;

    @FXML
    private void handleLogin() {
        String user = txtUsuario.getText().trim();
        String pass = txtPassword.getText().trim();

        if (user.isEmpty() || pass.isEmpty()) {
            lblMensaje.setText("Ingrese usuario y contraseña");
            lblMensaje.setStyle("-fx-text-fill: red;");
            return;
        }

        // Credenciales ejemplo
        if (user.equals("admin") && pass.equals("1234")) {
            try {
                FXMLLoader loader = new FXMLLoader(
                        MainApp.class.getResource("/co/edu/uniquindio/parcia2/tallerbicicletas/view/DashboardView.fxml")
                );

                Scene dashboardScene = new Scene(loader.load(), 800, 500);

                // obtener el stage actual desde cualquier control del login:
                Stage stage = (Stage) txtUsuario.getScene().getWindow();
                stage.setTitle("Panel - Taller de Bicicletas");
                stage.setScene(dashboardScene);

            } catch (Exception e) {
                e.printStackTrace();
                lblMensaje.setText("No se pudo cargar el Dashboard");
                lblMensaje.setStyle("-fx-text-fill: red;");
            }
        } else {
            lblMensaje.setText("Credenciales inválidas");
            lblMensaje.setStyle("-fx-text-fill: red;");
        }
    }
}
