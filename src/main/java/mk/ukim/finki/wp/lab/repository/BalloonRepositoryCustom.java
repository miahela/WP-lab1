package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Balloon;
import mk.ukim.finki.wp.lab.model.Manufacturer;

import java.util.List;
import java.util.Optional;

public interface  BalloonRepositoryCustom {
    List<Balloon> findAllByNameOrDescription(String text);
    List<Balloon> getAllSizes();
    List<Balloon> listSizes();
    void deleteCourseById(Long id);
    Balloon addBalloon(Balloon balloon);
    Balloon editBalloon(Long id, String name, String description, Optional<Manufacturer> manufacturer);
}
