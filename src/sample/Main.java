package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.apache.log4j.Logger;
import sample.controller.StatisticsController;
import sample.model.Person;
import sample.model.StatisticsModel;

public class Main extends Application {

    private static Logger logger = Logger.getLogger(Main.class.getName());

    public FXMLLoader layout = new FXMLLoader();
    public FXMLLoader panelBidLoader = new FXMLLoader();
    public FXMLLoader panelOfferLoader = new FXMLLoader();
    public FXMLLoader panelTradeLoader = new FXMLLoader();
    public FXMLLoader panelStatisticsLoader = new FXMLLoader();

    public TableView<StatisticsModel> staticsTableView;


    private final ObservableList<Person> data =
            FXCollections.observableArrayList(
                    new Person("Jacob", "Smith", "jacob.smith@example.com"),
                    new Person("Isabella", "Johnson", "isabella.johnson@example.com"),
                    new Person("Ethan", "Williams", "ethan.williams@example.com"),
                    new Person("Emma", "Jones", "emma.jones@example.com"),
                    new Person("Michael", "Brown", "michael.brown@example.com"));
    private TableView<StatisticsModel> table = new TableView<>();


    @Override
    public void start(Stage primaryStage) throws Exception {

        /*
        Repository.primaryStage = primaryStage;
        Repository.primaryStage.setTitle("Market Data Viewer");

        layout.setLocation(Main.class.getResource("view/Layout.fxml"));
        panelBidLoader.setLocation(Main.class.getResource("view/Bid.fxml"));
        panelOfferLoader.setLocation(Main.class.getResource("view/Offer.fxml"));
        panelTradeLoader.setLocation(Main.class.getResource("view/Trade.fxml"));

        panelStatisticsLoader.setLocation(Main.class.getResource("view/Statistics.fxml"));
        this.panelStatisticsLoader.load();
        */

        /*
        StatisticsController statisticsController = panelStatisticsLoader.getController();
        staticsTableView = statisticsController.getType();
        staticsTableView.setItems(dataStatistics);
        */

        table.setEditable(true);

        TableColumn firstNameCol = new TableColumn("First Name");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<>("firstName"));

        TableColumn lastNameCol = new TableColumn("Last Name");
        lastNameCol.setMinWidth(100);
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<>("lastName"));

        TableColumn emailCol = new TableColumn("Email");
        emailCol.setMinWidth(200);
        emailCol.setCellValueFactory(
                new PropertyValueFactory<>("email"));


        table.setItems(data);
        table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);

/*
        ScrollPane scrollBar = new ScrollPane();
        scrollBar.setContent(table);
        scrollBar.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        Repository.rootLayout_Loader.setLocation(Main.class.getResource("view/Root.fxml"));
        BorderPane rootLayout_Loader = (BorderPane) Repository.rootLayout_Loader.load();
        rootLayout_Loader.setCenter(scrollBar);
        */

        Repository.scene = new Scene(table);
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
