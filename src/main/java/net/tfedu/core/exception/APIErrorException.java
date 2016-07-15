package net.tfedu.core.exception;

public class APIErrorException extends CustomException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public APIErrorException(){
		super("APIError","api调用异常，请检查api参数");
	}
	public APIErrorException(String message){
		super("APIError",message);
	}
}
