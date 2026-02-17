package co.edu.uniquindio.parcia2.tallerbicicletas.controller;

import co.edu.uniquindio.parcia2.tallerbicicletas.model.Taller;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ClienteControlller implements Initializable {

    // Recomendado: usa un Taller compartido (ver AppContext abajo)
    private final Taller taller = new Taller();

    @FXML private TextField txtNombre;
    @FXML private TextField txtIdentificacion;
    @FXML private TextField txtDireccion;
    @FXML private TextField txtTelefono;
    @FXML private Label lblMensaje;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Estado inicial
        lblMensaje.setText("");
    }

    @FXML
    private void handleRegistrar() {
        String nombre = safeTrim(txtNombre.getText());
        String identificacion = safeTrim(txtIdentificacion.getText());
        String direccion = safeTrim(txtDireccion.getText());
        String telefonoTexto = safeTrim(txtTelefono.getText());

        // Validación de vacíos
        if (nombre.isEmpty() || identificacion.isEmpty() || direccion.isEmpty() || telefonoTexto.isEmpty()) {
            showError("Todos los campos son obligatorios");
            return;
        }

        // Validación: identificación numérica (opcional pero recomendado)
        if (!identificacion.matches("\\d+")) {
            showError("La identificación debe ser numérica");
            txtIdentificacion.requestFocus();
            return;
        }

        // Validación: teléfono numérico
        if (!telefonoTexto.matches("\\d+")) {
            showError("El teléfono debe ser numérico");
            txtTelefono.requestFocus();
            return;
        }

        // Parse y validación de rango
        int telefono;
        try {
            telefono = Integer.parseInt(telefonoTexto);
            if (telefono <= 0) {
                showError("El teléfono debe ser mayor que 0");
                txtTelefono.requestFocus();
                return;
            }
        } catch (NumberFormatException e) {
            // Por si el número es demasiado grande para int
            showError("Teléfono inválido");
            txtTelefono.requestFocus();
            return;
        }

        // Registro
        boolean registrado = taller.registrarCliente(nombre, identificacion, direccion, telefono);

        if (registrado) {
            showSuccess("Cliente registrado exitosamente");
            limpiarCampos();
        } else {
            showError("El cliente ya existe");
        }
    }

    @FXML
    private void handleLimpiar() {
        limpiarCampos();
    }

    private void limpiarCampos() {
        txtNombre.clear();
        txtIdentificacion.clear();
        txtDireccion.clear();
        txtTelefono.clear();
        lblMensaje.setText("");
        txtNombre.requestFocus();
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
