package sn.kai.kaivoiture.Exception;

public class UsernameAlreadyExistException extends Throwable {
    public UsernameAlreadyExistException(String username_already_exist) {
        super(username_already_exist);
    }
}
