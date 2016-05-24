package sample.model;


import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class StatisticsModel {

    private SimpleStringProperty  bid;
    private SimpleStringProperty  offer;
    private SimpleStringProperty  open;


    public StatisticsModel(){
        this.bid = new SimpleStringProperty("dsaasd");
        this.offer = new SimpleStringProperty("dsaasd");;
        this.open = new SimpleStringProperty("dsaasd");;

    }



}
