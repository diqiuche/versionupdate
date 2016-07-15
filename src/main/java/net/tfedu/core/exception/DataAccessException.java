package net.tfedu.core.exception;

/**
 * 
 * @author bruce
 *
 */
public class DataAccessException extends CustomException {

    /**
     * 
     */
    private static final long serialVersionUID = 924605455025554038L;

    public DataAccessException() {
        super("DataAccess", "数据访问错误");
    }

}
