package screensframework;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.apache.log4j.PropertyConfigurator;
import screensframework.adaptor.QuickFixAdapter;
import screensframework.controller.IndexController;
import screensframework.controller.PrincipalController;
import screensframework.utils.PropertiesFile;

public class MainApp extends Application {

    public static Stage indexStage = new Stage();

    public static final String RootFile = "view/root.fxml";

    public static final String LayoutID = "Layout";
    public static final String LayoutFile = "../view/layout.fxml";

    public static final String SymbolID = "SymbolID";
    public static final String SymbolFIle = "../view/symbol.fxml";

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        Repository.mainContainer = new PrincipalController();
        Repository.mainContainer.loadScreen(LayoutID, LayoutFile);
        Repository.mainContainer.loadScreen(SymbolID, SymbolFIle);

        Repository.mainContainer.setScreen(SymbolID);
        //Repository.mainContainer.setScreen(LayoutID);

        FXMLLoader rootLayout_Loader = new FXMLLoader();
        rootLayout_Loader.setLocation(MainApp.class.getResource(RootFile));
        BorderPane rootLayout = (BorderPane) rootLayout_Loader.load();
        rootLayout.setCenter(Repository.mainContainer);

        FXMLLoader loaderIndex = new FXMLLoader();
        loaderIndex.setLocation(MainApp.class.getResource("view/Index.fxml"));
        AnchorPane indexLoader = (AnchorPane) loaderIndex.load();
        Repository.indexController = loaderIndex.getController();

        Scene scene = new Scene(rootLayout);
        primaryStage.setScene(scene);
        primaryStage.show();

        Scene sceneIndex = new Scene(indexLoader, 776, 427);

       /*
        indexStage.initOwner(primaryStage);
        indexStage.setResizable(false);
        indexStage.setScene(sceneIndex);
        indexStage.show();
        */

    }

    public static void main(String[] args) {

        Repository.properties  = new PropertiesFile(args[0]);
        PropertyConfigurator.configure(Repository.properties.getPropertiesString("log4j"));
        new QuickFixAdapter(Repository.properties.getPropertiesString("qFixFile"));
        launch(args);
    }
}
