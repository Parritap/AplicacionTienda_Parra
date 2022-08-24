package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.*;

import java.io.IOException;

public class VistaPrincipalController {


    Cliente cliente;
    Tienda tienda = Singleton.getInstance().getTienda();

    Producto productoSeleccionado = null;

    ObservableList<Producto> OL_productos = FXCollections.observableArrayList();

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @FXML
    private Button btn_AgregarAlCarrito;

    @FXML
    private Button btn_IrAlCarrito;

    @FXML
    private Label labelMessage;

    @FXML
    private TableView<Producto> tablaProductos;

    @FXML
    private TableColumn<Producto, String> colNombreProducto;

    @FXML
    private TableColumn<Producto, Double> colValorProducto;

    @FXML
    private TextField txtFieldCantidad;

    @FXML
    void comprarProductos(ActionEvent event) {

        String str = txtFieldCantidad.getText();
        int num = 0;
        try {
            num = Integer.parseInt(str);
        } catch (NumberFormatException numberFormatException) {
            labelMessage.setText("Esa no es una cantidad valida.");
        }

        if (num < 1) {
            labelMessage.setText("Por favor ingrese un número válido");
        } else {
            DetalleFactura d = new DetalleFactura(productoSeleccionado, num);
            cliente.getCarritoCompras().getListaDetalles().add(d);
        }


    }

    @FXML
    void irAlCarrito(ActionEvent event) {

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/CarritoCompras.fxml"));
            AnchorPane root = loader.load();

            CarritoComprasController carritoComprasController = loader.getController();
            carritoComprasController.setCliente(cliente);

            Scene scene = ((Node) event.getSource()).getScene();
            carritoComprasController.setEscenaAnterior(scene);

            Stage thisStage = (Stage) scene.getWindow();
            thisStage.setScene(new Scene(root));

        } catch (IOException e) {
            e.printStackTrace();
        }




    }

    @FXML
    void initialize() {

        OL_productos.addAll(tienda.getListaProductos());

        colNombreProducto.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colValorProducto.setCellValueFactory(new PropertyValueFactory<>("valorUnitario"));

        tablaProductos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {

            productoSeleccionado = newSelection;
        });

        tablaProductos.getItems().clear();
        tablaProductos.setItems(OL_productos);
    }
}