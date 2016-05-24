package sample.controller;


import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.Repository;
import sample.model.StatisticsModel;

public class StatisticsController {

    @FXML
    private TableView<StatisticsModel> statistics;

    @FXML
    private TableColumn<StatisticsModel, String> bid;

    @FXML
    private TableColumn<StatisticsModel, String> offer;


    @FXML
    private TableColumn<StatisticsModel, String> open;

    @FXML
    private TableColumn<StatisticsModel, String> close;

    @FXML
    private TableColumn<StatisticsModel, String> high;

    @FXML
    private TableColumn<StatisticsModel, String> low;

    @FXML
    private TableColumn<StatisticsModel, String> imbalance;

    @FXML
    private TableColumn<StatisticsModel, String> volume;

    @FXML
    private TableColumn<StatisticsModel, String> amount;

    @FXML
    private TableColumn<StatisticsModel, String> vwap;

    @FXML
    private void initialize() throws Exception {

        /*
        bid.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getBid().toString()));
        offer.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getOffer().toString()));
        open.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getOpen().toString()));
        close.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getClose().toString()));
        high.setCellValueFactory(cellData2 -> new SimpleStringProperty(cellData2.getValue().getHigh().toString()));
        low.setCellValueFactory(cellData2 -> new SimpleStringProperty(cellData2.getValue().getLow().toString()));
        imbalance.setCellValueFactory(cellData2 -> new SimpleStringProperty(cellData2.getValue().getImbalance().toString()));
        volume.setCellValueFactory(cellData2 -> new SimpleStringProperty(cellData2.getValue().getVolume().toString()));
        amount.setCellValueFactory(cellData2 -> new SimpleStringProperty(cellData2.getValue().getAmount().toString()));
        vwap.setCellValueFactory(cellData2 -> new SimpleStringProperty(cellData2.getValue().getVwap().toString()));
        */


        bid.setCellFactory(column -> {
            return new TableCell<StatisticsModel, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    try {

                        setText((item == null) ? "" : Repository.formatNumber.format(Double.valueOf(item)));

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                }
            };
        });

        offer.setCellFactory(column -> {
            return new TableCell<StatisticsModel, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    try {

                        setText((item == null) ? "" : Repository.formatNumber.format(Double.valueOf(item)));

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                }
            };
        });


        close.setCellFactory(column -> {
            return new TableCell<StatisticsModel, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    try {

                        setText((item == null) ? "" : Repository.formatNumber.format(Double.valueOf(item)));

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                }
            };
        });

        high.setCellFactory(column -> {
            return new TableCell<StatisticsModel, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    try {

                        setText((item == null) ? "" : Repository.formatNumber.format(Double.valueOf(item)));

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                }
            };
        });

        low.setCellFactory(column -> {
            return new TableCell<StatisticsModel, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    try {

                        setText((item == null) ? "" : Repository.formatNumber.format(Double.valueOf(item)));

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                }
            };
        });

        imbalance.setCellFactory(column -> {
            return new TableCell<StatisticsModel, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    try {

                        setStyle("-fx-text-fill: #10bd22;");
                        setText((item == null) ? "" : Repository.formatNumber.format(Double.valueOf(item)));

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                }
            };
        });



        volume.setCellFactory(column -> {
            return new TableCell<StatisticsModel, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    try {

                        setStyle("-fx-text-fill: #fa1f18;");
                        setText((item == null) ? "" : Repository.formatNumber.format(Double.valueOf(item)));

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                }
            };
        });

        amount.setCellFactory(column -> {
            return new TableCell<StatisticsModel, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    try {

                        setText((item == null) ? "" : Repository.formatNumber.format(Double.valueOf(item)));

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                }
            };
        });

        vwap.setCellFactory(column -> {
            return new TableCell<StatisticsModel, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    try {

                        setStyle("-fx-text-fill: #10bd22;");
                        setText((item == null) ? "" : Repository.formatNumber.format(Double.valueOf(item)));

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                }
            };
        });

    }

    @FXML
    private synchronized void refreshTableView() {

        statistics.setEditable(true);
        bid.setVisible(true);
        offer.setVisible(true);
        open.setVisible(true);
        close.setVisible(true);
        high.setVisible(true);
        low.setVisible(true);
        imbalance.setVisible(true);
        volume.setVisible(true);
        amount.setVisible(true);
        vwap.setVisible(true);
    }

    public TableView<StatisticsModel> getType() {

        return statistics;
    }

}
