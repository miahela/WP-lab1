package mk.ukim.finki.wp.lab.implementations;

import mk.ukim.finki.wp.lab.exceptions.BalloonAlreadyExists;
import mk.ukim.finki.wp.lab.exceptions.BalloonDoesntExistException;
import mk.ukim.finki.wp.lab.exceptions.ManufacturerDoesntExist;
import mk.ukim.finki.wp.lab.model.Balloon;
import mk.ukim.finki.wp.lab.model.Manufacturer;
import mk.ukim.finki.wp.lab.repository.BalloonRepository;
import mk.ukim.finki.wp.lab.repository.impl.BalloonRepositoryImpl;
import mk.ukim.finki.wp.lab.service.BalloonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BalloonServiceImpl implements BalloonService {
    public BalloonRepository balloonRepository;

    public BalloonServiceImpl(@Autowired BalloonRepository balloonRepository) {
        this.balloonRepository = balloonRepository;
    }

    public List<Balloon> listAll() {
        List<Balloon> temp = new ArrayList<>();
        for ( Balloon balloon : balloonRepository.findAll() ) {
            if(!balloon.isSize()) temp.add(balloon);
        }
        return temp;
    }
    public List<Balloon> getAllSizes() {
        List<Balloon> temp = new ArrayList<>();
        for ( Balloon balloon : balloonRepository.findAll() ) {
            if(balloon.isSize()) temp.add(balloon);
        }
        return temp;
    }

    public List<Balloon> searchByNameOrDescription(String text) {
        List<Balloon> foundBalloons = new ArrayList<>();
        for (Balloon elem: balloonRepository.findAll()) {
            if(elem.getName().contains(text) || elem.getDescription().contains(text)) {
                foundBalloons.add(elem);
            }
        }
        return foundBalloons;
    }

    public Optional<Balloon> searchById(Long id) {
        return balloonRepository.findAll().stream().filter(i -> i.getId().equals(id)).findFirst();
    }

    public void deleteById(Long id){
        try{
            balloonRepository.findAll().remove(this.searchById(id).orElseThrow(BalloonDoesntExistException::new));

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public Balloon addNewBalloon(String name, String description, Optional<Manufacturer> manufacturer) throws BalloonAlreadyExists, ManufacturerDoesntExist {

        if (balloonRepository.findAll().stream().anyMatch(i->i.getName().equals(name))){
            throw new BalloonAlreadyExists();
        }
        Balloon balloon = new Balloon(name, description, manufacturer, false);
        balloonRepository.findAll().add(balloon);
        return balloon;
    }

    public Balloon editBalloon(Long id, String name, String description, Optional<Manufacturer> manufacturer) throws BalloonAlreadyExists{
        if (balloonRepository.findAll().stream().anyMatch(i->i.getName().equals(name))){
            throw new BalloonAlreadyExists();
        }
        Balloon balloon = balloonRepository.findAll().stream().filter(i->i.getId().equals(id)).findFirst().orElseThrow(BalloonDoesntExistException::new);
        balloon.setName(name);
        balloon.setDescription(description);
        balloon.setManufacturer(manufacturer.orElse(null));
        if(balloonRepository.findAll().stream().anyMatch(i->i.getId().equals(id))){
            balloonRepository.findAll().remove(balloonRepository.findAll().stream().filter(i->i.getId().equals(id)).findFirst().get());
            balloonRepository.findAll().add(balloon);
        }
        return balloon;
    }

    public List<Balloon> listSizes() {
        List<Balloon> temp = new ArrayList<>();
        for ( Balloon balloon : balloonRepository.findAll() ) {
            if(balloon.isSize()) temp.add(balloon);
        }
        return temp;
    }
}

