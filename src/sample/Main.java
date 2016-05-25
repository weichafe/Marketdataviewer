package sample;

import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
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
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.apache.log4j.Logger;
import sample.controller.LayoutController;
import sample.controller.StatisticsController;
import sample.model.StatisticsModel;

public class Main extends Application {

    private static Logger logger = Logger.getLogger(Main.class.getName());

    public FXMLLoader layout = new FXMLLoader();

    @Override
    public void start(Stage primaryStage) throws Exception {


        Repository.primaryStage = primaryStage;
        Repository.primaryStage.setTitle("Market Data Viewer");

        layout.setLocation(Main.class.getResource("view/Layout.fxml"));
        AnchorPane layoutPanel = (AnchorPane) layout.load();

        LayoutController lastPriceLocal = layout.getController();
        lastPriceLocal.setValues();

        ScrollPane scrollBar = new ScrollPane();
        scrollBar.setContent(layoutPanel);
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
