package sn.uasz.ParametresAPI.exceptions;

public class GroupeNotFoundException extends RuntimeException {

    public GroupeNotFoundException() {
        super("Groupe non trouvé.");
    }

    public GroupeNotFoundException(String message) {
        super(message);
    }
}
