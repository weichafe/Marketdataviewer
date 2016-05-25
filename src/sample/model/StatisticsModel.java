package sample.model;


import javafx.beans.property.SimpleDoubleProperty;


public class StatisticsModel {

    private SimpleDoubleProperty bid;
    private SimpleDoubleProperty offer;
    private SimpleDoubleProperty open;
    private SimpleDoubleProperty close;
    private SimpleDoubleProperty high;
    private SimpleDoubleProperty low;
    private SimpleDoubleProperty imbalance;
    private SimpleDoubleProperty volume;
    private SimpleDoubleProperty amount;
    private SimpleDoubleProperty vwap;


    public Double getBid() {
        return bid.get();
    }

    public SimpleDoubleProperty bidProperty() {
        return bid;
    }

    public void setBid(double bid) {
        this.bid = new SimpleDoubleProperty(bid);
    }

    public Double getOffer() {
        return offer.get();
    }

    public SimpleDoubleProperty offerProperty() {
        return offer;
    }

    public void setOffer(double offer) {

        this.offer = new SimpleDoubleProperty(offer);
    }

    public Double getOpen() {
        return open.get();
    }

    public SimpleDoubleProperty openProperty() {
        return open;
    }

    public void setOpen(double open) {

        this.open = new SimpleDoubleProperty(open);
    }

    public Double getClose() {
        return close.get();
    }

    public SimpleDoubleProperty closeProperty() {
        return close;
    }

    public void setClose(double close) {

        this.close = new SimpleDoubleProperty(close);
    }

    public Double getHigh() {
        return high.get();
    }

    public SimpleDoubleProperty highProperty() {
        return high;
    }

    public void setHigh(double high) {

        this.high = new SimpleDoubleProperty(high);
    }

    public Double getLow() {
        return low.get();
    }

    public SimpleDoubleProperty lowProperty() {
        return low;
    }

    public void setLow(double low) {
        this.low = new SimpleDoubleProperty(low);
    }

    public Double getImbalance() {
        return imbalance.get();
    }

    public SimpleDoubleProperty imbalanceProperty() {
        return imbalance;
    }

    public void setImbalance(double imbalance) {
        this.imbalance = new SimpleDoubleProperty(imbalance);
    }

    public Double getVolume() {

        return volume.get();
    }

    public SimpleDoubleProperty volumeProperty() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = new SimpleDoubleProperty(volume);
    }

    public Double getAmount() {
        return amount.get();
    }

    public SimpleDoubleProperty amountProperty() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = new SimpleDoubleProperty(amount);
    }

    public Double getVwap() {
        return vwap.get();
    }

    public SimpleDoubleProperty vwapProperty() {
        return vwap;
    }

    public void setVwap(double vwap) {

        this.vwap = new SimpleDoubleProperty(vwap);
    }
}
