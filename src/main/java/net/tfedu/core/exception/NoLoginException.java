package net.tfedu.core.exception;

public class NoLoginException extends CustomException {
    /**
     * 
     */
    private static final long serialVersionUID = -5245657609530099014L;

    public NoLoginException() {
        super("WithoutLogin", "用户未登录");
    }

}
