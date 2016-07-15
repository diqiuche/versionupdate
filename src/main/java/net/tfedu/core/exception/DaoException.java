package net.tfedu.core.exception;

public class DaoException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = -5543730490634115705L;

    public DaoException() {
        super("dao层异常");
    }

    public DaoException(String msg) {
        super(msg);
    }

    public DaoException(Exception e) {
        super("dao层异常", e);
    }

    public DaoException(String msg, Exception e) {
        super(msg, e);
    }

}
