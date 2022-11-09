package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.exceptions.BalloonDoesntExistException;
import mk.ukim.finki.wp.lab.model.Balloon;
import mk.ukim.finki.wp.lab.service.BalloonService;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BalloonRepository{
    public List<Balloon> findAllBalloons(){
        return DataHolder.balloons;
    }

    public List<Balloon> findAllByNameOrDescription(String text){

        try {
            if (DataHolder.balloons.isEmpty()) {
                throw new BalloonDoesntExistException();
            }
            List<Balloon> temp = new ArrayList<>();
            for (Balloon balloon : DataHolder.balloons) {
                if (balloon.getDescription().contains(text) || balloon.getName().contains(text)){
                    temp.add(balloon);
                }
            }
            return temp;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Balloon> listSizes() { return DataHolder.balloonSizes;}
}
