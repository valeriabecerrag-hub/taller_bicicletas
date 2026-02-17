package co.edu.uniquindio.parcia2.tallerbicicletas.controller;

import co.edu.uniquindio.parcia2.tallerbicicletas.app.MainApp;
import co.edu.uniquindio.parcia2.tallerbicicletas.app.AppContext;
import co.edu.uniquindio.parcia2.tallerbicicletas.model.Taller;
import co.edu.uniquindio.parcia2.tallerbicicletas.model.enums.EspecialidadMecanico;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MecanicoController implements Initializable {

    private final Taller taller = AppContext.TALLER;

    @FXML private TextField txtNombre;
    @FXML private TextField txtIdentificacion;
    @FXML private TextField codigoInterno;      // TextField en la vista
    @FXML private ComboBox<EspecialidadMecanico> cbEspecialidad;
    @FXML private Label lblMensaje;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblMensaje.setText("");
        cbEspecialidad.setItems(FXCollections.observableArrayList(EspecialidadMecanico.values()));
    }

    @FXML
    private void handleRegistrar() {
        String nombre = safeTrim(txtNombre.getText());
        String identificacion = safeTrim(txtIdentificacion.getText());
        String codigoTexto = safeTrim(codigoInterno.getText());
        EspecialidadMecanico especialidad = cbEspecialidad.getValue();


        if (nombre.isEmpty() || identificacion.isEmpty() || codigoTexto.isEmpty() || especialidad == null) {
            showError("Todos los campos son obligatorios");
            return;
        }

        if (!identificacion.matches("\\d+")) {
            showError("La identificación debe ser numérica");
            txtIdentificacion.requestFocus();
            return;
        }

        if (!codigoTexto.matches("\\d+")) {
            showError("El código interno debe ser numérico");
            codigoInterno.requestFocus();
            return;
        }


        int codigo;
        try {
            codigo = Integer.parseInt(codigoTexto);
            if (codigo <= 0) {
                showError("El código interno debe ser mayor que 0");
                codigoInterno.requestFocus();
                return;
            }
        } catch (NumberFormatException e) {
            showError("Código interno inválido");
            codigoInterno.requestFocus();
            return;
        }

        // Aquí llamamos EXACTAMENTE con la firma de tu Taller:
        boolean ok = taller.registrarMecanico(especialidad, codigo, nombre, identificacion);

        if (ok) {
            showSuccess("Mecánico registrado exitosamente");
            limpiarCampos();
        } else {
            showError("El mecánico ya existe");
        }
    }

    @FXML
    private void handleLimpiar() {
        limpiarCampos();
    }

    private void limpiarCampos() {
        txtNombre.clear();
        txtIdentificacion.clear();
        codigoInterno.clear();
        cbEspecialidad.getSelectionModel().clearSelection();
        lblMensaje.setText("");
        txtNombre.requestFocus();
    }

    @FXML
    private void volverDashboard(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    MainApp.class.getResource("/co/edu/uniquindio/parcia2/tallerbicicletas/view/DashboardView.fxml")
            );
            Scene scene = new Scene(loader.load(), 800, 500);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Panel - Taller de Bicicletas");
            stage.setScene(scene);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showError(String msg) {
        lblMensaje.setText(msg);
        lblMensaje.setStyle("-fx-text-fill: #dc2626; -fx-font-weight: 700;");
    }

    private void showSuccess(String msg) {
        lblMensaje.setText(msg);
        lblMensaje.setStyle("-fx-text-fill: #16a34a; -fx-font-weight: 700;");
    }

    private String safeTrim(String s) {
        return s == null ? "" : s.trim();
    }
}
