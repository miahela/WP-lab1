package mk.ukim.finki.wp.lab.exceptions;

public class BalloonDoesntExistException extends RuntimeException{
    public BalloonDoesntExistException() {
        super("Course doesn't exist!");
    }
}
