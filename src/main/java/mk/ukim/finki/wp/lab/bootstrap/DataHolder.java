package mk.ukim.finki.wp.lab.bootstrap;

import mk.ukim.finki.wp.lab.model.Balloon;
import mk.ukim.finki.wp.lab.model.Manufacturer;
import mk.ukim.finki.wp.lab.model.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataHolder {

    public static List<Balloon> balloons = new ArrayList<>();
    public static List<Balloon> balloonSizes = new ArrayList<>();
    public static List<Order> orders = new ArrayList<>();
    public static List<Manufacturer> manufacturers = new ArrayList<>();

    @PostConstruct
    public void init() {
        manufacturers.add(new Manufacturer("Manufacturer 1", "MKD", "Kiro Pajmakoski, 9"));
        manufacturers.add(new Manufacturer("Manufacturer 2", "SRB", "Left Street Up, 81A"));
        manufacturers.add(new Manufacturer("Manufacturer 3", "GER", "Razlovecko Vostanie, 5"));
        manufacturers.add(new Manufacturer("Manufacturer 4", "CRO", "Non-Fake Street, 436"));
        manufacturers.add(new Manufacturer("Manufacturer 5", "BUG", "Fun Street, 1"));

        balloons.add(new Balloon("Red", "Red Balloon", manufacturers.get(0)));
        balloons.add(new Balloon("Blue", "Blue Balloon", manufacturers.get(1)));
        balloons.add(new Balloon("Green", "Green Balloon", manufacturers.get(2)));
        balloons.add(new Balloon("Yellow", "Yellow Balloon", manufacturers.get(3)));
        balloons.add(new Balloon("Black", "Black Balloon", manufacturers.get(4)));

        balloonSizes.add(new Balloon("Big", "Big Balloon", manufacturers.get(0)));
        balloonSizes.add(new Balloon("Small", "Small Balloon", manufacturers.get(1)));
        balloonSizes.add(new Balloon("Tall", "Tall Balloon", manufacturers.get(2)));
        balloonSizes.add(new Balloon("Short", "Short Balloon", manufacturers.get(3)));
        balloonSizes.add(new Balloon("Wide", "Wide Balloon", manufacturers.get(4)));
    }


}