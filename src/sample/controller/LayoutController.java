package sample.controller;


import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.model.BidModel;
import sample.model.OfferModel;
import sample.model.StatisticsModel;

import java.net.URL;
import java.util.ResourceBundle;


public class LayoutController implements Initializable {


    @FXML private TableView<StatisticsModel> statistics;
    @FXML private TableColumn<StatisticsModel, String> bidStatistics;
    @FXML private TableColumn<StatisticsModel, String> offerStatistics;
    @FXML private TableColumn<StatisticsModel, String> openStatistics;
    @FXML private TableColumn<StatisticsModel, String> closeStatistics;
    @FXML private TableColumn<StatisticsModel, String> highStatistics;
    @FXML private TableColumn<StatisticsModel, String> lowStatistics;
    @FXML private TableColumn<StatisticsModel, String> imbalanceStatistics;
    @FXML private TableColumn<StatisticsModel, String> volumeStatistics;
    @FXML private TableColumn<StatisticsModel, String> amountStatistics;
    @FXML private TableColumn<StatisticsModel, String> vwapStatistics;


    @FXML private TableView<BidModel> bid;
    @FXML private TableColumn<BidModel, String> opBid;
    @FXML private TableColumn<BidModel, String> qtyBid;
    @FXML private TableColumn<BidModel, String> pxBid;

    @FXML private TableView<OfferModel> offer;
    @FXML private TableColumn<OfferModel, String> opOffer;
    @FXML private TableColumn<OfferModel, String> qtyOffer;
    @FXML private TableColumn<OfferModel, String> pxOffer;

    @FXML private TabPane tabPane;
    @FXML private Tab portafolio1;
    @FXML private Tab portafolio2;
    @FXML private Tab portafolio3;

    @FXML private TableView<OfferModel> trade;
    @FXML private TableColumn<OfferModel, String> timeTrade;
    @FXML private TableColumn<OfferModel, String> pxTrade;
    @FXML private TableColumn<OfferModel, String> qtyTrade;
    @FXML private TableColumn<OfferModel, String> amountTrade;
    @FXML private TableColumn<OfferModel, String> buyerTrade;
    @FXML private TableColumn<OfferModel, String> sellerTrade;
    @FXML private TableColumn<OfferModel, String> tcTrade;

    private ObservableList<StatisticsModel> statisticsData;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        bidStatistics.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getBid().toString()));
        offerStatistics.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getOffer().toString()));
        openStatistics.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getOpen().toString()));
        closeStatistics.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getClose().toString()));
        highStatistics.setCellValueFactory(cellData2 -> new SimpleStringProperty(cellData2.getValue().getHigh().toString()));
        lowStatistics.setCellValueFactory(cellData2 -> new SimpleStringProperty(cellData2.getValue().getLow().toString()));
        imbalanceStatistics.setCellValueFactory(cellData2 -> new SimpleStringProperty(cellData2.getValue().getImbalance().toString()));
        volumeStatistics.setCellValueFactory(cellData2 -> new SimpleStringProperty(cellData2.getValue().getVolume().toString()));
        amountStatistics.setCellValueFactory(cellData2 -> new SimpleStringProperty(cellData2.getValue().getAmount().toString()));
        vwapStatistics.  setCellValueFactory(cellData2 -> new SimpleStringProperty(cellData2.getValue().getVwap().toString()));

        inicializarTablaStatistics();
    }


    private void inicializarTablaStatistics() {

        statisticsData = FXCollections.observableArrayList();
        statistics.setItems(statisticsData);
    }

    public void setValues () {

        StatisticsModel statisticsModel = new StatisticsModel();
        statisticsModel.setBid(200d);
        statisticsModel.setOffer(200d);
        statisticsModel.setOpen(200d);
        statisticsModel.setClose(200d);
        statisticsModel.setHigh(200d);
        statisticsModel.setLow(200d);
        statisticsModel.setImbalance(200d);
        statisticsModel.setVolume(200d);
        statisticsModel.setAmount(200d);
        statisticsModel.setVwap(200d);

        statisticsData.add(statisticsModel);

    }
}
