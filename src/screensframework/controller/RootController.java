package screensframework.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import screensframework.MainApp;

import java.net.URL;
import java.util.ResourceBundle;

public class RootController implements Initializable, ControlledScreen {

    @FXML
    private void handleNew() {
    }

    @FXML
    private void handleOpen() {
    }


    @FXML
    private void handleSave() {
    }

    @FXML
    private void handleSaveAs() {
    }


    @FXML
    private void index() {

        try {

            MainApp.indexStage.show();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void setScreenParent(PrincipalController screenPage) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
