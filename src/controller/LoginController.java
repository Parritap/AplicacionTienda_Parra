package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.*;

import java.io.IOException;
import java.net.URL;

public class LoginController {

    Tienda tienda = Singleton.getInstance().getTienda();

    @FXML
    private Label LblMensajeErrorIngreso;

    @FXML
    private Label LblMensajeErrorIngreso1;

    @FXML
    private Label LblMensajeErrorIngreso11;

    @FXML
    private Button btnIngresar;

    @FXML
    private Button btnRegistrarse;

    @FXML
    private Label lblMessage;

    @FXML
    private TextField txtContraseñaUsuarioIngresar;

    @FXML
    private TextField txtEmailUsuarioIngresar;

    @FXML
    void ingresarEnAplicacion(ActionEvent event) {

        String contrasenia = txtContraseñaUsuarioIngresar.getText();
        String email = txtEmailUsuarioIngresar.getText();

        if (tienda.validarLogInUsuario(email, contrasenia)){

            Cliente c = tienda.leerCliente(email);
            cambiarEscenaDeVentanaCliente(getClass().getResource("../view/VistaPrincipalTienda.fxml"), event, c);
        }else{
            btnIngresar.setText("El usuario o contraseña son incorrectos");
        }

    }

    @FXML
    void registrarseEnAplicacion(ActionEvent event) {

    }


    private void cambiarEscenaDeVentanaCliente(URL resource, ActionEvent event, Cliente cliente) {

        if (event != null && resource != null) {

            Stage thisStage = (Stage) ((Node) (event.getSource())).getScene().getWindow();

            try {
                FXMLLoader loader = new FXMLLoader(resource);
                Parent root = loader.load();

                VistaPrincipalController vistaCliente = loader.getController();
                vistaCliente.setCliente(cliente);

                thisStage.setScene(new Scene(root));

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}
