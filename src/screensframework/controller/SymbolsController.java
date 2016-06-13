package screensframework.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import screensframework.model.IndexModel;
import screensframework.model.SymbolsModel;
import screensframework.utils.Helper;

import java.net.URL;
import java.util.Hashtable;
import java.util.ResourceBundle;

public class SymbolsController implements Initializable, ControlledScreen {

    private PrincipalController myController;

    @FXML private TableView<SymbolsModel> ipsa;
    @FXML private TableColumn<SymbolsModel, String> symbol;
    @FXML private TableColumn<SymbolsModel, String> open;
    @FXML private TableColumn<SymbolsModel, String> close;
    @FXML private TableColumn<SymbolsModel, String> high;
    @FXML private TableColumn<SymbolsModel, String> low;
    @FXML private TableColumn<SymbolsModel, String> imbalance;
    @FXML private TableColumn<SymbolsModel, String> volume;
    @FXML private TableColumn<SymbolsModel, String> amount;

    public int positions = 0;
    public Hashtable<String, Integer> hashData = new Hashtable<String, Integer>();
    public ObservableList<SymbolsModel> data = FXCollections.synchronizedObservableList(FXCollections.observableArrayList());

    @Override
    public void setScreenParent(PrincipalController screenPage) {
        myController = screenPage;
    }

    @Override
    public synchronized void initialize(URL location, ResourceBundle resources) {

        symbol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSymbol().toString()));
        open.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getOpen().toString()));
        close.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getClose().toString()));
        high.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getHigh().toString()));
        low.setCellValueFactory(cellData2 -> new SimpleStringProperty(cellData2.getValue().getLow().toString()));
        imbalance.setCellValueFactory(cellData2 -> new SimpleStringProperty(cellData2.getValue().getImbalance().toString()));
        volume.setCellValueFactory(cellData2 -> new SimpleStringProperty(cellData2.getValue().getVolume().toString()));
        amount.setCellValueFactory(cellData2 -> new SimpleStringProperty(cellData2.getValue().getAmount().toString()));

        symbol.setCellFactory(column -> {
            return new TableCell<SymbolsModel, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    try {
                        setStyle("-fx-text-fill: #e6e6e6; -fx-alignment: CENTER-RIGHT;");
                        setText(item);

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            };
        });

        open.setCellFactory(column -> {
            return new TableCell<SymbolsModel, String>() {
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

        close.setCellFactory(column -> {
            return new TableCell<SymbolsModel, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    try {

                        if(item == null) return;

                        if (data.get(getIndex()).getMarginRate().equals(" -")) {
                            setAlignment(Pos.BASELINE_RIGHT);
                            setTextFill(Color.WHITE);
                            setStyle("-fx-background-color: #522222");
                            setText(Helper.formatNumber3.format(Double.valueOf(item)));

                        } else if (data.get(getIndex()).getMarginRate().equals(" +")) {
                            setAlignment(Pos.BASELINE_RIGHT);
                            setTextFill(Color.WHITE);
                            setStyle("-fx-background-color: #084b14");
                            setText(Helper.formatNumber3.format(Double.valueOf(item)));

                        } else if (data.get(getIndex()).getMarginRate().equals("0-")) {
                            setAlignment(Pos.BASELINE_RIGHT);
                            setStyle("-fx-text-fill: #de3e09");
                            setText(Helper.formatNumber3.format(Double.valueOf(item)));

                        } else if (data.get(getIndex()).getMarginRate().equals("0+")) {
                            setAlignment(Pos.BASELINE_RIGHT);
                            setStyle("-fx-text-fill: #098f28");
                            setText(Helper.formatNumber3.format(Double.valueOf(item)));

                        } else {

                            setStyle("-fx-alignment: CENTER-RIGHT;");
                            setTextFill(Color.WHITE);
                            setText(Helper.formatNumber3.format(Double.valueOf(item)));
                        }


                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            };
        });

        volume.setCellFactory(column -> {
            return new TableCell<SymbolsModel, String>() {
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

        amount.setCellFactory(column -> {
            return new TableCell<SymbolsModel, String>() {
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

        imbalance.setCellFactory(column -> {
            return new TableCell<SymbolsModel, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    try {

                        if (item == null) return;

                        if (data.get(getIndex()).getMarginRate().equals(" -") || data.get(getIndex()).getMarginRate().equals(" +")) {

                            if (Double.valueOf(item) < 0) {
                                setStyle("-fx-border-color: #000000; -fx-font-weight: bold; -fx-alignment: CENTER-RIGHT; -fx-background-color: #522222");
                                setText(Helper.formatNumber3.format(Double.valueOf(item)));
                            }

                            if (Double.valueOf(item) == 0) {
                                setStyle("-fx-border-color: #000000; -fx-text-fill: #ffffff; -fx-font-weight: bold; -fx-alignment: CENTER-RIGHT; -fx-border: 1px solid;");
                                setText(Helper.formatNumber3.format(Double.valueOf(item)));
                            }

                            if (Double.valueOf(item) > 0) {
                                setStyle("-fx-border-color: #000000; -fx-text-fill: #ffffff; -fx-font-weight: bold; -fx-alignment: CENTER-RIGHT; -fx-background-color: #084b14");
                                setText(Helper.formatNumber3.format(Double.valueOf(item)));
                            }

                        } else if (data.get(getIndex()).getMarginRate().equals("0-") || data.get(getIndex()).getMarginRate().equals("0+")) {

                            if (Double.valueOf(item) < 0) {
                                setStyle("-fx-border-color: #000000; -fx-text-fill: #de3e09; -fx-font-weight: bold; -fx-alignment: CENTER-RIGHT; ");
                                setText(Helper.formatNumber3.format(Double.valueOf(item)));
                            }

                            if (Double.valueOf(item) == 0) {
                                setStyle("-fx-border-color: #000000; -fx-text-fill: #ffffff; -fx-font-weight: bold; -fx-alignment: CENTER-RIGHT;");
                                setText(Helper.formatNumber3.format(Double.valueOf(item)));
                            }

                            if (Double.valueOf(item) > 0) {
                                setStyle("-fx-border-color: #000000; -fx-text-fill: #098f28; -fx-font-weight: bold; -fx-alignment: CENTER-RIGHT; ");
                                setText(Helper.formatNumber3.format(Double.valueOf(item)));
                            }

                        } else {
                            setStyle("-fx-text-fill: #FFFFFF; -fx-font-weight: bold; -fx-alignment: CENTER-RIGHT;");
                            setText(Helper.formatNumber3.format(Double.valueOf(item)));
                        }

                }

                catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        };
        });

        ipsa.setItems(data);
    }

    public void addNewValue(SymbolsModel symbolsModel) {

        hashData.put(symbolsModel.getSymbol(), positions);
        data.add(positions++, symbolsModel);

    }

    public void oldValue(SymbolsModel symbolsModel){
        data.set(hashData.get(symbolsModel.getSymbol()), symbolsModel);
    }

}
