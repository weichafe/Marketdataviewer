package screensframework.controller;


import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class LayoutController implements Initializable, ControlledScreen {

    PrincipalController principalController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setScreenParent(PrincipalController principalController){
        this.principalController = principalController;
    }
}
