package net.tfedu.core.exception;

/**
 * 自定义异常，java常规方式提供异常定义
 * 
 * @author bruce
 *
 */
public class CustomException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = -2264593730959108392L;
    
    public static final String request_key = "request_key_CustomException";
    
    protected String code;

    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public CustomException() {
        super("service层异常");
    }

    public CustomException(String msg) {
        super(msg);
    }

    public CustomException(Exception e) {
        super("service层异常", e);
    }

    public CustomException(String msg, Exception e) {
        super(msg, e);
    }

    public CustomException(String code, String msg) {
        super(msg);
        setCode(code);
    }
}
