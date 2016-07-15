package net.tfedu.core.exception;

public class ParamsException extends CustomException {
    /**
     * 
     */
    private static final long serialVersionUID = -5245657609530099014L;

    public ParamsException() {
        super("ParamsError", "参数异常");
    }
    

    public ParamsException(String message) {
        super("ParamsError", message);
    }
}
