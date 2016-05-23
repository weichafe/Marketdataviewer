package sample.model;


public class TradeModel {

    private String time;
    private Double px;
    private Double qty;
    private Double amount;
    private Double buyer;
    private Double seller;
    private String tc;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getPx() {
        return px;
    }

    public void setPx(Double px) {
        this.px = px;
    }

    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getBuyer() {
        return buyer;
    }

    public void setBuyer(Double buyer) {
        this.buyer = buyer;
    }

    public Double getSeller() {
        return seller;
    }

    public void setSeller(Double seller) {
        this.seller = seller;
    }

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }
}
