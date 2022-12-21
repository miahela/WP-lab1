package mk.ukim.finki.wp.lab.model;

import javax.persistence.*;

@Entity
@Table(name = "Order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long orderId;

    @Column(name = "ballonColor")
    String balloonColor;

    @Column(name = "balloonSize")
    String balloonSize;

    @Column(name = "shoppingCartId")
    Long shoppingCartId;

    public Order(String balloonColor, String balloonSize, Long shoppingCartId) {
        this.balloonColor = balloonColor;
        this.balloonSize = balloonSize;
        this.orderId = (long) (Math.random()*1000);
        this.shoppingCartId = shoppingCartId;
    }

    public Order() {

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

