package mk.ukim.finki.wp.lab.repository.impl;

import mk.ukim.finki.wp.lab.exceptions.BalloonAlreadyExists;
import mk.ukim.finki.wp.lab.exceptions.BalloonDoesntExistException;
import mk.ukim.finki.wp.lab.exceptions.ManufacturerDoesntExist;
import mk.ukim.finki.wp.lab.model.Balloon;
import mk.ukim.finki.wp.lab.model.Manufacturer;
import mk.ukim.finki.wp.lab.repository.BalloonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class BalloonRepositoryImpl {

    private final BalloonRepository balloonRepository;

    public BalloonRepositoryImpl(@Autowired @Lazy BalloonRepository balloonRepository) {
        this.balloonRepository = balloonRepository;
    }

    public List<Balloon> findAllBalloons() {
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

    public List<Balloon> findAllByNameOrDescription(String text) {
        List<Balloon> foundBalloons = new ArrayList<>();
        for (Balloon elem: balloonRepository.findAll()) {
            if(elem.getName().contains(text) || elem.getDescription().contains(text)) {
                foundBalloons.add(elem);
            }
        }
        return foundBalloons;
    }

    public Optional<Balloon> findById(Long id) {
        return balloonRepository.findAll().stream().filter(i -> i.getId().equals(id)).findFirst();
    }

    public void deleteCourseById(Long id){
        try{
            balloonRepository.findAll().remove(this.findById(id).orElseThrow(BalloonDoesntExistException::new));

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public Balloon addBalloon(Balloon balloon) throws BalloonAlreadyExists, ManufacturerDoesntExist {
        if (balloonRepository.findAll().stream().anyMatch(i->i.getName().equals(balloon.getName()))){
            throw new BalloonAlreadyExists();
        }
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
