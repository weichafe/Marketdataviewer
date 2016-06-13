package screensframework.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import screensframework.model.IndexModel;
import java.net.URL;
import java.util.ResourceBundle;


public class EstadisticasController implements Initializable, ControlledScreen {

    private PrincipalController myController;

    @FXML private TableView<IndexModel> index;
    @FXML private TableColumn<IndexModel, String> symbol;
    @FXML private TableColumn<IndexModel, String> open;
    @FXML private TableColumn<IndexModel, String> close;
    @FXML private TableColumn<IndexModel, String> high;
    @FXML private TableColumn<IndexModel, String> low;
    @FXML private TableColumn<IndexModel, String> imbalance;
    @FXML private TableColumn<IndexModel, String> volume;
    @FXML private TableColumn<IndexModel, String> amount;

    @Override
    public void setScreenParent(PrincipalController screenPage) {
        myController = screenPage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        symbol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSymbol().toString()));
        open.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getValueDiv().toString()));
        close.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getVarDiv().toString()));
        high.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getValueSin().toString()));
        low.setCellValueFactory(cellData2 -> new SimpleStringProperty(cellData2.getValue().getVarSin().toString()));
        imbalance.setCellValueFactory(cellData2 -> new SimpleStringProperty(cellData2.getValue().getAmount().toString()));
        volume.setCellValueFactory(cellData2 -> new SimpleStringProperty(cellData2.getValue().getAmount().toString()));
        amount.setCellValueFactory(cellData2 -> new SimpleStringProperty(cellData2.getValue().getAmount().toString()));

    }
}
