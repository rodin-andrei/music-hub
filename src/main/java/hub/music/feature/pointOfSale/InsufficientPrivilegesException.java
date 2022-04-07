package hub.music.feature.pointOfSale;

public class InsufficientPrivilegesException extends  RuntimeException{
    public InsufficientPrivilegesException(String message){
        super(message);
    }
}