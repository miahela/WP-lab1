package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.exceptions.BalloonAlreadyExists;
import mk.ukim.finki.wp.lab.exceptions.BalloonDoesntExistException;
import mk.ukim.finki.wp.lab.exceptions.ManufacturerDoesntExist;
import mk.ukim.finki.wp.lab.model.Balloon;
import mk.ukim.finki.wp.lab.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface BalloonRepository extends JpaRepository<Balloon, Long> {

}
