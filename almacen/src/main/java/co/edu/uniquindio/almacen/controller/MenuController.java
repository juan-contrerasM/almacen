package co.edu.uniquindio.almacen.controller;

import co.edu.uniquindio.almacen.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {
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
        FXMLLoader loader= new FXMLLoader(getClass().getResource("../products2.fxml"));
        Parent root= loader.load();
        ProductsController controller= loader.getController();
        Scene scene = new Scene(root);
        Stage stage=new Stage();
        stage.setScene(scene);
       // controller.init(stage, this); //inicializar y poder enviar cosas de esta ventana a la otra
        stage.show();
        this.stage.close();


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
}