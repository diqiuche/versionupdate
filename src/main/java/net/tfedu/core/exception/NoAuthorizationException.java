package net.tfedu.core.exception;

public class NoAuthorizationException extends CustomException {
    /**
     * 
     */
    private static final long serialVersionUID = -5245657609530099014L;

    public NoAuthorizationException() {
        super("WithoutAuthorization", "用户不存在");
    }

}
