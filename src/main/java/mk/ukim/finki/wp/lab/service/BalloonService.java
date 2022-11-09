package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Balloon;
import mk.ukim.finki.wp.lab.repository.BalloonRepository;

import java.util.List;

public interface BalloonService {
    List<Balloon> listAll();

    List<Balloon> searchByNameOrDescription(String text);

    List<Balloon> listSizes();

}
