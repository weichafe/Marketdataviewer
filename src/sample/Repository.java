package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class Repository {

    public static String date;

    public static FXMLLoader rootLayout_Loader = new FXMLLoader();

    public static FXMLLoader tabPanelChile = new FXMLLoader();
    public static FXMLLoader tabPanelPeru = new FXMLLoader();
    public static FXMLLoader tabPanelColombia = new FXMLLoader();
    public static FXMLLoader sellSideLoader = new FXMLLoader();

    public static TabPane tabPanePrincipalTabChile;
    public static TabPane tabPanePrincipalTabColombia;
    public static TabPane tabPanePrincipalTabPeru;
    public static TabPane tabPanePrincipalTabSellSide;

    public static Scene scene;
    public static Stage primaryStage;

    public static DecimalFormat formatNumber = new DecimalFormat( "#,###,###,##0.00");

}
