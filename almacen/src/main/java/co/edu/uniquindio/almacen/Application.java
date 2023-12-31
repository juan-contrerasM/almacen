package co.edu.uniquindio.almacen;

import co.edu.uniquindio.almacen.model.PerishableProduct;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Application extends javafx.application.Application {
    private Stage primaryStage;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("menu.fxml"));
        Parent root= loader.load();
        Scene scene= new Scene(root);
        stage.setScene(scene);
        MenuController controller =loader.getController();
        controller.setStage( stage);
        stage.show();


    }






    public static void main(String[] args) {
        launch();
    }
}