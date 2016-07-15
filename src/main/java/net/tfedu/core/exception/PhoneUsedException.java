package net.tfedu.core.exception;

public class PhoneUsedException extends CustomException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PhoneUsedException() {
		super("PhoneUsedError","该号码已经被绑定，请更换手机号！");
	}
	
	
	

}
