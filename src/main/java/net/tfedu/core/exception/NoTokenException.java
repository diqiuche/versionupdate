package net.tfedu.core.exception;

public class NoTokenException extends CustomException {
    /**
     * 
     */
    private static final long serialVersionUID = -5245657609530099014L;

    public NoTokenException() {
        super("NoAccessToken", "缺少token令牌");
    }
}
