package net.tfedu.core.exception;

public class InvalidAccessTokenException extends CustomException {
    /**
     * 
     */
    private static final long serialVersionUID = -5245657609530099014L;

    public InvalidAccessTokenException() {
        super("InvalidAccessToken", "提供的token无效");
    }
}
