package net.tfedu.core.exception;

/**
 * 手机号码 错误的异常
 * @author wangwr
 *
 */
public class PhoneNoErrorException extends CustomException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PhoneNoErrorException(){
		super("PhoneNoError", "手机号码错误");
	}
	
}
