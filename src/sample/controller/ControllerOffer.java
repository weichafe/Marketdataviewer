package sample.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.Repository;
import sample.model.OfferModel;

public class ControllerOffer {

    @FXML
    private TableView<OfferModel> offer;


    @FXML
    private TableColumn<OfferModel, String> op;

    @FXML
    private TableColumn<OfferModel, String> qty;


    @FXML
    private TableColumn<OfferModel, String> px;


    @FXML
    private void initialize() throws Exception {

        op.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getOp().toString()));
        qty.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getQty().toString()));
        px.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPx().toString()));



        op.setCellFactory(column -> {
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



    }

    @FXML
    private synchronized void refreshTableView() {

        op.setVisible(true);
        qty.setVisible(true);
        px.setVisible(true);

    }

    public TableView<OfferModel> getType() {

        return offer;
    }
}
