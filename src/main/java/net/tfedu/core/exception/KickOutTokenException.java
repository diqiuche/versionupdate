package net.tfedu.core.exception;

/**
 * 用户被踢出异常
 * @author wangwr
 *
 */
public class KickOutTokenException extends CustomException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public KickOutTokenException() {
        super("KickOutTokenException", "当前用户在其他地点登录，若不是本人操作，请注意账号安全！");
    }

}
