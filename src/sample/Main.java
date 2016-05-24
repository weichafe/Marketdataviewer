package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.apache.log4j.Logger;

public class Main extends Application {

    private static Logger logger = Logger.getLogger(Main.class.getName());

    public FXMLLoader layout = new FXMLLoader();
    public FXMLLoader panelBidLoader = new FXMLLoader();
    public FXMLLoader panelOfferLoader = new FXMLLoader();
    public FXMLLoader panelTradeLoader = new FXMLLoader();
    public FXMLLoader panelStatisticsLoader = new FXMLLoader();
    public FXMLLoader panelPortafolioLoader = new FXMLLoader();


    @Override
    public void start(Stage primaryStage) throws Exception {


        Repository.primaryStage = primaryStage;
        Repository.primaryStage.setTitle("Market Data Viewer");

        layout.setLocation(Main.class.getResource("view/Layout.fxml"));
        panelBidLoader.setLocation(Main.class.getResource("view/Bid.fxml"));
        panelOfferLoader.setLocation(Main.class.getResource("view/Offer.fxml"));
        panelTradeLoader.setLocation(Main.class.getResource("view/Trade.fxml"));
        panelStatisticsLoader.setLocation(Main.class.getResource("view/Statistics.fxml"));


        ScrollPane scrollBar = new ScrollPane();
        scrollBar.setContent((AnchorPane) layout.load());
        scrollBar.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);


        Repository.rootLayout_Loader.setLocation(Main.class.getResource("view/Root.fxml"));
        BorderPane rootLayout_Loader = (BorderPane) Repository.rootLayout_Loader.load();
        rootLayout_Loader.setCenter(scrollBar);


        Repository.scene = new Scene(rootLayout_Loader);
        primaryStage.setScene(Repository.scene);
        primaryStage.show();

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {

                try {
                    logger.info("\nClose Aplications\n");
                    System.exit(0);

                } catch (Exception ex){
                    ex.printStackTrace();
                }

            }
        });



    }


    public static void main(String[] args) {
        launch(args);
    }
}
