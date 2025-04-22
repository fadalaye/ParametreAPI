package sn.uasz.ParametresAPI.exceptions;

/**
 * Exception levée lorsque le département demandé n'est pas trouvé.
 *
 * Cette classe étend {@link Exception} et est utilisée pour signaler
 * des erreurs spécifiques liées à la recherche de départements dans
 * l'application.
 *
 * @author [Votre Nom]
 * @version 1.0
 */
public class DepartementNotFindException extends Exception {

    /**
     * Constructeur pour l'exception.
     *
     * @param message le message d'erreur à associer à l'exception.
     */
    public DepartementNotFindException(String message) {
        super(message);
    }
}