package mk.ukim.finki.wp.lab.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    LocalDateTime dateCreated;

    public Long getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(Long shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Order(String balloonColor, String balloonSize, Long shoppingCartId) {
        this.balloonColor = balloonColor;
        this.balloonSize = balloonSize;
        this.orderId = (long) (Math.random()*1000);
        this.shoppingCartId = shoppingCartId;
    }

    public Order(String balloonColor, String balloonSize, LocalDateTime dateCreated) {
        this.orderId = (long) (Math.random()*1000);
        this.balloonColor = balloonColor;
        this.balloonSize = balloonSize;
        this.dateCreated = dateCreated;
    }

    public Order(String balloonColor, String balloonSize) {
        this.orderId = (long) (Math.random()*1000);
        this.balloonColor = balloonColor;
        this.balloonSize = balloonSize;
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

