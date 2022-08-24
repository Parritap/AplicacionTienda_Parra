package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Cliente;
import model.DetalleFactura;
import model.Producto;
import model.Tienda;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;

public class CarritoComprasController {

    Tienda tienda = Singleton.getInstance().getTienda();
    Cliente cliente;
    Scene escenaAnterior;

    Producto productoSeleccionado = null;

    ObservableList<DetalleFactura> OL_productos = FXCollections.observableArrayList();


    @FXML
    private Button btnHome;

    @FXML
    private TableColumn<Producto, Integer> tblColCantidadProducto;

    @FXML
    private TableColumn<Producto, String> tblColCodigoProducto;

    @FXML
    private TableColumn<Producto, String> tblColNombreProducto;

    @FXML
    private TableColumn<Producto, Double> tblColPrecioProducto;

    @FXML
    private TableColumn<Producto, String> tblColTipoProducto; //ESTO AQUÍ ESTÁ MALO :)

    @FXML
    private TableView<Producto> tblProducto;


    @FXML
    void volver_a_la_vistaPrincipal(ActionEvent event) {

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/VistaPrincipalTienda.fxml"));
            AnchorPane root = loader.load();

            VistaPrincipalController vistaPrincipalController = loader.getController();
            vistaPrincipalController.setCliente(cliente);

            Scene scene = ((Node) event.getSource()).getScene();

            Stage thisStage = (Stage) scene.getWindow();
            thisStage.setScene(new Scene(root));

        } catch (IOException e) {
            e.printStackTrace();
        }


    }



    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Scene getEscenaAnterior() {
        return escenaAnterior;
    }

    public void setEscenaAnterior(Scene escenaAnterior) {
        this.escenaAnterior = escenaAnterior;
    }


    @FXML
    void initialize() {



    }
}
