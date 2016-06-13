package screensframework.model;


import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class IndexModel {

    private SimpleStringProperty symbol;
    private SimpleDoubleProperty valueDiv;
    private SimpleDoubleProperty varDiv;
    private SimpleDoubleProperty valueSin;
    private SimpleDoubleProperty VarSin;
    private SimpleDoubleProperty amount;
    private int positions;

    public IndexModel(){
        this.symbol = new SimpleStringProperty("");
        this.valueDiv = new SimpleDoubleProperty(0);
        this.varDiv = new SimpleDoubleProperty(0);
        this.valueSin = new SimpleDoubleProperty(0);
        this.VarSin = new SimpleDoubleProperty(0);
        this.amount = new SimpleDoubleProperty(0);
    }

    public int getPositions() {
        return positions;
    }

    public void setPositions(int positions) {
        this.positions = positions;
    }

    public String getSymbol() {
        return symbol.get();
    }

    public SimpleStringProperty symbolProperty() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = new SimpleStringProperty(symbol);
    }

    public Double getValueDiv() {
        return valueDiv.get();
    }

    public SimpleDoubleProperty valueDivProperty() {
        return valueDiv;
    }

    public void setValueDiv(double valueDiv) {
        this.valueDiv = new SimpleDoubleProperty(valueDiv);
    }

    public Double getVarDiv() {
        return varDiv.get();
    }

    public SimpleDoubleProperty varDivProperty() {
        return varDiv;
    }

    public void setVarDiv(double varDiv) {
        this.varDiv = new SimpleDoubleProperty(varDiv);
    }

    public Double getValueSin() {
        return valueSin.get();
    }

    public SimpleDoubleProperty valueSinProperty() {
        return valueSin;
    }

    public void setValueSin(double valueSin) {
        this.valueSin = new SimpleDoubleProperty(valueSin);
    }

    public Double getVarSin() {
        return VarSin.get();
    }

    public SimpleDoubleProperty varSinProperty() {
        return VarSin;
    }

    public void setVarSin(double varSin) {
        this.VarSin = new SimpleDoubleProperty(varSin);
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
}
