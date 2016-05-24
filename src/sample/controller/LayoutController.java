package sample.controller;


import javafx.fxml.FXML;
import javafx.scene.Parent;


public class LayoutController{


    @FXML
    private Parent embeddedStatistics;

    @FXML
    private Parent embeddedBid;

    @FXML
    private Parent embeddedOffer;

    @FXML
    private Parent embeddedTrade;

    @FXML
    private StatisticsController statisticsController;

    @FXML
    private BidController bidController;

    @FXML
    private OfferController offerController;

    @FXML
    private TradeController tradeController;

    public void initialize() {

    }


}
