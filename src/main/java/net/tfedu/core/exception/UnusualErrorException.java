package net.tfedu.core.exception;

public class UnusualErrorException extends CustomException {
    /**
     * 
     */
    private static final long serialVersionUID = -5245657609530099014L;

    public UnusualErrorException() {
        super("UnusualError", "用户信息异常");
    }
}
