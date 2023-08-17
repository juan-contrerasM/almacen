package co.edu.uniquindio.almacen;

import co.edu.uniquindio.almacen.controller.ConsultProductsController;
import co.edu.uniquindio.almacen.controller.MenuController;
import co.edu.uniquindio.almacen.controller.ProductsController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    private Stage primaryStage;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("consultProducts.fxml"));
        Parent root= loader.load();
        Scene scene= new Scene(root);
        stage.setScene(scene);
        ConsultProductsController controller=loader.getController();
        controller.setStage( stage);
        stage.show();


    }
    public void loadingWindowProducts() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("products2.fxml"));
        Parent root = loader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}