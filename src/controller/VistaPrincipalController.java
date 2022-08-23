package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Producto;

public class VistaPrincipalController {



    @FXML
    private Label labelMessage;

    @FXML
    private TableView<Producto> table;

    @FXML
    private TextField txtFieldCantidad;



    public ObservableList<Producto> crearTablaProductos() {

        ObservableList<Producto> listaProductos = FXCollections.observableArrayList();




        return listaProductos;
    }


}




