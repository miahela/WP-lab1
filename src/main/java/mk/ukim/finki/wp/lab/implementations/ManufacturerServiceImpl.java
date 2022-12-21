package mk.ukim.finki.wp.lab.implementations;

import mk.ukim.finki.wp.lab.model.Manufacturer;
import mk.ukim.finki.wp.lab.repository.ManufacturerRepository;
import mk.ukim.finki.wp.lab.repository.impl.ManufacturerRepositoryImpl;
import mk.ukim.finki.wp.lab.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    public ManufacturerRepositoryImpl manufacturerRepository;

    public ManufacturerServiceImpl(ManufacturerRepositoryImpl manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<Manufacturer> findAll() {
        return manufacturerRepository.findAll();
    }

    @Override
    public Optional<Manufacturer> findById(Long id) {
        return manufacturerRepository.findById(id);
    }
}
