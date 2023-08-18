package co.edu.uniquindio.almacen.controller;
import co.edu.uniquindio.almacen.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ProductsController {

        //array donde vamos a guardar los productos

        private MenuController menuController;
        private Stage stage;

        @FXML
        private TextArea TextADercripcion;

        @FXML
        private Button btnConsult;

        @FXML
        private Button btnCreate;

        @FXML
        private Button btnDelete;

        @FXML
        private Button btnMenu;

        @FXML
        private Button btnUpdate;

        @FXML
        private Button btnVisualizar;

        @FXML
        private ComboBox<?> comboOrigen;

        @FXML
        private ComboBox<?> comboTipo;

        @FXML
        private ImageView imgLogo;

        @FXML
        private Pane paneBorder;

        @FXML
        private Pane paneBorder2;

        @FXML
        private Pane paneBorder3;

        @FXML
        private TextField textCodeApprobation;

        @FXML
        private TextField txtCant;

        @FXML
        private TextField txtCode;

        @FXML
        private TextField txtContainerWeight;

        @FXML
        private TextField txtExpirationDate;

        @FXML
        private TextField txtName;

        @FXML
        private TextField txtNameConsult;

        @FXML
        private TextField txtPackagingDate;

        @FXML
        private TextField txtTemperature;

        @FXML
        private TextField txtValue;
        @FXML
        private Label lblDescription;

        @FXML
        void consult(ActionEvent event) {

        }

        @FXML
        void create(ActionEvent event) {

        }

        @FXML
        void delete(ActionEvent event) {

        }

        @FXML
        void openManu(ActionEvent event) {

        }


        @FXML
        void update(ActionEvent event) {

        }

        @FXML
        void lista(ActionEvent event) {

        }

        public void setStage(Stage stage) {
                this.stage= stage;
        }


}



