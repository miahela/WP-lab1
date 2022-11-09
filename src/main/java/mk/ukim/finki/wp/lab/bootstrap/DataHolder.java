package mk.ukim.finki.wp.lab.bootstrap;

import mk.ukim.finki.wp.lab.model.Balloon;
import mk.ukim.finki.wp.lab.model.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<Balloon> balloons = new ArrayList<>();
    public static List<Balloon> balloonSizes = new ArrayList<>();
    public static List<Order> orders = new ArrayList<>();

    @PostConstruct
    public void init() {
        balloons.add(new Balloon("Red", "Red Balloon"));
        balloons.add(new Balloon("Blue", "Blue Balloon"));
        balloons.add(new Balloon("Green", "Green Balloon"));
        balloons.add(new Balloon("Yellow", "Yellow Balloon"));
        balloons.add(new Balloon("Black", "Black Balloon"));

        balloonSizes.add(new Balloon("Big", "Big Balloon"));
        balloonSizes.add(new Balloon("Small", "Small Balloon"));
        balloonSizes.add(new Balloon("Tall", "Tall Balloon"));
        balloonSizes.add(new Balloon("Short", "Short Balloon"));
        balloonSizes.add(new Balloon("Wide", "Wide Balloon"));
    }


}