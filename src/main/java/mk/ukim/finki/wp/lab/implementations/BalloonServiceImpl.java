package mk.ukim.finki.wp.lab.implementations;

import mk.ukim.finki.wp.lab.model.Balloon;
import mk.ukim.finki.wp.lab.model.Manufacturer;
import mk.ukim.finki.wp.lab.repository.BalloonRepository;
import mk.ukim.finki.wp.lab.repository.impl.BalloonRepositoryImpl;
import mk.ukim.finki.wp.lab.service.BalloonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BalloonServiceImpl implements BalloonService {
    public BalloonRepositoryImpl balloonRepository;

    public BalloonServiceImpl(BalloonRepositoryImpl balloonRepository) {
        this.balloonRepository = balloonRepository;
    }

    @Override
    public List<Balloon> listAll() {
        return balloonRepository.findAllBalloons();
    }

    @Override
    public List<Balloon> listSizes() {
        return balloonRepository.listSizes();
    }

    @Override
    public List<Balloon> getAllSizes() {
        return balloonRepository.getAllSizes();
    }

    @Override
    public List<Balloon> searchByNameOrDescription(String text) {
        return balloonRepository.findAllByNameOrDescription(text);
    }

    @Override
    public void deleteById(Long id) {
        balloonRepository.deleteCourseById(id);
    }

    @Override
    public Optional<Balloon> searchById(Long id) {
        return balloonRepository.findById(id);
    }

    @Override
    public Balloon addNewBalloon(String name, String description, Optional<Manufacturer> manufacturer) {
        return balloonRepository.addBalloon(new Balloon(name, description, manufacturer, false));
    }

    @Override
    public Balloon editBalloon(Long id, String name, String description, Optional<Manufacturer> manufacturer) {
        return balloonRepository.editBalloon(id, name, description, manufacturer);
    }

}

