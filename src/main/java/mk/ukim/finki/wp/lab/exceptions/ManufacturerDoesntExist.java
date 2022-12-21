package mk.ukim.finki.wp.lab.exceptions;

public class ManufacturerDoesntExist extends RuntimeException {
    public ManufacturerDoesntExist(String name) {
        super(String.format("Manufacturer with name %s doesn't exist", name));
    }
}
