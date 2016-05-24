package sample.controller;


import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.Repository;
import sample.model.OfferModel;

public class TradeController {

    @FXML
    private TableView<OfferModel> trade;

    @FXML
    private TableColumn<OfferModel, String> time;

    @FXML
    private TableColumn<OfferModel, String> px;

    @FXML
    private TableColumn<OfferModel, String> qty;

    @FXML
    private TableColumn<OfferModel, String> amount;

    @FXML
    private TableColumn<OfferModel, String> buyer;

    @FXML
    private TableColumn<OfferModel, String> seller;

    @FXML
    private TableColumn<OfferModel, String> tc;


    @FXML
    private void initialize() throws Exception {

        time.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getOp().toString()));
        px.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getQty().toString()));
        qty.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPx().toString()));
        amount.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPx().toString()));
        buyer.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPx().toString()));
        seller.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPx().toString()));
        tc.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPx().toString()));


        tc.setCellFactory(column -> {
            return new TableCell<OfferModel, String>() {
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

        seller.setCellFactory(column -> {
            return new TableCell<OfferModel, String>() {
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


        buyer.setCellFactory(column -> {
            return new TableCell<OfferModel, String>() {
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

        amount.setCellFactory(column -> {
            return new TableCell<OfferModel, String>() {
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

        time.setCellFactory(column -> {
            return new TableCell<OfferModel, String>() {
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

        px.setCellFactory(column -> {
            return new TableCell<OfferModel, String>() {
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


        qty.setCellFactory(column -> {
            return new TableCell<OfferModel, String>() {
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



    }

    @FXML
    private synchronized void refreshTableView() {

        time.setVisible(true);
        px.setVisible(true);
        qty.setVisible(true);
        amount.setVisible(true);
        buyer.setVisible(true);
        seller.setVisible(true);
        tc.setVisible(true);

    }

    public TableView<OfferModel> getType() {

        return trade;
    }
}
