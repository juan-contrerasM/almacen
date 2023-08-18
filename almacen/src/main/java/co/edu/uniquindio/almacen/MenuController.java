package co.edu.uniquindio.almacen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController  implements Initializable {
    private Stage stage;

    @FXML
    private Button btnClients;

    @FXML
    private Button btnProducts;

    @FXML
    private Button btnSales;

    @FXML
    private ImageView imgClients;

    @FXML
    private ImageView imgLogoAlmacen;

    @FXML
    private ImageView imgProducts;

    @FXML
    private ImageView imgSales;

    @FXML
    private Label lblMenuMain;

    @FXML
    private Pane paneColor;

    @FXML
    void openClients(ActionEvent event) throws IOException {


    }

    @FXML
    void openProducts(ActionEvent event) throws IOException {
        JOptionPane.showMessageDialog(null, "primero seleccionar el tipo de producto y undir en el boton cargar");
        FXMLLoader loader= new FXMLLoader(getClass().getResource("products.fxml"));
        Parent root= loader.load();
        ProductsController controller= loader.getController();
        controller.setStage(stage); // Pasar la referencia del Stage actual a la nueva ventana
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        // No cierres el stage actual aquí


    }
    @FXML
    private Label lblDescription;


    @FXML
    void openSales(ActionEvent event) {

    }
  // esta funcion sivre para que se muestre la primera interfaz
    public void setStage(Stage stage) {
       this.stage= stage;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}