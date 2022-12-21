package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Balloon;
import mk.ukim.finki.wp.lab.model.Manufacturer;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ManufacturerRepository {

    public List<Manufacturer> findAll(){
        return DataHolder.manufacturers;
    }

    public Manufacturer findById(Long id) {
        return DataHolder.manufacturers.stream().filter(carnet -> id.equals(carnet.getId())).findFirst().orElse(null);
    }
}
