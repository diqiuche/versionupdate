package net.tfedu.core.exception;

public class OutOfDateException extends CustomException {
    /**
     * 
     */
    private static final long serialVersionUID = -5245657609530099014L;

    public OutOfDateException() {
        super("OutOfDate", "卡号过期");
    }
}
