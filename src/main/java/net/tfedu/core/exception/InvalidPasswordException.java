package net.tfedu.core.exception;

public class InvalidPasswordException extends CustomException {
    /**
     * 
     */
    private static final long serialVersionUID = -5245657609530099014L;

    public InvalidPasswordException() {
        super("InvalidPassword", "密码无效");
    }
}
