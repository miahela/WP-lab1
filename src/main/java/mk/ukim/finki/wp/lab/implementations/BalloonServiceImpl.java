package mk.ukim.finki.wp.lab.implementations;

import mk.ukim.finki.wp.lab.model.Balloon;
import mk.ukim.finki.wp.lab.repository.BalloonRepository;
import mk.ukim.finki.wp.lab.service.BalloonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BalloonServiceImpl implements BalloonService {
    public BalloonRepository balloonRepository;

    public BalloonServiceImpl(BalloonRepository balloonRepository) {
        this.balloonRepository = balloonRepository;
    }

    @Override
    public List<Balloon> listAll() {
        return balloonRepository.findAllBalloons();
    }

    @Override
    public List<Balloon> searchByNameOrDescription(String text) {
        return balloonRepository.findAllByNameOrDescription(text);
    }

    @Override
    public List<Balloon> listSizes() {
        return balloonRepository.listSizes();
    }
}
