package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Manufacturer;

import java.util.List;
import java.util.Map;

public interface ManufacturerService {
    List<Manufacturer> findAll();

    Manufacturer findById(Long manufacturerId);

//    Map<Object, Object> save(String m1, String m11);
}
