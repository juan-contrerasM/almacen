package co.edu.uniquindio.almacen;

import co.edu.uniquindio.almacen.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class SaleController {
    private Stage stage;
    private ArrayList<RefrigeratedProduct> listRefrigerateProducts=new ArrayList<RefrigeratedProduct>();
    private ArrayList<PackagedProduct>listPackagedProduc= new ArrayList<PackagedProduct>();
    private ArrayList<PerishableProduct>perishableProductList= new ArrayList<PerishableProduct>();
    private ArrayList<String>inventary =new ArrayList<>();

    private ArrayList<NaturalClient> listNaturalClients = new ArrayList<NaturalClient>();
    private ArrayList<LegalClient> listLegalClient = new ArrayList<LegalClient>();
    private ArrayList<String> inventaryC = new ArrayList<>();

    @FXML
    private Button btnMenu;

    @FXML
    void openMenu(ActionEvent  event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
        Parent root = loader.load();
        MenuController controller = loader.getController();
        controller.setStage(stage); // Pasar la referencia del Stage actual a la nueva ventana
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        // Cierra el stage actual al regresar al menú
        ((Stage) btnMenu.getScene().getWindow()).close();
    }

    public void setStage(Stage stage) {
        this.stage=stage;
    }

    public ArrayList<RefrigeratedProduct> getListRefrigerateProducts() {
        return listRefrigerateProducts;
    }

    public void setListRefrigerateProducts(ArrayList<RefrigeratedProduct> listRefrigerateProducts) {
        this.listRefrigerateProducts = listRefrigerateProducts;
    }

    public ArrayList<PackagedProduct> getListPackagedProduc() {
        return listPackagedProduc;
    }

    public void setListPackagedProduc(ArrayList<PackagedProduct> listPackagedProduc) {
        this.listPackagedProduc = listPackagedProduc;
    }

    public ArrayList<PerishableProduct> getPerishableProductList() {
        return perishableProductList;
    }

    public void setPerishableProductList(ArrayList<PerishableProduct> perishableProductList) {
        this.perishableProductList = perishableProductList;
    }

    public ArrayList<String> getInventary() {
        return inventary;
    }

    public void setInventary(ArrayList<String> inventary) {
        this.inventary = inventary;
    }

    public ArrayList<NaturalClient> getListNaturalClients() {
        return listNaturalClients;
    }

    public void setListNaturalClients(ArrayList<NaturalClient> listNaturalClients) {
        this.listNaturalClients = listNaturalClients;
    }

    public ArrayList<LegalClient> getListLegalClient() {
        return listLegalClient;
    }

    public void setListLegalClient(ArrayList<LegalClient> listLegalClient) {
        this.listLegalClient = listLegalClient;
    }

    public ArrayList<String> getInventaryC() {
        return inventaryC;
    }

    public void setInventaryC(ArrayList<String> inventaryC) {
        this.inventaryC = inventaryC;
    }
}





