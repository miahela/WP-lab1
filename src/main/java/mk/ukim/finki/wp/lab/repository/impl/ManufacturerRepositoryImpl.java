package mk.ukim.finki.wp.lab.repository.impl;

import mk.ukim.finki.wp.lab.model.Manufacturer;
import mk.ukim.finki.wp.lab.repository.BalloonRepository;
import mk.ukim.finki.wp.lab.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ManufacturerRepositoryImpl {

    private final ManufacturerRepository manufacturerRepository;

    public ManufacturerRepositoryImpl(@Autowired @Lazy ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    public List<Manufacturer> findAll() {
        return manufacturerRepository.findAll();
    }

    public Optional<Manufacturer> findById(Long id) {
        return manufacturerRepository.findById(id);
    }
}
