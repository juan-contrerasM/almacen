package co.edu.uniquindio.almacen;

import co.edu.uniquindio.almacen.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class SaleDetailController {

    @FXML
    private Button btnMenu;

    @FXML
    private Button btnVenta;

    @FXML
    private TableColumn<?, ?> columnaDos;

    @FXML
    private TableColumn<?, ?> columnaTres;

    @FXML
    private TableColumn<?, ?> columnaUno;

    @FXML
    private Pane paneBody;

    @FXML
    private Pane paneHead;

    @FXML
    private TableView<?> tabla;

    @FXML
    private Label titleSaleDetail;
    private Stage stage;

    private ArrayList<RefrigeratedProduct> listRefrigerateProducts=new ArrayList<RefrigeratedProduct>();
    private ArrayList<PackagedProduct>listPackagedProduc= new ArrayList<PackagedProduct>();
    private ArrayList<PerishableProduct>perishableProductList= new ArrayList<PerishableProduct>();
    private ArrayList<String>inventary =new ArrayList<>();

    private ArrayList<NaturalClient> listNaturalClients = new ArrayList<NaturalClient>();
    private ArrayList<LegalClient> listLegalClient = new ArrayList<LegalClient>();
    private ArrayList<String> inventaryC = new ArrayList<>();


    @FXML
    void openMenu(ActionEvent event)throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
        Parent root = loader.load();
        MenuController controller = loader.getController();
        controller.setStage(stage); // Pasar la referencia del Stage actual a la nueva ventanacontroller.setInventary(inventary);
        controller.setInventaryC(inventaryC);
        controller.setListRefrigerateProducts(listRefrigerateProducts);
        controller.setListPackagedProduc(listPackagedProduc);
        controller.setPerishableProductList(perishableProductList);
        controller.setListLegalClient(listLegalClient);
        controller.setListNaturalClients(listNaturalClients);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        // Cierra el stage actual al regresar al menú
        ((Stage) btnMenu.getScene().getWindow()).close();

    }

    @FXML
    void openSale(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sale.fxml"));
        Parent root = loader.load();
        MenuController controller = loader.getController();
        controller.setStage(stage); // Pasar la referencia del Stage actual a la nueva ventanacontroller.setInventary(inventary);
        controller.setInventaryC(inventaryC);
        controller.setListRefrigerateProducts(listRefrigerateProducts);
        controller.setListPackagedProduc(listPackagedProduc);
        controller.setPerishableProductList(perishableProductList);
        controller.setListLegalClient(listLegalClient);
        controller.setListNaturalClients(listNaturalClients);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        // Cierra el stage actual al regresar al menú
        ((Stage) btnMenu.getScene().getWindow()).close();

    }


    public void setStage(Stage stage) {
    }
}