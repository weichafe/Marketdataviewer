package screensframework.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import screensframework.model.IndexModel;
import screensframework.subscription.SubscribeSymbol;
import screensframework.utils.Configuration;
import screensframework.utils.Helper;
import java.net.URL;
import java.util.Hashtable;
import java.util.ResourceBundle;


public class IndexController implements Initializable, ControlledScreen {

    private PrincipalController myController;

    @FXML private TableView<IndexModel> index;
    @FXML private TableColumn<IndexModel, String> symbol;
    @FXML private TableColumn<IndexModel, String> valueDiv;
    @FXML private TableColumn<IndexModel, String> varDiv;
    @FXML private TableColumn<IndexModel, String> valueSin;
    @FXML private TableColumn<IndexModel, String> VarSin;
    @FXML private TableColumn<IndexModel, String> amount;

    public int positions = 0;
    public Hashtable<String, IndexModel> hashData = new Hashtable<String, IndexModel>();
    public ObservableList<IndexModel> data = FXCollections.synchronizedObservableList(FXCollections.observableArrayList());

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //INDEX
        symbol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSymbol().toString()));
        valueDiv.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getValueDiv().toString()));
        varDiv.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getVarDiv().toString()));
        valueSin.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getValueSin().toString()));
        VarSin.setCellValueFactory(cellData2 -> new SimpleStringProperty(cellData2.getValue().getVarSin().toString()));
        amount.setCellValueFactory(cellData2 -> new SimpleStringProperty(cellData2.getValue().getAmount().toString()));

        inicializarTabla();

        symbol.setCellFactory(new Callback<TableColumn<IndexModel, String>, TableCell<IndexModel, String>>() {
            @Override
            public TableCell<IndexModel, String> call(TableColumn<IndexModel, String> col) {
                final TableCell<IndexModel, String> cell = new TableCell<>();
                cell.textProperty().bind(cell.itemProperty()); // in general might need to subclass TableCell and override updateItem(...) here
                cell.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        String [] symbolList = Configuration.getSymbolIndex(cell.getItem());
                        new SubscribeSymbol(symbolList).start();
                    }
                });
                return cell;
            }
        });

        amount.setCellFactory(column -> {
            return new TableCell<IndexModel, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    try {
                        setStyle("-fx-text-fill: #e6e6e6; -fx-alignment: CENTER-RIGHT;");
                        setText((item == null) ? "" : Helper.formatNumber.format(Double.valueOf(item)));

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            };
        });

        VarSin.setCellFactory(column -> {
            return new TableCell<IndexModel, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    try {

                        if(item == null) return;

                        if(item.startsWith("-")){
                            setStyle("-fx-text-fill: #ff1413; -fx-alignment: CENTER-RIGHT;");
                            setText(Helper.formatNumber3.format(Double.valueOf(item)));

                        } else {
                            setStyle("-fx-text-fill: #2dc619; -fx-alignment: CENTER-RIGHT;");
                            setText(Helper.formatNumber3.format(Double.valueOf(item)));

                        }


                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            };
        });

        valueSin.setCellFactory(column -> {
            return new TableCell<IndexModel, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    try {

                        if(item == null) return;
                        setStyle("-fx-text-fill: #e6e6e6; -fx-alignment: CENTER-RIGHT;");
                        setText(Helper.formatNumber3.format(Double.valueOf(item)));

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            };
        });

        varDiv.setCellFactory(column -> {
            return new TableCell<IndexModel, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    try {

                        if(item == null) return;

                        if(item.startsWith("-")){
                            setStyle("-fx-text-fill: #ff1413; -fx-alignment: CENTER-RIGHT;");
                            setText(Helper.formatNumber3.format(Double.valueOf(item)));

                        } else {
                            setStyle("-fx-text-fill: #2dc619; -fx-alignment: CENTER-RIGHT;");
                            setText(Helper.formatNumber3.format(Double.valueOf(item)));

                        }

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            };
        });

        valueDiv.setCellFactory(column -> {
            return new TableCell<IndexModel, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    try {

                        setStyle("-fx-text-fill: #e6e6e6; -fx-alignment: CENTER-RIGHT;");
                        setText((item == null) ? "" : Helper.formatNumber3.format(Double.valueOf(item)));

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            };
        });
    }

    public void inicializarTabla() {
        index.setItems(data);
    }

    @Override
    public void setScreenParent(PrincipalController screenPage) {
        myController = screenPage;
    }

}
