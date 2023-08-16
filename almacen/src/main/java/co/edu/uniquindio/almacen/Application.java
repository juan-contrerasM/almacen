package co.edu.uniquindio.almacen;

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
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

    }
    public void loadingWindowProducts() {

        try {
            FXMLLoader load = new FXMLLoader(getClass().getResource("products.fxml"));
            Parent root = load.load();
            Scene escena = new Scene(root);
            primaryStage = new Stage();
            primaryStage.setResizable(false);
            primaryStage.initModality(Modality.APPLICATION_MODAL);
            primaryStage.setScene(escena);
            primaryStage.setTitle("ventana de resgistro");
            primaryStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch();
    }
}