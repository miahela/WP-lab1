package mk.ukim.finki.wp.lab.model;

public class Order {
    String balloonColor;
    String balloonSize;
    Long orderId;

    public Order(String balloonColor, String balloonSize) {
        this.balloonColor = balloonColor;
        this.balloonSize = balloonSize;
        this.orderId = (long) (Math.random()*1000);;
    }

    public Order() {

    }

    public Order(String attribute, String attribute1, String clientName, String clientAddress) {
    }

    public String getBalloonColor() {
        return balloonColor;
    }

    public String getBalloonSize() {
        return balloonSize;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setBalloonColor(String balloonColor) {
        this.balloonColor = balloonColor;
    }

    public void setBalloonSize(String balloonSize) {
        this.balloonSize = balloonSize;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}

