package net.tfedu.core.exception;

public class PrepareContentExistException extends CustomException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 public PrepareContentExistException() {
	        super("PrepareContentExistError", "备课夹中已经存在当前资源");
	    }
}
