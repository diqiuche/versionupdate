package net.tfedu.core.exception;

public class WrongPassWordException extends CustomException {
    /**
     * 
     */
    private static final long serialVersionUID = -5245657609530099014L;

    public WrongPassWordException() {
        super("WrongPassWord", "密码错误");
    }
}
