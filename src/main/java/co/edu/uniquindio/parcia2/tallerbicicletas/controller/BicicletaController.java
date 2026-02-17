package co.edu.uniquindio.parcia2.tallerbicicletas.controller;

import co.edu.uniquindio.parcia2.tallerbicicletas.app.MainApp;
import co.edu.uniquindio.parcia2.tallerbicicletas.app.AppContext;
import co.edu.uniquindio.parcia2.tallerbicicletas.model.Cliente;
import co.edu.uniquindio.parcia2.tallerbicicletas.model.Taller;
import co.edu.uniquindio.parcia2.tallerbicicletas.model.enums.TipoBicicleta;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class BicicletaController implements Initializable {

    private final Taller taller = AppContext.TALLER;

    @FXML private ComboBox<Cliente> cbClientes;
    @FXML private ComboBox<TipoBicicleta> cbTipo;

    @FXML private TextField txtMarca;
    @FXML private TextField txtColor;
    @FXML private TextField txtSerial;
    @FXML private TextField txtAnio;

    @FXML private Label lblMensaje;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblMensaje.setText("");

        // Cargar tipos (enum)
        cbTipo.setItems(FXCollections.observableArrayList(TipoBicicleta.values()));

        // Cargar clientes existentes (debe existir getClientes() en Taller)
        cbClientes.setItems(FXCollections.observableArrayList(taller.getClientes()));

        // Mostrar texto agradable en el ComboBox
        cbClientes.setCellFactory(list -> new javafx.scene.control.ListCell<>() {
            @Override
            protected void updateItem(Cliente item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? "" : item.getNombre() + " - " + item.getNumIdentificacion());
            }
        });

        cbClientes.setButtonCell(new javafx.scene.control.ListCell<>() {
            @Override
            protected void updateItem(Cliente item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? "" : item.getNombre() + " - " + item.getNumIdentificacion());
            }
        });
    }

    @FXML
    private void handleRegistrar() {
        Cliente cliente = cbClientes.getValue();
        String marca = safeTrim(txtMarca.getText());
        TipoBicicleta tipo = cbTipo.getValue();
        String color = safeTrim(txtColor.getText());
        String serial = safeTrim(txtSerial.getText());
        String anioTexto = safeTrim(txtAnio.getText());

        if (cliente == null || marca.isEmpty() || tipo == null || color.isEmpty() || serial.isEmpty() || anioTexto.isEmpty()) {
            showError("Todos los campos son obligatorios (incluye cliente y tipo)");
            return;
        }

        if (!anioTexto.matches("\\d+")) {
            showError("El año debe ser numérico");
            txtAnio.requestFocus();
            return;
        }

        int anio;
        try {
            anio = Integer.parseInt(anioTexto);
            if (anio < 1900 || anio > 2100) {
                showError("Año fuera de rango (1900 - 2100)");
                txtAnio.requestFocus();
                return;
            }
        } catch (NumberFormatException e) {
            showError("Año inválido");
            txtAnio.requestFocus();
            return;
        }

        boolean ok = taller.registrarBicicleta(cliente, marca, tipo, color, serial, anio);

        if (ok) {
            showSuccess("Bicicleta registrada exitosamente");
            limpiarCampos();
        } else {
            showError("Ya existe una bicicleta con ese serial");
        }
    }

    @FXML
    private void handleLimpiar() {
        limpiarCampos();
    }

    private void limpiarCampos() {
        cbClientes.getSelectionModel().clearSelection();
        cbTipo.getSelectionModel().clearSelection();
        txtMarca.clear();
        txtColor.clear();
        txtSerial.clear();
        txtAnio.clear();
        lblMensaje.setText("");
        cbClientes.requestFocus();
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

